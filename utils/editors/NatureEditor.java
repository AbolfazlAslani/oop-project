package utils.editors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NatureEditor {

    public static void editNature(String ssn, Map<String, String> newData) throws IOException {
        String filePath = "database/lands.txt";
        List<String> fileLines = readFileLines(filePath);

        List<String> updatedFileLines = new ArrayList<>();
        StringBuilder currentBlock = new StringBuilder();
        boolean foundBlock = false;

        for (String line : fileLines) {
            if (line.startsWith("ssn=" + ssn)) {
                foundBlock = true;
            }

            if (line.equals("====================")) {
                if (foundBlock) {
                    updateBlockData(currentBlock, newData);
                    foundBlock = false;
                }
                updatedFileLines.add(currentBlock.toString());
                updatedFileLines.add(line);
                currentBlock.setLength(0);
            } else {
                currentBlock.append(line).append(System.lineSeparator());
            }
        }

        writeFileLines(filePath, updatedFileLines);
    }

    private static void updateBlockData(StringBuilder blockData, Map<String, String> newData) {
        String[] lines = blockData.toString().split(System.lineSeparator());
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            for (Map.Entry<String, String> entry : newData.entrySet()) {
                String key = entry.getKey();
                if (line.startsWith(key + "=")) {
                    lines[i] = key + "=" + entry.getValue();
                    break;
                }
            }
        }
        blockData.setLength(0);
        for (String line : lines) {
            blockData.append(line).append(System.lineSeparator());
        }
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