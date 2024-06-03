import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;

public class Beach_Booking2 {
	public static void main(String[] manch) {
		try {
			do {
				Scanner Manching = new Scanner(System.in);
				boolean logInSuccess = false, found = false;
				LocalDate localDate = LocalDate.now();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				dateFormat.setLenient(false);
				int mainMenuChoice = 0, choice = 0;
				String username = "", password = "";
				if (!logInSuccess) {
					try {
						Manching = new Scanner(System.in);
						System.out.println("---WELCOME TO GAME-J BEACH RESORT---");
						System.out.println("1 = Log in");
						System.out.println("2 = Sign up");
						System.out.println("3 = Exit");
						System.out.print("Enter Choice: ");
						mainMenuChoice = Manching.nextInt();
					} catch (Exception e) {
						System.out.println("Please choose numbers only.");
					}
				}
				if (!logInSuccess) {
					switch (mainMenuChoice) {
					case 1:
						File logInFile = new File("C:/CreateFile/login.txt");
						Scanner logInFileScanner = new Scanner(logInFile);
						Manching = new Scanner(System.in);
						System.out.println("|-------Login Form-----|");
						System.out.print("  Username: ");
						username = Manching.nextLine();
						System.out.print("  Password: ");
						password = Manching.nextLine();
						System.out.println("|______________________|");
						System.out.println();
						while (logInFileScanner.hasNextLine()) {
							String[] details = new String[4];
							String data = logInFileScanner.nextLine();
							details = data.split(";");
							if (username.equals(details[1]) && password.equals(details[2])) {
								logInSuccess = true;
								System.out.println("Logged-in Successfully.\n");
								break;
							}
						}
						if (!logInSuccess) {
							System.out.println("Invalid Username or password.");
						}
						break;
					case 2:
						FileWriter signUpFileWriter = new FileWriter("C:/CreateFile/login.txt", true);
						File signUpFile = new File("C:/CreateFile/login.txt");
						Scanner signUpFileScanner = new Scanner(signUpFile);
						int signUpID = 1;
						Boolean userNameFound = true;
						ArrayList<String> allUserNames = new ArrayList<>();
						while (signUpFileScanner.hasNextLine()) {
							String[] signUpDetails = new String[4];
							String data = signUpFileScanner.nextLine();
							signUpDetails = data.split(";");
							allUserNames.add(signUpDetails[1]);
							signUpID++;
						}
						Manching = new Scanner(System.in);
						System.out.println("|-------Sign Up Form-----|");
						do {
							userNameFound = false;
							System.out.print("Username: ");
							username = Manching.nextLine();
							for (int i = 0; i < allUserNames.size(); i++) {
								if (username.equalsIgnoreCase(allUserNames.get(i))) {
									userNameFound = true;
								}
							}
							if (userNameFound) {
								System.out.println("Username already existing. Please choose another username.");
							}
						} while (userNameFound);
						System.out.print("Password: ");
						password = Manching.nextLine();
						System.out.println("|______________________|");
						System.out.println("Signed up Successfully.\n");
						signUpFileWriter.write(signUpID + ";" + username + ";" + password + ";" + "1\n");
						signUpFileWriter.close();
						break;
					case 3:
						System.out.println("Exit...");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid choice! Please try again.");
						break;
					}
				}
				if (logInSuccess) {
					System.out.println("-------MENU-------");
					System.out.println("1 = Add Rooms");
					System.out.println("2 = Edit Rooms");
					System.out.println("3 = Search Rooms");
					System.out.println("4 = Update Rooms Status");
					System.out.println("5 = Add Cottages with tables and Chairs");
					System.out.println("6 = Edit Cottages with tables and Chairs");
					System.out.println("7 = Search Cottages with tables and Chairs");
					System.out.println("8 = Update Cottages with tables and Chairs");
					System.out.println("9 = Add Function Hall");
					System.out.println("10 = Edit Function Hall");
					System.out.println("11 = Search Function Hall");
					System.out.println("12 = Update Function Hall");
					System.out.println("13 = Add Pool");
					System.out.println("14 = Edit Pool");
					System.out.println("15 = Search Pool");
					System.out.println("16 = Update Pool");
					System.out.println("17 = Add Reservation");
					System.out.println("18 = Edit Reservations");
					System.out.println("19 = Search Reservations");
					System.out.println("20 = Update Reservation Status");
					System.out.println("21 = Log out");
					do {
						Manching = new Scanner(System.in);
						try {
							System.out.print("Enter choice: ");
							choice = Manching.nextInt();
						} catch (Exception e) {
						}
						if (choice <= 0 || choice > 21) {
							System.out.println("Invalid choice! Please choose from 1 to 21 only.");
						}
					} while (choice <= 0 || choice > 21);
					switch (choice) {
					case 1:
						FileWriter roomWriter = new FileWriter("C:/CreateFile/rooms.txt", true);
						File addRoomFile = new File("C:/CreateFile/rooms.txt");
						Scanner addRoomFileScanner = new Scanner(addRoomFile);
						int room = 1, size = 0;
						double rprice = 0.0;
						while (addRoomFileScanner.hasNextLine()) {
							String[] details = new String[4];
							String data = addRoomFileScanner.nextLine();
							room++;
						}
						System.out.println("------Add Rooms------");
						do {
							Manching = new Scanner(System.in);
							System.out.println("---Room Size---\n1 = Standard\n2 = Family size");
							System.out.print("Choose room size: ");
							String input = Manching.nextLine().trim();
							if (input.matches("[1-2]")) {
								size = Integer.parseInt(input);
								if (size <= 0 || size > 2) {
									System.out.println("Invalid Number! Please try again");
								}
							} else {
								System.out.println("Invalid Input!");
							}
						} while (size <= 0 || size > 2);
						do {
							Manching = new Scanner(System.in);
							try {
								if (size == 1) {
									System.out.print("Enter Standard room price: ");
									rprice = Manching.nextDouble();
								} else {
									System.out.print("Enter Family room price: ");
									rprice = Manching.nextDouble();
								}
							} catch (Exception e) {
							}
							if (rprice <= 0) {
								System.out.println("Invalid Input!");
							}
						} while (rprice <= 0);
						roomWriter.write(room + ";" + size + ";" + rprice + ";" + "1\n");
						roomWriter.close();
						System.out.println("Room Successfully added.");
						break;
					case 2:
						File editRoomFile = new File("C:/CreateFile/rooms.txt");
						Scanner roomFileScanner = new Scanner(editRoomFile);
						room = 1;
						size = 0;
						rprice = 0.0;
						System.out.println("------Edit Rooms------");
						found = false;
						ArrayList<String> tempRoomDetails = new ArrayList<String>();
						while (roomFileScanner.hasNextLine()) {
							tempRoomDetails.add(roomFileScanner.nextLine());
						}
						Manching = new Scanner(System.in);
						System.out.print("Enter Room Number to Edit Details: ");
						String roomEditSearch = Manching.nextLine();
						roomFileScanner = new Scanner(editRoomFile);
						while (roomFileScanner.hasNextLine()) {
							String[] details = new String[4];
							details = roomFileScanner.nextLine().split(";");
							if (roomEditSearch.equalsIgnoreCase(details[0])) {
								found = true;
								System.out.println("Room Number: " + details[0]);
								System.out.println("Room Size: " + details[1]);
								System.out.println("Price: " + details[2]);
								System.out.println("Status: " + details[3]);
								System.out.println();
							}
						}
						if (found) {
							do {
								Manching = new Scanner(System.in);
								System.out.println("---Room Size---\n1 = Standard\n2 = Family size");
								System.out.print("Choose new room size: ");
								String input = Manching.nextLine().trim();
								if (input.matches("[1-2]")) {
									size = Integer.parseInt(input);
									if (size <= 0 || size > 2) {
										System.out.println("Invalid Number! Please try again");
									}
								} else {
									System.out.println("Invalid Input!");
								}
							} while (size <= 0 || size > 2);
							do {
								Manching = new Scanner(System.in);
								try {
									if (size == 1) {
										System.out.print("Enter new Standard room price: ");
										rprice = Manching.nextDouble();
									} else {
										System.out.print("Enter new Family room price: ");
										rprice = Manching.nextDouble();
									}
								} catch (Exception e) {
								}
								if (rprice <= 0) {
									System.out.println("Invalid Input!");
								}
							} while (rprice <= 0);
							FileWriter roomWriter2 = new FileWriter("C:/CreateFile/rooms.txt");
							for (int i = 0; i < tempRoomDetails.size(); i++) {
								String[] details = new String[4];
								details = tempRoomDetails.get(i).split(";");
								if (roomEditSearch.equalsIgnoreCase(details[0])) {
									roomWriter2.write(details[0] + ";" + size + ";" + rprice + ";" + "1\n");
								} else {
									roomWriter2.write(tempRoomDetails.get(i) + "\n");
								}
							}
							roomWriter2.close();
							System.out.println("Room Edited Successfully.");
						} else {
							System.out.println("Incorrect room number entered.");
						}
						break;
					case 3:
						File searchRoomFile = new File("C:/CreateFile/rooms.txt");
						Scanner searchRoomFileScanner = new Scanner(searchRoomFile);
						System.out.println("-----Search rooms-----\n");
						found = false;
						Manching = new Scanner(System.in);
						System.out.print("Enter keyword to search: ");
						String rsearch = Manching.nextLine();
						System.out.println("Search results for " + rsearch + ":");
						System.out.println("|\tRoom Number\t|\tRoom type\t|\tRoom Price\t|\tStatus\t|");
						System.out.println(
								"----------------------------------------------------------------------------------------------");
						while (searchRoomFileScanner.hasNextLine()) {
							String[] details = new String[4];
							String content = searchRoomFileScanner.nextLine();
							details = content.split(";");
							if (content.matches("(.*)" + rsearch + "(.*)")) {
								System.out.println("|\t" + details[0] + "\t\t|\t" + details[1] + "\t\t|\t" + details[2]
										+ "\t\t|\t" + details[3] + "\t|");
							}
						}
						break;
					case 4:
						File editRoomStatusFile = new File("C:/CreateFile/rooms.txt");
						Scanner editRoomStatusFileScanner = new Scanner(editRoomStatusFile);
						System.out.println("-----Edit Room Status-----");
						ArrayList<String> tempRoomStatusDetails = new ArrayList<String>();
						while (editRoomStatusFileScanner.hasNextLine()) {
							tempRoomStatusDetails.add(editRoomStatusFileScanner.nextLine());
						}
						Manching = new Scanner(System.in);
						found = false;
						System.out.print("Enter Room number to edit Status: ");
						String searchEditStatusroom = Manching.nextLine();
						editRoomStatusFileScanner = new Scanner(editRoomStatusFile);
						while (editRoomStatusFileScanner.hasNextLine()) {
							String[] details = new String[4];
							String data = editRoomStatusFileScanner.nextLine();
							details = data.split(";");
							if (searchEditStatusroom.equalsIgnoreCase(details[0])) {
								System.out.println("Search Result for " + searchEditStatusroom + ": ");
								found = true;
								System.out.println("Room Number: " + details[0]);
								System.out.println("Room Type: " + details[1]);
								System.out.println("Price: " + details[2]);
								System.out.println("Status: " + details[3]);
								System.out.println();
							}
						}
						if (found) {
							int Status = 0;
							System.out.println("------Status------");
							System.out.println("1 = Active\n2 = Inactive\n3 = Occupied");
							do {
								System.out.print("Please Choose New Status: ");
								String input = Manching.nextLine().trim();
								if (input.matches("[1-3]")) {
									Status = Integer.parseInt(input);
								}
								if (Status <= 0 || Status > 2) {
									System.out.println("Invalid Input!");
								}
							} while (Status <= 0 || Status > 2);
							FileWriter roomWriter2 = new FileWriter("C:/CreateFile/rooms.txt");
							for (int i = 0; i < tempRoomStatusDetails.size(); i++) {
								String[] details1 = new String[4];
								details1 = tempRoomStatusDetails.get(i).split(";");
								if (searchEditStatusroom.equalsIgnoreCase(details1[0])) {
									roomWriter2.write(
											details1[0] + ";" + details1[1] + ";" + details1[2] + ";" + +Status + "\n");
								} else {
									roomWriter2.write(tempRoomStatusDetails.get(i) + "\n");
								}
							}
							roomWriter2.close();
							System.out.println("Status Edited successfully.");
						} else {
							System.out.println("Noting Matches your Number entered.");
						}
						break;
					case 5:
						FileWriter cottageWriter = new FileWriter("C:/CreateFile/cottage.txt", true);
						File cottageFile = new File("C:/CreateFile/cottage.txt");
						Scanner cottageFileScanner = new Scanner(cottageFile);
						int cottageNumber = 1, type = 0;
						double cprice = 0.0;
						while (cottageFileScanner.hasNextLine()) {
							String[] details = new String[4];
							String data = cottageFileScanner.nextLine();
							cottageNumber++;
						}
						System.out.println("---Add Cottage with tables and chairs---");
						do {
							Manching = new Scanner(System.in);
							System.out.println("---Types of Cottage---\n1 = Kubo\n2 = Umbrella");
							System.out.print("Choose cottage type: ");
							String input = Manching.nextLine().trim();
							if (input.matches("[1-2]")) {
								type = Integer.parseInt(input);
								break;
							}
							System.out.println("Invalid Input!");
						} while (true);
						do {
							Manching = new Scanner(System.in);
							try {
								if (type == 1) {
									System.out.print("Enter Kubo Cottage price: ");
									cprice = Manching.nextDouble();
								} else {
									System.out.print("Enter Umbrella Cottage price: ");
									cprice = Manching.nextDouble();
								}
							} catch (Exception e) {
							}
							if (cprice <= 0) {
								System.out.println("Invalid Input!");
							}
						} while (cprice <= 0);
						cottageWriter.write(cottageNumber + ";" + type + ";" + cprice + ";" + "1\n");
						cottageWriter.close();
						System.out.println("Cottage Successfully added.");
						break;
					case 6:
						File editCottageFile = new File("C:/CreateFile/cottage.txt");
						Scanner editCottageFileScanner = new Scanner(editCottageFile);
						cottageNumber = 1;
						type = 0;
						cprice = 0.0;
						System.out.println("---Edit Cottages with tables and Chairs---");
						found = false;
						ArrayList<String> tempCottageDetails = new ArrayList<String>();
						while (editCottageFileScanner.hasNextLine()) {
							tempCottageDetails.add(editCottageFileScanner.nextLine());
						}
						Manching = new Scanner(System.in);
						System.out.print("Enter Cottage Number to Edit Details: ");
						String cottageEditSearch = Manching.nextLine();
						editCottageFileScanner = new Scanner(editCottageFile);
						while (editCottageFileScanner.hasNextLine()) {
							String[] details = new String[4];
							details = editCottageFileScanner.nextLine().split(";");
							if (cottageEditSearch.equalsIgnoreCase(details[0])) {
								found = true;
								System.out.println("Cottage Number: " + details[0]);
								System.out.println("Cottage Size: " + details[1]);
								System.out.println("Price: " + details[2]);
								System.out.println("Status: " + details[3]);
								System.out.println();
							}
						}
						if (found) {
							do {
								Manching = new Scanner(System.in);
								System.out.println("---Types of Cottage---\n1 = Kubo\n2 = Umbrella");
								System.out.print("Choose new cottage type: ");
								String input = Manching.nextLine().trim();
								if (input.matches("[1-2]")) {
									type = Integer.parseInt(input);
									break;
								}
								System.out.println("Invalid Input!");
							} while (true);
							do {
								Manching = new Scanner(System.in);
								try {
									if (type == 1) {
										System.out.print("Enter new Kubo Cottage price: ");
										cprice = Manching.nextDouble();
									} else {
										System.out.print("Enter new Umbrella Cottage price: ");
										cprice = Manching.nextDouble();
									}
								} catch (Exception e) {
								}
								if (cprice <= 0) {
									System.out.println("Invalid Input!");
								}
							} while (cprice <= 0);
							FileWriter cottageWriter2 = new FileWriter("C:/CreateFile/cottage.txt");
							for (int i = 0; i < tempCottageDetails.size(); i++) {
								String[] details = new String[4];
								details = tempCottageDetails.get(i).split(";");
								if (cottageEditSearch.equalsIgnoreCase(details[0])) {
									cottageWriter2.write(details[0] + ";" + type + ";" + cprice + ";" + "1\n");
								} else {
									cottageWriter2.write(tempCottageDetails.get(i) + "\n");
								}
							}
							cottageWriter2.close();
							System.out.println("Cottage Edited Successfully.");
						} else {
							System.out.println("Incorrect Cottage Number.");
						}
						break;
					case 7:
						File searchCottageFile = new File("C:/CreateFile/cottage.txt");
						Scanner searchCottageFileScanner = new Scanner(searchCottageFile);
						System.out.println("-----Search Cottage-----\n");
						found = false;
						Manching = new Scanner(System.in);
						System.out.print("Enter Cottage number to search: ");
						String csearch = Manching.nextLine();
						System.out.println("Search results for " + csearch + ":");
						System.out.println("|\tCottage Number\t|\tCottage type\t|\tCottage Price\t|\tStatus\t|");
						System.out.println(
								"----------------------------------------------------------------------------------------------");
						while (searchCottageFileScanner.hasNextLine()) {
							String[] details = new String[4];
							String data = searchCottageFileScanner.nextLine();
							details = data.split(";");
							if (data.matches("(.*)" + csearch + "(.*)")) {
								System.out.println("|\t" + details[0] + "\t\t|\t" + details[1] + "\t\t|\t" + details[2]
										+ "\t\t|\t" + details[3] + "\t|");
							}
						}
						break;
					case 8:
						File editStatusCottageFile = new File("C:/CreateFile/cottage.txt");
						Scanner editStatusCottageFileScanner = new Scanner(editStatusCottageFile);
						System.out.println("-----Edit Cottage Status-----");
						ArrayList<String> tempCottageStatusDetails = new ArrayList<String>();
						while (editStatusCottageFileScanner.hasNextLine()) {
							tempCottageStatusDetails.add(editStatusCottageFileScanner.nextLine());
						}
						Manching = new Scanner(System.in);
						found = false;
						System.out.print("Enter Cottage number to edit Status: ");
						String searchEditStatusCottage = Manching.nextLine();
						editStatusCottageFileScanner = new Scanner(editStatusCottageFile);
						while (editStatusCottageFileScanner.hasNextLine()) {
							String[] details = new String[4];
							String data = editStatusCottageFileScanner.nextLine();
							details = data.split(";");
							if (searchEditStatusCottage.equalsIgnoreCase(details[0])) {
								System.out.println("Search Result for " + searchEditStatusCottage + ": ");
								found = true;
								System.out.println("Cottage Number: " + details[0]);
								System.out.println("Cottage Type: " + details[1]);
								System.out.println("Price: " + details[2]);
								System.out.println("Status: " + details[3]);
								System.out.println();
							}
						}
						if (found) {
							int Status = 0;
							System.out.println("------Status------");
							System.out.println("1 = Active\n2 = Inactive\n3 = Occupied");
							do {
								Manching = new Scanner(System.in);
								System.out.print("Please Choose New Status: ");
								String input = Manching.nextLine();
								if (input.matches("[1-3]")) {
									Status = Integer.parseInt(input);
									break;
								}
								System.out.println("Invalid Input!");
							} while (true);
							FileWriter cottageWriter2 = new FileWriter("C:/CreateFile/cottage.txt");
							for (int i = 0; i < tempCottageStatusDetails.size(); i++) {
								String[] details1 = new String[4];
								details1 = tempCottageStatusDetails.get(i).split(";");
								if (searchEditStatusCottage.equalsIgnoreCase(details1[0])) {
									cottageWriter2.write(
											details1[0] + ";" + details1[1] + ";" + details1[2] + ";" + Status + "\n");
								} else {
									cottageWriter2.write(tempCottageStatusDetails.get(i) + "\n");
								}
							}
							cottageWriter2.close();
							System.out.println("Status Edited successfully.");
						} else {
							System.out.println("Noting Matches your Number entered.");
						}
						break;
					case 9:
						FileWriter functionWriter = new FileWriter("C:/CreateFile/function.txt", true);
						File addFunctionFile = new File("C:/CreateFile/function.txt");
						Scanner addFunctionFileScanner = new Scanner(addFunctionFile);
						System.out.println("---Add Function Hall---");
						int functionHallNumber = 1, functionHallType = 0;
						double functionHallPrice = 0.0;
						String fhallName = "";
						ArrayList<String> allFunctionHallNames = new ArrayList<>();
						while (addFunctionFileScanner.hasNextLine()) {
							String[] details = new String[5];
							String data = addFunctionFileScanner.nextLine();
							details = data.split(";");
							functionHallNumber++;
							allFunctionHallNames.add(details[1]);
						}
						do {
							found = false;
							System.out.print("Enter function hall Name: ");
							fhallName = Manching.nextLine();
							for (int i = 0; i < allFunctionHallNames.size(); i++) {
								if (allFunctionHallNames.get(i).equalsIgnoreCase(fhallName)) {
									found = true;
								}
							}
						} while (found);
						do {
							Manching = new Scanner(System.in);
							System.out.println("---Function Hall Type---\n1 = Airconditioned\n2 = Open Funtion Hall");
							System.out.print("Enter Function Hall type: ");
							String input = Manching.nextLine().trim();
							if (input.matches("[1-2]")) {
								functionHallType = Integer.parseInt(input);
								break;
							}
							System.out.println("Invalid Input!");
						} while (true);
						do {
							Manching = new Scanner(System.in);
							try {
								System.out.print("Enter Function Hall Price: ");
								functionHallPrice = Manching.nextDouble();
							} catch (Exception e) {
							}
							if (functionHallPrice <= 0) {
								System.out.println("Invalid Input!");
							}
						} while (functionHallPrice <= 0);
						functionWriter.write(functionHallNumber + ";" + fhallName + ";" + functionHallType + ";"
								+ functionHallPrice + ";" + "1\n");
						functionWriter.close();
						System.out.println("Successfully added function Hall.");
						break;
					case 10:
						File editFunctionFile = new File("C:/CreateFile/function.txt");
						Scanner FunctionEdit = new Scanner(editFunctionFile);
						functionHallNumber = 1;
						functionHallType = 0;
						functionHallPrice = 0.0;
						System.out.println("------Edit Function Halls------");
						found = false;
						ArrayList<String> tempFuctionHallDetails = new ArrayList<String>();
						ArrayList<String> allfuncnames = new ArrayList<String>();
						while (FunctionEdit.hasNextLine()) {
							String[] details = new String[5];
							String data = FunctionEdit.nextLine();
							details = data.split(";");
							tempFuctionHallDetails.add(data);
							allfuncnames.add(details[1]);
						}
						roomEditSearch = "";
						fhallName = "";
						Manching = new Scanner(System.in);
						System.out.print("Enter Function Hall Number to Edit Details: ");
						roomEditSearch = Manching.nextLine();
						FunctionEdit = new Scanner(editFunctionFile);
						while (FunctionEdit.hasNextLine()) {
							String[] details = new String[4];
							details = FunctionEdit.nextLine().split(";");
							if (roomEditSearch.equalsIgnoreCase(details[0])) {
								found = true;
								System.out.println("Function Hall Number: " + details[0]);
								System.out.println("Function Hall Name: " + details[1]);
								System.out.println("Function Hall Type: " + details[2]);
								System.out.println("Price: " + details[3]);
								System.out.println("Status: " + details[4]);
								System.out.println();
							}
						}
						if (found) {
							do {
								found = false;
								System.out.print("Enter function hall Name: ");
								fhallName = Manching.nextLine();
								for (int i = 0; i < allfuncnames.size(); i++) {
									if (allfuncnames.get(i).equalsIgnoreCase(fhallName)) {
										found = true;
									}
								}
							} while (found);
							do {
								Manching = new Scanner(System.in);
								System.out
										.println("---Function Hall Type---\n1 = Airconditioned\n2 = Open Funtion Hall");
								System.out.print("Enter new Function Hall type: ");
								String input = Manching.nextLine().trim();
								if (input.matches("[1-2]")) {
									functionHallType = Integer.parseInt(input);
									break;
								}
								System.out.println("Invalid Input!");
							} while (true);
							do {
								Manching = new Scanner(System.in);
								try {
									System.out.print("Enter new Function Hall Price: ");
									functionHallPrice = Manching.nextDouble();
								} catch (Exception e) {
								}
								if (functionHallPrice <= 0) {
									System.out.println("Invalid Input!");
								}
							} while (functionHallPrice <= 0);
							FileWriter funcWriter2 = new FileWriter("C:/CreateFile/function.txt");
							for (int i = 0; i < tempFuctionHallDetails.size(); i++) {
								String[] details = new String[5];
								details = tempFuctionHallDetails.get(i).split(";");
								if (roomEditSearch.equalsIgnoreCase(details[0])) {
									funcWriter2.write(details[0] + ";" + fhallName + ";" + functionHallType + ";"
											+ functionHallPrice + ";" + "1\n");
								} else {
									funcWriter2.write(tempFuctionHallDetails.get(i) + "\n");
								}
							}
							funcWriter2.close();
							System.out.println("Function Hall Edited Successfully.");
						} else {
							System.out.println("Incorrect room Number.");
						}
						break;
					case 11:
						File searchFunctionFile = new File("C:/CreateFile/function.txt");
						Scanner searchFunctionScanner = new Scanner(searchFunctionFile);
						System.out.println("-----Search Function Halls-----\n");
						found = false;
						Manching = new Scanner(System.in);
						System.out.print("Enter Function Hall number to search: ");
						String fsearch = Manching.nextLine();
						System.out.println("Search results for " + fsearch + ":");
						System.out.println(
								"|\tFunction Hall Number\t|\tFunction hall name\t|\tFunctiong Hall type\t|\tFunctiong Hall Price\t|\tStatus\t|");
						System.out.println(
								"-----------------------------------------------------------------------------------------------------------------------------------------------------");
						while (searchFunctionScanner.hasNextLine()) {
							String[] details = new String[5];
							String data = searchFunctionScanner.nextLine();
							details = data.split(";");
							if (data.matches("(.*)" + fsearch + "(.*)")) {
								System.out.println("|\t" + details[0] + "\t\t\t|\t" + details[1] + "\t\t\t|\t"
										+ details[2] + "\t\t\t|\t" + details[3] + "\t\t\t|\t" + details[4] + "\t|");
							}
						}
						break;
					case 12:
						File editStatusFunctionFile = new File("C:/CreateFile/function.txt");
						System.out.println("-----Edit Function Hall Status-----");
						Scanner functionStatusScanner = new Scanner(editStatusFunctionFile);
						ArrayList<String> tempFuncStatusDetails = new ArrayList<String>();
						while (functionStatusScanner.hasNextLine()) {
							tempFuncStatusDetails.add(functionStatusScanner.nextLine());
						}
						Manching = new Scanner(System.in);
						found = false;
						System.out.print("Enter Function Hall number to edit Status: ");
						String searchEditStatusFunction = Manching.nextLine();
						functionStatusScanner = new Scanner(editStatusFunctionFile);
						while (functionStatusScanner.hasNextLine()) {
							String[] details = new String[4];
							String data = functionStatusScanner.nextLine();
							details = data.split(";");
							if (searchEditStatusFunction.equalsIgnoreCase(details[0])) {
								found = true;
								System.out.println("Search Result for " + searchEditStatusFunction + ": ");
								System.out.println("Function Hall Number: " + details[0]);
								System.out.println("Function Hall Name: " + details[1]);
								System.out.println("Function Hall Type: " + details[2]);
								System.out.println("Price: " + details[3]);
								System.out.println("Status: " + details[4]);
								System.out.println();
							}
						}
						if (found) {
							int Status = 0;
							System.out.println("------Status------");
							System.out.println("1 = Active\n2 = Inactive\n3 = Occupied");
							do {
								Manching = new Scanner(System.in);
								System.out.print("Please Choose New Status: ");
								String input = Manching.nextLine().trim();
								if (input.matches("[1-3]")) {
									Status = Integer.parseInt(input);
									break;
								}
								System.out.println("Invalid Input!");
							} while (true);
							FileWriter cottageWriter2 = new FileWriter("C:/CreateFile/function.txt");
							for (int i = 0; i < tempFuncStatusDetails.size(); i++) {
								String[] details = new String[4];
								details = tempFuncStatusDetails.get(i).split(";");
								if (searchEditStatusFunction.equalsIgnoreCase(details[0])) {
									cottageWriter2.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
											+ details[3] + ";" + Status + "\n");
								} else {
									cottageWriter2.write(tempFuncStatusDetails.get(i) + "\n");
								}
							}
							cottageWriter2.close();
							System.out.println("Status Edited successfully.");
						} else {
							System.out.println("Noting Matches your Number entered.");
						}
						break;
					case 13:
						FileWriter addPoolFileWriter = new FileWriter("C:/CreateFile/pools.txt", true);
						File addPoolFile = new File("C:/CreateFile/pools.txt");
						Scanner addPoolFileScanner = new Scanner(addPoolFile);
						System.out.println("----Add Pool----");
						int poolNumber = 1, poolType = 0;
						double poolPrice = 0.0;
						while (addPoolFileScanner.hasNext()) {
							String[] details = new String[4];
							String data = addPoolFileScanner.nextLine();
							poolNumber++;
						}
						do {
							Manching = new Scanner(System.in);
							System.out.println("---Pool Type---\n1 = Infinity pool\n2 = Kiddie pool");
							System.out.print("Enter pool type: ");
							String input = Manching.nextLine().trim();
							if (input.matches("[1-2]")) {
								poolType = Integer.parseInt(input);
								break;
							}
							System.out.println("Invalid Input!");
						} while (true);
						do {
							Manching = new Scanner(System.in);
							try {
								System.out.print("Enter Pool Price: ");
								poolPrice = Manching.nextDouble();
							} catch (Exception e) {
							}
							if (poolPrice <= 0) {
								System.out.println("Invalid Input!");
							}
						} while (poolPrice <= 0);
						addPoolFileWriter.write(poolNumber + ";" + poolType + ";" + poolPrice + ";" + "1\n");
						addPoolFileWriter.close();
						System.out.println("Successfully added Pool.");
						break;
					case 14:
						File editPoolFile = new File("C:/CreateFile/pools.txt");
						Scanner editPoolFileScanner = new Scanner(editPoolFile);
						poolType = 0;
						poolPrice = 0.0;
						System.out.println("------Edit Pool------");
						found = false;
						ArrayList<String> tempPoolDetails = new ArrayList<String>();
						while (editPoolFileScanner.hasNextLine()) {
							tempPoolDetails.add(editPoolFileScanner.nextLine());
						}
						Manching = new Scanner(System.in);
						System.out.print("Enter Pool Number to Edit Details: ");
						String poolEditSearch = Manching.nextLine();
						editPoolFileScanner = new Scanner(editPoolFile);
						while (editPoolFileScanner.hasNextLine()) {
							String[] details = new String[4];
							details = editPoolFileScanner.nextLine().split(";");
							if (poolEditSearch.equalsIgnoreCase(details[0])) {
								found = true;
								System.out.println("Pool Number: " + details[0]);
								System.out.println("Pool Type: " + details[1]);
								System.out.println("Price: " + details[2]);
								System.out.println("Status: " + details[3]);
								System.out.println();
							}
						}
						if (found) {
							do {
								Manching = new Scanner(System.in);
								System.out.println("---Pool Type---\n1 = Infinity pool\n2 = Kiddie pool");
								System.out.print("Enter new pool type: ");
								String input = Manching.nextLine().trim();
								if (input.matches("[1-2]")) {
									poolType = Integer.parseInt(input);
									break;
								}
								System.out.println("Invalid Input!");
							} while (true);
							do {
								Manching = new Scanner(System.in);
								try {
									System.out.print("Enter new Pool Price: ");
									poolPrice = Manching.nextDouble();
								} catch (Exception e) {
								}
								if (poolPrice <= 0) {
									System.out.println("Invalid Input!");
								}
							} while (poolPrice <= 0);
							FileWriter poolWriter2 = new FileWriter("C:/CreateFile/pools.txt");
							for (int i = 0; i < tempPoolDetails.size(); i++) {
								String[] details = new String[4];
								details = tempPoolDetails.get(i).split(";");
								if (poolEditSearch.equalsIgnoreCase(details[0])) {
									poolWriter2.write(details[0] + ";" + poolType + ";" + poolPrice + ";" + "1\n");
								} else {
									poolWriter2.write(tempPoolDetails.get(i) + "\n");
								}
							}
							poolWriter2.close();
							System.out.println("Pool Edited Successfully.");
						} else {
							System.out.println("Incorrect room Number.");
						}
						break;
					case 15:
						File searchPoolFile = new File("C:/CreateFile/pools.txt");
						Scanner searchPoolFileScanner = new Scanner(searchPoolFile);
						System.out.println("-----Search Pool-----\n");
						found = false;
						Manching = new Scanner(System.in);
						System.out.print("Enter Pool number to search: ");
						String psearch = Manching.nextLine();
						System.out.println("Search results for " + psearch + ":");
						System.out.println("|\tPool Number\t|\tPool type\t|\tPool Price\t|\tStatus\t|");
						System.out.println(
								"-----------------------------------------------------------------------------------------");
						while (searchPoolFileScanner.hasNextLine()) {
							String[] details = new String[4];
							String data = searchPoolFileScanner.nextLine();
							details = data.split(";");
							if (data.matches("(.*)" + psearch + "(.*)")) {
								System.out.println("|\t" + details[0] + "\t\t|\t" + details[1] + "\t\t|\t" + details[2]
										+ "\t\t|\t" + details[3] + "\t|");
							}
						}
						break;
					case 16:
						System.out.println("-----Edit Pool Status-----");
						File editPoolStatusFile = new File("C:/CreateFile/pools.txt");
						Scanner poolStatusScanner = new Scanner(editPoolStatusFile);
						ArrayList<String> tempPoolStatusDetails = new ArrayList<String>();
						while (poolStatusScanner.hasNextLine()) {
							tempPoolStatusDetails.add(poolStatusScanner.nextLine());
						}
						poolStatusScanner.close();
						Manching = new Scanner(System.in);
						found = false;
						System.out.print("Enter Pool number to edit Status: ");
						String searchEditStatusPool = Manching.nextLine();
						poolStatusScanner = new Scanner(editPoolStatusFile);
						while (poolStatusScanner.hasNextLine()) {
							String[] details = new String[4];
							String data = poolStatusScanner.nextLine();
							details = data.split(";");
							if (searchEditStatusPool.equalsIgnoreCase(details[0])) {
								found = true;
								System.out.println("Search Result for " + searchEditStatusPool + ": ");
								System.out.println("Pool Number: " + details[0]);
								System.out.println("Pool Type: " + details[1]);
								System.out.println("Price: " + details[2]);
								System.out.println("Status: " + details[3]);
								System.out.println();
							}
						}
						if (found) {
							int Status = 0;
							System.out.println("------Status------");
							System.out.println("1 = Active\n2 = Inactive\n3 = Occupied");
							do {
								Manching = new Scanner(System.in);
								System.out.print("Please Choose New Status: ");
								String input = Manching.nextLine().trim();
								if (input.matches("[1-3]")) {
									Status = Integer.parseInt(input);
									break;
								}
								System.out.println("Invalid Input!");
							} while (true);
							FileWriter poolWriter2 = new FileWriter("C:/CreateFile/pools.txt");
							for (int i = 0; i < tempPoolStatusDetails.size(); i++) {
								String[] details1 = new String[4];
								details1 = tempPoolStatusDetails.get(i).split(";");
								if (searchEditStatusPool.equalsIgnoreCase(details1[0])) {
									poolWriter2.write(
											details1[0] + ";" + details1[1] + ";" + details1[2] + ";" + Status + "\n");
								} else {
									poolWriter2.write(tempPoolStatusDetails.get(i) + "\n");
								}
							}
							poolWriter2.close();
							System.out.println("Status Edited successfully.");
						} else {
							System.out.println("Noting Matches your Number entered.");
						}
						break;
					case 17:
						FileWriter reservationWriter = new FileWriter("C:/CreateFile/reservation.txt", true);
						File reservation = new File("C:/CreateFile/reservation.txt");
						Scanner reservationScanner = new Scanner(reservation);
						File pools = new File("C:/CreateFile/pools.txt");
						File cottage = new File("C:/CreateFile/cottage.txt");
						File rooms = new File("C:/CreateFile/rooms.txt");
						File function = new File("C:/CreateFile/function.txt");

						System.out.println("-----Add Reservation-----");
						String reservationAmenitiesChoice = "", reservationDate = "";
						int reservationNumber = 1, reservationPeriod = 0, reservationStatus = 0, reservationChoice = 0;
						String reservationClientName = "", reservationClientAddress = "",
								reservationClientContactNum = "";
						double SumReservationPrice = 0;
						boolean noAvailable = true, isValidDate = false;
						ArrayList<String> allAmenitiesReserved = new ArrayList<>();
						Manching = new Scanner(System.in);
						do {
							System.out.print("Enter Client Name: ");
							reservationClientName = Manching.nextLine();
						} while (reservationClientName.isBlank());
						do {
							System.out.print("Enter Client Address: ");
							reservationClientAddress = Manching.nextLine();
						} while (reservationClientAddress.isBlank());
						while (!isValidDate) {
							Manching = new Scanner(System.in);
							System.out.print("Enter new Reservation date (yyyy-MM-dd): ");
							reservationDate = Manching.nextLine();
							try {
								Date tryDate = dateFormat.parse(reservationDate);
								isValidDate = true;
							} catch (ParseException e) {
								System.out.println("Invalid date format. Please try again.");
							}
						}
						do {
							reservationChoice = 0;
							String tempReserve = "";
							do {
								try {
									Manching = new Scanner(System.in);
									System.out.println("Select Amenities to reserve: ");
									System.out.println("1 = Room");
									System.out.println("2 = Cottage with tables and chairs");
									System.out.println("3 = Funtion Hall");
									System.out.println("4 = Pool");
									System.out.print("Enter choice: ");
									reservationChoice = Manching.nextInt();

								} catch (Exception e) {
									System.out.println("Please do not Include Special Characters");
								}
								if (reservationChoice <= 0 || reservationChoice > 4) {
									System.out.println("Invalid Input! Please choose 1 to 4 only.");
								}
							} while (reservationChoice <= 0 || reservationChoice > 4);
							switch (reservationChoice) {
							case 1:
								Scanner roomReservationScanner = new Scanner(rooms);
								ArrayList<String> allRoomNumbers = new ArrayList<String>();
								ArrayList<String> allRooms = new ArrayList<String>();
								found = false;
								System.out.println("Available Rooms:");
								System.out.println("|\tRoom Number\t|\tRoom type\t|\tRoom Price\t|\tStatus\t|");
								System.out.println(
										"----------------------------------------------------------------------------------------------");
								while (roomReservationScanner.hasNextLine()) {
									String[] details = new String[4];
									String data = roomReservationScanner.nextLine();
									details = data.split(";");
									allRooms.add(data);
									allRoomNumbers.add(details[0]);
									if (details[3].equalsIgnoreCase("1")) {
										System.out.println("|\t" + details[0] + "\t\t|\t" + details[1] + "\t\t|\t"
												+ details[2] + "\t\t|\t" + details[3] + "\t|");
										noAvailable = false;
									}
								}
								String roomNumberReserve = "";
								if (noAvailable) {
									System.out.println("No available Rooms to book. All Rooms are Occupied.");
								} else {
									do {
										Manching = new Scanner(System.in);
										System.out.print("Enter Room Number to reserve: ");
										roomNumberReserve = Manching.nextLine();
										for (int i = 0; i < allRoomNumbers.size(); i++) {
											if (allRoomNumbers.get(i).equals(roomNumberReserve)) {
												found = true;
											}
										}
										if (!found) {
											System.out.println("Invalid Number!");
										}
									} while (!found);
									roomReservationScanner = new Scanner(rooms);
									while (roomReservationScanner.hasNextLine()) {
										String[] details = new String[4];
										String data = roomReservationScanner.nextLine();
										details = data.split(";");
										if (roomNumberReserve.equals(details[0])) {
											allAmenitiesReserved.add(
													details[0] + ":" + details[1] + ":" + details[2] + ":" + "3" + ",");
											SumReservationPrice += (Double.parseDouble(details[2]));
										}
									}
									FileWriter rWriter = new FileWriter("C:/CreateFile/rooms.txt");
									for (int i = 0; i < allRooms.size(); i++) {
										String[] details = new String[4];
										String data = allRooms.get(i);
										details = data.split(";");
										if (roomNumberReserve.equals(details[0])) {
											rWriter.write(
													details[0] + ";" + details[1] + ";" + details[2] + ";" + "3\n");
										} else {
											rWriter.write(data + "\n");
										}
									}
									rWriter.close();
								}
								break;
							case 2:
								Scanner cottageReservationScanner = new Scanner(cottage);
								found = false;
								noAvailable = true;
								ArrayList<String> allCottageNumbers = new ArrayList<String>();
								ArrayList<String> allCottage = new ArrayList<String>();
								System.out.println("Available Cottage:");
								System.out
										.println("|\tCottage Number\t|\tCottage type\t|\tCottage Price\t|\tStatus\t|");
								System.out.println(
										"----------------------------------------------------------------------------------------------");
								while (cottageReservationScanner.hasNextLine()) {
									String[] details = new String[4];
									String data = cottageReservationScanner.nextLine();
									details = data.split(";");
									allCottage.add(data);
									allCottageNumbers.add(details[0]);
									if (details[3].equals("1")) {
										System.out.println("|\t" + details[0] + "\t\t|\t" + details[1] + "\t\t|\t"
												+ details[2] + "\t\t|\t" + details[3] + "\t|");
										noAvailable = false;
									}
								}
								String cottageNumberReserve = "";
								if (noAvailable) {
									System.out.println("No available Cottages to book. All Cottages are Occupied.");
								} else {
									do {
										Manching = new Scanner(System.in);
										System.out.print("Enter Cottage Number to reserve: ");
										cottageNumberReserve = Manching.nextLine();
										for (int i = 0; i < allCottageNumbers.size(); i++) {
											if (allCottageNumbers.get(i).equals(cottageNumberReserve)) {
												found = true;
											}
										}
										if (!found) {
											System.out.println("Invalid Number!");
										}
									} while (!found);
									cottageReservationScanner = new Scanner(cottage);
									while (cottageReservationScanner.hasNextLine()) {
										String[] details = new String[4];
										String data = cottageReservationScanner.nextLine();
										details = data.split(";");
										if (cottageNumberReserve.equals(details[0])) {
											allAmenitiesReserved.add(
													details[0] + ":" + details[1] + ":" + details[2] + ":" + "3" + ",");
											SumReservationPrice += (Double.parseDouble(details[2]));
										}
									}
									FileWriter cWriter = new FileWriter("C:/CreateFile/cottage.txt");
									for (int i = 0; i < allCottage.size(); i++) {
										String[] details = new String[4];
										String data = allCottage.get(i);
										details = data.split(";");
										if (cottageNumberReserve.equals(details[0])) {
											cWriter.write(
													details[0] + ";" + details[1] + ";" + details[2] + ";" + "3\n");
										} else {
											cWriter.write(data + "\n");
										}
									}
									cWriter.close();
								}
								break;
							case 3:
								noAvailable = true;
								Scanner functionReservationScanner = new Scanner(function);
								found = false;
								ArrayList<String> allFunctionNumbers = new ArrayList<String>();
								ArrayList<String> allFunc = new ArrayList<String>();
								System.out.println("Available Function Halls:");
								System.out.println(
										"|\tFunction Hall Number\t|\tFuntion Hall Name\t|\tFunction Hall type\t|\tFunction Hall Price\t|\tStatus\t|");
								System.out.println(
										"--------------------------------------------------------------------------------------------------------------------------------------------");
								while (functionReservationScanner.hasNextLine()) {
									String[] details = new String[5];
									String data = functionReservationScanner.nextLine();
									details = data.split(";");
									allFunc.add(data);
									allFunctionNumbers.add(details[0]);
									if (details[4].equals("1")) {
										System.out.println(
												"|\t" + details[0] + "\t\t\t|\t" + details[1] + "\t\t\t|\t" + details[2]
														+ "\t\t\t|\t" + details[3] + "\t\t\t|\t" + details[4] + "\t|");
										noAvailable = false;
									}
								}
								String funcNumberReserve = "";
								if (noAvailable) {
									System.out.println(
											"No available Function Halls to book. All Funtion halls are Occupied.");
								} else {
									do {
										Manching = new Scanner(System.in);
										System.out.print("Enter Function Hall Number to reserve: ");
										funcNumberReserve = Manching.nextLine();
										for (int i = 0; i < allFunctionNumbers.size(); i++) {
											if (allFunctionNumbers.get(i).equals(funcNumberReserve)) {
												found = true;
											}
										}
										if (!found) {
											System.out.println("Invalid Number!");
										}
									} while (!found);
									functionReservationScanner = new Scanner(function);
									while (functionReservationScanner.hasNextLine()) {
										String[] details = new String[5];
										String data = functionReservationScanner.nextLine();
										details = data.split(";");
										if (funcNumberReserve.equals(details[0])) {
											allAmenitiesReserved.add(details[0] + ":" + details[1] + ":" + details[2]
													+ ":" + details[3] + ":" + "3" + ",");
											SumReservationPrice += (Double.parseDouble(details[3]));
										}
									}
									FileWriter fWriter = new FileWriter("C:/CreateFile/function.txt");
									for (int i = 0; i < allFunc.size(); i++) {
										String[] details = new String[4];
										String data = allFunc.get(i);
										details = data.split(";");
										if (funcNumberReserve.equals(details[0])) {
											fWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";"
													+ details[3] + ";" + "3\n");
										} else {
											fWriter.write(data + "\n");
										}
									}
									fWriter.close();
								}
								break;
							case 4:
								noAvailable = true;
								ArrayList<String> allPools = new ArrayList<>();
								Scanner poolReservationScanner = new Scanner(pools);
								found = false;
								ArrayList<String> allPoolNumbers = new ArrayList<String>();
								System.out.println("Available Pools:");
								System.out.println("|\tPool Number\t|\tPool type\t|\tPool Price\t|\tStatus\t|");
								System.out.println(
										"--------------------------------------------------------------------------------------------------------------------");
								poolReservationScanner = new Scanner(pools);
								while (poolReservationScanner.hasNextLine()) {
									String[] details = new String[4];
									String data = poolReservationScanner.nextLine();
									details = data.split(";");
									allPoolNumbers.add(details[0]);
									allPools.add(data);
									if (details[3].equals("1")) {
										System.out.println("|\t" + details[0] + "\t\t|\t" + details[1] + "\t\t|\t"
												+ details[2] + "\t\t|\t" + details[3] + "\t|");
										noAvailable = false;
									}
								}
								String poolNumberReserve = "";
								if (noAvailable) {
									System.out.println("No available Pools to Book. All Pools are occupied.");
								} else {
									do {
										Manching = new Scanner(System.in);
										System.out.print("Enter Pool Number to reserve: ");
										poolNumberReserve = Manching.nextLine();
										for (int i = 0; i < allPoolNumbers.size(); i++) {
											if (allPoolNumbers.get(i).equals(poolNumberReserve)) {
												found = true;
											}
										}
										if (!found) {
											System.out.println("Invalid Number!");
										}
									} while (!found);
									poolReservationScanner = new Scanner(pools);
									while (poolReservationScanner.hasNextLine()) {
										String[] details = new String[4];
										String data = poolReservationScanner.nextLine();
										details = data.split(";");
										if (poolNumberReserve.equals(details[0])) {
											allAmenitiesReserved.add(
													details[0] + ":" + details[1] + ":" + details[2] + ":" + "3" + ",");
											SumReservationPrice += (Double.parseDouble(details[2]));
										}
									}
									FileWriter pWriter = new FileWriter("C:/CreateFile/pools.txt");
									for (int i = 0; i < allPools.size(); i++) {
										String[] details = new String[4];
										String data = allPools.get(i);
										details = data.split(";");
										if (poolNumberReserve.equals(details[0])) {
											pWriter.write(
													details[0] + ";" + details[1] + ";" + details[2] + ";" + "3\n");
										} else {
											pWriter.write(data + "\n");
										}
									}
									pWriter.close();
								}
								break;
							default:
								break;
							}
							if (SumReservationPrice > 0 || noAvailable) {
								System.out.println("Total Payment: " + SumReservationPrice);
								System.out.println("All Amenities Reserved: ");
								for (int i = 0; i < allAmenitiesReserved.size(); i++) {
									System.out.println(allAmenitiesReserved.get(i));
								}
								do {
									Manching = new Scanner(System.in);
									System.out.print("Do you want to reserve more amenities? y = yes | n = no: ");
									reservationAmenitiesChoice = Manching.nextLine();
								} while (!(reservationAmenitiesChoice.equalsIgnoreCase("y"))
										&& !(reservationAmenitiesChoice.equalsIgnoreCase("n")));
							}
						} while (reservationAmenitiesChoice.equalsIgnoreCase("y"));
						do {
							Manching = new Scanner(System.in);

							System.out.println("---Reservation Period---\n1 = Day tour\n2 = Overnight");
							System.out.print("Enter Reservation Period: ");
							String input = Manching.nextLine().trim();
							if (input.matches("[1-2]")) {
								reservationPeriod = Integer.parseInt(input);
								break;
							}
							System.out.println("Invalid Input!");
						} while (true);
						int reservePayment = 0;
						do {
							Manching = new Scanner(System.in);
							System.out.println("1 = Partial");
							System.out.println("2 = Full payment");
							System.out.print("Choose payment Status: ");
							String input = Manching.nextLine().trim();
							if (input.matches("[1-2]")) {
								reservePayment = Integer.parseInt(input);
								break;
							}
							System.out.println("Invalid Input!");
						} while (true);
						String allreserved = "";
						for (int i = 0; i < allAmenitiesReserved.size(); i++) {
							allreserved += allAmenitiesReserved.get(i);
						}
						reservationWriter.write(reservationNumber + ";" + reservationClientName + ";"
								+ reservationClientAddress + ";" + reservationDate + ";" + allreserved + ";"
								+ SumReservationPrice + ";" + reservePayment + ";" + reservationPeriod + ";" + "1\n");
						reservationWriter.close();
						System.out.println("Successfully Added Reservation.");
						break;
					case 18:
						File reservationFile = new File("C:/CreateFile/reservation.txt");
						Scanner reservationFileScanner = new Scanner(reservationFile);
						ArrayList<String> allReservation = new ArrayList<>();
						while (reservationFileScanner.hasNextLine()) {
							String data = reservationFileScanner.nextLine();
							allReservation.add(data);
						}
						System.out.println("-----Edit Reservation-----");
						reservationAmenitiesChoice = "";
						reservationDate = "";
						reservationNumber = 1;
						reservationPeriod = 0;
						reservationStatus = 0;
						reservationChoice = 0;
						reservationClientName = "";
						reservationClientAddress = "";
						reservationClientContactNum = "";
						SumReservationPrice = 0;
						boolean searchFound = false;
						isValidDate = false;
						System.out.print("Enter Reservation ID to edit details: ");
						String reservationSearch = Manching.nextLine();
						reservationFileScanner = new Scanner(reservationFile);
						while (reservationFileScanner.hasNextLine()) {
							String[] details = new String[9];
							String data = reservationFileScanner.nextLine();
							details = data.split(";");
							if (details[0].equals(reservationSearch)) {
								searchFound = true;
								System.out.println("Reservation ID: " + details[0]);
								System.out.println("Client Name: " + details[1]);
								System.out.println("Client Address: " + details[2]);
								System.out.println("Reservation Date: " + details[3]);
								System.out.println("All Ameneties Reserved: " + details[4]);
								System.out.println("Reservation Price: " + details[5]);
								System.out.println("Reservation Period: " + details[6]);
								System.out.println("Payment Status: " + details[7]);
								if (details[8].equals("1")) {
									System.out.println("Reservation Status: Active");
								}
								if (details[8].equals("2")) {
									System.out.println("Reservation Status: Cancelled");
								}
								if (details[8].equals("3")) {
									System.out.println("Reservation Status: Done");
								}
							}
						}
						if (searchFound) {
							System.out.println("Edit Reservation Deatils.\n");
							do {
								Manching = new Scanner(System.in);
								System.out.print("Enter new Client Name: ");
								reservationClientName = Manching.nextLine();
							} while (reservationClientName.isBlank());
							do {
								Manching = new Scanner(System.in);
								System.out.print("Enter new Client Address: ");
								reservationClientAddress = Manching.nextLine();
							} while (reservationClientAddress.isBlank());
							while (!isValidDate) {
								Manching = new Scanner(System.in);
								System.out.print("Enter new Reservation date (yyyy-MM-dd): ");
								reservationDate = Manching.nextLine();
								try {
									Date tryDate = dateFormat.parse(reservationDate);
									isValidDate = true;
								} catch (ParseException e) {
									System.out.println("Invalid date format. Please try again.");
								}
							}
							do {
								Manching = new Scanner(System.in);

								System.out.println("---Reservation Period---\n1 = Day tour\n2 = Overnight");
								System.out.print("Enter new Reservation Period: ");
								String input = Manching.nextLine().trim();
								if (input.matches("[1-2]")) {
									reservationPeriod = Integer.parseInt(input);
									break;
								}
								System.out.println("Invalid Input!");
							} while (true);
							reservePayment = 0;
							do {
								Manching = new Scanner(System.in);
								System.out.println("1 = Partial");
								System.out.println("2 = Full payment");
								System.out.print("Choose new payment Status: ");
								String input = Manching.nextLine().trim();
								if (input.matches("[1-2]")) {
									reservePayment = Integer.parseInt(input);
									break;
								}
								System.out.println("Invalid Input!");
							} while (true);
							FileWriter reservationWriter2 = new FileWriter("C:/CreateFile/reservation.txt");
							for (int i = 0; i < allReservation.size(); i++) {
								String[] details = new String[9];
								String data = allReservation.get(i);
								details = data.split(";");
								if (reservationSearch.equals(details[0])) {
									reservationWriter2.write(
											details[0] + ";" + reservationClientName + ";" + reservationClientAddress
													+ ";" + reservationDate + ";" + details[4] + ";" + details[5] + ";"
													+ reservePayment + ";" + reservationPeriod + ";" + "1\n");
								} else {
									reservationWriter2.write(data + "\n");
								}
							}
							reservationWriter2.close();
							System.out.println("Successfully Edited Reservation.");
						} else {
							System.out.println("Reservation ID incorrect.");
						}
						break;
					case 19:
						File searchReservationFile = new File("C:/CreateFile/reservation.txt");
						Scanner searchReservationFileScanner = new Scanner(searchReservationFile);
						System.out.println("-----Search Reservation-----");
						System.out.print("Enter keyword to search reservations: ");
						String reserveSearch = Manching.nextLine();
						searchFound = false;
						System.out.println(
								"|\tReservation ID\t|\tClient Name\t|\tClient Address\t\t|\tReservation Date\t|\tAll Ameneties Reserved\t\t\t\t\t|\tPrice\t|\tPayment Satus\t|\tReservation Period\t|\tStatus\t|");
						System.out.println(
								"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						while (searchReservationFileScanner.hasNextLine()) {
							String[] details = new String[9];
							String data = searchReservationFileScanner.nextLine();
							details = data.split(";");
							if (data.matches("(.*)" + reserveSearch + "(.*)")) {
								searchFound = true;
								System.out.println("|\t" + details[0] + "\t\t|\t" + details[1] + "\t\t|\t" + details[2]
										+ "\t|\t" + details[3] + "\t\t|\t" + details[4] + "\t|\t" + details[5] + "\t|\t"
										+ details[6] + "\t\t|\t" + details[7] + "\t\t\t|\t" + details[8] + "\t|");
							}
						}
						if (!searchFound) {
							System.out.println("No matches your search.");
						}
						break;
					case 20:
						File reservationStatusFile = new File("C:/CreateFile/reservation.txt");
						Scanner reservationStatusFileScanner = new Scanner(reservationStatusFile);
						ArrayList<String> allReservationStatus = new ArrayList<>();
						while (reservationStatusFileScanner.hasNextLine()) {
							String data = reservationStatusFileScanner.nextLine();
							allReservationStatus.add(data);
						}
						System.out.println("-----Edit Reservation Status-----");
						searchFound = false;
						reservationSearch = "";
						System.out.print("Enter Reservation ID to edit Status: ");
						reservationSearch = Manching.nextLine();
						reservationStatusFileScanner = new Scanner(reservationStatusFile);
						while (reservationStatusFileScanner.hasNextLine()) {
							String[] details = new String[9];
							String data = reservationStatusFileScanner.nextLine();
							details = data.split(";");
							if (details[0].equals(reservationSearch)) {
								searchFound = true;
								System.out.println("Reservation ID: " + details[0]);
								System.out.println("Client Name: " + details[1]);
								System.out.println("Client Address: " + details[2]);
								System.out.println("Reservation Date: " + details[3]);
								System.out.println("All Ameneties Reserved: " + details[4]);
								System.out.println("Reservation Price: " + details[5]);
								System.out.println("Reservation Period: " + details[6]);
								System.out.println("Payment Status: " + details[7]);
								if (details[8].equals("1")) {
									System.out.println("Reservation Status: Active");
								}
								if (details[8].equals("2")) {
									System.out.println("Reservation Status: Cancelled");
								}
								if (details[8].equals("3")) {
									System.out.println("Reservation Status: Done");
								}
							}
						}
						if (searchFound) {
							reservationStatus = 0;
							System.out.println("1 = Active\n2 = Cancelled\n3 = Done");
							do {
								System.out.print("Enter new Status: ");
								String input = Manching.nextLine().trim();
								if (input.matches("[1-3]")) {
									reservationStatus = Integer.parseInt(input);
									break;
								}
								System.out.println("Invalid Status.");
							} while (true);
							FileWriter reservationWriter3 = new FileWriter("C:/CreateFile/reservation.txt");
							for (int i = 0; i < allReservationStatus.size(); i++) {
								String[] details = new String[9];
								String data = allReservationStatus.get(i);
								details = data.split(";");
								if (reservationSearch.equals(details[0])) {
									reservationWriter3.write(details[0] + ";" + details[0] + ";" + details[0] + ";"
											+ details[0] + ";" + details[4] + ";" + details[5] + ";" + details[0] + ";"
											+ details[0] + ";" + reservationStatus + "\n");
								} else {
									reservationWriter3.write(data + "\n");
								}
							}
							reservationWriter3.close();
							System.out.println("Successfully Edited Reservation Status.");
						} else {
							System.out.println("Reservation ID incorrect.");
						}
						break;
					case 21:
						System.out.println("Log out.");
						logInSuccess = false;
						break;
					default:
						break;
					}
				}
			} while (true);
		} catch (Exception e) {
			System.out.println("An Error Occured.\n" + e);
		}
	}
}