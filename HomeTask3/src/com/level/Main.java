package com.level;

import com.level.courtesan.Courtesan;
import com.level.courtesan.impl.AsianCourtesan;
import com.level.courtesan.impl.EuropeanCourtesan;
import com.level.courtesan.impl.LatinaCourtesan;
import com.level.courtesan.impl.NiggaCourtesan;
import com.level.house.CourtesanArrayList;
import com.level.house.House;
import com.level.house.HouseLevel;
import com.level.house.Randomise;

import java.util.Arrays;
import java.util.Scanner;

import static com.level.house.HouseLevel.MIDDLE;

public class Main {
    private static final House HOUSE = initHouse();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMainMenu();
            switch (scanner.nextInt()) {
                case 1:
                    houseMenu();
                    break;
                case 2:
                    System.out.println("How many whores do you have? (Select from 3 to 10)");
                    int input = scanner.nextInt();
                    if (input > 2 && input < 11) {
                        addFreshGirlsMenu(scanner.nextInt());
                    } else {
                        System.out.println("We can't afford so many employers.Try again.");
                    }
                    break;
                case 3:
                    System.out.println("Around the corner");
                    return;
            }
        }

    }

    private static void houseMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------");
        HOUSE.printAll();
        System.out.println("-------------------------------------");
        printHouseMenu();
        System.out.println("-------------------------------------");

        while (true) {
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("choose sex workers # ?");
                    int workersNumber = scanner.nextInt();
                    HOUSE.getCourtesanInfo(workersNumber);
                    processMenu(HOUSE.getCourtesanNameByIndex(workersNumber));
                    break;
                case 2:
                    System.out.println("soooooo... what is your decision?");
                    workersNumber = scanner.nextInt();
                    HOUSE.getCourtesanInfo(workersNumber);
                    processMenu(HOUSE.getCourtesanNameByIndex(workersNumber));
                    break;
                case 3:
                    System.exit(0);
                case 4:
                    return;
            }
        }
    }

    private static void addFreshGirlsMenu(int count) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("You have " + count + " workers.How do you want to add them?");
        printAddNewMenu();
        System.out.println("-------------------------------------");

        while (true) {
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Adding manually...");
                    addWorkersManually(count);
                    break;
                case 2:
                    System.out.println("Adding randomly...");
                    addWorkersRandomly(count);
                    break;
                case 3:
                    System.out.println("The List of girls: ");
                    HOUSE.printAll();
                    printAddNewMenu();
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void processMenu(String courtesanName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("You are about to start you process with " + courtesanName);
        printProcessMenu();
        while (true) {
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("You are processing...");
                    System.out.println("...");
                    System.out.println("............");
                    System.out.println("...");
                    System.out.println("You are done, go home or try another.");
                    System.out.println("------ LIST of Sex Workers in da House -----");
                    HOUSE.printAll();
                    printHouseMenu();
                    return;
                case 2:
                    System.out.println("Cancelling order. Choose another.");
                    HOUSE.printAll();
                    printHouseMenu();
                    return;
                case 3:
                    System.out.println("Good bye and Fuck you!");
                    System.exit(0);
                    break;
            }
        }
    }

    private static void printProcessMenu() {
        System.out.println("1. Init fucking process.");
        System.out.println("2. Cancel process. And start over.");
        System.out.println("3. Fuck it! I'll go home.");
    }

    private static void printAddNewMenu() {
        System.out.println("1. Add manually each sex worker.");
        System.out.println("2. Add randomly all of them.");
        System.out.println("3. I wanna watch all workers.");
        System.out.println("4. I'm gonna start over.");
    }

    private static void printHouseMenu() {
        System.out.println("1. I would like to have fun with one of your girls!");
        System.out.println("2. I need to think");
        System.out.println("3. I just wanna look for free.");
        System.out.println("4. There is better choice on the street.");
    }

    private static void printMainMenu() {
        System.out.println("Welcome to " + HOUSE.getHouseName());
        System.out.println("1. Show me everyone.");
        System.out.println("2. I brought you some sex workers.");
        System.out.println("3. Where is the library? (Quit)");
    }

    private static House initHouse() {
        Courtesan[] courtesans = new Courtesan[7];

        courtesans[0] = new AsianCourtesan("Anonima1", 5, new int[]{90, 60, 90});
        courtesans[1] = new AsianCourtesan("Anonima2", 5, new int[]{90, 60, 90});
        courtesans[2] = new AsianCourtesan("Anonima3", 5, new int[]{90, 60, 90});
        courtesans[3] = new AsianCourtesan("Anonima4", 5, new int[]{90, 60, 90});
        courtesans[4] = new NiggaCourtesan("Anonima5", 5, new int[]{90, 60, 90});
        courtesans[5] = new EuropeanCourtesan("Anonima6", 5, new int[]{90, 60, 90});
        courtesans[6] = new LatinaCourtesan("Anonima7", 5, new int[]{90, 60, 90});
        return new House("Pavlovsky House", MIDDLE, courtesans);
    }

    private static void addWorkersManually(int count) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < count; i++) {
            System.out.println("Enter name: ");
            String name = scanner.next();
            System.out.println("Enter age: ");
            int age = scanner.nextInt();
            System.out.println("Enter bust,cm: ");
            int[] params = new int[3];
            params[0] = scanner.nextInt();
            System.out.println("Enter waist, cm: ");
            params[1] = scanner.nextInt();
            System.out.println("Enter hip, cm: ");
            params[2] = scanner.nextInt();
            System.out.println("You are adding " + name + ", " + age + " years old, parameters are: " + Arrays.toString(params));
            HOUSE.registration(new EuropeanCourtesan(name, age, params));
        }
        HOUSE.printAll();
        printAddNewMenu();
    }

    private static void addWorkersRandomly(int count) {
        for (int i = 0; i < count; i++) {
            String name = Randomise.getRandomName();
            int age = Randomise.getRandomAge();
            int[] params = Randomise.getRandomParams();
            HOUSE.registration(new AsianCourtesan(name, age, params));
        }
        HOUSE.printAll();
        printAddNewMenu();
    }
}
