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
    *function
*/
    private Solution() {
        //constructor
    }
    /**.
        * @param args of type string : command line arguments
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int rno = sc.nextInt();
        System.out.println("Name : " + name + " Roll Number : " + rno);
    }
}