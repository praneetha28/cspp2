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
    public static final int N_U_M_B_E_R = 9;
    /**.
        this is to calculate farenheit using celsius
    */
    public static final int N_U_M = 5;
    /**.
        this is to calculate farenheit using celsius
    */
    public static final int N_O = 32;
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
        double fahrenheit;
        double c = scan.nextDouble();
        fahrenheit = calculateFromDegreesToFarenheit(c);
        System.out.println(fahrenheit);
    }
    /**
    Need to fill the calculateFromDegreesToFarenheit and print the output
    of fahrenheit.
    *@return float
    /**
    * this is comment of function
    * @param c **this is to calculate farenheit using celsius**
    */
    public static double calculateFromDegreesToFarenheit(final double c) {
    /**.
    function
    */
        return (c * N_U_M_B_E_R / N_U_M) + N_O;
    }
}
