import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number and you'll get the sum of digits in it: ");
        int number = myScanner.nextInt();
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        System.out.println("Sum of digits is " + sum);
    }
}
