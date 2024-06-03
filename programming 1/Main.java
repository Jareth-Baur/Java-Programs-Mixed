public class Main {
	public static void main(String[] args) {

	    int count = 0, num = 123456;
	    
		for (; num != 0; num /= 10, ++count) {
	    	System.out.println(num);
		}
		System.out.println("Number of digits: " + count);
	}
}
/*
123456
12345
1234
123
12
1
Number of digits: 6
*/