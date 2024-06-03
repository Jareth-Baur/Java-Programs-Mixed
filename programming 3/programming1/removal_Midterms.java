public class removal_Midterms {
	public static void main(String[] args) {

		int[][] arr = { { 4, 1, 6, 28, 75, 45 }, 
						{ 11, 3, 9, 86, 61, 71 }, 
						{ 50, 78, 20, 24, 60, 70 },
						{ 76, 48, 63, 90, 52, 46 }, 
						{ 40, 53, 30, 27, 80, 81 },	};
		int[] odd_Sum = new int[5];
		int[] even_Sum = new int[5];
		int[] odd_Counter = new int[5];
		int[] even_Counter = new int[5];
		int sum_of_all_even = 0, sum_of_all_odd = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(arr[i][j] + ",\t");
				if ((arr[i][j] % 2) == 0) {
					even_Sum[i] += arr[i][j];
					even_Counter[i]++;
				} else {
					odd_Sum[i] += arr[i][j];
					odd_Counter[i]++;
				}
			}
			System.out.println();
		}
		for (int x = 0; x < 5; x++) {
			System.out.println("Row " + x + ": " + odd_Counter[x] + " odd and " + even_Counter[x] + " even numbers");
			System.out.println("Row " + x + ": sum | odd = " + odd_Sum[x] + " even = " + even_Sum[x]);
			sum_of_all_even += even_Counter[x];
			sum_of_all_odd += odd_Counter[x];
		}
		System.out.print("All odd: " + sum_of_all_odd + "| All even: " + sum_of_all_even);
	}
}