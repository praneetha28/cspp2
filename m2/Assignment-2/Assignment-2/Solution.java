import java.util.Scanner;
import java.lang.Math.*;
public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		double res;
		res = rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	public static double rootsOfQuadraticEquation(int a, int b, int c) {
		double det;
		det = b * b - 4 * a * c;
		double r1;
		double r2;
		r1 = (-b+Math.sqrt(det))/(2*a);
        r2 = (-b-Math.sqrt(det))/(2*a);
        System.out.println(+ r1 + " " + r2);
        return 0;
	}
}
