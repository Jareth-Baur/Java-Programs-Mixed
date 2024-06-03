package problem2;

import java.util.*;

public class Main {
    private Stack<String> mainStack = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter String: ");
            String input = scanner.nextLine();
            if (input.length() % 2 == 1) {
                mainStack.push(input);
            }
        } while (true);

        scanner.close();
    }
}