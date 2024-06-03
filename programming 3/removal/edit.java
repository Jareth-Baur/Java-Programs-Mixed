import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class edit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			File editPlane = new File("C:/removal/plane.txt");
			Scanner editPlaneScanner = new Scanner(editPlane);
			System.out.println("Edit Plane Details.");
			ArrayList<String> tempPlaneStatusDetails = new ArrayList<String>();
			boolean PlaneFound = false;
			while (editPlaneScanner.hasNextLine()) {
				String temp = editPlaneScanner.nextLine();
				tempPlaneStatusDetails.add(temp);
			}
			boolean found = false;
			sc = new Scanner(System.in);
			System.out.print("Enter Plane ID to edit Details: ");
			String searchEditStatusBooking = sc.nextLine();
			editPlaneScanner = new Scanner(editPlane);
			while (editPlaneScanner.hasNextLine()) {
				sc = new Scanner(System.in);
				String[] details = new String[9];
				String data = editPlaneScanner.nextLine();
				details = data.split(";");
				if (searchEditStatusBooking.equalsIgnoreCase(details[0])) {
					System.out.println("Search Result for " + searchEditStatusBooking + ": ");
					found = true;
					System.out.println("Plane ID: " + details[0]);
					System.out.println("Plane Name: " + details[1]);
					System.out.println("Plane Size: " + details[2]);
					System.out.println("Plane Turbane : " + details[3]);
					System.out.println("Date Added: " + details[4]);
					System.out.println("Status: " + details[5]);
					System.out.println();
				}
			}
			if (found) {
				int planeID = 1, tempNumberOfSabad = 0, tempPlaneSize = 0;
				String planeSizeChoice = "", numberOfSabadChoice = "";
				editPlaneScanner = new Scanner(editPlane);
				while (editPlaneScanner.hasNextLine()) {
					String[] details = new String[6];
					details = editPlaneScanner.nextLine().split(";");
					planeID++;
				}
				String planeName = "";
				do {
					PlaneFound = false;
					do {
						System.out.print("Enter new Plane Name: ");
						planeName = sc.nextLine();
						if (planeName.isBlank()) {
							System.out.println("Invalid Plane Name. Please try again.");
						}
					} while (planeName.isBlank());
					editPlaneScanner = new Scanner(editPlane);
					while (editPlaneScanner.hasNextLine()) {
						String[] details = new String[6];
						String data  = editPlaneScanner.nextLine();
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
						System.out.print("Enter new Plane size: ");
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
						System.out.print("Enter new Plane Turbane: ");
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
				FileWriter planeWriter = new FileWriter("C:/removal/plane.txt");
				for (int i = 0; i < tempPlaneStatusDetails.size(); i++) {
					String[] details = new String[6];
					details = tempPlaneStatusDetails.get(i).split(";");
					if (searchEditStatusBooking.equalsIgnoreCase(details[0])) {
						planeWriter.write(details[0] + ";" + planeName + ";" + planeSizeChoice + ";"
								+ numberOfSabadChoice + ";" + details[4] + ";" + details[5] + "\n");
					} else {
						planeWriter.write(tempPlaneStatusDetails.get(i) + "\n");
					}
				}
				planeWriter.close();
				System.out.println("Status Edited successfully.");
			} else {
				System.out.println("Noting Matches your Plane ID entered.");
			}
		} catch (Exception e) {
			System.out.println("An Error Occured while running the program." + e);
		}
	}
}
