package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DateOfDeathAdder {

    public static void addDateOfDeath(String ssn, String dateOfDeath) throws IOException {
        String filePath = "database/user.txt";
        List<String> fileLines = readFileLines(filePath);
        int blockStartIndex = findBlockStartIndex(fileLines, ssn);

        if (blockStartIndex != -1) {
            String blockSeparator = "====================";
            int blockEndIndex = findBlockEndIndex(fileLines, blockStartIndex + 1, blockSeparator);

            if (blockEndIndex != -1) {
                fileLines.add(blockEndIndex, "dateofdeath=" + dateOfDeath);
                writeFileLines(filePath, fileLines);
                System.out.println("Date of death added successfully.");
            } else {
                System.out.println("Block end not found for the given SSN.");
            }
        } else {
            System.out.println("Block start not found for the given SSN.");
        }
    }

    private static int findBlockStartIndex(List<String> lines, String ssn) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith("ssn=" + ssn)) {
                return i;
            }
        }
        return -1;
    }

    private static int findBlockEndIndex(List<String> lines, int startIndex, String blockSeparator) {
        for (int i = startIndex; i < lines.size(); i++) {
            if (lines.get(i).equals(blockSeparator)) {
                return i;
            }
        }
        return -1;
    }

    private static List<String> readFileLines(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

    private static void writeFileLines(String filePath, List<String> lines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

}
