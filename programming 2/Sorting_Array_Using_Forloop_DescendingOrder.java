import java.util.*;
public class Sorting_Array_Using_Forloop_DescendingOrder{
	public static void main (String[] jareth){
		Scanner SC = new Scanner(System.in);
		
		int value = 0,index=0,counter=0;
		System.out.print("Input array length: ");
		int length = SC.nextInt();
		int[] myArray = new int[length];

		do {
			do {
				System.out.print("Input array Index: ");
				index = SC.nextInt();
			}while(index>=length || myArray[index]>0 || index<0);
			System.out.print("Input array value: ");
			value = SC.nextInt();

			if (myArray[index]>0 || myArray[index]<0) {
			}else{
				myArray[index] = value;
				counter++;
				int temp = 0;
				for (int i=0; i<myArray.length-1; i++) {
					for (int j=i+1; j<myArray.length-1; j++) {
						if (myArray[i] < myArray[j]) {
							temp = myArray[i];
							myArray[i] = myArray[j];
							myArray[j] = temp;
						}
					}
					if (i == myArray.length-1) {
						System.out.print(myArray[i]);
					}else{
						System.out.print(myArray[i]+",");
					}
				}
			}
			System.out.println();
		}while(counter<length);
		System.out.println();
	}
}