import java.util.*;
public class Aya {
	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);

		char[][] arr = {	{'a','w','m','p','r','j'},
							{'d','e','i','w','q','h'},
							{'b','m','y','o','u','u'},
							{'r','a','f','c','g','d'},
							{'e','i','o','w','c','l'},	};
		String alphabet = "abcdefghijklmnopqrstuvwxyz",vowel = "aeiou", consonant = "bcdfghjklmnpqrstvwxyz";
		int[] vowelCounter = new int[5];
		int[] consonantCounter = new int[6];
		for (int i=0; i<5; i++) {
			System.out.print("|\t");
			for (int j=0; j<6; j++) {
				if (vowel.matches("(.*)"+arr[i][j]+"(.*)") )	vowelCounter[i]++;
				else consonantCounter[j]++;
				System.out.print(arr[i][j]+"\t|\t");
			}
			System.out.print("Vowel Count: "+vowelCounter[i]+"\t|\n");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		}
		System.out.print("|");
		for (int i=0; i<6; i++) {
			System.out.print("\t"+consonantCounter[i]+"\t|");
		}
		System.out.print("  <--  Consonant Count");
	}
}