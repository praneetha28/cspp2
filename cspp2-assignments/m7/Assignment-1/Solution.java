import java.util.*;
class InputValidator
{
	/*Write the atrributes and methods for InputValidator*/
	String data;
	int length;
	InputValidator(String data, int len) {
		this.data = data;
		this.length = len;
	}
	public static boolean validateData(int length) {
		if(length >= 6) {
			return true;
		} else {
			return false;
		}
	}

}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	int length = input.length();
    	InputValidator i=new InputValidator(input, length);    	
    	System.out.println(i.validateData(length));

    }

}
