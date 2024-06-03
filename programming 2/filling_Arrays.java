import java.util.*;
public class filling_Arrays{
	public static void main (String[] jareth){
		Scanner SC = new Scanner(System.in);
		int[] myArray = new int[10];
		int index = 0, value = 0;
		for (int b=0; b<myArray.length; b++) {
			do{
				System.out.print("Input specific index: ");
				index = SC.nextInt();
			}while(index >= myArray.length || myArray[index] > 0);

			System.out.print("Input specific value: ");
			myArray[index] = SC.nextInt();

			for (int a=0; a<myArray.length; a++) {
				System.out.print(myArray[a]+",");
			}
			System.out.println();
		}
	}
}