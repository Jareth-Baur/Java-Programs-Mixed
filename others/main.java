public class main{
	public static void main(String[] args) {

		objects object = new objects();

		int[] array = {12,23,34,45,56,67,78,89,90,01};
		String[] arr = {"qwe","asd","zxc","iop","jkl","bnm","cvb","fgh","rty"};
		int[][] array2 = {	{71, 19, 27, 61, 97, 82},
							{11, 28, 20, 66, 97, 20},
							{25, 56, 29, 79, 21, 60},
							{74, 87, 47, 89, 85, 85},
							{11, 77, 75, 35, 86, 79},	};
		object.printArray(array2);
		System.out.println("Integer array: ");
		object.printArray(array);
		System.out.println("\nString array: ");
		object.printArray(arr);
	}
}