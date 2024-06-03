import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Encryption e = new Encryption();
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        if (e.countConsonant(input) == 2 && e.countEvenNumber(input) == 2 && e.isFirstLetterConsonant(input) == true) {
            System.out.println(e.encrypt(input));
        }
        scanner.close();
    }
}