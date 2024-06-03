import java.util.*;
public class AssignmentFeb16{
	public static void main (String[] jareth){
		Scanner SC = new Scanner(System.in);

		String[] names = {"John","Edna","Imelda","Reyre","Rogene","Peejay","Jomar","Shaquille"};
		int count = 0;
		for (int a=0; a<names.length; ++a) {
			if (names[a].charAt(0)=='A' || 
				names[a].charAt(0)=='E' ||
				names[a].charAt(0)=='I' || 
				names[a].charAt(0)=='O' ||				
				names[a].charAt(0)=='U') {
			}else{
				count++;
			}
		}
		System.out.print("Number of names that starts with consonants: "+count);
	}
}