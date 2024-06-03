import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("B");
        hashSet.add("D");
        hashSet.add("A");
        hashSet.add("C");
        for (String string : hashSet) {
            System.out.print(string + " ");
        }
        System.out.println();
        System.out.println(hashSet);
    }
}
