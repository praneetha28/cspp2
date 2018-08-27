import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double fahrenheit;
		double degreesCelsius = scan.nextDouble();
		fahrenheit = calculateFromDegreesToFarenheit(degreesCelsius);
		System.out.println(fahrenheit);
	}
	/*
	Need to fill the calculateFromDegreesToFarenheit function and print the output
	of fahrenheit.
	*/
	public static double calculateFromDegreesToFarenheit(double c){
	return(c*9/5)+32;	
	}
}