package hash_map;

import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		HashMap<Integer, Integer> myHashMap = new HashMap<>();
		int[][] arr = new int[10][10];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = (int)(Math.random()*80)+10;
				System.out.print(arr[i][j]+", ");
			}
			System.out.println();
		}
	}
}
