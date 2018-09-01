import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : Praneetha
 */
    public final class Solution {
    /**
     * Constructs the object.
     */
    public static final int N_U_M = 50;
    /**.
     * number */
    public static final int N_U_M_1 = 100;
    /**.
     * number */
    public static final int N_U_M_2 = 150;
    /**.
     * number */
    public static final int N_U_M_3 = 200;
    /**.
     * number */
    public static final int N_U_M_4 = 250;
    /**.
     * number */
    public static final int N_U_M_5 = 300;
    /**.
     * number */
    public static final int N_U_M_6 = 350;
    /**.
     * number */
    public static final int N_U_M_7 = 400;
    /**.
     * number */
    public static final int N_U_M_8 = 450;
    /**.
     * number */
    public static final int N_U_M_9 = 500;
    /**.
     * number */
    public static final int N_U = 550;
    /**.
     * number */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a,
        final int rows, final int columns) {

    // write ypur code here
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (a[i][j] >= N_U_M && a[i][j] < N_U_M_2) {
                    a[i][j] = N_U_M_1;
                } else if (a[i][j] >= N_U_M_2 && a[i][j] < N_U_M_4) {
                    a[i][j] = N_U_M_3;
                } else if (a[i][j] >= N_U_M_4 && a[i][j] < N_U_M_6) {
                    a[i][j] = N_U_M_5;
                } else if (a[i][j] >= N_U_M_6 && a[i][j] < N_U_M_8) {
                    a[i][j] = N_U_M_7;
                } else if (a[i][j] >= N_U_M_8 && a[i][j] < N_U) {
                    a[i][j] = N_U_M_9;
                }
            }
        }
        return a;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
