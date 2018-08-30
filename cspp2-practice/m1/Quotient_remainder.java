import java.util.Scanner;
public class Quotient_remainder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		float quot;
		float rem;
		quot = a / b;
		rem = a % b;
		System.out.println(quot);
		System.out.println(rem);
	}
}