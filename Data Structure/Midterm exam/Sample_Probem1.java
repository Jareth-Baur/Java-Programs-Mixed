import java.util.*;

public class Sample_Probem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Integer sequence: ");
        String input = scan.nextLine();
        System.out.println();
        String[] S = input.split(",");
        System.out.println("Input = " + Arrays.toString(S));
        Stack<Integer> odd = new Stack<>();
        Stack<Integer> even = new Stack<>();
        for (int i = 0; i < S.length; i++) {
            if (Integer.parseInt(S[i]) % 2 == 0) {
                even.push(Integer.parseInt(S[i]));
            } else {
                odd.push(Integer.parseInt(S[i]));
            }
        }
        Stack<Integer> allStack = new Stack<>();
        allStack.addAll(odd);
        allStack.addAll(even);
        System.out.println("Output = " + allStack);
        System.out.println("There are " + odd.size() + " and " + even.size() + " even numbers.");
        scan.close();
    }
}
