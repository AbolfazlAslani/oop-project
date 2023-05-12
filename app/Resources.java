package app;

import java.util.Map;

import utils.DataCollector;
import utils.DateOfDeathAdder;
import utils.SystemClear;
import utils.Retrievers.NatureRetriever;
import utils.Retrievers.PersonRetriever;

import java.util.HashMap;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Resources {
    public static String city;

    public Resources(String city) {
        Resources.city = city;
    }

    public static void create(Map<String, String> data) {

    }

    public static void findHumanResources(String ssn) {
        try {
            Map<String, String> personData = PersonRetriever.retrievePersonData(ssn);
            if (!personData.isEmpty()) {
                // * Clears the command prompt \
                SystemClear.main();
                System.out.println("====================================================");
                System.out.println("Person data found:");
                for (Map.Entry<String, String> entry : personData.entrySet()) {
                    System.out.println(entry.getKey() + "=" + entry.getValue());
                }
            } else {
                System.out.println("Person data not found for the given SSN.");
            }
        } catch (IOException e) {
            System.out.println("Error retrieving person data: " + e.getMessage());
        }

    }

    public static void findNatureResources(String ssn) {
        try {
            Map<String, String> personData = NatureRetriever.retrievePersonData(ssn);
            if (!personData.isEmpty()) {
                // * Clears the command prompt \
                SystemClear.main();
                System.out.println("====================================================");
                System.out.println("Your data found:");
                for (Map.Entry<String, String> entry : personData.entrySet()) {
                    System.out.println(entry.getKey() + "=" + entry.getValue());
                }
            } else {
                System.out.println("Person data not found for the given SSN.");
            }
        } catch (IOException e) {
            System.out.println("Error retrieving person data: " + e.getMessage());
        }

    }

    public static void HumanResourceDeathSubmittion(String ssn, String deathDate) {

        try {
            DateOfDeathAdder.addDateOfDeath(ssn, deathDate);
        } catch (IOException e) {
            System.out.println("Error adding date of death: " + e.getMessage());
        }

    }

    public static void RandomHumanResourceCreator(int counter) {

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
            for (int i = 0; i < counter; i++) {
                List<String> randomDataList = DataCollector.collectRandomDataFromFiles(fileNames);
                HumanResources randomData = new HumanResources(randomDataList.get(5), randomDataList.get(4),
                        randomDataList.get(8), randomDataList.get(2), randomDataList.get(1), randomDataList.get(0),
                        randomDataList.get(3), randomDataList.get(7), randomDataList.get(6));
                randomData.submit();

            }

        } catch (IOException e) {
            System.out.println("Error collecting random data: " + e.getMessage());
        }
    }
}
