import java.io.*;
import java.util.*;

/**
 * @ Jareth Baur
 * @ November 22, 2023
 */
public class MyQueue {

    private static Queue<String> female = new PriorityQueue<>();
    private static Queue<String> male = new PriorityQueue<>();

    public static void main(String[] args) throws FileNotFoundException {
        getNames();
        System.out.println(pairTheDancers());
    }

    public static void getNames() throws FileNotFoundException {
        File names = new File("C:/all programs/java programs/Data Structure/Queue/names.txt");
        Scanner nameScanner = new Scanner(names);
        while (nameScanner.hasNextLine()) {
            String next = nameScanner.nextLine();
            if (next.charAt(0) == 'F') {
                female.offer(next);
            } else {
                male.offer(next);
            }
        }
        nameScanner.close();
    }

    public static String pairTheDancers() {

        while (female.peek() != null && male.peek() != null) {
            female.poll();
            male.poll();
        }
        if (female.isEmpty() && male.isEmpty()) {
            return "No one is waiting to dance.";
        } else if (male.isEmpty()) {
            return "There's still " + female.size() + " female/s waiting to dance";
        } else {
            return "There's still " + male.size() + " male/s waiting to dance";
        }
    }
}