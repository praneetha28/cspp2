/**.
    * Author : praneetha.
    * date : 31/08/18
*/
import java.util.Scanner;
/**.
    * scanner function for taking user input
*/
public final class Solution {
    /**.
     Fill the main function to convert binary to decimal
    */
    private Solution() {
        //constructor
    }
    /**.
        * @param args of type string : command line arguments
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n - 1; i++) {
            sc.nextLine();
            String s = sc.nextLine();
            int res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**.
    Need to write the function for conversion
    *@return int
    /**
    * this is comment of function
    * @param str **this is binary number**
    */
    public static int binaryToDecimal(final String str) {
        int decimal = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                decimal += Math.pow(2, str.length() - 1 - i);
            }
        }
        return decimal;
    }

}
