package laboratory_task;

public class Student {
	int id;
	String name;
	int age;

	Student() {
		id = 0;
		name = "";
		age = -1;
	}

	Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	void countWords() {
		if (name.matches("[ ]")) {
			System.out.println("Two-Word First name.");
		} else {
			System.out.println("One-Word First name.");
		}
	}

	void displayAll() {
		System.out.println("ID	: " + id);
		System.out.println("Name	: " + name);
		System.out.println("Age	: " + age);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
