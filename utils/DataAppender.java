package utils;

import java.util.Map;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class DataAppender {
    public DataAppender(Map<String, String> map, String filePath, String separator) throws IOException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)))) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                writer.println(key + separator + value);
            }
            writer.println(separator + "==================" + separator); // separator between maps
        }
    }

}
