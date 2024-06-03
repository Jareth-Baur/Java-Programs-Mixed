import java.util.*;
public class NestedForloop{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);
		int row = 0, col = 0,r,c;

		System.out.print("Enter row ");
		row = SC.nextInt();

		System.out.print("Enter column ");
		col = SC.nextInt();

		for(r=0; r<=row; r++){
			for(c=0; c<=col; c++){
				System.out.print(" * ");
			}
			System.out.println();
		}
	}
}