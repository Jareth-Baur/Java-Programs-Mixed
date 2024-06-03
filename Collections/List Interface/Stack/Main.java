import java.util.Iterator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        Iterator<Integer> iterable = stack.iterator();
        while (iterable.hasNext()) {
            System.out.print(iterable.next() + " ");
        }
        System.out.println();
        stack.insertElementAt(200, 4);
        stack.add(0, 90);
        System.out.println("Stack: " + stack);
    }
}
