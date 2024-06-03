import java.util.*;
	public class Finals_3{
		public static void main (String[] jareth){
		Scanner SC = new Scanner (System.in);

		int num=0,count1=0,count2=0,a,b;
		String name1,name2,vowel = "",consonant = "";

		System.out.println("**Menu**");
		System.out.println("1 = Count all vowels");
		System.out.println("2 = Count all consonants");
		System.out.print("Please choose a number: ");
		num = SC.nextInt();
		switch(num){
			case 1:
			System.out.print("Please Enter a String: ");
			name1 = SC.next();
			for (a=1; a<=name1.length(); ++a) {
				if (name1.charAt(a)=='a' || name1.charAt(a)=='A' ||
					name1.charAt(a)=='e' || name1.charAt(a)=='E' ||
					name1.charAt(a)=='i' || name1.charAt(a)=='I' ||
					name1.charAt(a)=='o' || name1.charAt(a)=='O' ||
					name1.charAt(a)=='u' || name1.charAt(a)=='U') {
					vowel += name1.charAt(a)+", ";
					count1++;				
				}else if (name1.charAt(a)==' ') {
					count1--;
				}
			}
			break;
			case 2:
			System.out.print("Please Enter a String: ");
			name2 = SC.next();
			for (b=1; b<=name2.length(); ++b) {
				if (name2.charAt(b)=='b' || name2.charAt(b)=='B' ||
					name2.charAt(b)=='c' || name2.charAt(b)=='C' ||
					name2.charAt(b)=='d' || name2.charAt(b)=='D' ||
					name2.charAt(b)=='f' || name2.charAt(b)=='F' ||
					name2.charAt(b)=='g' || name2.charAt(b)=='G' ||
					name2.charAt(b)=='h' || name2.charAt(b)=='H' ||
					name2.charAt(b)=='j' || name2.charAt(b)=='J' ||
					name2.charAt(b)=='k' || name2.charAt(b)=='K' ||
					name2.charAt(b)=='l' || name2.charAt(b)=='L' ||
					name2.charAt(b)=='m' || name2.charAt(b)=='M' ||
					name2.charAt(b)=='n' || name2.charAt(b)=='N' ||
					name2.charAt(b)=='p' || name2.charAt(b)=='P' ||
					name2.charAt(b)=='q' || name2.charAt(b)=='Q' ||
					name2.charAt(b)=='r' || name2.charAt(b)=='R' ||
					name2.charAt(b)=='s' || name2.charAt(b)=='S' ||
					name2.charAt(b)=='t' || name2.charAt(b)=='T' ||
					name2.charAt(b)=='v' || name2.charAt(b)=='V' ||
					name2.charAt(b)=='w' || name2.charAt(b)=='W' ||
					name2.charAt(b)=='x' || name2.charAt(b)=='X' ||
					name2.charAt(b)=='y' || name2.charAt(b)=='Y' ||
					name2.charAt(b)=='z' || name2.charAt(b)=='Z') {
					consonant += name2.charAt(b)+", ";
					count2++;				
				}else if (name2.charAt(b)==' ') {
					count2--;
				}
			}
			break;
			default:
			System.out.print("Invalid!");
			break;
		}
		System.out.println();
		System.out.println(vowel);
		System.out.println("Total vowels: "+count1);
		System.out.println(consonant);
		System.out.println("Total consonants: "+count2);
		System.out.println("The difference is: "+(count1-count2));
	}
}