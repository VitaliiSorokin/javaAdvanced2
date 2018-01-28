import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Horse first = new Horse();
        Horse second = new Horse();
        Horse third = new Horse();
        Horse fourth = new Horse();
        Horse fifth = new Horse();

        first.setName("First Horse");
        second.setName("Second Horse");
        third.setName("Third Horse");
        fourth.setName("Fourth Horse");
        fifth.setName("Fifth Horse");

        Horse[] horses = new Horse[]{
                first, second, third, fourth, fifth
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select horse from 1 to 5: ");

        String chosenName = horses[scanner.nextInt() - 1].getName();

        System.out.println("You chose " + chosenName);
        System.out.println("--------------------- Race starts ----------------");

        for (Horse horse : horses) {
            horse.start();
        }

        int position = 1;
        String winnersName = null;
        while (position < 6) {
            for (Horse horse : horses) {
                if (!horse.isAlive() && !horse.getFinished()) {
                    if (winnersName == null) {
                        winnersName = horse.getName();
                    }

                    System.out.println(horse.getName() + " has finished at " + position++ + " position");
                    horse.setFinished(true);
                }
            }
        }
        System.out.println("----------------- Race finished -------------------");

        if (winnersName.equals(chosenName)) {
            System.out.println("Congratulations! Your horse has won the race!");
        } else {
            System.out.println("Try your luck next time!");
        }

    }
}
