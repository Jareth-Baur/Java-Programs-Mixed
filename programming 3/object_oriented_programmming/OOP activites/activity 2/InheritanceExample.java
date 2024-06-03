
public class InheritanceExample {
    public static void main(String[] args) {
        // ! Create a Dog object
        Dog myDog = new Dog("Buddy", "Golden Retriever");

        // ! Call the overridden speak method
        myDog.speak(); // ! Output: Buddy (a Golden Retriever dog) barks.

        // ! Call a derived class-specific method
        myDog.fetch(); // ! Output: Buddy fetches a ball.
    }
}
