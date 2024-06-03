import java.util.*;
public class MultiplicationTable{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);
		int a,b,r,c, row = 0, col =0;
		String ans = "";

		for(b=0; b<1; b++){

			System.out.print("Input row: ");
			row = SC.nextInt();// 11

			System.out.print("Input column: ");
			col = SC.nextInt();// 11

			for(a=0; a<col; a++){
				System.out.print(a +"\t");
			}
				System.out.println();
			for(r=1; r<row; r++){
				System.out.print(r + "\t");
				for(c=1; c<col; c++){
					System.out.print((r*c)+"\t");
				}
				System.out.println();
			}

			System.out.println();
			System.out.println("Do you Want to input another rows and columns?");
			System.out.println("Y - Yes | N - No");
			ans = SC.next();

			if(ans.equals("y")){
				b=-1;
			}else{
				System.out.println();
				System.out.print("End");
			}
		}
	}
}