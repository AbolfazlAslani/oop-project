package statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AgeCounter {
    public static void counter(int age) {

        int countHigher = 0;
        int countLower = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("database/user.txt"))) {
            String line;
            boolean isBlock = false;

            while ((line = reader.readLine()) != null) {
                if (line.equals("====================")) {
                    isBlock = !isBlock;
                    continue;
                }

                if (isBlock) {
                    if (line.startsWith("age=")) {
                        int blockAge = Integer.parseInt(line.substring(4));
                        if (blockAge > age) {
                            countHigher++;
                        } else if (blockAge < age) {
                            countLower++;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Number of blocks with age higher than " + age + ": " + countHigher);
        System.out.println("Number of blocks with age lower than " + age + ": " + countLower);
    }
}
