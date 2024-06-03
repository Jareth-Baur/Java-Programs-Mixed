import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class activate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			File editPlaneStatus = new File("C:/removal/plane.txt");
			Scanner editPlaneStatusScanner = new Scanner(editPlaneStatus);
			System.out.println("Edit Plane Status.");
			ArrayList<String> tempPlaneStatusDetails = new ArrayList<String>();
			while (editPlaneStatusScanner.hasNextLine()) {
				String temp = editPlaneStatusScanner.nextLine();
				tempPlaneStatusDetails.add(temp);
			}
			boolean found = false;
			sc = new Scanner(System.in);
			System.out.print("Enter Plane ID to edit Status: ");
			String searchEditStatusBooking = sc.nextLine();
			editPlaneStatusScanner = new Scanner(editPlaneStatus);
			while (editPlaneStatusScanner.hasNextLine()) {
				sc = new Scanner(System.in);
				String[] details = new String[9];
				String data = editPlaneStatusScanner.nextLine();
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
				int planeStatusChoice = 0;
				System.out.println("------Status------");
				System.out.println("1. Active\n2. On-Flight");
				do {
					sc = new Scanner(System.in);
					System.out.print("Please Choose New Status: ");
					String input = sc.nextLine().trim();
					if (input.matches("[1-2]")) {
						planeStatusChoice = Integer.parseInt(input);
						break;
					}
					System.out.println("Invalid Input! Please from 1 to 2 only.");
				} while (true);
				FileWriter planeStatusWriter = new FileWriter("C:/removal/plane.txt");
				for (int i = 0; i < tempPlaneStatusDetails.size(); i++) {
					String[] details = new String[6];
					details = tempPlaneStatusDetails.get(i).split(";");
					if (searchEditStatusBooking.equalsIgnoreCase(details[0])) {
						planeStatusWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";" + details[3]
								+ ";" + details[4] + ";" + planeStatusChoice + "\n");
					} else {
						planeStatusWriter.write(tempPlaneStatusDetails.get(i) + "\n");
					}
				}
				planeStatusWriter.close();
				System.out.println("Status Edited successfully.");
			} else {
				System.out.println("Noting Matches your Plane ID entered.");
			}
		} catch (Exception e) {
			System.out.println("An Error Occured while running the program." + e);
		}
	}
}
