package Reflections;

public class Cat {
    private final String NAME;
    private int age;

    Cat(String name, int age) {
        this.NAME = name;
        this.age = age;
    }

    public String getName() {
        return this.NAME;
    }

    public int getAge() {
        return this.age;
    }

    void setAge(int age) {
        this.age = age;
    }

    void meow() {
        System.out.println("Meow.");
    }

    private void heyThisIsPrivate() {
        System.out.println("How did you call this?");
    }

    public static void thisIsAPublicStaticMethod() {
        System.out.println("I'm public and static!");
    }
}
