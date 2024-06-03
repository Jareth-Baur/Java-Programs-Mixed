public class midterm_Problem1 {
	public static void main(String[] args) {

		int[][] arr = { { 4, 1, 6, 28, 75, 45 }, 
				{ 11, 3, 9, 86, 61, 71 }, 
				{ 50, 78, 20, 24, 60, 70 },
				{ 76, 48, 63, 90, 52, 46 }, 
				{ 40, 53, 30, 27, 80, 81 },	};
		int[] counter = new int[10];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(arr[i][j] + ",\t");
			}
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				if (arr[i][j] >= 1 && arr[i][j] <= 10) {
					counter[0]++;
				} else if (arr[i][j] >= 11 && arr[i][j] <= 20) {
					counter[1]++;
				} else if (arr[i][j] >= 21 && arr[i][j] <= 30) {
					counter[2]++;
				} else if (arr[i][j] >= 31 && arr[i][j] <= 40) {
					counter[3]++;
				} else if (arr[i][j] >= 41 && arr[i][j] <= 50) {
					counter[4]++;
				} else if (arr[i][j] >= 51 && arr[i][j] <= 60) {
					counter[5]++;
				} else if (arr[i][j] >= 61 && arr[i][j] <= 70) {
					counter[6]++;
				} else if (arr[i][j] >= 71 && arr[i][j] <= 80) {
					counter[7]++;
				} else if (arr[i][j] >= 81 && arr[i][j] <= 90) {
					counter[8]++;
				} else if (arr[i][j] >= 91 && arr[i][j] <= 100) {
					counter[9]++;
				}
			}
		}
		System.out.println("1-10: " + counter[0] + " Instance(s)");
		System.out.println("11-20: " + counter[1] + " Instance(s)");
		System.out.println("21-30: " + counter[2] + " Instance(s)");
		System.out.println("31-40: " + counter[3] + " Instance(s)");
		System.out.println("41-50: " + counter[4] + " Instance(s)");
		System.out.println("51-60: " + counter[5] + " Instance(s)");
		System.out.println("61-70: " + counter[6] + " Instance(s)");
		System.out.println("71-80: " + counter[7] + " Instance(s)");
		System.out.println("81-90: " + counter[8] + " Instance(s)");
		System.out.println("91-100: " + counter[9] + " Instance(s)");
	}
}