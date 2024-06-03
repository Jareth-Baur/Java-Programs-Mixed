public class AssignmentOperator2{
	public static void main (String[] Jareth){


		int a = 11;
		a <<= 3;

		System.out.println(a);

		int b = 11;
		b >>= 30;

		System.out.println(b);

		int c = 24;		//   0000 1101 = 13
		c &= 5;			// & 0000 0011 = 3
						//   0000 0001 = 1
		System.out.println(c); // 128 64 32 16 8 4 2 1 = 8bits binary

		int d = 24;
		d |= 5;

		System.out.println(d);


	
	}
}	