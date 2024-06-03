import java.util.*;
public class Grades{
	public static void main(String[] args){
		Scanner SC = new Scanner(System.in);

		String name = "";
		int pre,mid,fin;
		double fin2;

		System.out.print("Enter your name: ");
		name = SC.nextLine();

		System.out.print("Enter prelim grade: ");
		pre = SC.nextInt();

		System.out.print("Enter prelim grade: ");
		mid = SC.nextInt();

		System.out.print("Enter prelim grade: ");
		fin = SC.nextInt();

		fin2 = (pre*0.20)+(mid*0.20)+(fin*0.60);
		System.out.println(fin2);

		if(fin2>90 && fin2<=100){
			System.out.print("Excellent Performance!");
		}else if(fin2>75 && fin2<=90){
			System.out.print("Satisfacory Performance!");
		}else if(fin2>75){
			System.out.print("Poor Performance!");
		}
	}
}