import java.util.*;
public class practiceMarch11 {
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);

		int array_counter = 0, index = 0;
		System.out.print("Input array length: ");
		int length = SC.nextInt();

		int[] array = new int[length];
		int[] array2 = new int[length];

		do {
			do {
				System.out.print("Input array index: ");
				index = SC.nextInt();
			}while (index>=length || index<0 || array[index]>0);
			System.out.print("Input array value: ");
			array[index] = SC.nextInt();

			int a = 0;
			while (a<length) {
				array2[a] = array[a];
				a++;
			}
			for (int i=0; i<length; ++i) {
				for (int j=i+1; j<length; ++j) {
					if (array2[i] < array2[j]) {
						int temp = array2[i];
						array2[i] = array2[j];
						array2[j] = temp;
					}
				}
			}
			int even = 0;
			int odd = 0;
			for (int x=0; x<length; ++x) {
				if (array2[x]%2==0) {
					even += array2[x];
				}else{
					odd += array2[x];
				}
			}
			System.out.println();
			for (int z=0; z<length; ++z) {
				if (z==length-1) {
					System.out.print(array2[z]+".");
				}else{
					System.out.print(array2[z]+",");
				}
			}
			System.out.println();
			System.out.println("Sum of odd: "+odd);
			System.out.println("Sum of even: "+even);
			array_counter++;
		}while (array_counter<length);
	}
}