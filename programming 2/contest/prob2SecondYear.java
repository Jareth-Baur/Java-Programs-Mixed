import java.util.*;
public class prob2SecondYear {
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);

		System.out.print("Input number of strings: ");
		int length = SC.nextInt();

		String[] arr = new String[length];
		int index = 0;
		String letter = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String value1 = "", value2 = "", newval1 = "", newval2 = "";

		for (int q=0; q<length; q++) {
			do {
				System.out.print("Input index: ");
				index = SC.nextInt();
			} while (index>=length || index<0 || arr[index]!=null);
			SC = new Scanner (System.in);

			System.out.print("Input string 1: ");
			value1 = SC.nextLine();

			System.out.print("Input string 2: ");
			value2 = SC.nextLine();

			newval1 = "";
			newval2 = "";
			for (int w=0; w<value1.length(); w++) {
				if (letter.matches("(.*)"+value1.charAt(w)+"(.*)")) {
					newval1 += value1.charAt(w)+"";
				}
			}
			for (int w1=value2.length()-1; w1>=0; w1--) {
				if (letter.matches("(.*)"+value2.charAt(w1)+"(.*)")) {
					newval2 += value2.charAt(w1)+"";
				}
			}
			if (newval1.equalsIgnoreCase(newval2)) {
				arr[index] = "Palindrome";
			}else{
				arr[index] = "not";
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}