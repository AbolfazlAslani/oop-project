package utils.Retrievers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NatureRetriever {

    public static Map<String, String> retrievePersonData(String ssn) throws IOException {
        String filePath = "database/lands.txt";
        List<String> fileLines = readFileLines(filePath);

        Map<String, String> personData = new HashMap<>();
        StringBuilder currentBlock = new StringBuilder();
        boolean foundBlock = false;

        for (String line : fileLines) {
            if (line.startsWith("ssn=" + ssn)) {
                foundBlock = true;
            }

            if (line.equals("====================")) {
                if (foundBlock) {
                    personData = parseBlockData(currentBlock.toString());
                    break;
                }
                currentBlock.setLength(0);
            } else {
                currentBlock.append(line).append(System.lineSeparator());
            }
        }

        return personData;
    }

    private static Map<String, String> parseBlockData(String blockData) {
        Map<String, String> personData = new HashMap<>();
        String[] lines = blockData.split(System.lineSeparator());
        for (String line : lines) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                personData.put(key, value);
            }
        }
        return personData;
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

}
