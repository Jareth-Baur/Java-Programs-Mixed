import java.util.*;
public class practiceMar13 {
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);

		int index=0,counter=0;
		boolean retval = false;
		String value = "";
		System.out.print("Input array length: ");
		int length = SC.nextInt();

		String[] myArray = new String[length];
		String[] myArray2 = new String[length];
		
		ArrayList<String> arrlist = new ArrayList<>(length);
		do {
			do {
				System.out.print("Input array index: ");
				index = SC.nextInt();
			}while (index>=length || myArray[index]!=null || index<0);
			SC = new Scanner (System.in);
			
			do {
				System.out.print("Input array value: ");
				value = SC.nextLine();
				retval = arrlist.contains(value);
			}while(retval==true);
			arrlist.add(value);
				
			myArray[index] = value;
			
			for (int c=0; c<length; c++) {
				myArray2[c] = myArray[c];
			}
			Arrays.sort(myArray2);

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