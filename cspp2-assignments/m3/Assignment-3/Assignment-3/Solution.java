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
    private Solution() {
        //constructor
    }
    /**.
        * @param args of type string : command line arguments
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int res = gcd(n1, n2);
        System.out.println(res);
    }
    /**.
    Need to write the gcd function and print the output.
    *@return float
    /**
    * this is comment of function
    * @param a **this is one number**
    * @param b **this is two number**
    */
    public static int gcd(final int a, final int b) {
        int gcdnumber = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcdnumber = i;
            }
        }
        return gcdnumber;
    }
}

