import java.util.Scanner;
public class factorial {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int res = factorial(num);
        System.out.println(res);
    }
    public static int factorial(int n) {
        if (n != 0) {
            return (n * factorial(n - 1));
        } else {
            return 1;
        }
    }
        
}