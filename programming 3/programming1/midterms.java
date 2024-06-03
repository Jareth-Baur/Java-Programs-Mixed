public class midterms {
	public static void main(String[] args) {
		int[][] array = {	{ 4, 1, 6, 28, 75, 45 }, 
							{ 11, 3, 9, 86, 61, 71 }, 
							{ 50, 78, 20, 24, 60, 70 },
							{ 76, 48, 63, 90, 52, 46 }, 
							{ 40, 53, 30, 27, 80, 81 },	};
		int[] rowEven = new int[5];
		int[] colEven = new int[6];

		int[] rowOdd = new int[5];
		int[] colOdd = new int[6];

		int[] rowEvenValue = new int[5];
		int[] colEvenValue = new int[6];

		int[] rowOddValue = new int[5];
		int[] colOddValue = new int[6];
		int oddSum = 0, evenSum = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(array[i][j] + "\t");

				if (array[i][j] % 2 == 0) {
					rowEven[i]++;
					colEven[j]++;
					rowEvenValue[i] += array[i][j];
					colEvenValue[j] += array[i][j];
					evenSum++;

				} else {
					rowOdd[i]++;
					colOdd[j]++;
					rowOddValue[i] += array[i][j];
					colOddValue[j] += array[i][j];
					oddSum++;
				}
			}
			System.out.println();
		}
		for (int x = 0; x < 5; x++) {
			System.out.println("Row" + x + ":" + rowOdd[x] + " odd " + rowEven[x] + " even numbers");
			System.out.println("Row" + x + " sum| odd = " + rowOddValue[x] + " even = " + rowEvenValue[x]);
		}
		System.out.println();
		for (int x = 0; x < 6; x++) {
			System.out.println("Column" + x + ":" + colOdd[x] + " odd " + colEven[x] + " even numbers");
			System.out.println("Column" + x + " sum| odd = " + colOddValue[x] + " even = " + colEvenValue[x]);
		}
		System.out.println("All odd: " + oddSum + " | All even: " + evenSum);
	}
}
