import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class Main {
    @SuppressWarnings({ "unused", "unchecked" })
    public static void main(String[] args) {
        // todo Default constructor initialized with the default size of (10)
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(6);
        list1.add(4);
        list1.add(7);

        System.out.println(list1);

        // todo Constructing a list containing the specified elements on another list
        ArrayList<Integer> list2 = new ArrayList<>(list1);
        System.out.println(list2);
        list2.add(9);
        list2.add(5);
        int size = 5;
        // todo Constructing the list with the initial size
        ArrayList<Integer> list3 = new ArrayList<>(size);

        Object obj1 = list2.clone();
        list3 = (ArrayList<Integer>) obj1;
        System.out.println(list3);
        Iterator<Integer> listIterator = list3.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        Spliterator<Integer> spliterator = list3.spliterator();
        System.out.println();
        int s = list3.stream().reduce(0, (all, x) -> all + x);
        System.out.println(s);
        list3.sort(null);
        System.out.println(list3);
    }
}