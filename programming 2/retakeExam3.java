import java.util.*;
public class retakeExam3 {
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);

		System.out.print("Input numbers of string to input: ");
		int length = SC.nextInt();

		String[] arr = new String[length];
		int index = 0,vowelCounter = 0,consonantCounter = 0, product = 0;
		String vowels = "AEIOUaeiou", consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ", value = "";

		for (int q = 0; q < length; q++) {
			do {
				System.out.print("Input array index: ");
				index = SC.nextInt();
			}while (index>=length || index<0 || arr[index]!=null);
			SC = new Scanner (System.in);

			System.out.print("Input string value: ");
			value = SC.nextLine();

			vowelCounter = 0;
			consonantCounter = 0;
			for (int w=0; w<value.length(); w++) {
				if ( vowels.matches("(.*)"+value.charAt(w)+"(.*)") ) {
					vowelCounter++;
				}else if ( consonants.matches("(.*)"+value.charAt(w)+"(.*)") ) {
					consonantCounter++;
				}
			}
			product = (vowelCounter*consonantCounter);
			if ( (product%2)==0 ) {
				arr[index] = "Even-"+product;
			}else{
				arr[index] = "Odd-"+product;
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}