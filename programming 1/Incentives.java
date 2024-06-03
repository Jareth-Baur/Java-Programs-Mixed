import java.util.*;
public class Incentives{
	public static void main(String[] args){
		Scanner SC = new Scanner(System.in);

		int  mon = 0;
		double in1,in2,in3;

		System.out.print("Enter months of service: ");
		mon = SC.nextInt();

		System.out.println("You Served "+mon+" months");

		if(mon<=12){
			in1 = 30000*0.60;
			System.out.println("You can get "+in1+" incentives.");
			System.out.println("Rank and File employee");
		}else if(mon>12 && mon<=60){
			in2 = 30000*0.80;
			System.out.println("You can get "+in2+" incentives.");
			System.out.println("Rank and File employee");
		}else if(mon>60){
			in3 = 30000*0.90;
			System.out.println("You can get "+in3+" incentives.");
			System.out.println("Excecutives");
		}
	}
}