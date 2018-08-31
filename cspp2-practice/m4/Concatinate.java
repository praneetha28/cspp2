import java.util.Scanner;
public class Concatinate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str2 = sc.nextLine();
		String res = helloName(str2);
		System.out.println(res);
	}
	public static String helloName(String s) {
		String str = "Hello ";
		return str.concat(s+"!");
	}
}