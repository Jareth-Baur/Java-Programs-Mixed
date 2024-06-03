// ! Derived class
class Dog extends Animal {
    String breed;

    // ! Derived class constructor with super to initialize base class properties
    public Dog(String name, String breed) {
        super(name); // ! Call the base class constructor to initialize the 'name' property
        this.breed = breed;
    }

    // ! Override the speak method of the base class
    @Override
    public void speak() {
        System.out.println(name + " (a " + breed + " dog) barks.");
    }

    // ! New method specific to the Dog class
    public void fetch() {
        System.out.println(name + " fetches a ball.");
    }
}