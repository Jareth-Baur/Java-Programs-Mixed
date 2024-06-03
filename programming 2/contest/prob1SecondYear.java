import java.util.*;
public class prob1SecondYear {
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);

		System.out.print("Input number of strings: ");
		int length = SC.nextInt();

		int[] arr = new int[length];
		int index = 0,counter =0;
		String value1 = "",value2 = "",matcher = "";
		for (int q=0; q<length; q++) {
			do {
				System.out.print("Input index: ");
				index = SC.nextInt();
			} while (index>=length || index<0 || arr[index]>0);
			SC = new Scanner (System.in);

			System.out.print("Input string 1: ");
			value1 = SC.nextLine();

			System.out.print("Input string 2: ");
			value2 = SC.nextLine();
			
			matcher = value2.toLowerCase()+"";
			for (int w=0; w<value1.length(); w++) {
				String temp = value1.charAt(w)+"";
				if (matcher.matches("(.*)"+temp+"(.*)")) {
					counter++;
				}
			}
			arr[index] = counter;
			System.out.println(Arrays.toString(arr));
		}
	}
}