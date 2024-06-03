import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter nth number: ");
        int input = scanner.nextInt();
        System.out.println(input + "th Value: " + calculate(input));
        scanner.close();
    }

    private static int calculate(int number) {
        int[] array = new int[number];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i < array.length; i++) {
            array[i] = array[i-1] + array[i-2] + array[i-3];
        }
        return array[number - 1];
    }
}
