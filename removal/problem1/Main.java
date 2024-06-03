import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Helper helper = new Helper();
        do {
            System.out.print("Enter Number: ");
            int input = scanner.nextInt();
            if (input < 0)
                break;
            helper.execute(input);
        } while (true);
        scanner.close();
    }
}