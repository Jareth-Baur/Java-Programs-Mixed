import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("B");
        treeSet.add("D");
        treeSet.add("A");
        treeSet.add("C");
        for (String string : treeSet) {
            System.out.print(string + " ");
        }
        System.out.println();
        System.out.println(treeSet);
    }
}
