import java.util.*;
public class problem2 {
	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);

		int[][] arr = {	{4 ,1 ,6 ,28,75,45},
						{11,3 ,9 ,86,61,71},
						{50,78,20,24,60,70},
						{76,48,63,90,52,46},
						{40,53,30,27,80,81},	};
		int[] sum = new int[6];
		int temporary_Highest = 0, temporary_Lowest = 0,highest = 0;
		for (int i=0; i<5; i++) {
			int lowest = 100;
			System.out.printf("|\t");
			for (int j=0; j<6; j++) {
				sum[j] += arr[i][j];
				System.out.print(arr[i][j]+"\t|\t");
				temporary_Lowest = arr[i][j];
				if (lowest>temporary_Lowest)	lowest = temporary_Lowest;
				temporary_Highest = arr[i][j];
				if (highest<temporary_Highest)	highest = temporary_Highest;
			}
			if ( (i%2)==0 )	System.out.printf("Lowest: "+lowest+"\t|\n");
			else 	System.out.print("Highest: "+highest+"\t|\n");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		}
		System.out.print("|");
		for (int z=0; z<6; z++) {
			System.out.printf("\t"+sum[z]+"\t|");
		}
	}
}