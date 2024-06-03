import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String input = scan.nextLine();

        Encryption e = new Encryption();
        boolean b = e.containsComma(input);
        System.out.println(b);
        if (!e.containsSpecialCharacters(input)) {
            System.out.println(e.encrypt(input));
        }
        scan.close();
    }
}