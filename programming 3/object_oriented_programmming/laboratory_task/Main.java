package laboratory_task;

public class Main {

	public static void main(String[] args) {
		Student student = new Student();
		Student s1 = new Student(20231024, "John", 23);
		Student s2 = new Student(20231025, "Alvin Kyle", 27);
		s1.displayAll();
		s1.countWords();
		System.out.println("--------------------");
		s2.displayAll();
		s2.countWords();
		System.out.println("--------------------");
	}

}
