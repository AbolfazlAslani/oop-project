package menu;

import app.HumanResources;
import app.NatureResources;
import utils.DuplicateSsn;
import utils.*;

import java.util.Scanner;

public class NatureResourceMenu {
    public static void createNatureResource() {
        Scanner sc = new Scanner(System.in);
        // * Clears the command prompt \

        SystemClear.main();
        System.out.println("====================================================");
        System.out.println("Please Enter Code : ");
        String ssn = sc.nextLine();
        Boolean checker = DuplicateSsn.codeChecker(ssn);
        // * Code Is Validated Here
        if (checker) {
            // * Clears the command prompt \

            SystemClear.main();
            System.out.println("====================================================");

            System.out.println("Code Already Exists;");
            System.out.println("1.Try Again");
            System.out.println("2.Main Menu");
            int javab = sc.nextInt();
            if (javab == 1) {
                createNatureResource();
            } else {
                Intro.mainMenu();
            }
        }
        System.out.println("Please Enter animal Type : ");
        String animal_type = sc.nextLine();
        System.out.println("Please Enter plant type : ");
        String plant_type = sc.nextLine();
        System.out.println("Please Enter City : ");
        String city = sc.nextLine();
        System.out.println("Please Enter land name : ");
        String lands = sc.nextLine();
        System.out.println("Please Enter Country : ");
        String country = sc.nextLine();
        System.out.println("Please Enter Area name : ");
        String Area = sc.nextLine();
        NatureResources newNature = new NatureResources(animal_type, plant_type, lands, country, Area, ssn, city);
        newNature.submit();
        System.out.println("Your Data Submitted Succesfully ! ");

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

    public static void editNatureResource() {
        Scanner sc = new Scanner(System.in);
        // * Clears the command prompt \

        SystemClear.main();
        System.out.println("====================================================");
        System.out.println("Please Enter Code : ");
        String ssn = sc.nextLine();
        Boolean checker = DuplicateSsn.codeChecker(ssn);
        // * Code Is Validated Here
        if (checker == false) {
            // * Clears the command prompt \

            SystemClear.main();
            System.out.println("====================================================");

            System.out.println("Cannot Find Code");
            System.out.println("1.Try Again");
            System.out.println("2.Main Menu");
            int javab = sc.nextInt();
            if (javab == 1) {
                editNatureResource();
            } else {
                Intro.mainMenu();
            }
        }
        System.out.println("Please Enter animal Type : ");
        String animal_type = sc.nextLine();
        System.out.println("Please Enter plant type : ");
        String plant_type = sc.nextLine();
        System.out.println("Please Enter City : ");
        String city = sc.nextLine();
        System.out.println("Please Enter land name : ");
        String lands = sc.nextLine();
        System.out.println("Please Enter Country : ");
        String country = sc.nextLine();
        System.out.println("Please Enter Area name : ");
        String Area = sc.nextLine();
        NatureResources newNature = new NatureResources(animal_type, plant_type, lands, country, Area, ssn, city);
        newNature.edit();
        System.out.println("Your Data Edited Succesfully ! ");

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

}
