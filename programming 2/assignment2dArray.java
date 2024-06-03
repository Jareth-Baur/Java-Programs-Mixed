import java.util.*;
public class assignment2dArray {
	public static void main (String[] jareth) {
		Scanner SC = new Scanner (System.in);

		System.out.print("Input row for 2 dimentional array: ");
		int row = SC.nextInt();

		System.out.print("Input column for 2 dimentional array: ");
		int col = SC.nextInt();

		int[][] arr = new int[row][col];
		int col_Index = 0,row_Index = 0;

		for (int z=0; z<(row*col); z++) {
			do {
				System.out.print("Input row index: ");
				row_Index = SC.nextInt();
			} while (row_Index>=row || arr[row_Index][col_Index]>0);
			do {
				System.out.print("Input col index: ");
				col_Index = SC.nextInt();
			} while (col_Index>=row || arr[row_Index][col_Index]>0);
			System.out.print("Input int value: ");
			arr[row_Index][col_Index] = SC.nextInt();

			for (int x=0; x<row; x++) {
				for (int y=0; y<col; y++) {
					System.out.print(arr[x][y]+",\t");
				}
				System.out.println();
			}
		}
	}
}