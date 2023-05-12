package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataCollector {

    public static String getRandomDataFromFile(String filePath) throws IOException {
        List<String> lines = readAllLines(filePath);

        if (!lines.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(lines.size());
            return lines.get(index);
        }

        return null;
    }

    public static List<String> collectRandomDataFromFiles(List<String> fileNames) throws IOException {
        List<String> randomDataList = new ArrayList<>();

        for (String fileName : fileNames) {
            String filePath = "randomData/person/" + fileName + ".txt"; // Replace with the actual directory path
            String randomData = getRandomDataFromFile(filePath);

            if (randomData != null) {
                randomDataList.add(randomData);
            }
        }

        return randomDataList;
    }

    public static void main(String[] args) {
        List<String> fileNames = List.of(
                "address",
                "age",
                "city",
                "job",
                "lastname",
                "name",
                "nation",
                "sex",
                "ssn");

        try {
            List<String> randomDataList = collectRandomDataFromFiles(fileNames);
            System.out.println("Random Data:");
            for (String randomData : randomDataList) {
                System.out.println(randomData);
            }
        } catch (IOException e) {
            System.out.println("Error collecting random data: " + e.getMessage());
        }
    }

    private static List<String> readAllLines(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path);
    }
}
