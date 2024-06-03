import java.util.*;
import java.io.*;
public class midterms2d {
	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);
		int[][] board = new int[5][6];
		int[][] sortedBoard = new int[5][6];
		int row = 0,col = 0;
		float average = 0, sum = 0;
		String userInput = "";

		for (int p=0; p<30; p++) {
			SC = new Scanner(System.in);
			do {
				System.out.print("Input rows and columns (0,0): ");
				userInput = SC.nextLine();
				String[] temp = userInput.split(",");
				row = Integer.parseInt(temp[0]);
				col = Integer.parseInt(temp[1]);
			} while (row>=5 || col>=6 || board[row][col]>0);
			System.out.print("Input int value: ");
			int value = SC.nextInt();
			board[row][col] = value;
			sortedBoard[row][col] = value;
			for (int i=0; i<5; i++) {
				Arrays.sort(sortedBoard[i]);
				sum = 0;
				average = 0;
				for (int j=0; j<6; j++) {
					sum += board[i][j];
					System.out.print(" "+board[i][j]+" |");
				}
				average = sum/6;
				System.out.print(" Avg: "+average);
				System.out.println("\n------------------------");
			}
			for (int i=0; i<6; i++) {
				sum = 0;
				average = 0;
				for (int j=0; j<5; j++) {
					sum += board[j][i];
				}
				average = sum/5;
				System.out.print(average+"|");
			}
			System.out.println();
		}
	}
}