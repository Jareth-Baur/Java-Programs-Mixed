package File;

public class Printer<T> {
    T thingToPrint;

    Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    void print() {
        System.out.println(thingToPrint);
    }
}
