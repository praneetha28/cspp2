import java.util.Scanner;

public class degrees_to_farenheit {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double fahrenheit;
		double c = scan.nextDouble();
		fahrenheit = (c*9/5)+32;
		System.out.println(fahrenheit);
	}
}