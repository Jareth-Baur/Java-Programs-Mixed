package sample;

public class Dog extends Animal {

	Dog(String name) {
		super(name);
	}

	void eat(String food) {
		System.out.println(name + " is eating " + food);
	}

	void bark() {
		System.out.println(name + " is barking.");
	}
}
