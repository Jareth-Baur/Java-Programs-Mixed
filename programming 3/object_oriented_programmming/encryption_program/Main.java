package encryption_program;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	    Encryption_Program ep = new Encryption_Program();
	    Scanner scan = new Scanner(System.in);
	    System.out.print("Enter a string: ");
	    String in = scan.nextLine();
	    ep.setInput(in);
	    int countedConsonants = ep.countConsonants(in);
	    int countedEvenNumbers = ep.countEven(in);
	    if (countedConsonants >= 2 || countedEvenNumbers > 0) {
	        ep.encrypt();
	    } else {
	        ep.decrypt();
	    }
	    scan.close();
	}
}
