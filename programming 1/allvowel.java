import java.util.*;
public class allvowel{
	public static void main(String[] args){
		Scanner dith = new Scanner(System.in);
		System.out.print("Enter a name: ");
		String name = dith.nextLine();
		String allvowels = "", allconsonants="";
		int counter = 0, count=0;
		for(int a = 0 ; a < name.length(); a++){
		    if(name.charAt(a)== 'a' || name.charAt(a) == 'A'||name.charAt(a)== 'e' || name.charAt(a) == 'E'
					||name.charAt(a)== 'i' || name.charAt(a) == 'I'
					|| name.charAt(a)== 'o' || name.charAt(a) == 'O'
					|| name.charAt(a)== 'u' || name.charAt(a) == 'U'){
		    allvowels += name.charAt(a)+", ";
		    counter++;
		    }else if(name.charAt(a)== 'b' || name.charAt(a) == 'B' 
					||name.charAt(a)== 'c' || name.charAt(a) == 'C'
					||name.charAt(a)== 'd' || name.charAt(a) == 'D'
					|| name.charAt(a)== 'f' || name.charAt(a) == 'F'
					|| name.charAt(a)== 'g' || name.charAt(a) == 'G'
					||name.charAt(a)== 'h' || name.charAt(a) == 'H'
					||name.charAt(a)== 'j' || name.charAt(a) == 'J'
					|| name.charAt(a)== 'k' || name.charAt(a) == 'K'
					|| name.charAt(a)== 'l' || name.charAt(a) == 'L'
					||name.charAt(a)== 'm' || name.charAt(a) == 'M'
					||name.charAt(a)== 'n' || name.charAt(a) == 'N'
					|| name.charAt(a)== 'p' || name.charAt(a) == 'P'
					|| name.charAt(a)== 'q' || name.charAt(a) == 'Q'
					||name.charAt(a)== 'r' || name.charAt(a) == 'R'
					||name.charAt(a)== 's' || name.charAt(a) == 'S'
					|| name.charAt(a)== 't' || name.charAt(a) == 'T'
					|| name.charAt(a)== 'v' || name.charAt(a) == 'V'
					||name.charAt(a)== 'w' || name.charAt(a) == 'W'
					||name.charAt(a)== 'x' || name.charAt(a) == 'X'
					|| name.charAt(a)== 'y' || name.charAt(a) == 'Y'
					|| name.charAt(a)== 'z' || name.charAt(a) == 'Z'){
		    allconsonants += name.charAt(a)+", ";
		    count++;
		    }
		    }
		    System.out.println(allvowels);
		    System.out.println("number of vowels: "+counter);
			System.out.println(allconsonants);
			System.out.println("number of consonants:"+count);
			System.out.println("The difference is:" + (counter-count));
	}
}