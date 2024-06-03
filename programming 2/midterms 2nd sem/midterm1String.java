import java.util.*;
public class midterm1String {
	public static void main(String[] args) {
		int counter;
		Random random = new Random();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String[][] board = new String[5][6];
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				board[i][j] = alphabet.charAt( random.nextInt( alphabet.length() ) )+"";
				System.out.print(board[i][j]+", ");
			}
			System.out.println();
		}
		ArrayList<String> list = new ArrayList<String>();
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if ( !(list.contains(board[i][j])) )	list.add(board[i][j]);
			}
		}
		for (int y=0; y<list.size(); y++) {
			counter = 0;
			for (int i=0; i<board.length; i++) {
				for (int j=0; j<board[i].length; j++) {
					if ( list.get(y).equals(board[i][j]) ) counter++;
				}
			}
			System.out.println(list.get(y)+" - Number of Intances: "+counter);
		}
	}
}