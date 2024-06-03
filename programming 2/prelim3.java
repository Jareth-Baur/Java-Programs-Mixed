import java.util.*;
public class prelim3 {
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);

		System.out.print("Enter the number of strings to add: ");
		int length = SC.nextInt();

		int[] arr = new int[length];
		int[] arr2 = new int[length];
		boolean retval = false;
		int index = 0;
		String value = "";
		ArrayList<String> arrList = new ArrayList<String>(length);

		for (int q=0; q<length; q++) {
			do {
				System.out.print("Enter the index for string #"+(q+1)+": ");
				index = SC.nextInt();
			}while (index>=length || arr[index]>0);
			SC = new Scanner (System.in);
			do {
				System.out.print("Enter the String value for index "+index+": ");
				value = SC.nextLine();
				retval = arrList.contains(value);
			}while (retval==true);
			arrList.add(value);
			arr[index] = value.length();
			for (int w=0; w<length; w++) {
				arr2[w] = arr[w];
			}
			Arrays.sort(arr2);
			System.out.println("Current state of the array: "+Arrays.toString(arr2));
		}
	}
}