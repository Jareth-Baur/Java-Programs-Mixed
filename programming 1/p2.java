import java.util.*;
public class p2{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);

		int a,b,c;
		System.out.print("Please input a number: ");
		b = SC.nextInt();

		for(a=9; a>0; a--){
			if(a%2==1){
				c = a*b;
				System.out.println(a+" x "+b+" = "+c);
			}else{

			}
		}
	}
}