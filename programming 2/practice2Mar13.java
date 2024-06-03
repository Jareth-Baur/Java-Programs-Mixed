import java.util.*;
public class practice2Mar13 {
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);
		int index=0,counter=0;
		System.out.print("Input array length: ");
		int length = SC.nextInt();

		int[] myArray = new int[length];
		int[] myArray2 = new int[length];
		do {
			do {
				System.out.print("Input array index: ");
				index = SC.nextInt();
			}while (index>=length || myArray[index]>0 || index<0);
			SC = new Scanner (System.in);

			System.out.print("Input array value: ");
			String value = SC.nextLine();
			myArray[index] = value.length();

			for (int c=0; c<length; c++) {
				myArray2[c] = myArray[c];
			}
			
			System.out.print(Arrays.toString(myArray2));
			System.out.println();
			counter++;
		}while (counter<length);
	}
}