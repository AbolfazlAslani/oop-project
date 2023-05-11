package menu;

import app.HumanResources;
import utils.DuplicateSsn;
import utils.*;

import java.util.Scanner;

public class HumanResourceMenu {
    public static void createHumanResource() {
        Scanner sc = new Scanner(System.in);
        // * Clears the command prompt \

        SystemClear.main();
        System.out.println("====================================================");
        System.out.println("Please Enter SSN : ");
        String ssn = sc.nextLine();
        Boolean checker = DuplicateSsn.checker(ssn);
        // * SSN Is Validated Here
        if (checker) {
            // * Clears the command prompt \

            SystemClear.main();
            System.out.println("====================================================");

            System.out.println("SSN Already Exists;");
            System.out.println("1.Try Again");
            System.out.println("2.Main Menu");
            int javab = sc.nextInt();
            if (javab == 1) {
                createHumanResource();
            } else {
                Intro.mainMenu();
            }
        }
        System.out.println("Please Enter Name : ");
        String name = sc.nextLine();
        System.out.println("Please Enter Lastname : ");
        String lastname = sc.nextLine();
        System.out.println("Please Enter City : ");
        String city = sc.nextLine();
        System.out.println("Please Enter Address : ");
        String Address = sc.nextLine();
        System.out.println("Please Enter Job : ");
        String Job = sc.nextLine();
        System.out.println("Please Enter Age : ");
        String Age = sc.nextLine();
        System.out.println("Please Enter Sex : ");
        String sex = sc.nextLine();
        System.out.println("Please Enter Nation : ");
        String nation = sc.nextLine();
        HumanResources newPerson = new HumanResources(name, lastname, ssn, city, Age, Address, Job, sex, nation);
        newPerson.submit();
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

    public static void editHumanResource() {
        Scanner sc = new Scanner(System.in);
        // * Clears the command prompt \

        SystemClear.main();
        System.out.println("====================================================");
        System.out.println("Please Enter SSN : ");
        String ssn = sc.nextLine();
        Boolean checker = DuplicateSsn.checker(ssn);
        // * SSN Is Validated Here
        if (checker == false) {
            // * Clears the command prompt \

            SystemClear.main();
            System.out.println("====================================================");

            System.out.println("Cannot Find SSN");
            System.out.println("1.Try Again");
            System.out.println("2.Main Menu");
            int javab = sc.nextInt();
            if (javab == 1) {
                editHumanResource();
            } else {
                Intro.mainMenu();
            }
        }
        System.out.println("Please Edit Name : ");
        String name = sc.nextLine();
        System.out.println("Please Edit Lastname : ");
        String lastname = sc.nextLine();
        System.out.println("Please Edit City : ");
        String city = sc.nextLine();
        System.out.println("Please Edit Address : ");
        String Address = sc.nextLine();
        System.out.println("Please Edit Job : ");
        String Job = sc.nextLine();
        System.out.println("Please Edit Age : ");
        String Age = sc.nextLine();
        System.out.println("Please Edit Sex : ");
        String sex = sc.nextLine();
        System.out.println("Please Edit Nation : ");
        String nation = sc.nextLine();
        HumanResources newPerson = new HumanResources(name, lastname, ssn, city, Age, Address, Job, sex, nation);
        newPerson.edit();
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
