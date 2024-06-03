import java.util.*;
public class prelim1 {
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);

		System.out.print("Enter the length of the array: ");
		int length = SC.nextInt();
		int value = 0;
		int[] arr = new int[length];

		for (int q=0; q<length; q++) {
			do {
				System.out.print("Enter a positive integer for index "+q+": ");
				value = SC.nextInt();
				if (value < 0) {
					System.out.println("Invalid input. Please enter a valid positive integer. ");
				}
			}while ((value%2)!=0);
			arr[q] = value;
		}
		System.out.print("Array: "+Arrays.toString(arr));
	}
}