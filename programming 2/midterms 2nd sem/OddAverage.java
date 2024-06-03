import java.util.*;
public class OddAverage {
	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);

		int[][] board = new int[5][6];
		int highest = 0, lowest = (int)(Math.random()*99+10),tempHighest = 0, tempLowest = 0;
		int row = board.length, col = board[0].length;
		float[] rowavg = new float[row];
		float[] colavg = new float[col];
		int[] rowSum = new int[row];
		int[] colSum = new int[col];

		for (int i=0; i<5; i++) {
			for (int j=0; j<6; j++) {
				board[i][j] = (int)(Math.random()*99+10);
			}
		}
		for (int i=0; i<5; i++) {
			for (int j=0; j<6; j++) {
				if (board[i][j]%2==1) {
					rowSum[i] += board[i][j];
					colSum[j] += board[i][j];
				}
				tempLowest = board[i][j];
				tempHighest = board[i][j];
				if (highest < tempHighest)	highest = tempHighest;
				if (lowest > tempLowest)	lowest = tempLowest;
			}
		}
		for (int x=0; x<row; x++) {
			rowavg[x] = rowSum[x] / row;
		}
		for (int x=0; x<col; x++) {
			colavg[x] = colSum[x] / col;
		}
		for (int i=0; i<5; i++) {
			for (int j=0; j<6; j++) {
				System.out.printf(" "+board[i][j]+" |");
			}
			System.out.print(" Avg: "+colavg[i]);
			System.out.println("\n------------------------");
		}
		for (int i=0; i<5; i++) {
			System.out.print(rowavg[i]+"|");
		}
		System.out.println("\nHighest number located: "+highest);
		System.out.println("Lowest number located: "+lowest);
	}
}