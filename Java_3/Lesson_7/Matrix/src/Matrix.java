import java.util.Arrays;

public class Matrix {

    static final int S = 5;
    static int[][] matrix = new int[S][S];

    public static void main(String[] args) {

        printSpiralMatrix(S);

    }

    public static void printSpiralMatrix(int SIZE) {

        // input conditions

        int num = 1;
        int i = 0;
        int j = -1;
        boolean reverse = false;

        //

        horizontal(SIZE, num, i, j, reverse);
        for (int x = 0; x < matrix.length; x++) {
            System.out.println(Arrays.toString(matrix[x]));
        }
    }

    public static void horizontal(int SIZE, int num, int i, int j, boolean reverse) {

        if (SIZE <= 0)
            return;

        if (reverse) {
            for (int k = 0; k < SIZE; k++) {
                j--;
                matrix[i][j] = num++;
            }
        } else {
            for (int k = 0; k < SIZE; k++) {
                j++;
                matrix[i][j] = num++;
            }
        }

        vertical(--SIZE, num, i, j, switchReverse(reverse));
    }

    public static void vertical(int SIZE, int num, int i, int j, boolean reverse) {

        if (SIZE <= 0)
            return;

        if (reverse) {
            for (int k = 0; k < SIZE; k++) {
                i++;
                matrix[i][j] = num++;
            }
        } else {
            for (int k = 0; k < SIZE; k++) {
                i--;
                matrix[i][j] = num++;
            }
        }

        horizontal(SIZE, num, i, j, reverse);
    }

    public static boolean switchReverse (boolean reverse) {
        if (reverse) {
            reverse = false;
            return reverse;
        } else {
            reverse = true;
            return reverse;
        }
    }

}
