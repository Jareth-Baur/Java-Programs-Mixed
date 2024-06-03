import java.util.*;

public class OptionalMain {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Optional<Cat> optionalCat = findCatByName("Fred");

        optionalCat.map(Cat::getAge).orElse(0);

        // pass default values to user if the optionalCat value is null
        Cat newCat = optionalCat.orElse(new Cat("UNKNOWN", 0));

        Cat newestCat = optionalCat.get(); // prefered alternative method is .orElseThrow();

        if (optionalCat.isPresent()) {
            System.out.println(optionalCat.get().getAge());
        } else {
            System.out.println(0); // No cat found :(
        }
    }

    private static Optional<Cat> findCatByName(String name) {
        Cat cat = new Cat(name, 3);
        return Optional.ofNullable(null);
    }
}