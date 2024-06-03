package activity;

public class Animals {
	String name, animalSound;
	int yearsLived;

	Animals() {

	}

	void makeNoise() {
		System.out.println("This is animal's noise.");
	}

	void makeNoise(int numberOfTimes) {
		for (int i = 0; i < numberOfTimes; i++) {
			System.out.println((i + 1) + ". This is animal's noise.");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnimalSound() {
		return animalSound;
	}

	public void setAnimalSound(String animalSound) {
		this.animalSound = animalSound;
	}

	public int getYearsLived() {
		return yearsLived;
	}

	public void setYearsLived(int yearsLived) {
		this.yearsLived = yearsLived;
	}
	void displayDetails() {
		
	}
}
