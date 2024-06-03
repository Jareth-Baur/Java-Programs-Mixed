package Lambdas;

public class LambdaMain {
    public static void main(String[] args) {
        Cat myCat = new Cat();

        Printable lambdaPrintable = (s) -> "meow" + s;

        printThing(lambdaPrintable);

    }

    static void printThing(Printable thing) {
        thing.print("!");
    }
}
