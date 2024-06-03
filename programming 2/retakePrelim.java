import java.util.*;
public class retakePrelim {
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);

		System.out.print("Input array length: ");
		int length = SC.nextInt();

		String[] arr = new String[length];
		String value = "", vowels = "AEIOUaeiou", consonants = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";
		byte index = 0;

		for (int q=0; q<length; q++) {
			do {
				System.out.print("Input array index: ");
				index = SC.nextByte();
			}while (index<0 || index>=length || arr[index]!=null);
			SC = new Scanner (System.in);
			
			System.out.print("Input string value: ");
			value = SC.nextLine();

			if (value.charAt(0)=='.') {
				arr[index] = "Period";
			}else if (vowels.matches("(.*)"+value.charAt(0)+"(.*)")) {
				arr[index] = "Vowels";
			}else if (consonants.matches("(.*)"+value.charAt(0)+"(.*)")) {
				arr[index] = "Consonants";
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();
	}
}