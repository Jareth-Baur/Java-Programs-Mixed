import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;
import java.text.*;

public class Plane_Booking2 {
	public static void main(String[] args) {
		boolean loginSuccessful = false;
		try {
			String line = "---------------------------------------------------------";
			String logInMenu = "*****MainMenu*****\n1. Log-in\n2. Register a new Staff / User\n3. Exit\n";
			String menu = "*****Menu*****\n" + "0. Add Plane\n" + "1. Search Plane\n" + "2. Edit Plane Status\n"
					+ "3. Add Flight\n" + "4. Search Flight\n" + "5. Add Booking\n" + "6. Search Booking\n"
					+ "7. Edit Flight\n" + "8. Edit Booking\n" + "9. Update Flight Status\n"
					+ "10. Update Booking Status\n" + "11. Log-out";
			System.out.print("Welcome to Plane Booking System.\n");
			do {
				boolean cancel = false;
				Scanner sc = new Scanner(System.in);
				LocalDate date = LocalDate.now();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				dateFormat.setLenient(false);
				if (!loginSuccessful) {
					System.out.print(logInMenu);
					int logInMenuChoice = 0;
					do {
						sc = new Scanner(System.in);
						try {
							System.out.print("Please choose a number: ");
							String input = sc.nextLine();
							logInMenuChoice = Integer.parseInt(input);
						} catch (Exception e) {
						}
						if (logInMenuChoice < 1 || logInMenuChoice > 3)
							System.out.println("Invalid Number! Please Input Valid number 1,2 or 3 only.");
					} while (logInMenuChoice < 1 || logInMenuChoice > 3);
					switch (logInMenuChoice) {
					case 1:
						File loginFile = new File("C:/java programs/Plane Booking System/user.txt");
						Scanner loginFileScanner = new Scanner(loginFile);
						String username = "", password = "", data = "";
						System.out.println("------Log in Form------");
						sc = new Scanner(System.in);
						System.out.print("Enter Username: ");
						username = sc.nextLine();
						System.out.print("Enter Password: ");
						password = sc.nextLine();
						while (loginFileScanner.hasNextLine()) {
							String[] details = new String[4];
							data = loginFileScanner.nextLine();
							details = data.split(";");
							if (username.equals(details[1]) && password.equals(details[2])) {
								System.out.println("Log in Successful.\n");
								loginSuccessful = true;
							}
						}
						if (data.isBlank()) {
							System.out.println("No Registered Users / Staff found! Please Register first.");
							break;
						}
						if (!loginSuccessful) {
							System.out.println("Invalid Username or Password try again.\n");
						}
						break;
					case 2:
						FileWriter userWriter = new FileWriter("C:/java programs/Plane Booking System/user.txt", true);
						File userFile = new File("C:/java programs/Plane Booking System/user.txt");
						Scanner userFileScanner = new Scanner(userFile);
						ArrayList<String> allUserNames = new ArrayList<String>();
						int userID = 1;
						while (userFileScanner.hasNextLine()) {
							String[] details = new String[4];
							details = userFileScanner.nextLine().split(";");
							allUserNames.add(details[1]);
							userID++;
						}
						userFileScanner.close();
						System.out.println("Register a new user/staff.\n");
						String userName = "", userPassword = "";
						boolean found = false;
						do {
							found = false;
							sc = new Scanner(System.in);
							System.out.print("Enter Username to add: ");
							userName = sc.nextLine();
							for (int i = 0; i < allUserNames.size(); i++) {
								String name = allUserNames.get(i);
								if (name.equalsIgnoreCase(userName)) {
									found = true;
								}
							}
						} while (found);
						System.out.print("Enter password: ");
						userPassword = sc.nextLine();
						userWriter.write(userID + ";" + userName + ";" + userPassword + ";" + "1\n");
						System.out.println("Registered Successfully.");
						userWriter.close();
						break;
					case 3:
						System.out.println("Exiting...");
						System.exit(1);
						break;
					default:
						break;
					}
				}
				if (loginSuccessful) {
					int menuChoice = -1;
					System.out.println(menu);
					do {
						sc = new Scanner(System.in);
						try {
							System.out.print("Please choose a number: ");
							String input = sc.nextLine();
							menuChoice = Integer.parseInt(input);
						} catch (Exception e) {
						}
						if (menuChoice < 0 || menuChoice > 11) {
							System.out.println("Invalid number! Please choose from numbers 0 to 11 only.");
						}
					} while (menuChoice < 0 || menuChoice > 11);
					switch (menuChoice) {
					case 0:
						System.out.println("Add plane.\n");
						sc = new Scanner(System.in);
						date = LocalDate.now();
						FileWriter planeWriter = new FileWriter("C:/java programs/Plane Booking System/plane.txt",
								true);
						File planeFileAddPlane = new File("C:/java programs/Plane Booking System/plane.txt");
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
							System.out.print("Enter Plane Name: ");
							planeName = sc.nextLine();
							if (planeName.equalsIgnoreCase("cancel")) {
								cancel = true;
								System.out.println("Cancelled.");
								break;
							}
							if (planeName.isBlank()) {
								System.out.println("Invalid Plane Name. Please try again.");
							}
						} while (planeName.isBlank());
						if (cancel) {
							break;
						}
						String[] planeSizeHolder = { "Small", "Medium", "Large" };
						System.out.println("1. Small\n2. Medium\n3. Large");
						do {
							sc = new Scanner(System.in);
							try {
								System.out.print("Enter Plane size: ");
								String input = sc.nextLine().trim();
								if (input.equalsIgnoreCase("cancel")) {
									cancel = true;
									System.out.println("Cancelled.");
									break;
								}
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
						if (cancel) {
							break;
						}
						String[] numberOfSabadHolder = { "Single", "Double" };
						System.out.println("1. Single\n2. Double");
						do {
							sc = new Scanner(System.in);
							try {
								System.out.print("Enter Plane Turbane: ");
								String input = sc.nextLine().trim();
								if (input.equalsIgnoreCase("cancel")) {
									cancel = true;
									System.out.println("Cancelled.");
									break;
								}
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
						if (cancel) {
							break;
						}
						planeWriter.write(planeID + ";" + planeName + ";" + planeSizeChoice + ";" + numberOfSabadChoice
								+ ";" + date + ";" + "1\n");
						planeWriter.close();
						System.out.println("Plane added Successfully.");
						System.out.println("All Planes:");
						System.out.println(
								"|    Plane no.\t|\tPlane Name\t|\tPlane Size\t|\tPlane Turbane\t|\tDate Added\t|    Status\t|");
						System.out.println(line + line);
						planeScanner = new Scanner(planeFileAddPlane);
						while (planeScanner.hasNextLine()) {
							String[] details = new String[6];
							String content = planeScanner.nextLine();
							details = content.split(";");
							System.out.println("|    " + details[0] + "\t\t|\t" + details[1] + "\t\t|\t" + details[2]
									+ "\t\t|\t" + details[3] + "\t\t|\t" + details[4] + "\t|\t" + details[5] + "\t|");
							System.out.println(line + line);
						}
						planeScanner.close();
						break;
					case 1:
						File planeFileSearch = new File("C:/java programs/Plane Booking System/plane.txt");
						Scanner planeFileScanner = new Scanner(planeFileSearch);
						sc = new Scanner(System.in);
						System.out.println("Search Plane.\n");
						System.out.print("Input keyword to search: ");
						String PlaneSearch = sc.nextLine();
						System.out.println("Search result for " + PlaneSearch + ": ");
						System.out.println(
								"|    Plane no.\t|\tPlane Name\t|\tPlane Size\t|\tPlane Turbane\t|\tDate Added\t|    Status\t|");
						System.out.println(line + line);
						boolean noPlaneFound = true;
						while (planeFileScanner.hasNextLine()) {
							String[] details = new String[6];
							String content = planeFileScanner.nextLine();
							details = content.split(";");
							noPlaneFound = true;
							if (content.matches("(.*)" + PlaneSearch + "(.*)")) {
								noPlaneFound = false;
								System.out.println("|    " + details[0] + "\t\t|\t" + details[1] + "\t\t|\t"
										+ details[2] + "\t\t|\t" + details[3] + "\t\t|\t" + details[4] + "\t|\t"
										+ details[5] + "\t|");
								System.out.println(line + line);
							}
						}
						if (noPlaneFound) {
							System.out.println("No Plane Matches Your Search.");
						}
						break;
					case 2:
						File editPlaneStatus = new File("C:/java programs/Plane Booking System/plane.txt");
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
						if (searchEditStatusBooking.equalsIgnoreCase("cancel")) {
							cancel = true;
							System.out.println("Cancelled.");
							break;
						}
						editPlaneStatusScanner = new Scanner(editPlaneStatus);
						while (editPlaneStatusScanner.hasNextLine()) {
							sc = new Scanner(System.in);
							String[] details = new String[6];
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
								if (input.equalsIgnoreCase("cancel")) {
									cancel = true;
									System.out.println("Cancelled.");
									break;
								}
								if (input.matches("[1-2]")) {
									planeStatusChoice = Integer.parseInt(input);
									break;
								}
								System.out.println("Invalid Input! Please from 1 to 2 only.");
							} while (true);
							if (cancel) {
								break;
							}
							FileWriter planeStatusWriter = new FileWriter(
									"C:/java programs/Plane Booking System/plane.txt");
							for (int i = 0; i < tempPlaneStatusDetails.size(); i++) {
								String[] details = new String[6];
								details = tempPlaneStatusDetails.get(i).split(";");
								if (searchEditStatusBooking.equalsIgnoreCase(details[0])) {
									planeStatusWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
											+ details[3] + ";" + details[4] + ";" + planeStatusChoice + "\n");
								} else {
									planeStatusWriter.write(tempPlaneStatusDetails.get(i) + "\n");
								}
							}
							planeStatusWriter.close();
							System.out.println("Status Edited successfully.");
						} else {
							System.out.println("Noting Matches your Plane ID entered.");
						}
						break;
					case 3:
						System.out.println("Add a flight:\n");
						FileWriter flightWriter = new FileWriter("C:/java programs/Plane Booking System/flight.txt",
								true);
						File addFlight = new File("C:/java programs/Plane Booking System/flight.txt");
						Scanner addFlightScanner = new Scanner(addFlight);
						File viewPlaneID = new File("C:/java programs/Plane Booking System/plane.txt");
						Scanner viewPlaneIDScanner = new Scanner(viewPlaneID);
						ArrayList<Integer> allPlaneID = new ArrayList<Integer>();
						ArrayList<String> allPlaneDetails = new ArrayList<String>();
						addFlightScanner = new Scanner(addFlight);
						while (viewPlaneIDScanner.hasNextLine()) {
							String[] details = new String[6];
							String data = viewPlaneIDScanner.nextLine();
							allPlaneDetails.add(data);
							details = data.split(";");
							if (details[5].equals("1")) {
								allPlaneID.add(Integer.parseInt(details[0]));
							}
						}
						int flightID = 1, planeIDChoice = 0, tempClassificationChoice = 0, tempCategory = 0;
						String from = "", to = "", flightDate = "", departTime = "", arrivalTime = "",
								categoryChoice = "";
						boolean isValidDate = false, isValidTime = false;
						found = false;
						while (addFlightScanner.hasNextLine()) {
							String[] details = new String[3];
							details = addFlightScanner.nextLine().split(";");
							flightID++;
						}
						System.out.println("-----List of Available Plane ID's-----");
						for (int i = 0; i < allPlaneID.size(); i++) {
							System.out.println(allPlaneID.get(i));
						}

						do {
							sc = new Scanner(System.in);
							try {
								System.out.print("Please Choose one of the Plane Numbers above ex(1): ");
								String input = sc.nextLine().trim();
								if (input.equalsIgnoreCase("cancel")) {
									System.out.println("Cancelled.");
									cancel = true;
									break;
								}
								planeIDChoice = Integer.parseInt(input);
								for (int i = 0; i < allPlaneID.size(); i++) {
									if (planeIDChoice == allPlaneID.get(i)) {
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
						FileWriter statusReWrite = new FileWriter("C:/java programs/Plane Booking System/plane.txt",
								false);
						PrintWriter pwOb = new PrintWriter(statusReWrite, false);
						pwOb.flush();
						pwOb.close();
						statusReWrite.close();
						FileWriter newPlaneFileWriter = new FileWriter(
								"C:/java programs/Plane Booking System/plane.txt", true);
						viewPlaneID = new File("C:/java programs/Plane Booking System/plane.txt");
						for (int i = 0; i < allPlaneDetails.size(); i++) {
							String[] details = new String[6];
							String id = planeIDChoice + "";
							details = allPlaneDetails.get(i).split(";");
							if (details[0].equals(id)) {
								newPlaneFileWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
										+ details[3] + ";" + details[4] + ";" + "2\n");
							} else {
								newPlaneFileWriter.write(allPlaneDetails.get(i) + "\n");
							}
						}
						newPlaneFileWriter.close();
						System.out.println("------Fill in destination------");
						do {
							sc = new Scanner(System.in);
							System.out.print("Enter From: ");
							from = sc.nextLine();
							if (from.equalsIgnoreCase("cancel")) {
								System.out.println("Cancelled.");
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
						do {
							sc = new Scanner(System.in);
							System.out.print("Enter To: ");
							to = sc.nextLine();
							if (to.equalsIgnoreCase("Cancel")) {
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
						String[] classification = { "First Class", "Business Class", "Economy Class" };
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
								for (int i = 0; i < classification.length; i++) {
									if (tempClassificationChoice == (i + 1)) {
										classificationChoice = classification[i];
									}
								}
								break;
							}
							System.out.println("Invalid Input! Please try again.");
						} while (true);
						if (cancel) {
							break;
						}
						String[] category = { "One Way", "Round Trip" };
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
								for (int i = 0; i < category.length; i++) {
									if (tempCategory == (i + 1)) {
										categoryChoice = category[i];
									}
								}
								break;
							}
							System.out.println("Invalid Input! Please try again.");
						} while (true);
						if (cancel) {
							break;
						}
						flightWriter.write(flightID + ";" + planeIDChoice + ";" + from + ";" + to + ";" + flightDate
								+ ";" + departTime + ";" + arrivalTime + ";" + classificationChoice + ";"
								+ categoryChoice + ";" + "1\n");
						flightWriter.close();
						System.out.println("Flight added successfully.\nList of All Flights: ");
						System.out.println(
								"|\tFlight ID\t|\tPlane No.\t|\tFrom\t\t|\tTo\t\t|\tDate of Flight\t|\tDepart Time\t|\tArrival Time\t|\tClassification\t|\tCategory\t|\tStatus\t|");
						System.out.println(line + line + line + line + "-------");
						addFlight = new File("C:/java programs/Plane Booking System/flight.txt");
						addFlightScanner = new Scanner(addFlight);
						while (addFlightScanner.hasNextLine()) {
							String[] details = new String[10];
							String content = addFlightScanner.nextLine();
							details = content.split(";");
							System.out.println("|\tF-" + details[0] + "\t\t|\tP-" + details[1] + "\t\t|\t" + details[2]
									+ "\t\t|\t" + details[3] + "\t\t|\t" + details[4] + "\t|\t" + details[5] + "\t\t|\t"
									+ details[6] + "\t\t|\t" + details[7] + "\t|\t" + details[8] + "\t|\t" + details[9]
									+ "\t|");
							System.out.println(line + line + line + line + "-------");
						}
						break;
					case 4:
						File searchFlight = new File("C:/java programs/Plane Booking System/flight.txt");
						Scanner searchFlightScanner = new Scanner(searchFlight);
						boolean noFlightFound = false;
						System.out.println("Search a flight.\n");
						System.out.print("Input keyword to search: ");
						String flightSearch = sc.nextLine();
						if (flightSearch.equalsIgnoreCase("cancel")) {
							System.out.println("Cancelled");
							cancel = true;
							break;
						}
						System.out.println("Search result for " + flightSearch + ": ");
						System.out.println(
								"|\tFlight ID\t|\tPlane No.\t|\tFrom\t\t|\tTo\t\t|\tDate of Flight\t|\tDepart Time\t|\tArrival Time\t|\tClassification\t|\tCategory\t|\tStatus\t|");
						System.out.println(line + line + line + line + "-------");
						while (searchFlightScanner.hasNextLine()) {
							String[] details = new String[10];
							String content = searchFlightScanner.nextLine();
							noFlightFound = false;
							if (content.matches("(.*)" + flightSearch + "(.*)")) {
								details = content.split(";");
								System.out.println("|\tF-" + details[0] + "\t\t|\tP-" + details[1] + "\t\t|\t"
										+ details[2] + "\t|\t" + details[3] + "\t\t|\t" + details[4] + "\t|\t"
										+ details[5] + "\t\t|\t" + details[6] + "\t\t|\t" + details[7] + "\t|\t"
										+ details[8] + "\t|\t" + details[9] + "\t|");
								System.out.println(line + line + line + line + "-------");
							} else {
								noFlightFound = true;
							}
						}
						if (noFlightFound) {
							System.out.println("Nothing Matches your search.");
						}
						break;
					case 5:
						FileWriter bookingWriter = new FileWriter("C:/java programs/Plane Booking System/booking.txt",
								true);
						File addBookingFile = new File("C:/java programs/Plane Booking System/booking.txt");
						Scanner addBookingScanner = new Scanner(addBookingFile);
						System.out.println("Add Booking:\n");
						File bookFlightFile = new File("C:/java programs/Plane Booking System/flight.txt");
						Scanner bookFlightFileScanner = new Scanner(bookFlightFile);
						int bookingID = 1, bookingFlightID = 0, tempPayment = 0, numberOfTravelers = 0;
						double amount = -1;
						String fullName = "", payment = "", email = "", statusChoice = "";
						boolean isValid = false, flightNotFound = true;
						ArrayList<String> allFlightDetails = new ArrayList<String>();
						while (bookFlightFileScanner.hasNextLine()) {
							String[] details = new String[10];
							String data = bookFlightFileScanner.nextLine();
							details = data.split(";");
							allFlightDetails.add(data);
						}
						while (addBookingScanner.hasNextLine()) {
							String[] details = new String[9];
							details = addBookingScanner.nextLine().split(";");
							bookingID++;
						}
						System.out.println("-----Flight ID and Destination details-----");
						System.out.println("Flight ID\tFrom\t\t\tTo");
						System.out.println("-----------------------------------------------------");
						for (int i = 0; i < allFlightDetails.size(); i++) {
							String[] details = new String[10];
							String data = allFlightDetails.get(i);
							details = data.split(";");
							System.out.println(details[0] + "\t\t" + details[2] + "\t\t\t" + details[3]);
						}
						do {
							sc = new Scanner(System.in);
							flightNotFound = true;
							flightID = 0;
							try {
								System.out.print("Enter Flight ID to add to your Booking: ");
								String input = sc.nextLine().trim();
								bookingFlightID = Integer.parseInt(input);
								if (input.equalsIgnoreCase("cancel")) {
									System.out.println("Cancelled");
									cancel = true;
									break;
								}
								bookingFlightID = Integer.parseInt(input);
								for (int i = 0; i < allFlightDetails.size(); i++) {
									String[] details = new String[10];
									String data = allFlightDetails.get(i);
									details = data.split(";");
									if (input.equals(details[0])) {
										flightNotFound = false;
									}
								}
								if (flightNotFound) {
									System.out.println("Invalid Flight ID. Please Choose from the choices only.");
								}
							} catch (Exception e) {
								System.out.println("Invalid Flight ID. Please try again.");
							}
						} while (flightNotFound);
						if (cancel) {
							break;
						}
						do {
							sc = new Scanner(System.in);
							System.out.print("Enter applicant's full name: ");
							fullName = sc.nextLine();
							if (fullName.equalsIgnoreCase("cancel")) {
								System.out.println("Cancelled");
								cancel = true;
								break;
							}
							if (containsSpecialCharacters(fullName)) {
								System.out.println("Invalid Name! Please do not Inlcude Special Characters / Numbers.");
							}
						} while (containsSpecialCharacters(fullName));
						if (cancel) {
							break;
						}
						String[] paymentMethod = { "Credit Card", "Debit Card", "Cash", "Paper Check",
								"Digital Payment" };
						System.out.println("----Mode of Payments----");
						System.out.println("1. Credit Card\n" + "2. Debit Card\n" + "3. Cash\n" + "4. Paper Check\n"
								+ "5. Digital Payment.");
						do {
							sc = new Scanner(System.in);
							System.out.print("Please Select Mode of Payment: ");
							String input = sc.nextLine().trim();
							if (input.equalsIgnoreCase("cancel")) {
								System.out.println("Cancelled");
								cancel = true;
								break;
							}
							if (input.matches("[1-5]")) {
								tempPayment = Integer.parseInt(input);
								for (int i = 0; i < paymentMethod.length; i++) {
									if (tempPayment == (i + 1)) {
										payment = paymentMethod[i];
									}
								}
								break;
							}
							System.out.println("Invalid Input! Please try again.");
						} while (true);
						if (cancel) {
							break;
						}
						while (!isValid) {
							sc = new Scanner(System.in);
							System.out.print("Enter an email address: ");
							email = sc.nextLine();
							if (email.equalsIgnoreCase("cancel")) {
								System.out.println("Cancelled");
								cancel = true;
								break;
							}
							isValid = isValidEmail(email);
							if (!isValid) {
								System.out.println("Invalid email address. Please try again.");
							}
						}
						if (cancel) {
							break;
						}
						do {
							sc = new Scanner(System.in);
							try {
								System.out.print("Enter head count of travelers (maximum of 10): ");
								String input = sc.nextLine().trim();
								if (input.equalsIgnoreCase("cancel")) {
									System.out.println("Cancelled");
									cancel = true;
									break;
								}
								numberOfTravelers = Integer.parseInt(input);
							} catch (Exception e) {
							}
							if (numberOfTravelers < 1 || numberOfTravelers > 10) {

								System.out.println("Invalid Input! Please choose from 1 to 10 only.");
							}
						} while (numberOfTravelers < 1 || numberOfTravelers > 10);
						if (cancel) {
							break;
						}
						do {
							sc = new Scanner(System.in);
							try {
								System.out.print("Enter amount: ");
								String input = sc.nextLine().trim();
								if (input.equalsIgnoreCase("cancel")) {
									System.out.println("Cancelled");
									cancel = true;
									break;
								}
								amount = Double.parseDouble(input);
							} catch (Exception e) {
							}
							if (amount <= 0) {
								System.out.println("Invalid Input! Please do not include special characters.");
							}
						} while (amount <= 0);
						if (cancel) {
							break;
						}
						bookingWriter.write(bookingID + ";" + bookingFlightID + ";" + fullName + ";" + payment + ";"
								+ email + ";" + date + ";" + numberOfTravelers + ";" + amount + ";" + "2\n");
						bookingWriter.close();
						System.out.println("Booking added successfully.\nList of All Bookings.");
						System.out.println(
								"|\tBooking ID\t|\tFlight ID\t|\tApplicants Name\t|\tMode of Payment\t|\tEmail Address\t\t\t|\tDate of Booking\t|\tNumber of Travelers\t|\tAmount\t|\tStatus\t|");
						System.out.println(line + line + line + line + "---");
						addBookingScanner = new Scanner(addBookingFile);
						while (addBookingScanner.hasNextLine()) {
							String[] details = new String[10];
							String content = addBookingScanner.nextLine();
							details = content.split(";");
							System.out.println("|\tB-" + details[0] + "\t\t|\tF-" + details[1] + "\t\t|\t" + details[2]
									+ "\t|\t" + details[3] + "\t|\t" + details[4] + "\t|\t" + details[5] + "\t|\t"
									+ details[6] + "\t\t\t|\t" + details[7] + "\t|\t" + details[8] + "\t|");
							System.out.println(line + line + line + line + "---");
						}
						break;
					case 6:
						File searchBookingFile = new File("C:/java programs/Plane Booking System/booking.txt");
						Scanner searchBookingScanner = new Scanner(searchBookingFile);
						System.out.println("Search Booking.\n");
						found = false;
						sc = new Scanner(System.in);
						System.out.print("Input keyword to search: ");
						String bookingSearch = sc.nextLine();
						if (bookingSearch.equalsIgnoreCase("cancel")) {
							System.out.println("Cancelled");
							cancel = true;
							break;
						}
						System.out.println("Search result for " + bookingSearch + ": ");
						System.out.println(
								"|\tBooking ID\t|\tFlight ID\t|\tApplicants Name\t|\tMode of Payment\t|\tEmail Address\t\t\t|\tDate of Booking\t|\tNumber of Travelers\t|\tAmount\t|\tStatus\t|");
						System.out.println(line + line + line + line + "---");
						while (searchBookingScanner.hasNextLine()) {
							String[] details = new String[9];
							String content = searchBookingScanner.nextLine();
							if (content.matches("(.*)" + bookingSearch + "(.*)")) {
								found = true;
								details = content.split(";");
								System.out.println("|\tB-" + details[0] + "\t\t|\tF-" + details[1] + "\t\t|\t"
										+ details[2] + "\t|\t" + details[3] + "\t|\t" + details[4] + "\t|\t"
										+ details[5] + "\t|\t" + details[6] + "\t\t\t|\t" + details[7] + "\t|\t"
										+ details[8] + "\t|");
								System.out.println(line + line + line + line + "---");
							}
						}
						if (!found) {
							System.out.println("Nothing Matches your search.");
						}
						break;
					case 7:
						File editFlightFile = new File("C:/java programs/Plane Booking System/flight.txt");
						Scanner editFlightScanner = new Scanner(editFlightFile);
						System.out.println("Edit Flight Details.");
						ArrayList<String> tempFlightDetails = new ArrayList<String>();
						while (editFlightScanner.hasNextLine()) {
							String content = editFlightScanner.nextLine();
							tempFlightDetails.add(content);
						}
						found = false;
						String searchEditFlight = "";
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
							String[] details = new String[6];
							String data = editViewPlaneIDScanner.nextLine();
							editAllPlaneDetails.add(data);
							details = data.split(";");
							if (details[5].equals("1")) {
								editAllPlaneID.add(Integer.parseInt(details[0]));
							}
						}
						if (found) {
							flightID = 1;
							planeIDChoice = 0;
							tempClassificationChoice = 0;
							tempCategory = 0;
							from = "";
							to = "";
							flightDate = "";
							departTime = "";
							arrivalTime = "";
							categoryChoice = "";
							isValidDate = false;
							isValidTime = false;
							found = false;
							editFlightScanner = new Scanner(editFlightFile);
							while (editFlightScanner.hasNextLine()) {
								String[] details = new String[5];
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
							FileWriter editStatusReWrite = new FileWriter(
									"C:/java programs/Plane Booking System/plane.txt", false);
							PrintWriter pwOb2 = new PrintWriter(editStatusReWrite, false);
							pwOb2.flush();
							pwOb2.close();
							editStatusReWrite.close();
							FileWriter newEditPlaneFileWriter = new FileWriter(
									"C:/java programs/Plane Booking System/plane.txt", true);
							editViewPlaneID = new File("C:/java programs/Plane Booking System/plane.txt");
							for (int i = 0; i < editAllPlaneDetails.size(); i++) {
								String[] details = new String[5];
								String id = planeIDChoice + "";
								details = editAllPlaneDetails.get(i).split(";");
								if (details[0].equals(id)) {
									newEditPlaneFileWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
											+ details[3] + ";" + details[4] + ";" + "2\n");
								} else {
									newEditPlaneFileWriter.write(editAllPlaneDetails.get(i) + "\n");
								}
							}
							newEditPlaneFileWriter.close();
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
							String[] classification2 = { "First Class", "Business Class", "Economy Class" };
							System.out.println("-----Classifications-----");
							System.out.println("1. First Class\n2. Business Class\n3. Economy Class");
							classificationChoice = "";
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
							FileWriter editFlightWriter = new FileWriter(
									"C:/java programs/Plane Booking System/flight.txt");
							for (int i = 0; i < tempFlightDetails.size(); i++) {
								String[] details3 = new String[10];
								details3 = tempFlightDetails.get(i).split(";");
								if (searchEditFlight.equalsIgnoreCase(details3[0])) {
									editFlightWriter.write((flightID - 1) + ";" + planeIDChoice + ";" + from + ";" + to
											+ ";" + flightDate + ";" + departTime + ";" + arrivalTime + ";"
											+ classificationChoice + ";" + categoryChoice + ";" + "1\n");
								} else {
									editFlightWriter.write(tempFlightDetails.get(i) + "\n");
								}
							}
							System.out.println("Flight Edited successfully.");
							editFlightWriter.close();
						} else {
							System.out.println("Nothing matches your Flight ID Entered.");
						}
						break;
					case 8:
						File editBookingFile = new File("C:/java programs/Plane Booking System/booking.txt");
						Scanner editBookingScanner = new Scanner(editBookingFile);
						System.out.println("Edit Booking Details.");
						ArrayList<String> tempEditBookDetails = new ArrayList<String>();
						while (editBookingScanner.hasNextLine()) {
							String data = editBookingScanner.nextLine();
							tempEditBookDetails.add(data);
						}
						found = false;
						sc = new Scanner(System.in);
						System.out.print("Enter Booking ID to edit Details: ");
						String searchEditBooking = sc.nextLine();
						if (searchEditBooking.equalsIgnoreCase("cancel")) {
							System.out.println("Cancelled");
							cancel = true;
							break;
						}
						editBookingScanner = new Scanner(editBookingFile);
						while (editBookingScanner.hasNextLine()) {
							String[] details = new String[9];
							String data = editBookingScanner.nextLine();
							details = data.split(";");
							if (searchEditBooking.equalsIgnoreCase(details[0])) {
								found = true;
								System.out.println("Book ID: " + details[0]);
								System.out.println("Flight ID: " + details[1]);
								System.out.println("Full Name: " + details[2]);
								System.out.println("Mode of Payment: " + details[3]);
								System.out.println("Email Address: " + details[4]);
								System.out.println("Booking Date: " + details[5]);
								System.out.println("Number of Travelers: " + details[6]);
								System.out.println("Amount: " + details[7]);
								System.out.println("Booking Status: " + details[8]);
								System.out.println();
							}
						}
						if (found) {
							bookingID = 1;
							bookingFlightID = 1;
							tempPayment = 0;
							numberOfTravelers = 0;
							amount = -1;
							fullName = "";
							payment = "";
							email = "";
							statusChoice = "";
							isValid = false;
							editBookingScanner = new Scanner(editBookingFile);
							while (editBookingScanner.hasNextLine()) {
								String[] details = new String[9];
								details = editBookingScanner.nextLine().split(";");
								bookingID++;
								bookingFlightID++;
							}
							do {
								sc = new Scanner(System.in);
								System.out.print("Enter new applicant's full name: ");
								fullName = sc.nextLine();
								if (fullName.equalsIgnoreCase("cancel")) {
									System.out.println("Cancelled");
									cancel = true;
									break;
								}
								if (containsSpecialCharacters(fullName)) {
									System.out.println(
											"Invalid Name! Please do not Inlcude Special Characters / Numbers.");
								}
							} while (containsSpecialCharacters(fullName));
							if (cancel) {
								break;
							}
							String[] paymentMethod2 = { "Credit Card", "Debit Card", "Cash", "Paper Check",
									"Digital Payment" };
							System.out.println("----Mode of Payments----");
							System.out.println("1. Credit Card\n" + "2. Debit Card\n" + "3. Cash\n" + "4. Paper Check\n"
									+ "5. Digital Payment.");
							do {
								sc = new Scanner(System.in);
								System.out.print("Please Select new Mode of Payment: ");
								String input = sc.nextLine().trim();
								if (input.equalsIgnoreCase("cancel")) {
									System.out.println("Cancelled");
									cancel = true;
									break;
								}
								if (input.matches("[1-5]")) {
									tempPayment = Integer.parseInt(input);
									for (int i = 0; i < paymentMethod2.length; i++) {
										if (tempPayment == (i + 1)) {
											payment = paymentMethod2[i];
										}
									}
									break;
								}
								System.out.println("Invalid Input! Please try again.");
							} while (true);
							if (cancel) {
								break;
							}
							while (!isValid) {
								sc = new Scanner(System.in);
								System.out.print("Enter a new email address: ");
								email = sc.nextLine();
								if (email.equalsIgnoreCase("cancel")) {
									System.out.println("Cancelled");
									cancel = true;
									break;
								}
								isValid = isValidEmail(email);
								if (!isValid) {
									System.out.println("Invalid email address. Please try again.");
								}
							}
							if (cancel) {
								break;
							}
							do {
								sc = new Scanner(System.in);
								try {
									System.out.print("Enter new head count of travelers (maximum of 10): ");
									String input = sc.nextLine().trim();
									if (input.equalsIgnoreCase("cancel")) {
										System.out.println("Cancelled");
										cancel = true;
										break;
									}
									numberOfTravelers = Integer.parseInt(input);
								} catch (Exception e) {
								}
								if (numberOfTravelers < 1 || numberOfTravelers > 10) {

									System.out.println("Invalid Input! Please choose from 1 to 10 only.");
								}
							} while (numberOfTravelers < 1 || numberOfTravelers > 10);
							if (cancel) {
								break;
							}
							do {
								sc = new Scanner(System.in);
								try {
									System.out.print("Enter new amount: ");
									String input = sc.nextLine().trim();
									if (input.equalsIgnoreCase("cancel")) {
										System.out.println("Cancelled");
										cancel = true;
										break;
									}
									amount = Double.parseDouble(input);
								} catch (Exception e) {
								}
								if (amount <= 0) {
									System.out.println("Invalid Input! Please do not include special characters.");
								}
							} while (amount <= 0);
							FileWriter editBookingWriter = new FileWriter(
									"C:/java programs/Plane Booking System/booking.txt");
							for (int i = 0; i < tempEditBookDetails.size(); i++) {
								String[] details1 = new String[9];
								details1 = tempEditBookDetails.get(i).split(";");
								if (searchEditBooking.equalsIgnoreCase(details1[0])) {
									editBookingWriter.write((bookingID - 1) + ";" + (bookingFlightID - 1) + ";"
											+ fullName + ";" + payment + ";" + email + ";" + date + ";"
											+ numberOfTravelers + ";" + amount + ";" + "2\n");
								} else {
									editBookingWriter.write(tempEditBookDetails.get(i) + "\n");
								}
							}
							editBookingWriter.close();
							System.out.println("Booking Edited successfully.");
						} else {
							System.out.println("Nothing Matches your Booking ID Entered.");
						}
						break;
					case 9:
						File flightFile = new File("C:/java programs/Plane Booking System/flight.txt");
						Scanner flightScanner = new Scanner(flightFile);
						System.out.println("Edit Flight Status.");
						ArrayList<String> tempStatusFlightDetails = new ArrayList<String>();
						while (flightScanner.hasNextLine()) {
							tempStatusFlightDetails.add(flightScanner.nextLine());
						}
						found = false;
						sc = new Scanner(System.in);
						System.out.print("Enter Flight ID to edit Status: ");
						String searchUpdateFlight = sc.nextLine();
						if (searchUpdateFlight.equalsIgnoreCase("cancel")) {
							System.out.println("Cancelled");
							cancel = true;
							break;
						}
						flightScanner = new Scanner(flightFile);
						while (flightScanner.hasNextLine()) {
							String[] details2 = new String[10];
							String data = flightScanner.nextLine();
							details2 = data.split(";");
							if (searchUpdateFlight.equalsIgnoreCase(details2[0])) {
								found = true;
								System.out.println("Flight ID: " + details2[0]);
								System.out.println("Plane ID: " + details2[1]);
								System.out.println("From: " + details2[2]);
								System.out.println("To: " + details2[3]);
								System.out.println("Date of Flight: " + details2[4]);
								System.out.println("Depart Time: " + details2[5]);
								System.out.println("Arrival Time: " + details2[6]);
								System.out.println("Classification: " + details2[7]);
								System.out.println("Category: " + details2[8]);
								String stat = "Done";
								if (details2[9].equals("1")) {
									stat = "Active";
								}
								System.out.println("Flight Status: " + stat);
								System.out.println();
							}
						}
						int sta = 0;
						if (found) {
							FileWriter flightWriter2 = new FileWriter(
									"C:/java programs/Plane Booking System/flight.txt");
							System.out.print("------Status------\n");
							System.out.println("1. Active\n2. Done.\n");
							do {
								sc = new Scanner(System.in);
								System.out.print("Enter new status ex(1): ");
								String input = sc.nextLine().trim();
								if (input.equalsIgnoreCase("cancel")) {
									System.out.println("Cancelled");
									cancel = true;
									break;
								}
								if (input.matches("[1-2]")) {
									sta = Integer.parseInt(input);
									break;
								}
								System.out.println("Invalid Input! Please choose 1 or 2 only.");
							} while (true);
							if (cancel) {
								break;
							}
							for (int i = 0; i < tempStatusFlightDetails.size(); i++) {
								String[] details = new String[10];
								details = tempStatusFlightDetails.get(i).split(";");
								if (searchUpdateFlight.equalsIgnoreCase(details[0])) {
									flightWriter2.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
											+ details[3] + ";" + details[4] + ";" + details[5] + ";" + details[6] + ";"
											+ details[7] + ";" + details[8] + ";" + sta + ";\n");
								} else {
									flightWriter2.write(tempStatusFlightDetails.get(i) + "\n");
								}
							}
							flightWriter2.close();
							System.out.println("Flight Status Updated Successfully.");
						} else {
							System.out.println("Noting Matches your Flight ID entered.");
						}
						break;
					case 10:
						File bookingFile = new File("C:/java programs/Plane Booking System/booking.txt");
						Scanner bookingScanner = new Scanner(bookingFile);
						System.out.println("Edit Booking Status.");
						ArrayList<String> tempBookingStatusDetails = new ArrayList<String>();
						while (bookingScanner.hasNextLine()) {
							tempBookingStatusDetails.add(bookingScanner.nextLine());
						}
						found = false;
						sc = new Scanner(System.in);
						System.out.print("Enter Book ID to edit Status: ");
						String searchStatusBooking = sc.nextLine();
						if (searchStatusBooking.equalsIgnoreCase("cancel")) {
							System.out.println("Cancelled");
							cancel = true;
							break;
						}
						bookingScanner = new Scanner(bookingFile);
						while (bookingScanner.hasNextLine()) {
							String[] details = new String[9];
							String data = bookingScanner.nextLine();
							details = data.split(";");
							if (searchStatusBooking.equalsIgnoreCase(details[0])) {
								System.out.println("Search Result for " + searchStatusBooking + ": ");
								found = true;
								System.out.println("Book ID: " + details[0]);
								System.out.println("Flight ID: " + details[1]);
								System.out.println("Full Name: " + details[2]);
								System.out.println("Mode of Payment: " + details[3]);
								System.out.println("Email Address: " + details[4]);
								System.out.println("Booking Date: " + details[5]);
								System.out.println("Number of Travelers: " + details[6]);
								System.out.println("Amount: " + details[7]);
								System.out.println("Booking Status: " + details[8]);
								System.out.println();
							}
						}
						if (found) {
							int tempStatus2 = 0;
							String statusChoice2 = "";
							String[] status2 = { "Paid", "Unpaid", "Cancelled" };
							System.out.println("------Status------");
							System.out.println("1. Paid\n2. Unpaid\n3. Cancelled");
							do {
								sc = new Scanner(System.in);
								System.out.print("Please Choose New Status: ");
								String input = sc.nextLine().trim();
								if (input.equalsIgnoreCase("cancel")) {
									System.out.println("Cancelled");
									cancel = true;
									break;
								}
								if (input.matches("[1-3]")) {
									tempStatus2 = Integer.parseInt(input);
									break;
								}
								System.out.println("Invalid Input! Please from 1 to 3 only.");
							} while (true);
							if (cancel) {
								break;
							}
							FileWriter bookingWriter2 = new FileWriter(
									"C:/java programs/Plane Booking System/booking.txt");
							for (int i = 0; i < tempBookingStatusDetails.size(); i++) {
								String[] details = new String[9];
								details = tempBookingStatusDetails.get(i).split(";");
								if (searchStatusBooking.equalsIgnoreCase(details[0])) {
									bookingWriter2.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
											+ details[3] + ";" + details[4] + ";" + details[5] + ";" + details[6] + ";"
											+ details[7] + ";" + tempStatus2 + "\n");
								} else {
									bookingWriter2.write(tempBookingStatusDetails.get(i) + "\n");
								}
							}
							bookingWriter2.close();
							System.out.println("Booking Status Edited successfully.");
						} else {
							System.out.println("Noting Matches your Booking ID entered.");
						}
						break;
					case 11:
						System.out.println("Logging out...");
						Thread.sleep(3000);
						System.out.println("Successfully Logged out.\n");
						loginSuccessful = false;
						break;
					default:
						break;
					}
				}
			} while (true);
		} catch (Exception e) {
			System.out.println("An Error Occured\n" + e);
		}
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
