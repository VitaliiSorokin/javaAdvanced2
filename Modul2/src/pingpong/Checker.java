package pingpong;

import java.util.Scanner;

import static pingpong.Game.isEntered;

public class Checker implements Runnable {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an answer to win .. ");
        if (scanner.hasNext()) {
            isEntered = true;
        }
    }
}
