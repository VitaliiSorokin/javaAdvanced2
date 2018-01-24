public class ClockSymmetry {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                int hLeft = i / 10;
                int hRight = i % 10;
                int mLeft = j / 10;
                int mRight = j % 10;

                if (hLeft == mRight && hRight == mLeft) {
                    counter++;
                }
            }
        }
        System.out.println("Total number of symmetric combinations is: " + counter);
    }
}
