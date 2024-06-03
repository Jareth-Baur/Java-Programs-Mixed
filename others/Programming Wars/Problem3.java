import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("1st set: ");
        String firstInput = scan.nextLine();

        System.out.print("2nd set: ");
        String secondInput = scan.nextLine();

        ArrayList<String> firstSet = new ArrayList<>();
        ArrayList<String> secondSet = new ArrayList<>();

        for (int i = 0; i < firstInput.length(); i++) {
            if (firstInput.charAt(i) != ',' && !firstSet.contains(firstInput.charAt(i) + "")) {
                firstSet.add(firstInput.charAt(i) + "");
            }
        }
        for (int i = 0; i < secondInput.length(); i++) {
            if (secondInput.charAt(i) != ',' && !secondSet.contains(secondInput.charAt(i) + "")) {
                secondSet.add(secondInput.charAt(i) + "");
            }
        }
        if (firstSet.containsAll(secondSet) && secondSet.containsAll(firstSet)) {
            System.out.println("The two sets are equal.");
        } else if (secondSet.containsAll(firstSet)) {
            System.out.println("1st set is a proper subset to the 2nd set.");
        } else if (firstSet.containsAll(secondSet)) {
            System.out.println("2nd set is a proper subset to the 1st set.");
        }
        scan.close();
    }
}
