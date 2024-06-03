import java.util.Arrays;
import java.util.Scanner;

public class FridayAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = 0;
        do {
            scanner = new Scanner(System.in);
            System.out.print("Enter array length: ");
            try {
                arrayLength = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Array length.");
            }
        } while (arrayLength == 0);
        int[] intArray = new int[arrayLength];
        while (arrayLength > 0) {
            int value = 0, index = -1;
            do {
                scanner = new Scanner(System.in);
                System.out.print("Input value: ");
                try {
                    value = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid Value.");
                }
            } while (value == 0);
            do {
                index = -1;
                scanner = new Scanner(System.in);
                System.out.print("Enter index: ");
                try {
                    index = scanner.nextInt();
                } catch (Exception e) {
                }
                if (index <= 0 || index >= intArray.length) {
                    System.out.println("Invalid Index.");
                }
            } while (index <= 0 || index >= intArray.length);
            intArray[index] = value;
            System.out.println("Current Array Value/s: " + Arrays.toString(intArray));
            arrayLength--;
        }
        scanner.close();
    }
}
