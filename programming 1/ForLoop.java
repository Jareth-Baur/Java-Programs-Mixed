import java.util.*;
public class ForLoop{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);

		int a,b,c = 0;
		System.out.println("Please input a number: ");
		b = SC.nextInt();
		for( a=1; a<=b; a++){
			System.out.println(a);
			c+=a;
		}
			System.out.println("The sum is "+c);
	}
}