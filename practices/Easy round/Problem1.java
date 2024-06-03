import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Array Length: ");
        int arrayLength = scanner.nextInt();
        String[] arrayOfStrings = new String[arrayLength];
        for (int i = 0; i < arrayOfStrings.length; i++) {
            scanner = new Scanner(System.in);
            System.out.print("Enter string no. " + (i + 1) + ": ");
            arrayOfStrings[i] = scanner.nextLine();
        }
        int[] sum = calculateNumbers(arrayOfStrings);
        int[] letterCount = countAllLetters(arrayOfStrings);
        System.out.println("Sum of all numbers: ");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print("index " + (i + 1) + ": " + sum[i] + ", ");
        }
        System.out.println("\nLetter count per index: ");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print("index " + (i + 1) + ": " + letterCount[i] + ", ");
        }
        scanner.close();
    }

    private static int[] calculateNumbers(String[] array) {
        int[] sum = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            String stringEveryIndex = array[i];
            for (int j = 0; j < stringEveryIndex.length(); j++) {
                try {
                    int characterEveryString = Integer.parseInt(String.valueOf(stringEveryIndex.charAt(j)));
                    sum[i] += characterEveryString;
                } catch (Exception e) {
                }
            }
        }
        return sum;
    }

    private static int[] countAllLetters(String[] array) {
        int[] letterCount = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            String stringEveryIndex = array[i];
            for (int j = 0; j < stringEveryIndex.length(); j++) {
                if (String.valueOf(stringEveryIndex.charAt(j)).toLowerCase().matches("[a-z]")) {
                    letterCount[i]++;
                }
            }
        }
        return letterCount;
    }
}