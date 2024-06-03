import java.io.*;
import java.util.*;

public class finals2 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			File building = new File("c:/java programs/building.txt");
			Scanner bsc = new Scanner(building);
			ArrayList<String> allDetails = new ArrayList<String>();
			while (bsc.hasNextLine()) {
				String[] details = new String[5];
				String data = bsc.nextLine();
				details = data.split(";");
				allDetails.add(data);
			}
			boolean found = false, searchFound = false;
			String rname = "";
			System.out.print("Enter room ID to search: ");
			String search = sc.nextLine();
			bsc = new Scanner(building);
			while (bsc.hasNextLine()) {
				String[] details = new String[5];
				String data = bsc.nextLine();
				details = data.split(";");
				if (search.equals(details[0])) {
					searchFound = true;
					System.out.println("Building ID: " + details[0]);
					System.out.println("Building Name: " + details[1]);
					System.out.println("Building type: " + details[2]);
					System.out.println("Ventilation type: " + details[3]);
					if (details[4].equals("1")) {
						System.out.println("Status: available");
					} else if (details[4].equals("2")) {
						System.out.println("Status: occupied");
					} else {
						System.out.println("Status: under-repair");
					}
					System.out.println();
					do {
						found = false;
						sc = new Scanner(System.in);
						System.out.print("Enter room name: ");
						rname = sc.nextLine();
						for (int i = 0; i < allDetails.size(); i++) {
							String[] arr = new String[5];
							String temp = allDetails.get(i);
							arr = temp.split(";");
							if (arr[0].equalsIgnoreCase(search) && arr[1].equalsIgnoreCase(rname)) {
								found = true;
							}
						}
						if (found) {
							System.out.println("Building Name Already Exisitng");
						}
					} while (found);
					String rtype = "";
					do {
						found = true;
						sc = new Scanner(System.in);
						System.out.print("Enter room type: ");
						rtype = sc.nextLine();
						if (rtype.equalsIgnoreCase("Single")) {
							found = false;
						}
						if (rtype.equalsIgnoreCase("Double")) {
							found = false;
						}
						if (rtype.equalsIgnoreCase("family")) {
							found = false;
						}
						if (found) {
							System.out.println("Invalid Input. Enter a valid room type.");
						}
					} while (found);
					String vtype = "";
					do {
						found = true;
						sc = new Scanner(System.in);
						System.out.print("Enter ventilation type: ");
						vtype = sc.nextLine();
						if (vtype.equalsIgnoreCase("aircon")) {
							found = false;
						}
						if (vtype.equalsIgnoreCase("non-air")) {
							found = false;
						}
						if (found) {
							System.out.println("Invalid Input. Enter a valid ventilation type.");
						}
					} while (found);
					FileWriter roomWriter = new FileWriter("c:/java programs/building.txt");
					for (int i = 0; i < allDetails.size(); i++) {
						String[] array = new String[5];
						array = allDetails.get(i).split(";");
						if (array[0].equals(search)) {
							roomWriter.write(
									details[0] + ";" + rname + ";" + rtype + ";" + vtype + ";" + details[4] + "\n");
						} else {
							roomWriter.write(allDetails.get(i) + "\n");
						}
					}
					roomWriter.close();
					System.out.println("Status Edited Successfully.");
					break;
				}
			}
			if (!searchFound) {
				System.out.println("No matches your Building ID entered.");
			}
		} catch (Exception e) {
			System.out.println("An error occured.\n" + e);
		}
	}
}
