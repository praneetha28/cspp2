/**.
    * Author : praneetha.
    * date : 27/08/18
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
        Scanner scan = new Scanner(System.in);
        float res;
        int base = scan.nextInt();
        int height = scan.nextInt();
        res = areaOfTriangle(base, height);
        System.out.println(res);
    }
    /**
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    *@return float
    /**
    * this is comment of function
    * @param b **this is base of trianle**
    * @param h **this is height of triangle**
    */
    public static int areaOfTriangle(final int b, final int h) {
    /**.
    function
    */
        return (b * h) / 2;
    }
}