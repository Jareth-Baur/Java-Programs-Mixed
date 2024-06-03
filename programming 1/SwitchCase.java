import java.util.*;
public class SwitchCase{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);
		String day = "";

		System.out.print("Enter a day: ");
		day = SC.nextLine();

		switch (day){
			case "Monday": case "monday":
				System.out.print("1");
			   break;
			case "Tuesday": case "tuesday":
				System.out.print("2");
			   break;
			case "Wednesday":
			case "wednesday":
				System.out.print("3");
			   break;
			case "Thursday":
			case "thursday":
				System.out.print("4");
			   break;
			case "Friday":
			case "friday":
				System.out.print("5");
			   break;
			case "Saturday":
			case "saturday":
				System.out.print("6");
			   break;
			case "Sunday":
			case "sunday":
				System.out.print("7");
			   break;
			default:
				System.out.print("Invalid!");
			   break;
		}
	}
}