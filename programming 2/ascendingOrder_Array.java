import java.util.*;
public class ascendingOrder_Array{
	public static void main (String[] jareth){
		Scanner SC = new Scanner(System.in);
		int[] arr = {24,67,5,2,34,98,-1,-4,6,41,60};

		System.out.println("Elements after Sorting: ");

		for (int i=0; i<arr.length; i++) {
			for (int j=i+1; j<arr.length; j++) {
				int tmp = 0;
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
			if (i==arr.length-1) {
				System.out.print(arr[i]);
			}else{
				System.out.print(arr[i]+",");			
			}
		}
	}
}
