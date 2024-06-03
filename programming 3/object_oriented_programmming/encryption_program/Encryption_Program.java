package encryption_program;

public class Encryption_Program {
	String input;
	final int key = 3;

	Encryption_Program(){
	}

	void setInput(String input) {
		this.input = input;
	}

	int countConsonants(String input) {
		String consonant = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
		int counter = 0;
		for (int i = 0; i < input.length(); i++) {
			String temp = input.charAt(i)+"";
			if (temp.matches("(.*)" + consonant + "(.*)")) {
				counter++;
			}
		}
		return counter;
	}

	int countEven(String input) {
		int counter = 0;
		String allNumberString = "";
		for (int i = 0; i < input.length(); i++) {
			String temp = input.charAt(i) + "";
			if (temp.matches("[0-9]")) {
				allNumberString += temp;
			}
		}
		for (int i = 0; i < allNumberString.length(); i++) {
			int temp = Integer.parseInt(allNumberString.charAt(i) + "");
			if (temp % 2 == 0) {
				counter++;
			}
		}

		return counter;
	}

	void encrypt() {
		char[] c = input.toCharArray();
		for (char d : c) {
			d += key;
			System.out.print(d);
		}
		System.out.println(" has been encrypted.");
	}

	void decrypt() {
		char[] c = input.toCharArray();
		for (char d : c) {
			d -= key;
			System.out.print(d);
		}
		System.out.println(" has been decrypted.");
	}
}