/**.
    * Author : praneetha.
    * date : 3/09/18
*/
import java.util.Scanner;
/**.
    * scanner function for taking user input
*/
class InputValidator {
    /**.
     *Write the atrributes and methods for InputValidator
    */
    private String data;
    /**.
     attributes
    */
    private int length;
    /**.
        constructor
    */
    /**.
    * this is comment of function
    * @param str **data**
    * @param len **len for data**
    */
    InputValidator(final String str, final int len) {
        this.data = str;
        this.length = len;
    }
    /**.
        method for comapring
    */
    public static final int N_U_M = 6;
    /**.
        this is to compare
    */
    /**.
    Need to write function for validating.
    *@return boolean
    /**
    * this is comment of function
    * @param length **len for data**
    */
    public static boolean validateData(final int length) {
        if (length >= N_U_M) {
            return true;
        }
        return false;
    }
}
/**.
    main class
*/
public final class Solution {
    /**.
     Fill the main class
    */
    private Solution() {
        //constructor
    }
    /**.
        * @param args of type string : command line arguments
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        int length = input.length();
        InputValidator i = new InputValidator(input, length);
        System.out.println(i.validateData(length));
    }
}

