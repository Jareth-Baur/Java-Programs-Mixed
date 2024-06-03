import java.util.*;
public class Strings_ascendingOrder_Array{
	public static void main (String[] jareth){
		Scanner SC = new Scanner(System.in);
		String[] arr = {"Jeezreel","Jareth","Elyza","Edjayz","Jasper","Dina","Edna","Glenje","Johnny","Alpha","Bravo"};

		System.out.println("Elements after Sorting: ");

		for (int i=0; i<arr.length; i++) {
			for (int j=i+1; j<arr.length; j++) {
				String tmp = "";
				String pre1 = arr[i];
				String pre2 = arr[j];
				if (pre1.length() > pre2.length()) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
			if (i==arr.length-1) {
				System.out.print(arr[i]+".");
			}else{
				System.out.print(arr[i]+",");			
			}
		}
	}
}
