/**.
    * Author : praneetha.
    * date : 28/08/18
*/
import java.util.Scanner;
/**.
    * scanner function for taking user inputs
*/
public final class Solution {
    /**.
    Do not modify this main function.
    */
    private Solution() {
        //constructor
    }
    /**.
        * @param args of type string : command line arguments
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**.
    Need to write the power function and print the output.
    *@return float
    /**
    * this is comment of function
    * @param b **this is base number**
    * @param e **this is exponent number**
    */
    public static long power(final int b, final int e) {
        if (e != 0) {
            return (b * power(b, e - 1));
        } else {
            return 1;
        }
    }
}
