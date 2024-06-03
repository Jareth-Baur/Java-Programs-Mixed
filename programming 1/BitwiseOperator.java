import java.util.*;
public class BitwiseOperator{
	public static void main (String[] Jareth){
		Scanner JB = new Scanner(System.in);

		System.out.print("Please input first number: ");
		int a = JB.nextInt();
		// 60

		System.out.print("Please input second number: ");
		int b = JB.nextInt();
		// 8

		System.out.println("Bitwise And: "+ (a & b) );
		System.out.println("Bitwise Or: "+ (a | b) );
		System.out.println("Bitwise Xor: "+ (a ^ b) );
		System.out.println("Bitwise compliment: "+ (~a) );

		System.out.println("Left Shift: "+ (a << 2) );
		System.out.println("Right Shift: "+ (b >> 2) );
	}
}		
/* 

	0011 1100 = 240
a << 2
	0000 0001 = 2
b >> 2

*/
