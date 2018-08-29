/**.
    * Author : praneetha.
    * date : 29/08/18
*/

import java.util.Scanner;
/**.
	Do not modify this main function.
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

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int i = 0;
    	int count = 0;
    	for (i = 1; i <= n; i ++)
    	{
        	int j = i;
        	while (j != 0)
        	{
            	if (j % 10 == 7)
                	count ++;
            	j = j/10;
        	}
    	}
    	System.out.println(count);
    }
}