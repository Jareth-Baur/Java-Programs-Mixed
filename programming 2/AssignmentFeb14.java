import java.util.*;
public class AssignmentFeb14{
	public static void main (String[] jareth){
		Scanner SC = new Scanner(System.in);

		String value = "";
		int length = 0, index = 0, counter = 0;
		
		System.out.print("Input array length: ");
		length = SC.nextInt();
		String[] myArray = new String[length];

		do{
			do{
				System.out.print("Input array Index: ");
				index = SC.nextInt();
			}while (index>=length || index<0 || myArray[index]!=null);

			SC = new Scanner(System.in);
			System.out.print("Input array Value: ");
			value = SC.nextLine();

			if ( (value.length()%2 )==1 ) {
				myArray[index] = value;
				counter++;		
			}else{
				myArray[index] = null;
			}

			for (int b=0; b<myArray.length; ++b) {
				System.out.print(myArray[b]+",");
			}
			System.out.println();
		}while (counter<myArray.length);

		for (int c=myArray.length-1; c>=0; c--) {
			System.out.print(myArray[c]+",");
		}
	}
}