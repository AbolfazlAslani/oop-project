package gui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AgeStatisticsGUI extends JFrame {
    private JLabel lblHigher;
    private JLabel lblLower;

    public AgeStatisticsGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Age Statistics");
        setSize(300, 200);
        setLayout(new FlowLayout());

        lblHigher = new JLabel("Blocks with age higher than given age: ");
        lblLower = new JLabel("Blocks with age lower than given age: ");

        add(lblHigher);
        add(lblLower);
    }

    public void displayStatistics(int higherCount, int lowerCount) {
        lblHigher.setText("Blocks with age higher than given age: " + higherCount);
        lblLower.setText("Blocks with age lower than given age: " + lowerCount);

        setVisible(true);
    }

    public static void calculateAgeStatistics(int age) {
        int higherCount = 0;
        int lowerCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("database/user.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("age=")) {
                    int blockAge = Integer.parseInt(line.substring(4));
                    if (blockAge > age) {
                        higherCount++;
                    } else {
                        lowerCount++;
                    }
                }
            }

            AgeStatisticsGUI gui = new AgeStatisticsGUI();
            gui.displayStatistics(higherCount, lowerCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
