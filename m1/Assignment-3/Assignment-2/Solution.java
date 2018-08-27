import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float res;
		int base = scan.nextInt();
		int height = scan.nextInt();
		res = areaOfTriangle(base, height);
		System.out.println(res);
	}
	/*
	Need to fill the areaOfTriangle function and print the output
	of fahrenheit.
	*/
	public static int areaOfTriangle(int b, int h) {
		return (b *h)/2;
	}
}