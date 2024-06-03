import java.util.*;
public class prelim2 {
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);

		int[] arr = new int[5];
		int value = 0;

		for (int q=1; q<6; q++) {
			System.out.print("Enter the number of tickets sold for showing "+q+": ");
			value = SC.nextInt();
			arr[q-1] = value;
		}
		Arrays.sort(arr);
		System.out.print("Sorted sales: ");
		for (int w=0; w<5; w++) {
			if (w==4) {
				System.out.print(arr[w]);
			}else{
				System.out.print(arr[w]+",");
			}
		}
	}
}