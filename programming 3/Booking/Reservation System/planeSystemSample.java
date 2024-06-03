import java.io.*;
import java.text.*;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;

public class planeSystemSample {
	public static void main(String[] args) {
		boolean loginSuccessful = false, found = false, isValid = false, isValidDate = false, searchFound = false,
				cancel = false;
		Scanner sc = new Scanner(System.in);
		LocalDate localDate = LocalDate.now();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			do {
				File editFlightFile = new File("C:/java programs/Plane Booking System/flight.txt");
				Scanner editFlightScanner = new Scanner(editFlightFile);
				System.out.println("-----Edit Flight Details-----\n");
				ArrayList<String> tempFlightDetails = new ArrayList<String>();
				while (editFlightScanner.hasNextLine()) {
					String content = editFlightScanner.nextLine();
					tempFlightDetails.add(content);
				}
				found = false;
				String searchEditFlight = "";
				String tempCurrentPlaneID = "";
				sc = new Scanner(System.in);
				System.out.print("Enter Flight ID to edit Details: ");
				searchEditFlight = sc.nextLine();
				if (searchEditFlight.equalsIgnoreCase("cancel")) {
					System.out.println("Cancelled");
					cancel = true;
					break;
				}
				editFlightScanner = new Scanner(editFlightFile);
				while (editFlightScanner.hasNextLine()) {
					sc = new Scanner(System.in);
					String[] details = new String[10];
					String data = editFlightScanner.nextLine();
					details = data.split(";");
					if (searchEditFlight.equalsIgnoreCase(details[0])) {
						found = true;
						tempCurrentPlaneID = details[1];
						System.out.println("Flight ID: " + details[0]);
						System.out.println("Plane ID: " + details[1]);
						System.out.println("From: " + details[2]);
						System.out.println("To: " + details[3]);
						System.out.println("Date of Flight: " + details[4]);
						System.out.println("Depart Time: " + details[5]);
						System.out.println("Arrival Time: " + details[6]);
						System.out.println("Classification: " + details[7]);
						System.out.println("Category: " + details[8]);
						String stat = "Done";
						if (details[9].equals("1")) {
							stat = "Active";
						}
						System.out.println("Flight Status: " + stat);
						System.out.println();
					}
				}
				File editViewPlaneID = new File("C:/java programs/Plane Booking System/plane.txt");
				Scanner editViewPlaneIDScanner = new Scanner(editViewPlaneID);
				ArrayList<Integer> editAllPlaneID = new ArrayList<Integer>();
				ArrayList<String> editAllPlaneDetails = new ArrayList<String>();
				while (editViewPlaneIDScanner.hasNextLine()) {
					String[] details = new String[3];
					String data = editViewPlaneIDScanner.nextLine();
					editAllPlaneDetails.add(data);
					details = data.split(";");
					if (details[2].equals("1")) {
						editAllPlaneID.add(Integer.parseInt(details[0]));
					}
				}
				if (found) {
					int flightID = 1;
					int planeIDChoice = 0;
					int tempClassificationChoice = 0;
					int tempCategory = 0;
					String from = "";
					String to = "";
					String flightDate = "";
					String departTime = "";
					String arrivalTime = "";
					String categoryChoice = "";
					isValidDate = false;
					boolean isValidTime = false;
					found = false;
					int flightEditChoice = 0;
					System.out.println(
							"1 = Plane ID\n2 = From\n3 = To\n4 = Date of Flight\n5 = Depart Time\n6 = Arrival Time\n7 = Classification\n8 = Category");
					do {
						try {
							System.out.print("Enter number to a detail you want to edit: ");
							String input = sc.nextLine().trim();
							if (input.equalsIgnoreCase("cancel")) {
								System.out.println("Cancelled");
								cancel = true;
								break;
							}
							flightEditChoice = Integer.parseInt(input);
						} catch (Exception e) {
						}
						if (flightEditChoice < 1 || flightEditChoice > 8) {
							System.out.println("Invalid Input! Please try again.");
						}
					} while (flightEditChoice < 1 || flightEditChoice > 8);
					if (cancel) {
						break;
					}
					switch (flightEditChoice) {
					case 1:
						editFlightScanner = new Scanner(editFlightFile);
						while (editFlightScanner.hasNextLine()) {
							String[] details = new String[3];
							details = editFlightScanner.nextLine().split(";");
							flightID++;
						}
						System.out.println("---------List of Available Plane ID's--------- ");
						for (int i = 0; i < editAllPlaneID.size(); i++) {
							System.out.println(editAllPlaneID.get(i));
						}
						do {
							sc = new Scanner(System.in);
							try {
								System.out.print("Please Choose one of the Plane Numbers above ex(1): ");
								String input = sc.nextLine();
								if (input.equalsIgnoreCase("cancel")) {
									System.out.println("Cancelled");
									cancel = true;
									break;
								}
								planeIDChoice = Integer.parseInt(input);
								for (int i = 0; i < editAllPlaneID.size(); i++) {
									if (planeIDChoice == editAllPlaneID.get(i)) {
										found = true;
									}
								}
							} catch (Exception e) {
							}
							if (!found) {
								System.out.println("Invalid plane ID! Please try again.");
							}
						} while (!found);
						if (cancel) {
							break;
						}
						FileWriter editStatusReWrite = new FileWriter("C:/java programs/Plane Booking System/plane.txt",
								false);
						PrintWriter pwOb2 = new PrintWriter(editStatusReWrite, false);
						pwOb2.flush();
						pwOb2.close();
						editStatusReWrite.close();
						FileWriter newEditPlaneFileWriter = new FileWriter(
								"C:/java programs/Plane Booking System/plane.txt", true);
						editViewPlaneID = new File("C:/java programs/Plane Booking System/plane.txt");
						for (int i = 0; i < editAllPlaneDetails.size(); i++) {
							String[] details = new String[3];
							String id = planeIDChoice + "";
							details = editAllPlaneDetails.get(i).split(";");
							if (details[0].equals(id)) {
								newEditPlaneFileWriter.write(details[0] + ";" + details[1] + ";" + "2\n");
							} else if (tempCurrentPlaneID.equalsIgnoreCase(details[1])) {
								newEditPlaneFileWriter.write(details[0] + ";" + details[1] + ";" + "1\n");
							}else {
								newEditPlaneFileWriter.write(editAllPlaneDetails.get(i)+"\n");
							}
						}
						newEditPlaneFileWriter.close();
						FileWriter editFlightWriter = new FileWriter(
								"C:/java programs/Plane Booking System/flight.txt");
						for (int i = 0; i < tempFlightDetails.size(); i++) {
							String[] details = new String[10];
							details = tempFlightDetails.get(i).split(";");
							if (searchEditFlight.equalsIgnoreCase(details[0])) {
								editFlightWriter.write(details[0] + ";" + planeIDChoice + ";" + details[2] + ";" + details[3]
										+ ";" + details[4] + ";" + details[5] + ";" + details[6] + ";" + details[7]
										+ ";" + details[8] + ";" + "1\n");
							} else {
								editFlightWriter.write(tempFlightDetails.get(i) + "\n");
							}
						}
						System.out.println("Flight Edited successfully.");
						editFlightWriter.close();
						break;
					case 2:
						System.out.println("-----Fill in destination-----");
						do {
							sc = new Scanner(System.in);
							System.out.print("Enter From: ");
							from = sc.nextLine();
							if (from.equalsIgnoreCase("cancel")) {
								System.out.println("Cancelled");
								cancel = true;
								break;
							}
							if (containsSpecialCharacters(from)) {
								System.out.println("Invalid Input! Please Do not Include Special Characters.");
							}
						} while (containsSpecialCharacters(from));
						if (cancel) {
							break;
						}
						editFlightWriter = new FileWriter(
								"C:/java programs/Plane Booking System/flight.txt");
						for (int i = 0; i < tempFlightDetails.size(); i++) {
							String[] details = new String[10];
							details = tempFlightDetails.get(i).split(";");
							if (searchEditFlight.equalsIgnoreCase(details[0])) {
								editFlightWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";" + from
										+ ";" + details[4] + ";" + details[5] + ";" + details[6] + ";" + details[7]
										+ ";" + details[8] + ";" + "1\n");
							} else {
								editFlightWriter.write(tempFlightDetails.get(i) + "\n");
							}
						}
						System.out.println("Flight Edited successfully.");
						editFlightWriter.close();
						break;
					case 3:
						System.out.println("-----Fill in destination-----");
						do {
							sc = new Scanner(System.in);
							System.out.print("Enter To: ");
							to = sc.nextLine();
							if (to.equalsIgnoreCase("cancel")) {
								System.out.println("Cancelled");
								cancel = true;
								break;
							}
							if (containsSpecialCharacters(to)) {
								System.out.println("Invalid Input! Please Do not Include Special Characters.");
							}
						} while (containsSpecialCharacters(to));
						if (cancel) {
							break;
						}
						editFlightWriter = new FileWriter(
								"C:/java programs/Plane Booking System/flight.txt");
						for (int i = 0; i < tempFlightDetails.size(); i++) {
							String[] details = new String[10];
							details = tempFlightDetails.get(i).split(";");
							if (searchEditFlight.equalsIgnoreCase(details[0])) {
								editFlightWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
										+ details[3] + ";" + to + ";" + details[5] + ";" + details[6] + ";" + details[7]
										+ ";" + details[8] + ";" + "1\n");
							} else {
								editFlightWriter.write(tempFlightDetails.get(i) + "\n");
							}
						}
						System.out.println("Flight Edited successfully.");
						editFlightWriter.close();
						break;
					case 4:
						isValidDate = false;
						while (!isValidDate) {
							sc = new Scanner(System.in);
							System.out.print("Enter flight date (yyyy-MM-dd): ");
							flightDate = sc.nextLine();
							if (flightDate.equalsIgnoreCase("cancel")) {
								System.out.println("Cancelled");
								cancel = true;
								break;
							}
							try {
								Date tryDate = dateFormat.parse(flightDate);
								isValidDate = true;
							} catch (ParseException e) {
								System.out.println("Invalid date format. Please try again.");
							}
						}
						if (cancel) {
							break;
						}
						editFlightWriter = new FileWriter(
								"C:/java programs/Plane Booking System/flight.txt");
						for (int i = 0; i < tempFlightDetails.size(); i++) {
							String[] details = new String[10];
							details = tempFlightDetails.get(i).split(";");
							if (searchEditFlight.equalsIgnoreCase(details[0])) {
								editFlightWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
										+ details[3] + ";" + details[4] + ";" + departTime + ";" + details[6] + ";"
										+ details[7] + ";" + details[8] + ";" + "1\n");
							} else {
								editFlightWriter.write(tempFlightDetails.get(i) + "\n");
							}
						}
						System.out.println("Flight Edited successfully.");
						editFlightWriter.close();
						break;
					case 5:
						isValidTime = false;
						while (!isValidTime) {
							sc = new Scanner(System.in);
							System.out.print("Enter departure time (hh:mm): ");
							departTime = sc.nextLine();
							if (departTime.equalsIgnoreCase("cancel")) {
								System.out.println("Cancelled");
								cancel = true;
								break;
							}
							if (isValidTimeFormat(departTime)) {
								isValidTime = true;
							} else {
								System.out.println("Invalid time format! Please try again.");
							}
						}
						if (cancel) {
							break;
						}
						editFlightWriter = new FileWriter(
								"C:/java programs/Plane Booking System/flight.txt");
						for (int i = 0; i < tempFlightDetails.size(); i++) {
							String[] details = new String[10];
							details = tempFlightDetails.get(i).split(";");
							if (searchEditFlight.equalsIgnoreCase(details[0])) {
								editFlightWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
										+ details[3] + ";" + details[4] + ";" + departTime + ";" + details[6] + ";"
										+ details[7] + ";" + details[8] + ";" + "1\n");
							} else {
								editFlightWriter.write(tempFlightDetails.get(i) + "\n");
							}
						}
						System.out.println("Flight Edited successfully.");
						editFlightWriter.close();
						break;
					case 6:
						isValidTime = false;
						while (!isValidTime) {
							sc = new Scanner(System.in);
							System.out.print("Enter arrival time (hh:mm): ");
							arrivalTime = sc.nextLine();
							if (arrivalTime.equalsIgnoreCase("cancel")) {
								System.out.println("Cancelled");
								cancel = true;
								break;
							}
							if (isValidTimeFormat(arrivalTime)) {
								isValidTime = true;
							} else {
								System.out.println("Invalid time format! Please try again.");
							}
						}
						if (cancel) {
							break;
						}
						editFlightWriter = new FileWriter(
								"C:/java programs/Plane Booking System/flight.txt");
						for (int i = 0; i < tempFlightDetails.size(); i++) {
							String[] details = new String[10];
							details = tempFlightDetails.get(i).split(";");
							if (searchEditFlight.equalsIgnoreCase(details[0])) {
								editFlightWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
										+ details[3] + ";" + details[4] + ";" + details[5] + ";" + arrivalTime + ";"
										+ details[7] + ";" + details[8] + ";" + "1\n");
							} else {
								editFlightWriter.write(tempFlightDetails.get(i) + "\n");
							}
						}
						System.out.println("Flight Edited successfully.");
						editFlightWriter.close();
						break;
					case 7:
						String[] classification2 = { "First Class", "Business Class", "Economy Class" };
						System.out.println("-----Classifications-----");
						System.out.println("1. First Class\n2. Business Class\n3. Economy Class");
						String classificationChoice = "";
						do {
							sc = new Scanner(System.in);
							System.out.print("Please choose classification: ");
							String input = sc.nextLine().trim();
							if (input.equalsIgnoreCase("cancel")) {
								System.out.println("Cancelled");
								cancel = true;
								break;
							}
							if (input.matches("[1-3]")) {
								tempClassificationChoice = Integer.parseInt(input);
								for (int i = 0; i < classification2.length; i++) {
									if (tempClassificationChoice == (i + 1)) {
										classificationChoice = classification2[i];
									}
								}
								break;
							}
							System.out.println("Invalid Input! Please try again.");
						} while (true);
						if (cancel) {
							break;
						}
						editFlightWriter = new FileWriter(
								"C:/java programs/Plane Booking System/flight.txt");
						for (int i = 0; i < tempFlightDetails.size(); i++) {
							String[] details = new String[10];
							details = tempFlightDetails.get(i).split(";");
							if (searchEditFlight.equalsIgnoreCase(details[0])) {
								editFlightWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
										+ details[3] + ";" + details[4] + ";" + details[5] + ";" + details[6] + ";"
										+ classificationChoice + ";" + details[8] + ";" + "1\n");
							} else {
								editFlightWriter.write(tempFlightDetails.get(i) + "\n");
							}
						}
						System.out.println("Flight Edited successfully.");
						editFlightWriter.close();
						break;
					case 8:
						String[] category2 = { "One Way", "Round Trip" };
						System.out.println("-----category-----");
						System.out.println("1. One Way\n2. Round Trip");
						do {
							sc = new Scanner(System.in);
							System.out.print("Please choose category: ");
							String input = sc.nextLine().trim();
							if (input.equalsIgnoreCase("cancel")) {
								System.out.println("Cancelled");
								cancel = true;
								break;
							}
							if (input.matches("[1-2]")) {
								tempCategory = Integer.parseInt(input);
								for (int i = 0; i < category2.length; i++) {
									if (tempCategory == (i + 1)) {
										categoryChoice = category2[i];
									}
								}
								break;
							}
							System.out.println("Invalid Input! Please try again.");
						} while (true);
						if (cancel) {
							break;
						}
						editFlightWriter = new FileWriter(
								"C:/java programs/Plane Booking System/flight.txt");
						for (int i = 0; i < tempFlightDetails.size(); i++) {
							String[] details = new String[10];
							details = tempFlightDetails.get(i).split(";");
							if (searchEditFlight.equalsIgnoreCase(details[0])) {
								editFlightWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
										+ details[3] + ";" + details[4] + ";" + details[5] + ";" + details[6] + ";"
										+ details[7] + ";" + categoryChoice + ";" + "1\n");
							} else {
								editFlightWriter.write(tempFlightDetails.get(i) + "\n");
							}
						}
						System.out.println("Flight Edited successfully.");
						editFlightWriter.close();
						break;
					default:
						break;
					}
				} else {
					System.out.println("Nothing matches your Flight ID Entered.");
				}
			} while (true);
		} catch (Exception e) {
			System.out.println("An Error Occured\n" + e);
		}
		sc.close();
	}

	private static boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private static boolean containsSpecialCharacters(String name) {
		return !name.matches("[a-zA-Z ]+");
	}

	private static boolean isValidTimeFormat(String time) {
		String[] timeParts = time.split(":");
		if (timeParts.length != 2) {
			return false;
		}
		try {
			int hours = Integer.parseInt(timeParts[0]);
			int minutes = Integer.parseInt(timeParts[1]);

			if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
