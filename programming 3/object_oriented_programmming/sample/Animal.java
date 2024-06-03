package sample;

public class Animal {
	protected String name;

	Animal(String name) {
		this.name = name;
	}

	void eat() {
		System.out.println(name + " is eating.");
	}
}
