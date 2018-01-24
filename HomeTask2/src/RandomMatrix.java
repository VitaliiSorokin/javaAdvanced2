import java.util.Arrays;
import java.util.Random;

public class RandomMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[8][5];
        Random rand = new Random();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = rand.nextInt(90) + 10;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(i + ": " + Arrays.toString(matrix[i]));
        }
    }
}
