import java.util.*;
public class do_while{
	public static void main (String[] jareth){
		Scanner SC = new Scanner(System.in);
		int a = 0, num =0;
		do {
			System.out.print("enter a number between 1 and 10: ");
			num = SC.nextInt();
		}while (num<1 || num>10);
	System.out.println(num+" is a number from 1 to 10");		
	}
}