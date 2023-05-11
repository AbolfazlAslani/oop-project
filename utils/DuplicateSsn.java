package utils;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;

public class DuplicateSsn {
    public static boolean isDuplicateSSN(String filePath, String ssnToCheck) throws IOException {
        List<Map<String, String>> maps = readMapsFromFile(filePath);

        for (Map<String, String> map : maps) {
            String ssn = map.get("ssn");
            if (ssn != null && ssn.equals(ssnToCheck)) {
                return true; // Found a duplicate SSN
            }
        }

        return false; // No duplicate SSN found
    }

    public static List<Map<String, String>> readMapsFromFile(String filePath) throws IOException {
        List<Map<String, String>> maps = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Map<String, String> currentMap = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove leading/trailing whitespace

                if (line.equals("====================")) {
                    // End of current map entry, add it to the list
                    maps.add(currentMap);
                    currentMap = new HashMap<>();
                } else {
                    // Split the line into key-value pairs and add them to the current map
                    String[] parts = line.split("=", 2);
                    if (parts.length == 2) {
                        String key = parts[0];
                        String value = parts[1];
                        currentMap.put(key, value);
                    }
                }
            }

            // Add the last map to the list if it is not empty
            if (!currentMap.isEmpty()) {
                maps.add(currentMap);
            }
        }

        return maps;
    }

    public static Boolean checker(String ssn) {
        boolean action;

        try {
            String filePath = "database/user.txt";
            boolean isDuplicate = isDuplicateSSN(filePath, ssn);
            if (isDuplicate) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the maps from the file: " + e.getMessage());
        }
        return true;

    }

    public static Boolean codeChecker(String ssn) {
        boolean action;

        try {
            String filePath = "database/lands.txt";
            boolean isDuplicate = isDuplicateSSN(filePath, ssn);
            if (isDuplicate) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the maps from the file: " + e.getMessage());
        }
        return true;

    }
}
