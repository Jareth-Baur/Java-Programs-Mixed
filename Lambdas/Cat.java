package Lambdas;

public class Cat implements Printable {
    String name;
    int age;

    Cat() {
    }

    public void print() {
        System.out.println("meow");
    }

    @Override
    public String print(String suffix) {
        throw new UnsupportedOperationException("Unimplemented method 'print'");
    }
}
