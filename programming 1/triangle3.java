import java.util.*;
public class triangle3{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);

		int row = 6,a,b;

		for(a=row; a>=1; a--){
			for(b=1; b<=row; b++){
				if(a<=b){
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