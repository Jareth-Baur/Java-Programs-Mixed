import java.util.ArrayList;
import java.util.List;

public class ListToArrayExample {
    public static void main(String[] args) {
        // Create a List
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        // Convert List to Array
        String[] stringArray = stringList.toArray(new String[9]);

        // Print the elements of the array
        for (String fruit : stringArray) {
            System.out.println(fruit);
        }
    }
}
