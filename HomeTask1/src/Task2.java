import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Enter a two-digit number:");
        int n = new Scanner(System.in).nextInt();
        System.out.println("Sum of digits in your number is: " + (n / 10 + n % 10));
    }
}
