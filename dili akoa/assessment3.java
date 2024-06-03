import java.lang.*;
import java.util.*;
import java.util.Arrays;

public class assessment3{
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
int array[] = {1,2,3,4,5,6,7,8,9,10}; 
int n = array.length;
	System.out.println("Initial Array:\n"+Arrays.toString(array));

	System.out.println("Input Number: ");
		int num = in.nextInt();

	System.out.println("Input Index: ");
	int index = in.nextInt();

	insertX(n,array,num,index);
	}

public static void insertX(int n,int array[], int num, int index){
	int newarray[] = new int[n+1];

	for(int i =0; i<n+1; i++){
		if(i< index-1){
			newarray[i] = array[i];
		}else if(i==index-1){
			newarray[i] = num;
		}else{
			newarray[i]=array[i-1];
		}
			   }
      System.out.println("\n Array with "+num+" inserted at position"+index+":\n"+Arrays.toString(newarray));
}
}