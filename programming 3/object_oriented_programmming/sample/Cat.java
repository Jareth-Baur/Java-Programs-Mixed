package sample;

public class Cat extends Animal {

	Cat(String name) {
		super(name);
	}

	void eat(String food) {
		System.out.println(name + " is eating " + food);
	}

	void meow() {
		System.out.println(name + " is meow meow.");
	}
}
