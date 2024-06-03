import java.util.*;
public class valueException{
	public static void main (String[] jareth){
		Scanner SC = new Scanner(System.in);
		int index = 0, counter = 0, sum = 0;

		System.out.print("Input array length: ");
		int length = SC.nextInt();
		int[] myArray = new int[length];
		int[] myArray2 = new int[length];

		do {
			do {
				System.out.print("Input array index: ");
				index = SC.nextInt();
			}while (index>=length || myArray[index]>0 || index<0);
			SC = new Scanner(System.in);
			
			int value = 0;
			do {
			    try { 
			        System.out.print("Input positive even value: ");
			        value = SC.nextInt();
			    } catch (InputMismatchException e) {
			        
			    }
			SC.nextLine();
			} while (value <= 0 || (value%2)!=0);
			myArray[index] = value;
			
			for (int q=0; q<length; q++) {
				myArray2[q] = myArray[q];
				sum += myArray[q];
			}
			for (int w=0; w<length; w++) {
				System.out.print(myArray2[w]+",");
			}
			System.out.println();
			System.out.print("Sum of values: "+sum);
			System.out.println();
			counter++;
		}while (counter<length);
	}
}