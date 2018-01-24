import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.print("Please, guess the number between 1 & 10: ");
        System.out.println(new Scanner(System.in).nextInt() == (int) (Math.random() * 10 + 1) ?
                "Good Job, Lucky!" : "Try your luck next time!");
    }
}
