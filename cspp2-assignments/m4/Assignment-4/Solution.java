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
     Fill the main function to reverse the string
    */
    private Solution() {
        //constructor
    }
    /**.
        * @param args of type string : command line arguments
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**.
    Need to write the function for conversion
    *@return string
    /**
    * this is comment of function
    * @param str **this is word**
    */
    public static String reverseString(final String str) {
        String rev = "";
        for (int i = 0; i < str.length(); i++) {
            rev = str.charAt(i) + rev;
        }
        return rev;
    }

}
