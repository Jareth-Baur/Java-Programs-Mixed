import java.util.*;
public class array_belt_in_methods {
	public static void main(String[] args) {

		ArrayList<Integer> arraylist = new ArrayList<Integer>();

		Integer[] array = new Integer[10];
		Integer[] arr = new Integer[10];
		String[][] myArray = new String[5][6];
		//int arr_length = 0;

		for (int q=0; q<array.length; q++) {
			array[q] = (int)(Math.random()*99+10);
			arr[q] = array[q];
			arraylist.add( (int)(Math.random()*99+10) );
		}
		Arrays.sort(arr);
		Arrays.sort(array);
		//Arrays.sort(array, Collections.reverseOrder());
		//Arrays.fill();
		System.out.println("Array in descending order");
		System.out.println( Arrays.toString(array)+"\n"+Arrays.toString(arr) );

		System.out.print(Arrays.deepToString(myArray));
		System.out.println( Arrays.equals(arr, array) );
		
	}
}