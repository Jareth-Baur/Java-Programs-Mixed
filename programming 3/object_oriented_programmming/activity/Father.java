package activity;

public class Father extends Grand_Father {
	String sport;

	Father(String name, String hobbie, int age, String sport) {
		super(name, hobbie, age);
		this.sport = sport;
	}

	@Override
	void display() {
		System.out.println("Name	: " + name);
		System.out.println("Hobby	: " + hobby);
		System.out.println("Age	: " + age);
		System.out.println("Sport	: " + sport);
	}
}
