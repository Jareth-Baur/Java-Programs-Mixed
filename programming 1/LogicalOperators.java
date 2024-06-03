public class LogicalOperators{
	public static void main(String[] Jareth){
		
		boolean p = true;
		boolean q = false;
		
		System.out.println("p = true and q = false");
		System.out.println();
		System.out.println( "p && p = "+(p && p) ); // false
		//					 T    F 	
		System.out.println( "p && q = "+(p && q) ); // true
		//					 T    T
		System.out.println( "q && p = "+(q && p) ); // false
		//					 F    F
		System.out.println( "q && q = "+(q && q) ); // false
		//					 F    T

		System.out.println( "p || p = "+(p || p) ); // true
		//					 T    F 								 	
		System.out.println( "p || q = "+(p || q) ); // true
		//					 T    T
		System.out.println( "q || p = "+(q || p) ); // true
		//					 F    F
		System.out.println( "q || q = "+(q || q) ); // false
		//					 F    T


	}
}