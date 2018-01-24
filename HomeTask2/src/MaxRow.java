import java.util.Arrays;
import java.util.Random;

public class MaxRow {
    public static void main(String[] args) {
        int[][] matrix = new int[7][4];
        int maxMultipl = 1;
        int maxMultiRowIndex = 0;
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            int tempMaxMultipl = 1;
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(11) - 5;
                tempMaxMultipl *= Math.abs(matrix[i][j]);
            }
            if (tempMaxMultipl > maxMultipl) {
                maxMultipl = tempMaxMultipl;
                maxMultiRowIndex = i;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            System.out.println(i + ": " + Arrays.toString(matrix[i]));
        }
        System.out.println("Biggest row index is: " + maxMultiRowIndex);
    }
}
