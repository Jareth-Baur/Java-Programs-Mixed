// ! Base class
class Animal {
    String name;

    // ! Parameterized constructor in the base class
    public Animal(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(name + " makes a sound.");
    }
}