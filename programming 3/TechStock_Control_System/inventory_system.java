import java.util.*;
import java.io.*;
import java.text.*;
import java.time.*;

public class inventory_system {
	public static void main(String[] manch) {
		try {
			boolean logInSuccess = false, found = false;

			do {
				Scanner Manching = new Scanner(System.in);

				LocalDate localDate = LocalDate.now();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
				dateFormat.setLenient(false);
				int mainMenuChoice = 0, choice = 0;
				String username = "", password = "";

				if (!logInSuccess) {
					try {
						Manching = new Scanner(System.in);
						System.out.println("---WELCOME TO  ITC Pre-Assessment---");
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
						File logInFile = new File("c:/inventory/login.txt");
						Scanner logInFileScanner = new Scanner(logInFile);
						Manching = new Scanner(System.in);
						System.out.println("|-------Login Form-----|");
						System.out.print("Username: ");
						username = Manching.nextLine();
						System.out.print("Password: ");
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
						FileWriter signUpFileWriter = new FileWriter("c:/inventory/login.txt", true);
						File signUpFile = new File("c:/inventory/login.txt");
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
					System.out.println("1 = Add Record");
					System.out.println("2 = View Record");
					System.out.println("3 = Edit Record");
					System.out.println("4 = Delete Record");
					System.out.println("5 = Report");
					System.out.println("6 = Exit/Logout");

					do {
						Manching = new Scanner(System.in);
						try {
							System.out.print("Enter choice: ");
							choice = Manching.nextInt();
						} catch (Exception e) {
						}
						if (choice <= 0 || choice > 6) {
							System.out.println("Invalid choice! Please choose from 1 to 5 only.");
						}
					} while (choice <= 0 || choice > 6);

					switch (choice) {
					case 1:
						FileWriter addWriter = new FileWriter("c:/inventory/Add Peripheral.txt", true);
						File addPheFile = new File("c:/inventory/Add Peripheral.txt");
						Scanner addPheFileScanner = new Scanner(addPheFile);
						String current = "2023";
						int code = 0001;
						int phe = 0, stat = 0;
						String id = "";
						String input1 = "", name = "", employee = "", marks = "";
						while (addPheFileScanner.hasNextLine()) {
							String[] details = new String[6];
							String data = addPheFileScanner.nextLine();
							code++;
						}
						System.out.println("------Add Peripheral------");

						do {
							Manching = new Scanner(System.in);
							System.out.println(
									"---Peripheral---\n1 = Input Device\n2 = Output Device\n3 = Input/Output Device");
							System.out.print("Choose Peripheral: ");
							String input = Manching.nextLine().trim();
							if (input.matches("[1-3]")) {
								phe = Integer.parseInt(input);
								if (phe <= 0 || phe > 3) {
									System.out.println("Invalid Number! Please try again");
								}
							} else {
								System.out.println("Invalid Input!");
							}
							if (input.matches("[1]")) {
								input1 = "Input Device";
							}
							if (input.matches("[2]")) {
								input1 = "Output Device";
							}
							if (input.matches("[3]")) {
								input1 = "Both";
							}
						} while (phe <= 0 || phe > 3);

						do {
							Manching = new Scanner(System.in);
							try {
								if (phe == 1) {
									System.out.print("Enter input device: ");
									id = Manching.nextLine();
								}
								if (phe == 2) {
									System.out.print("Enter output device: ");
									id = Manching.nextLine();
								}
								if (phe == 3) {
									System.out.print("Enter input/output device: ");
									id = Manching.nextLine();
								}
							} catch (Exception e) {
							}
							if (phe <= 0) {
								System.out.println("Invalid Input!");
							}
						} while (phe <= 0);

						do {
							Manching = new Scanner(System.in);
							System.out.print("Name: ");
							name = Manching.nextLine();
						} while (false);

						do {
							Manching = new Scanner(System.in);
							System.out.println("Peripheral Status: \n1=Available \n2=Not Available");
							stat = Manching.nextInt();

							if (stat == 1) {
								marks = "Available";
								employee = "None";
							}
							if (stat == 2) {
								Manching = new Scanner(System.in);
								marks = "Not";
								System.out.print("Enter Name of Employee assigned to: ");
								employee = Manching.nextLine();
							}
						} while (false);

						addWriter.write(current + "-" + code + ";" + name + ";" + phe + "(" + input1 + ")" + ";" + id
								+ ";" + marks + ";" + employee + "\n");
						addWriter.close();
						System.out.println("Peripheral Successfully added.");
						break;
					case 2:
						if (logInSuccess) {
							int choice2 = 0;

							System.out.println("--View Records--");
							System.out.println("1=View all peripherals");
							System.out.println("2=View available peripherals");
							System.out.println("3=View not available peripherals");
							System.out.println("4=View all input devices");
							System.out.println("5=View all output devices");
							System.out.println("6=View all input/output devices");
							System.out.println("7=View all employees");
							System.out.println("8=exit");

							do {
								Manching = new Scanner(System.in);
								try {
									System.out.print("Enter choice: ");
									choice2 = Manching.nextInt();
								} catch (Exception e) {
								}
								if (choice2 <= 0 || choice2 > 8) {
									System.out.println("Invalid choice! Please choose from 1 to 5 only.");
								}
							} while (choice2 <= 0 || choice2 > 8);

							switch (choice2) {
							case 1:
								File viewPheFile = new File("c:/inventory/Add Peripheral.txt");
								Scanner viewPheFileScanner = new Scanner(viewPheFile);
								System.out.println("-----View All Peripherals-----\n");
								ArrayList<String> allPheNumbers = new ArrayList<String>();
								ArrayList<String> allPhe = new ArrayList<String>();
								found = false;

								System.out.println("All Peripheral:");
								System.out.println("Code;Name;Kinds of Peripheral;Device Name;Status;employee");
								System.out.println("-----------------------------------");
								while (viewPheFileScanner.hasNextLine()) {
									String[] details = new String[6];
									String content = viewPheFileScanner.nextLine();
									details = content.split(";");
									System.out.println(details[0] + ";" + details[1] + ";" + details[2] + ";"
											+ details[3] + ";" + details[4] + ";" + details[5]);
								}
								break;

							case 2:
								File viewPhe2File = new File("c:/inventory/Add Peripheral.txt");
								Scanner viewPhe2FileScanner = new Scanner(viewPhe2File);
								System.out.println("-----View available peripherals-----\n");
								found = false;
								Manching = new Scanner(System.in);
								String rsearch = "Available";
								System.out.println("Available Peripheral: ");
								System.out.println("Code;Name;Kinds of Peripheral;Device Name;Status;employee");
								System.out.println("--------------------------------------");
								boolean not = false;
								while (viewPhe2FileScanner.hasNextLine()) {
									String[] details = new String[6];
									String content = viewPhe2FileScanner.nextLine();
									details = content.split(";");
									if (content.matches("(.*)" + rsearch + "(.*)")) {
										not = true;
										System.out.println(details[0] + ";" + details[1] + ";" + details[2] + ";"
												+ details[3] + ";" + details[4] + ";" + details[5]);
									}
								}

								if (not == false) {
									System.out.println("No Available Peripheral");
								}

								break;

							case 3:
								File viewPhe3File = new File("c:/inventory/Add Peripheral.txt");
								Scanner viewPhe3FileScanner = new Scanner(viewPhe3File);
								System.out.println("-----View Not Available peripherals-----\n");
								found = false;
								Manching = new Scanner(System.in);
								String rsearch2 = "Not";
								System.out.println("Available Peripheral: ");
								System.out.println("Code;Name;Kinds of Peripheral;Device Name;Status;Employee");
								System.out.println("---------------------------------------------------");
								not = false;
								while (viewPhe3FileScanner.hasNextLine()) {
									String[] details = new String[6];
									String content = viewPhe3FileScanner.nextLine();
									details = content.split(";");
									if (content.matches("(.*)" + rsearch2 + "(.*)")) {
										not = true;
										System.out.println(details[0] + ";" + details[1] + ";" + details[2] + ";"
												+ details[3] + ";" + details[4] + ";" + details[5]);
									}
								}

								if (not == false) {
									System.out.println("Peripheral is/are available");
								}

								break;

							case 4:
								File viewPhe4File = new File("c:/inventory/Add Peripheral.txt");
								Scanner viewPhe4FileScanner = new Scanner(viewPhe4File);
								System.out.println("-----View Input Devices-----\n");
								found = false;
								Manching = new Scanner(System.in);
								String rsearch3 = "Input";
								System.out.println("All Input Device: ");
								System.out.println("Code;Name;Kinds of Peripheral;Device Name;Status;Employee");
								System.out.println("---------------------------------------------------");
								not = false;
								while (viewPhe4FileScanner.hasNextLine()) {
									String[] details = new String[6];
									String content = viewPhe4FileScanner.nextLine();
									details = content.split(";");
									if (content.matches("(.*)" + rsearch3 + "(.*)")) {
										not = true;
										System.out.println(details[0] + ";" + details[1] + ";" + details[2] + ";"
												+ details[3] + ";" + details[4] + ";" + details[5]);
									}
								}

								if (not == false) {
									System.out.println("No input devices");
								}

								break;

							case 5:
								File viewPhe5File = new File("c:/inventory/Add Peripheral.txt");
								Scanner viewPhe5FileScanner = new Scanner(viewPhe5File);
								System.out.println("-----View Output Devices-----\n");
								found = false;
								Manching = new Scanner(System.in);
								String rsearch4 = "Output";
								System.out.println("All Output Device: ");
								System.out.println("Code;Name;Kinds of Peripheral;Device Name;Status;Employee");
								System.out.println("---------------------------------------------------------");
								not = false;
								while (viewPhe5FileScanner.hasNextLine()) {
									String[] details = new String[6];
									String content = viewPhe5FileScanner.nextLine();
									details = content.split(";");
									if (content.matches("(.*)" + rsearch4 + "(.*)")) {
										not = true;
										System.out.println(details[0] + ";" + details[1] + ";" + details[2] + ";"
												+ details[3] + ";" + details[4] + ";" + details[5]);
									}
								}

								if (not == false) {
									System.out.println("No output devices");
								}

								break;

							case 6:
								File viewPhe6File = new File("c:/inventory/Add Peripheral.txt");
								Scanner viewPhe6FileScanner = new Scanner(viewPhe6File);
								System.out.println("-----View Input/Output Devices-----\n");
								found = false;
								Manching = new Scanner(System.in);
								String rsearch5 = "Both";
								System.out.println("All Input Device: ");
								System.out.println("Code;Name;Kinds of Peripheral;Device Name;Status;Employee");
								System.out.println("---------------------------------------------------------");
								not = false;
								while (viewPhe6FileScanner.hasNextLine()) {
									String[] details = new String[6];
									String content = viewPhe6FileScanner.nextLine();
									details = content.split(";");
									if (content.matches("(.*)" + rsearch5 + "(.*)")) {
										not = true;
										System.out.println(details[0] + ";" + details[1] + ";" + details[2] + ";"
												+ details[3] + ";" + details[4] + ";" + details[5]);
									}
								}

								if (not == false) {
									System.out.println("No input/output devices");
								}

								break;

							case 7:
								File viewPhe7File = new File("c:/inventory/Add Peripheral.txt");
								Scanner viewPhe7FileScanner = new Scanner(viewPhe7File);
								System.out.println("-----View all employees-----\n");
								found = false;
								Manching = new Scanner(System.in);
								String rsearch6 = "Not";
								System.out.println("Name of Employee");
								System.out.println("-------------------");
								not = false;
								while (viewPhe7FileScanner.hasNextLine()) {
									String[] details = new String[1];
									String content = viewPhe7FileScanner.nextLine();
									details = content.split(";");
									if (content.matches("(.*)" + rsearch6 + "(.*)")) {
										not = true;
										System.out.println(details[5]);
									}
								}

								if (not == false) {
									System.out.println("No Records found");
								}

								break;

							case 8:
								System.out.println("Exit...");
								System.exit(0);
								break;
							}
						}
						break;
					case 3:
						File editFile = new File("c:/inventory/Add Peripheral.txt");
						Scanner editFileScanner = new Scanner(editFile);
						current = "2023";
						code = 0001;
						phe = 0;
						id = "";
						input1 = "";
						name = "";
						employee = "";
						marks = "";
						stat = 0;
						System.out.println("------Edit Peripheral------");
						found = false;
						ArrayList<String> tempeditDetails = new ArrayList<String>();
						while (editFileScanner.hasNextLine()) {
							tempeditDetails.add(editFileScanner.nextLine());
						}
						Manching = new Scanner(System.in);
						System.out.print("Enter Code Number to Edit Details: ");
						String editEditSearch = Manching.nextLine();
						editFileScanner = new Scanner(editFile);
						while (editFileScanner.hasNextLine()) {
							String[] details = new String[6];
							details = editFileScanner.nextLine().split(";");
							if (editEditSearch.equalsIgnoreCase(details[0])) {
								found = true;
								System.out.println("Code Number: " + details[0]);
								System.out.println("Name: " + details[1]);
								System.out.println("Kinds of Peripheral: " + details[2]);
								System.out.println("Name: " + details[3]);
								System.out.println("Status: " + details[4]);
								System.out.println("Employee assigned to: " + details[5]);
								System.out.println();
							}
						}
						if (found) {
							do {
								Manching = new Scanner(System.in);
								System.out.println(
										"---Peripheral---\n1 = Input Device\n2 = Output Device\n3 = Input/Output Device");
								System.out.print("Choose Peripheral: ");
								String input = Manching.nextLine().trim();
								if (input.matches("[1-3]")) {
									phe = Integer.parseInt(input);
									if (phe <= 0 || phe > 3) {
										System.out.println("Invalid Number! Please try again");
									}
								} else {
									System.out.println("Invalid Input!");
								}
								if (input.matches("[1]")) {
									input1 = "Input Device";
								}
								if (input.matches("[2]")) {
									input1 = "Output Device";
								}
								if (input.matches("[3]")) {
									input1 = "Both";
								}
							} while (phe <= 0 || phe > 3);

							do {
								Manching = new Scanner(System.in);
								try {
									if (phe == 1) {
										System.out.print("Enter input device: ");
										id = Manching.nextLine();
									}
									if (phe == 2) {
										System.out.print("Enter output device: ");
										id = Manching.nextLine();
									}
									if (phe == 3) {
										System.out.print("Enter input/output device: ");
										id = Manching.nextLine();
									}
								} catch (Exception e) {
								}
								if (phe <= 0) {
									System.out.println("Invalid Input!");
								}
							} while (phe <= 0);

							do {
								Manching = new Scanner(System.in);
								System.out.print("Name: ");
								name = Manching.nextLine();
							} while (false);

							do {
								Manching = new Scanner(System.in);
								System.out.println("Peripheral Status: \n1=Available \n2=Not Available");
								stat = Manching.nextInt();

								if (stat == 1) {
									marks = "Available";
									employee = "None";
								}
								if (stat == 2) {
									Manching = new Scanner(System.in);
									marks = "Not";
									System.out.print("Enter Name of Employee assigned to: ");
									employee = Manching.nextLine();
								}
							} while (false);

							FileWriter editWriter2 = new FileWriter(
									"C:/Users/SB-PC/Desktop/ITC 120/Add Peripheral.txt");
							for (int i = 0; i < tempeditDetails.size(); i++) {
								String[] details = new String[6];
								details = tempeditDetails.get(i).split(";");
								if (editEditSearch.equalsIgnoreCase(details[0])) {
									editWriter2.write(details[0] + ";" + name + ";" + phe + "(" + input1 + ")" + ";"
											+ id + ";" + marks + ";" + employee + "\n");
								} else {
									editWriter2.write(tempeditDetails.get(i) + "\n");
								}
							}
							editWriter2.close();
							System.out.println("Peripherals Edited Successfully.");
						} else {
							System.out.println("Incorrect code entered.");
						}
						break;

					case 4:
						File deleteFile = new File("c:/inventory/Add Peripheral.txt");
						Scanner deleteFileScanner = new Scanner(deleteFile);
						code = 0001;
						phe = 0;
						id = "";
						input1 = "";
						name = "";
						String ans = "";
						employee = "";
						System.out.println("------Delete Record------");
						found = false;
						ArrayList<String> tempdeleteDetails = new ArrayList<String>();
						while (deleteFileScanner.hasNextLine()) {
							tempdeleteDetails.add(deleteFileScanner.nextLine());
						}
						Manching = new Scanner(System.in);
						System.out.print("Enter Code Number to Delete: ");
						String deleteDeleteSearch = Manching.nextLine();
						deleteFileScanner = new Scanner(deleteFile);
						while (deleteFileScanner.hasNextLine()) {
							String[] details = new String[6];
							details = deleteFileScanner.nextLine().split(";");
							if (deleteDeleteSearch.equalsIgnoreCase(details[0])) {
								found = true;
								System.out.println("Code Number: " + details[0]);
								System.out.println("Name: " + details[1]);
								System.out.println("Kinds of Peripheral: " + details[2]);
								System.out.println("Name: " + details[3]);
								System.out.println("Status: " + details[4]);
								System.out.println("Employee assigned to: " + details[5]);
								System.out.println();
								System.out.println("Are you sure you want to delete?");
								do {
									Manching = new Scanner(System.in);
									System.out.println("Y for yes and N for no: ");
									ans = Manching.nextLine().trim();
									if (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")) {
										System.out.println("Invalid! Try another one.");
									}
								} while (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n"));
							}
						}
						if (ans.equalsIgnoreCase("y")) {
							FileWriter deleteWriter2 = new FileWriter("c:/inventory/Add Peripheral.txt");
							current = "2023";
							code = 0001;
							marks = "";
							for (int i = 0; i < tempdeleteDetails.size(); i++) {
								String[] details = new String[7];
								details = tempdeleteDetails.get(i).split(";");
								if (deleteDeleteSearch.equalsIgnoreCase(details[0])) {
									deleteWriter2.write(details[0] + ";" + name + ";" + phe + "(" + input1 + ")" + ";"
											+ id + ";" + marks + ";" + employee + "\n");
									code++;
								} else {
									deleteWriter2.write(tempdeleteDetails.get(i) + "\n");
								}
							}
							deleteWriter2.close();
							System.out.println("Deleted Successfully.");
						} else {
							System.out.println("Deleting cancelled!");
						}
						break;

					case 6:
						System.out.println("Log out.");
						logInSuccess = false;
						break;
					}
				}

			} while (true);

		} catch (Exception e) {
			System.out.println("An Error Occured.\n" + e);
		}
	}
}