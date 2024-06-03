import java.util.*;
public class midterm2 {
	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);

		int counter;
		Random rndm = new Random();
		String num = "";
		int[][] board = new int[5][6];
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				board[i][j] = rndm.nextInt(10);
			}
		}
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if ( !(num.matches("(.*)"+board[i][j]+"(.*)")) ) num += board[i][j]+",";
			}
		}
		String [] numberlist = num.split(",");
		int[] newNumberlist = new int[numberlist.length];
		for (int q=0; q<numberlist.length; q++) {
			newNumberlist[q] = Integer.parseInt(numberlist[q]);
		}
		for (int i=0; i<board.length; i++) {
			System.out.print("{ ");
			for (int j=0; j<board[i].length; j++) {

				System.out.print(board[i][j]+", ");
			}
			System.out.print("}\n");
		}
		Arrays.sort(newNumberlist);
		for (int y=0; y<numberlist.length; y++) {
			counter = 0;
			for (int i=0; i<board.length; i++) {
				for (int j=0; j<board[i].length; j++) {
					if (newNumberlist[y]==board[i][j]) counter++;
				}
			}
			System.out.println(newNumberlist[y]+" - Number of Intances: "+counter);
		}
	}
}