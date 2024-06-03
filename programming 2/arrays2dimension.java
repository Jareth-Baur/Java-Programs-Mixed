import java.util.*;
public class arrays2dimension {
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);

		String[][] arr = {
			{"Jareth","jareth123"},
			{"Silas","silas123"},
			{"James","james123"},
			{"Alliah","alliah123"}
		};

		for (String name[] : arr) {
			for (String info : name) {
				System.out.print(info+",");
			}
			System.out.println();
		}
	}
}