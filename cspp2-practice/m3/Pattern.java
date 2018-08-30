import java.util.Scanner;
public class Pattern {
	public static void main(String[] args) {
		int i = 5;
		for(i = 1;i<=5;i++) {
			for (int j = 1;j <= i;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}	
	}
}