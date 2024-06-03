import java.util.Stack;

public class Helper {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> tempStack = new Stack<>();

    private void ifOdd(int input) {
        mainStack.push(input);
        System.out.println("Stack: " + mainStack);
    }

    private void ifEven(int input) {
        for (int i = 0; i < mainStack.size(); i++) {
            if (input < mainStack.get(i)) {
                tempStack.push(mainStack.get(i));
            }
        }
        mainStack.clear();
        for (int i = 0; i < tempStack.size(); i++) {
            mainStack.push(tempStack.get(i));
        }
        tempStack.clear();
        System.out.println("Stack: " + mainStack);
    }

    public void execute(int input) {
        if (input % 2 == 1) {
            ifOdd(input);
        } else {
            ifEven(input);
        }
    }
}
