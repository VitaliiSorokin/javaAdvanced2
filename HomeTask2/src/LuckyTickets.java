public class LuckyTickets {


    public static void main(String[] args) {
        int counter = 0;
        for (int i = 1; i < 1000000; i++){
            int leftSide = i/1000;
            int rightSide = i%1000;
            if(getSumOfDigits(leftSide) == getSumOfDigits(rightSide)) {
                counter++;
            }
        }
        System.out.println("Total number of lucky tickets is " + counter);
    }


    private static int getSumOfDigits(int input) {
        int sum = 0;
        while (input > 0) {
            sum += input % 10;
            input = input / 10;
        }
        return sum;
    }
}
