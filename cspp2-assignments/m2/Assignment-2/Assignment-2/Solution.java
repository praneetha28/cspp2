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
    public static final int N_O = 4;
    /**.
        this is to calculate farenheit using celsius
    */
    private Solution() {
        //constructor
    }
    /**.
        * @param args of type string : command line arguments
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        double res;
        res = rtsQuadraticEq(a, b, c);
    }
    /**.
    Need to write the rootsOfQuadraticEquation and print the output.
    *@return float
    /**
    * this is comment of function
    * @param a **this is one number**
    * @param b **this is one number**
    * @param c **this is one number**
    */
    public static double rtsQuadraticEq(final int a, final int b, final int c) {
        double det;
        det = b * b - N_O * a * c;
        double r1;
        double r2;
        r1 = (-b + java.lang.Math.sqrt(det)) / (2 * a);
        r2 = (-b - java.lang.Math.sqrt(det)) / (2 * a);
        System.out.println(+r1 + " " + r2);
        return 0;
    }
}
