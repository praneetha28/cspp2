import java.util.Scanner;
public class area_of_circle {
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        double res;
        res = area(r);
        System.out.println(res);
    }
    public static double area(int r) {
        double ar;
        ar = pi() * r * r;
        return ar;

    }
    public static double pi() {
        return 3.14;
    }
}