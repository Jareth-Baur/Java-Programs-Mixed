import java.util.*;
public class MultiplicationTable2{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);
		int a,b,r,c, row = 0, col =0;

		System.out.println("Multiplication Table");
		System.out.print("Please Input row: ");
		row = SC.nextInt();// 11

		System.out.print("Please Input column: ");
		col = SC.nextInt();// 11
		System.out.print("0 \t|");

		for(a=1; a<col; a++){
			System.out.print(" "+a+"\t\t");
		}
		System.out.println();

		for(b=1; b<=col; b++){
			System.out.print("_______________");
		}
		System.out.println();

		for(r=1; r<row; r++){
			System.out.print(r+"\t|");
			for(c=1; c<col; c++){
				System.out.print(" "+r+" x "+c+" = "+(r*c)+"\t");
			}
			System.out.println();
		}
	}
}