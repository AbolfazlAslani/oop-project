package statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DeathCounter {

    public static void main(String[] args) {
        int count = countBlocksWithDateOfDeath();
        System.out.println("Number of blocks with date of death: " + count);
    }

    public static int countBlocksWithDateOfDeath() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("database/user.txt"))) {
            String line;
            StringBuilder block = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.equals("====================")) {
                    if (block.toString().contains("dateofdeath=")) {
                        count++;
                    }
                    block = new StringBuilder();
                } else {
                    block.append(line).append(System.lineSeparator());
                }
            }
            // Check for the last block in case it doesn't have a closing delimiter
            if (block.toString().contains("dateofdeath=")) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
