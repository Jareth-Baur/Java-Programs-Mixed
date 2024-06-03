import java.util.*;
public class Assignment1mar6{
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);

		int index=0,counter=0;
		System.out.print("Input array length: ");
		int length = SC.nextInt();
		String[] myArray = new String[length];
		String[] myArray2 = new String[length];
		do {
			do {
				System.out.print("Input array index: ");
				index = SC.nextInt();
			}while (index>=length || myArray[index]!=null || index<0);
			SC = new Scanner (System.in);

			System.out.print("Input array value: ");
			myArray[index] = SC.nextLine();
			
			for (int c=0; c<length; c++) {
				myArray2[c] = myArray[c];
			}
			for (int i=0; i<length; ++i) {
				for (int j=i+1; j<length; ++j) {
					if ( (myArray2[i]!=null && myArray2[j]!=null)
						&& myArray2[i].length() > myArray2[j].length()
						|| (myArray2[i]==null && myArray2[j]!=null) ) {
						String temp = myArray2[i];
						myArray2[i] = myArray2[j];
						myArray2[j] = temp;
					}
				}
			}

			for (int q=0; q<length; q++) {
				if (q==length-1) {
					System.out.print(myArray2[q]+".");
				}else{
					System.out.print(myArray2[q]+",");
				}
			}
			System.out.println();
			counter++;
		}while (counter<length);
	}
}