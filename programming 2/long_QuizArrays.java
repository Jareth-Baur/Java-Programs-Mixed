import java.util.*;
public class long_QuizArrays{
	public static void main (String[] jareth){
		Scanner SC = new Scanner(System.in);
		int index = 0;
		System.out.print("Input Array length: ");
		int length = SC.nextInt();
		boolean cont = true;
		int[] myArray = new int[length];

		do {
			System.out.println("**MENU**");
			System.out.println("1 = Add value");
			System.out.println("2 = search value");
			System.out.println("3 = Exit");
			int choice = SC.nextInt();

			switch (choice) {
				case 1:
					do {
						System.out.print("Input Array Index: ");
						index = SC.nextInt();
					}while (index>=myArray.length || myArray[index]>0 || index<0);

					System.out.print("Input value: ");
					myArray[index] = SC.nextInt();

					for (int i=0; i<myArray.length; i++) {
						System.out.print(myArray[i]+",");
					}
					System.out.println();
					break;
				case 2:
					System.out.print("Input value: ");
					int search = SC.nextInt();
					boolean found = false;
					String remarks = "Not Found!";
					for (int i=0; i<myArray.length; i++) {
						if (search == myArray[i]) {
							found = true;
						}
						if (found = true) {
							remarks = "Found!";
							break;
						}
					}
					System.out.println(search+" "+remarks);
					System.out.println();
					break;
				case 3:
					cont = false;
					break;
				default:
					System.out.println("Invalid Number!");
					break;
			}
		}while (cont==true);
	}
}