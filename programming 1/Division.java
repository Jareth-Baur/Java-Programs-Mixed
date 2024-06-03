import java.util.*;
public class Division{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);

		int num = 0;
		double a,b,r,c;

		System.out.print("Please Input Number: ");
		num = SC.nextInt();
		
		System.out.print("0 \t|");

		for(a=1; a<=num; ++a){
			System.out.print(" "+a+"\t\t");
		}
		System.out.println();

		for(b=1; b<=num; ++b){
			System.out.print("_______________");
		}
		System.out.println();

		for(r=1; r<=num; ++r){
			System.out.print(r+"\t|");
			for(c=1; c<=num; ++c){
				System.out.print(c+" / "+r+" = "+r/c+"\t");
			}
			System.out.println();
		}
	}
}