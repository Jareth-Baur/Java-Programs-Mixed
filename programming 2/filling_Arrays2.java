import java.util.*;
public class filling_Arrays2{
	public static void main (String[] jareth){
		Scanner SC = new Scanner(System.in);
		int[] myArray = new int[3];
		int index = 0, count = 0, value = 0;
		do {
			do {
				System.out.print("Please Input Index: ");
				index = SC.nextInt();
			}while (index>=myArray.length || index<0);
				System.out.print("Please Input Value: ");
				value = SC.nextInt();

				if (myArray[index]>0) {
					System.out.println("Index "+index+" has a Value already!");
				}else{
					myArray[index] = value;
					System.out.println(myArray[index]+" has been added!");
					count++;
				}
				for (int a=0; a<myArray.length; a++) {
					System.out.print(myArray[a]+",");
				}
				System.out.println();
		}while (count<myArray.length);
	}
}