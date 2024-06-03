import java.util.*;
public class Names{
	public static void main (String[] jareth){
		Scanner SC = new Scanner (System.in);
		String allname ="";
		System.out.print("Please Input number of Names: ");
		int num_name = SC.nextInt();

		for (int name = 1; name<=num_name; name++) {
			System.out.print("Please Input Name "+name);
			String names = SC.next();
			allname += names+",";
		}
		System.out.println("**List of Names**");
		System.out.println(allname);
	}
}