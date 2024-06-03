import java.util.*;
public class ass2{
	public static void main (String[] jareth){	
		Scanner SC = new Scanner (System.in);

		boolean z = true;
		String p = "", num = "";
		while (z==true) {
			System.out.print("Please Input Phone Number: ");
			num = SC.nextLine();
			int q = num.length();

			if (q == 11 && num.charAt(0) == '0' && num.charAt(1) == '9' && 
				num.charAt(2) >= '0' && num.charAt(2) <= '9' &&
				num.charAt(3) >= '0' && num.charAt(3) <= '9' &&
				num.charAt(4) >= '0' && num.charAt(4) <= '9' &&
				num.charAt(5) >= '0' && num.charAt(5) <= '9' &&
				num.charAt(6) >= '0' && num.charAt(6) <= '9' &&
				num.charAt(7) >= '0' && num.charAt(7) <= '9' &&
				num.charAt(8) >= '0' && num.charAt(8) <= '9' &&
				num.charAt(9) >= '0' && num.charAt(9) <= '9' &&
				num.charAt(10) >= '0' && num.charAt(10) <= '9' ) {
				System.out.println("Your Number "+num+" is Valid.");
				System.out.print("Invalid Numbers You Input is "+p);
				z = false;
			}else{
				p += num+",";
				System.out.println("Invalid Number!");
				System.out.println();
			}
		}
	}
}