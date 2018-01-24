import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int[] fibbArr = new int[11];
        fibbArr[0] = 1;
        fibbArr[1] = 1;
        for (int i = 2; i < fibbArr.length; i++) {
            fibbArr[i] = fibbArr[i - 2] + fibbArr[i - 1];
        }
        System.out.println(Arrays.toString(fibbArr));
    }
}
