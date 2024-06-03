import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class add {
	public static void main(String[] args) {
		boolean PlaneFound = false;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Add plane.\n");
			sc = new Scanner(System.in);
			LocalDate localdate = LocalDate.now();
			FileWriter planeWriter = new FileWriter("C:/removal/plane.txt",
					true);
			File planeFileAddPlane = new File("C:/removal/plane.txt");
			Scanner planeScanner = new Scanner(planeFileAddPlane);
			int planeID = 1, tempNumberOfSabad = 0, tempPlaneSize = 0;
			String planeSizeChoice = "", numberOfSabadChoice = "";
			while (planeScanner.hasNextLine()) {
				String[] details = new String[6];
				details = planeScanner.nextLine().split(";");
				planeID++;
			}
			String planeName = "";
			do {
				PlaneFound = false;
				do {
					System.out.print("Enter Plane Name: ");
					planeName = sc.nextLine();
					if (planeName.isBlank()) {
						System.out.println("Invalid Plane Name. Please try again.");
					}
				} while (planeName.isBlank());
				planeScanner = new Scanner(planeFileAddPlane);
				while (planeScanner.hasNextLine()) {
					String[] details = new String[6];
					String data  = planeScanner.nextLine();
					details = data.split(";");
					if (details[1].equalsIgnoreCase(planeName)) {
						PlaneFound = true;
						break;
					}
				}
				if (PlaneFound) {
					System.out.println("Plane name found. Please try again.");
				}
			} while (PlaneFound);
			String[] planeSizeHolder = { "Small", "Medium", "Large" };
			System.out.println("1. Small\n2. Medium\n3. Large");
			do {
				sc = new Scanner(System.in);
				try {
					System.out.print("Enter Plane size: ");
					String input = sc.nextLine().trim();
					tempPlaneSize = Integer.parseInt(input);
					for (int i = 0; i < planeSizeHolder.length; i++) {
						if (tempPlaneSize == (i + 1)) {
							planeSizeChoice = planeSizeHolder[i];
						}
					}
				} catch (Exception e) {
				}
				if (tempPlaneSize < 1 || tempPlaneSize > 3) {
					System.out.println("Invalid Input! Please try again.");
				}
			} while (tempPlaneSize < 1 || tempPlaneSize > 3);
			String[] numberOfSabadHolder = { "Single", "Double" };
			System.out.println("1. Single\n2. Double");
			do {
				sc = new Scanner(System.in);
				try {
					System.out.print("Enter Plane Turbane: ");
					String input = sc.nextLine().trim();
					tempNumberOfSabad = Integer.parseInt(input);
					for (int i = 0; i < numberOfSabadHolder.length; i++) {
						if (tempNumberOfSabad == (i + 1)) {
							numberOfSabadChoice = numberOfSabadHolder[i];
						}
					}
				} catch (Exception e) {
				}
				if (tempNumberOfSabad < 1 || tempNumberOfSabad > 2) {
					System.out.println("Invalid Input! Please try again.");
				}
			} while (tempNumberOfSabad < 1 || tempNumberOfSabad > 2);
			planeWriter.write(
					planeID + ";"+planeName+";" + planeSizeChoice + ";" + numberOfSabadChoice + ";" + localdate + ";" + "1\n");
			planeWriter.close();
			System.out.println("Plane added Successfully.");
		} catch (Exception e) {
			System.out.println("An Error Occured while running the program." + e);
		}
	}
}
