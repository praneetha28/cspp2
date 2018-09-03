/**.
    * Author : praneetha.
    * date : 3/09/18
*/
import java.util.Scanner;
/**.
    * scanner function for taking user input
*/
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    String data;
    int length;
    InputValidator(String data, int len) {
        this.data = data;
        this.length = len;
    }
    public static final int N_U_M = 6;
    /**.
        this is to compare
    */
    public static boolean validateData(int length) {
        if (length >= N_U_M) {
            return true;
        }
        return false;
    }

}
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
        String input = s.next();
        int length = input.length();
        InputValidator i = new InputValidator(input, length);
        System.out.println(i.validateData(length));
    }
}
