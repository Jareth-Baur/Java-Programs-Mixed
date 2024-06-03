import java.util.*;
public class CharSeque{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);
		String name = "",allvowels = "";
		int counter = 0;

		System.out.print("Please Enter Your Name: ");
		name = SC.nextLine();

		for(int a=0; a<name.length(); ++a){
			if(name.charAt(a)=='a' || name.charAt(a)=='A'){
				allvowels += name.charAt(a)+", ";
				counter++;
			}else if(name.charAt(a)=='e' || name.charAt(a)=='E'){
				allvowels += name.charAt(a)+", ";
				counter++;
			}else if(name.charAt(a)=='i' || name.charAt(a)=='I'){
				allvowels += name.charAt(a)+", ";
				counter++;
			}else if(name.charAt(a)=='o' || name.charAt(a)=='O'){
				allvowels += name.charAt(a)+", ";
				counter++;
			}else if(name.charAt(a)=='u' || name.charAt(a)=='U'){
				allvowels += name.charAt(a)+", ";
				counter++;
			}
		}
		System.out.println(allvowels);
		System.out.print("Number of vowels: "+counter);
	}
}