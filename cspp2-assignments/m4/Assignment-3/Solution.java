
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<=n-1;i++) {
			String s=sc.next();
			int res=binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static int binaryToDecimal(String str) {
		int decimal = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				decimal += java.lang.Math.pow(2, str.length()-1-i); 
			}
		}
		return decimal;
	}

}
