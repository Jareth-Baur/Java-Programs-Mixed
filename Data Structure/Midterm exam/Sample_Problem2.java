import java.util.*;

public class Sample_Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("List Limit: ");
        int initialCapacity = scanner.nextInt();

        List<Integer> originalList = new ArrayList<>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            originalList.add(0);
        }
        for (int i = 0; i < initialCapacity; i++) {
            System.out.print("Input value and index separated with a comma: ");
            String[] input = scanner.next().split(",");

            try {
                int value = Integer.parseInt(input[0].trim());
                int index = Integer.parseInt(input[1].trim());

                if (originalList.get(index) == 0 && index < initialCapacity && index >= 0) {
                    originalList.set(index, value);
                } else {
                    if (index >= initialCapacity || index < 0) {
                        System.out.print("Invalid Index! ");
                    }
                    if (originalList.get(index) != 0) {
                        System.out.print("Index unavailable! ");
                    }
                    i--;
                }
            } catch (Exception e) {
                System.out.print("Invalid Index! ");
                i--;
            }
        }
        System.out.print("Please input divisor: ");
        int divisor = scanner.nextInt();
        List<Integer> quotientList = new ArrayList<>();
        for (int i = 0; i < originalList.size(); i++) {
            quotientList.add((originalList.get(i) / divisor));
        }
        System.out.println("Original List: " + originalList);
        System.out.println("Qoutient List: " + quotientList);
        scanner.close();
    }
}