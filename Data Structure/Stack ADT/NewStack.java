import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class NewStack {
    public static void main(String[] args) throws FileNotFoundException {
        // ! Specify the file path to read brackets from (changable)
        String filePath = "C:/all programs/java programs/Data Structure/Stack ADT/File/Printer.java";

        // ! Extract all brackets from the file and store them in a variable
        String allBraces = extractBracketsFromFile(filePath);

        // ! Print the extracted brackets
        System.out.println("All Brackets    : " + allBraces);

        // ! Print the count of brackets in the extracted string
        System.out.println("Bracket count   : " + allBraces.length());

        // ! Check if the brackets are matched (equal count of opening and closing brackets)
        System.out.println("Is Matched      : " + determineIfMatched(allBraces));

        // ! Check if the brackets are balanced (correctly nested)
        System.out.println("Is Balanced     : " + determineIfBalanced(allBraces));
    }

    // ! Determine if the brackets in the string are matched (equal count of opening and closing brackets)
    public static boolean determineIfMatched(String stringToDetermine) {
        int openingCounter = 0, closingCounter = 0;
        for (char c : stringToDetermine.toCharArray()) {
            if ("{[<(".contains(String.valueOf(c))) {
                openingCounter++;
            } else if ("}])>".contains(String.valueOf(c))) {
                closingCounter++;
            }
        }
        return openingCounter == closingCounter;
    }

    // ! Determine if the brackets in the string are balanced (correctly nested)
    public static boolean determineIfBalanced(String stringToDetermine) {
        Stack<Character> stack = new Stack<>();

        // ! Iterate through each character in the string
        for (char c : stringToDetermine.toCharArray()) {
            // ! If it's an opening bracket, push onto the stack
            if ("{[<(".contains(String.valueOf(c))) {
                stack.push(c);
            } else if ("}])>".contains(String.valueOf(c))) {
                // ! If it's a closing bracket, pop from the stack and check for matching pair
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        // ! If the stack is empty at the end, brackets are balanced
        return stack.isEmpty();
    }

    // ! Check if the given opening and closing brackets form a matching pair
    private static boolean isMatchingPair(char opening, char closing) {
        return ("{[<(".indexOf(opening) == "}]>)".indexOf(closing));
    }

    // ! Extract brackets from a file and concatenate them into a string
    public static String extractBracketsFromFile(String filePath) throws FileNotFoundException {
        List<Character> allBraces = new ArrayList<>();
        char[] validBraces = { '{', '}', '(', ')', '[', ']', '<', '>' };

        // ! Use try-with-resources to automatically close the file scanner
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            // ! Read each line from the file
            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine();
                // ! Iterate through each character in the line
                for (char temp : data.toCharArray()) {
                    // ! If the character is a valid bracket, add it to the list
                    if (new String(validBraces).indexOf(temp) != -1) {
                        allBraces.add(temp);
                    }
                }
            }
        }
        // ! Convert the list of characters to a string and return
        return allBraces.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
}
