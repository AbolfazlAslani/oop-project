package menu;

import java.util.List;
import java.util.Scanner;

import statistics.AgeCounter;
import statistics.DeathCounter;
import statistics.GenderBlockRetriever;
import utils.SystemClear;

public class StatisticsDataMenu {

    public static void statisticsMainMenu() {
        Scanner sc = new Scanner(System.in);
        // * Clears the command prompt \

        SystemClear.main();
        System.out.println("====================================================");
        System.out.println("1.Person Age Higher And Lower Stats");
        System.out.println("2.Number Of Dead People");
        System.out.println("3.Gender Seperation");

        System.out.print("Select : ");

        int number = sc.nextInt();
        if (number == 1) {
            higherAndLowerAgeCounter();

        } else if (number == 2) {
            deathCounter();
        } else if (number == 3) {
            genderSeperator();
        }

        // * a menu should be added for add data again or comeback

        sc.close();

    }

    private static void higherAndLowerAgeCounter() {
        Scanner sc = new Scanner(System.in);
        // * Clears the command prompt \

        SystemClear.main();
        System.out.println("====================================================");
        System.out.print("Please Enter The Age : ");
        int age = sc.nextInt();
        AgeCounter.counter(age);
        System.out.println("====================================================");
        System.out.println("Your Data Found Succesfully ! ");
        System.out.println("1.Main Menu");
        System.out.println("2.Exit");
        System.out.print("Select : ");
        int javabe2 = sc.nextInt();
        if (javabe2 == 1) {
            Intro.mainMenu();
        }

        // * a menu should be added for add data again or comeback

        sc.close();

    }

    private static void deathCounter() {
        Scanner sc = new Scanner(System.in);
        // * Clears the command prompt \

        SystemClear.main();
        System.out.println("====================================================");
        DeathCounter.main(null);

        System.out.println("====================================================");
        System.out.println("Your Data Found Succesfully ! ");
        System.out.println("1.Main Menu");
        System.out.println("2.Exit");
        System.out.print("Select : ");
        int javabe2 = sc.nextInt();
        if (javabe2 == 1) {
            Intro.mainMenu();
        }

        // * a menu should be added for add data again or comeback

        sc.close();

    }

    private static void genderSeperator() {
        Scanner sc = new Scanner(System.in);
        // * Clears the command prompt \

        SystemClear.main();
        System.out.println("====================================================");
        System.out.println("1.Male");
        System.out.println("2.Female");
        System.out.print("Select: ");
        int input = sc.nextInt();
        if (input == 1) {
            List<String> maleBlocks = GenderBlockRetriever.retrieveBlocksByGender("male");
            System.out.println("Male blocks:\n" + maleBlocks);

            System.out.println("====================================================");
            System.out.println("Your Data Found Succesfully ! ");
            System.out.println("1.Main Menu");
            System.out.println("2.Exit");
            System.out.print("Select : ");
            int javabe2 = sc.nextInt();
            if (javabe2 == 1) {
                Intro.mainMenu();
            }

        }

        else {
            List<String> femaleBlocks = GenderBlockRetriever.retrieveBlocksByGender("female");
            System.out.println("Female blocks:\n" + femaleBlocks);

            System.out.println("====================================================");
            System.out.println("Your Data Found Succesfully ! ");
            System.out.println("1.Main Menu");
            System.out.println("2.Exit");
            System.out.print("Select : ");
            int javabe2 = sc.nextInt();
            if (javabe2 == 1) {
                Intro.mainMenu();
            }
        }
        // * a menu should be added for add data again or comeback

        sc.close();

    }

}
