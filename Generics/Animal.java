package Generics;

public class Animal {
    String animal;
    static String cat;
    static String dog;

    Animal(String animal) {
        this.animal = animal;
        Animal.cat = "simba";
        Animal.dog = "patchi";
    }

    Animal() {
    }

    static String cat() {
        return cat;
    }

    static String dog() {
        return dog;
    }

    void eat() {
        System.out.println("munch!");
    }
}
