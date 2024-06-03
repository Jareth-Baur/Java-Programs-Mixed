import java.util.*;
public class Conversion{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);

		int conversion = 0, month = 0, day = 0;
		int a, b, c;

		System.out.println("1 = Conversion of month");
		System.out.println("2 = Conversion of day");
		System.out.println("Choose type of conversion.");
		conversion = SC.nextInt();

		if (conversion == 1){
			System.out.println("Please input number from 1-12 to convert to month.");
			month = SC.nextInt();
			switch(month){
				case 1:
				System.out.print("January");
				break;
				case 2:
				System.out.print("February");
				break;
				case 3:
				System.out.print("March");
				break;
				case 4:
				System.out.print("April");
				break;
				case 5:
				System.out.print("May");
				break;
				case 6:
				System.out.print("June");
				break;
				case 7:
				System.out.print("July");
				break;
				case 8:
				System.out.print("August");
				break;
				case 9:
				System.out.print("September");
				break;
				case 10:
				System.out.print("October");
				break;
				case 11:
				System.out.print("November");
				break;
				case 12:
				System.out.print("December");
				break;
				default:
				System.out.print("Invalid month!");
				break;
			}
		}else if (conversion == 2){
			System.out.println("Please input number from 1-7 to convert to day.");
			month = SC.nextInt();
			switch(day){
				case 1:
				System.out.print("Monday");
				break;
				case 2:
				System.out.print("Tuesday");
				break;
				case 3:
				System.out.print("Wednesday");
				break;
				case 4:
				System.out.print("Thursday");
				break;
				case 5:
				System.out.print("Friday");
				break;
				case 6:
				System.out.print("Saturday");
				break;
				case 7:
				System.out.print("Sunday");
				break;
				default:
				System.out.print("Invalid day!");
				break;
			}
		}else{
			System.out.print("Invalid Number!");
		}	
	}
}