/**.
    * Author : praneetha.
    * date : 29/08/18
*/

import java.util.Scanner;
/**.
    * scanner function for taking user inputs
*/
public final class Solution {
    /**.
     Fill the main function to print the number of 7's between 1 to n
    */
    public static final int N_O = 10;
    /**.
     * { var_description }
    */
    public static final int N_U_M = 7;
    /**.
     * { var_description }
    */
    private Solution() {
        //constructor
    }
    /**.
        * @param args of type string : command line arguments
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 0;
        int count = 0;
        for (i = 1; i <= n; i++) {
            int j = i;
            while (j != 0) {
                if (j % N_O == N_U_M) {
                    count++;
                }
                j = j / N_O;
            }
        }
        System.out.println(count);
    }
}
