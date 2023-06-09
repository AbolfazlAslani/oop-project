package menu;

import app.HumanResources;
import utils.DuplicateSsn;
import utils.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

public class Intro {
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        // * Clears the command prompt \

        SystemClear.main();
        System.out.println("====================================================");
        System.out.println("Welcome To The Nature $ Human Resources Program ! ");
        System.out.println("1.Resources");
        System.out.println("2.Create Random Resources");
        System.out.println("3.Statistic Reports");
        System.out.print("Select : ");
        int answer = sc.nextInt();
        if (answer == 1) {
            // * Clears the command prompt \

            SystemClear.main();
            System.out.println("====================================================");

            System.out.println("1.Human Resources");
            System.out.println("2.Nature Resources");
            System.out.print("Select : ");
            int secanswer = sc.nextInt();
            if (secanswer == 1) {
                // * Clears the command prompt \

                SystemClear.main();
                System.out.println("====================================================");

                System.out.println("1.Create New Resource");
                System.out.println("2.Edit Resources");
                System.out.println("3.Submit Death");
                System.out.println("4.Search");
                System.out.print("Select : ");
                int thirdanswer = sc.nextInt();
                if (thirdanswer == 1) {
                    HumanResourceMenu.createHumanResource();
                } else if (thirdanswer == 2) {
                    HumanResourceMenu.editHumanResource();
                } else if (thirdanswer == 3) {
                    HumanResourceMenu.submitDeath();
                } else {
                    HumanResourceMenu.findHumanResource();
                }

            } else {
                // * Clears the command prompt \

                SystemClear.main();
                System.out.println("====================================================");

                System.out.println("1.Create New Resource");
                System.out.println("2.Edit Resources");
                System.out.println("3.Search");
                System.out.print("Select : ");
                int thirdanswer = sc.nextInt();
                if (thirdanswer == 1) {
                    NatureResourceMenu.createNatureResource();
                } else if (thirdanswer == 2) {
                    NatureResourceMenu.editNatureResource();
                } else {
                    NatureResourceMenu.findNatureResource();
                }

            }
        } else if (answer == 2) {
            HumanResourceMenu.randomHuman();
        } else {
            StatisticsDataMenu.statisticsMainMenu();
        }
        sc.close();

    }

}
