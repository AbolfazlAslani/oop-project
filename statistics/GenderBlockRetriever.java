package statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenderBlockRetriever {

    public static List<String> retrieveBlocksByGender(String gender) {
        List<String> blocks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("database/user.txt"))) {
            String line;
            StringBuilder block = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.equals("====================")) {
                    if (block.toString().contains("sex=" + gender)) {
                        blocks.add(block.toString());
                    }
                    block = new StringBuilder();
                } else {
                    block.append(line).append(System.lineSeparator());
                }
            }
            // Check for the last block in case it doesn't have a closing delimiter
            if (block.toString().contains("sex=" + gender)) {
                blocks.add(block.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blocks;
    }
}
