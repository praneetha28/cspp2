import java.util.Scanner;
public class FirstLast {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		if (arr[0] == 6 || arr[arr.length-1] == 6) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}