package activity;

public class Grand_Father {
	String name, hobby;
	int age;

	Grand_Father(String name, String hobby, int age) {
		this.name = name;
		this.hobby = hobby;
		this.age = age;
	}

	void display() {
		System.out.println("Name	: " + name);
		System.out.println("Hobby	: " + hobby);
		System.out.println("Age	: " + age);
	}
	
}
