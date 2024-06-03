import java.util.*;
public class sortArrayString{
	public static void main (String[] jareth){
		Scanner SC = new Scanner(System.in);
		String[] arr = {"Jareth","Jezreel","Edjayz","Elyza","Erick","Judel","Judel","Ethan","Joena","Dina","Jasper"};
		int count=0;
		System.out.println("Elements after Sorting: ");

		for (int i=0; i<arr.length; i++) {
			char[] eachLetterinArray = arr[i].toCharArray();
			for (int j=0; j<eachLetterinArray.length; j++) {
				if (	(eachLetterinArray[j]+'a'-97 >=65 && eachLetterinArray[j]+'a'-97 <=90)
					||	(eachLetterinArray[j]+'a'-97 >=97 && eachLetterinArray[j]+'a'-97 <=122)	) {;
					count++;
				}
			}
		}
		System.out.println(count);
		count = 0;
	}
}
