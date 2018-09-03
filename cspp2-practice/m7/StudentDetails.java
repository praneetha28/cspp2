import java.util.Scanner;
import java.lang.Math.*;
class StudentDetails {
	String name;
	String rollno;
	double m1, m2, m3;
	StudentDetails(String n, String rno, double m1, double m2, double m3) {
		this.name = n;
		this.rollno = rno;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}
	public static double gpa (double m1, double m2, double m3) {
		double res = (m1 + m2 + m3) / 3;
		return (Math.floor(res*10))/10;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String rollno = sc.nextLine();
		double m1 = sc.nextDouble();
		double m2 = sc.nextDouble();
		double m3 = sc.nextDouble();
		StudentDetails s = new StudentDetails(name, rollno, m1, m2, m3);
		System.out.println(s.gpa(m1, m2, m3));	
	}
}