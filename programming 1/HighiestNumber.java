import java.util.*;

public class HighiestNumber{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);

		System.out.print("Enter first number: ");//30
		int a = SC.nextInt();

		System.out.print("Enter second number: ");//60
		int b = SC.nextInt();

		System.out.print("Enter third number: ");//50
		int c = SC.nextInt();

		System.out.print("Enter fourth number: ");//60
		int d = SC.nextInt();

		System.out.print("Enter fifth number: ");//10
		int e = SC.nextInt();

		if(a>b){
			if(a>c){
				if(a>d){
					if(a>e){
						System.out.print(a+" is the highest!");
					}else{
						System.out.print(e+" is the highest!");
					}
				}else{
					if(d>e){
						System.out.print(d+" is the highest!");
					}else{
						System.out.print(e+" is the highest!");
					}
				}
			}else{
				if(c>d){
					if(c>e){
						System.out.print(c+" is the highest!");
					}else{
						System.out.print(e+" is the highest!");
					}
				}else{
					if(d>e){
						System.out.print(d+" is the highest!");
					}else{
						System.out.print(e+" is the highest!");
					}
				}
			}
		}else{
			if(b>c){
				if(b>d){
					if(b>e){
						System.out.print(b+" is the highest!");
					}else{
						System.out.print(e+" is the highest!");
					}
				}else{
					if(d>e){
						System.out.print(d+" is the highest!");
					}else{
						System.out.print(e+" is the highest!");
					}
				}
			}else{
				if(c>d){
					if(c>e){
						System.out.print(c+" is the highest!");
					}else{
						System.out.print(e+" is the highest!");
					}
				}else{
					if(d>e){
						System.out.print(d+" is the highest!");
					}else{
						System.out.print(e+" is the highest!");
					}
				}
			}	
		}		
	}
}