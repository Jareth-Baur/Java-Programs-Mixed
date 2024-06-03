import java.util.*;
public class triangle4{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);

		int row = 5,a,b;

		for(a=1; a<=row; a++){
			for(b=1; b<=row; b++){
				if(b<a){
					System.out.print(" ");
				}else{
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
/*

*****
 ****
  ***
   **
    *

*/