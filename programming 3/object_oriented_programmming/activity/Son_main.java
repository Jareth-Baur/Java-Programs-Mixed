package activity;

public class Son_main {

	public static void main(String[] args) {
		Father f1 = new Father("Jerick", "Reading", 74, "Basketball");
		Father f2 = new Father("Zander", "Playing Video Games", 35, "Badminton");
		Father f3 = new Father("James", "Coding", 23, "Taekwondo");
		f1.display();
		println("-----------------------------");
		f2.display();
		println("-----------------------------");
		f3.display();
		println("-----------------------------");

		Animals animal = new Animals();
		println("");
		animal.makeNoise();
		animal.makeNoise(3);
		Animals[] arr = new Animals[5];
	}

	static void println(String content) {
		System.out.println(content);
	}

}
