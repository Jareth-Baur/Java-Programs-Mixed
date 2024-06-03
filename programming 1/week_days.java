import java.util.*;
public class week_days{
	public static void main (String[] jareth){
		Scanner SC = new Scanner (System.in);

		System.out.print("Input Week: ");
		int week = SC.nextInt();

		System.out.print("Input Days: ");
		int days = SC.nextInt();

		for (int a = 1; a<= week; ++a) {
			System.out.println("Week "+a);
			for (int b = 1; b<= days; ++b) {
				System.out.println("			Day "+b);
			}
		}
	}
}