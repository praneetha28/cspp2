/**.
    * Author : praneetha.
    * date : 30/08/18
*/
import java.util.Scanner;
/**.
    * scanner function for taking user input
*/
public final class Solution {
    /**.
     Fill the main function to add two matrices
    */
    private Solution() {
        //constructor
    }
    /**.
        * @param args of type string : command line arguments
    */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] arr1 = new int[r][c];
		for (int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
            	arr1[i][j] = sc.nextInt();
            }
        }
        int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int[][] arr2 = new int[r1][c1];
		for (int i = 0; i < r1; i++) {
            for(int j = 0; j < c1; j++) {
            	arr2[i][j] = sc.nextInt();
            }
        }
        if (r == r1 && c == c1) {
        	String res1 = "";
        	int[][] res = new int[r1][c1];
        	for (int i = 0; i < r; i++) {
        		for (int j = 0; j < c1; j++) {
        			res[i][j] = arr1[i][j] + arr2[i][j];
        			res1 += res[i][j] + " ";
        		}
        		res1 += res1.trim() + "\n";
        	}
        	System.out.println(r);
        } else {
        	System.out.println("not possible");
        }
	}
}