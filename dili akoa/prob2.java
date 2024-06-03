import java.util.*;
import java.io.*;

public class prob2{
	public static void main(String[] args)throws IOException{
		Scanner hen = new Scanner(System.in);
		int [] arr = {1,2,3,4,5};
		int n = arr.length;
		int h = 0;
		FileWriter write1 = new FileWriter("D:/prob2.txt");
		write1.write("Initial Array: 1,2,3,4,5\n");

		System.out.println("Please input a number: ");
		int number = hen.nextInt();
		System.out.println("Please input index: ");
		int index = hen.nextInt();
		int ind = index-1;

		System.out.println("Initial Array: "+Arrays.toString(arr));
		int [] newArr = new int[n+1];

		for(int a = 0; a<newArr.length;a++){	
			if(a==ind){
				newArr[a] = number;
			}else{
				newArr[a] = arr[h];
				h++;
			}
		}
		newArr[ind] = number;
	
		write1.write("Inserted initial array with initial Inserted "+newArr[ind]+" value: ");
		write1.write(newArr[0]+","+newArr[1]+","+newArr[2]+","+newArr[3]+","+newArr[4]+","+newArr[5]);

		System.out.println("Successfully Added to the Text File! ");
		write1.close();
		}
	}	