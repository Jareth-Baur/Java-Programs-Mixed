package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
        new GenericsExample();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(8);
        list.add(24);
        printList(list);
        Printer<Integer> intPrinter = new Printer<>(23);
        intPrinter.print();

        Printer<String> stringPrinter = new Printer<>("This is a String");
        stringPrinter.print();
    }

    private static void printList(List<?> list) {
        for (Object object : list) {
            System.out.print(object + ", ");
        }
        System.out.println();
    }
}