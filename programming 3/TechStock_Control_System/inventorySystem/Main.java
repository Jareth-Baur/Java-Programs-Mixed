package inventorySystem;
/*	____________________________________________________
	|  ABC Company Inventory System                    |
	|              on 2022-11-28 06:30:00              |
	|    Developer: John Ray D. Paulin                 |
	|    ** Main class for the inventory system.       |
	|__________________________________________________|
*/

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	private static int count;
	private static int sizeofarray;
	private static Peripheral[] perList;
	private static Employee[] empList;
	private static int lastgeneratedCode = 0004;

	public static void main(String[] args) {

		sizeofarray = 1;
		count = 0;
		perList = new Peripheral[100];

		Scanner scan = new Scanner(System.in);

		// Initializing array of Employees. Fixed length to 5 atm.
		empList = new Employee[5];
		empList[0] = new Employee("2022-0001", "John", "Doe");
		empList[1] = new Employee("2022-0002", "Jane", "Smith");
		empList[2] = new Employee("2022-0003", "Alex", "Mckinley");
		empList[3] = new Employee("2022-0004", "Jeff", "Finn");
		empList[4] = new Employee("2022-0005", "Grey", "Lanes");

		// prepopulate the list of peripherals
		Peripheral p1 = new Peripheral("20220001", "A4 Tech Mouse", "Input Device", "");
		Peripheral p2 = new Peripheral("20220002", "Logitech Keyboard 4601", "Input Device", "John Doe");
		Peripheral p3 = new Peripheral("20220003", "Samsung 24 inches TScreen", "Input/Output Device", "Grey Lanes");
		Peripheral p4 = new Peripheral("20220004", "Sembrand Soundbar Speaker", "Output Device", "Jeff Finn");

		String[] defaultDataPerList = { p1.getCode(), p1.getName(), p1.getPeripheral(), p1.getAssignedTo() };
		addElement(defaultDataPerList);

		defaultDataPerList[0] = p2.getCode();
		defaultDataPerList[1] = p2.getName();
		defaultDataPerList[2] = p2.getPeripheral();
		defaultDataPerList[3] = p2.getAssignedTo();
		addElement(defaultDataPerList);

		defaultDataPerList[0] = p3.getCode();
		defaultDataPerList[1] = p3.getName();
		defaultDataPerList[2] = p3.getPeripheral();
		defaultDataPerList[3] = p3.getAssignedTo();
		addElement(defaultDataPerList);

		defaultDataPerList[0] = p4.getCode();
		defaultDataPerList[1] = p4.getName();
		defaultDataPerList[2] = p4.getPeripheral();
		defaultDataPerList[3] = p4.getAssignedTo();
		addElement(defaultDataPerList);
		// end - prepopulate the list of peripherals

		char choice;
		do {
			String[] peripheralData = new String[4];
			hr('=', 40);
			System.out.println("ABC Company Inventory System. v2.1.2");
			hr('-', 40);
			System.out.println("[ A ] - Add Peripheral");
			System.out.println("[ V ] - View Records");
			System.out.println("[ U ] - Update a Record");
			System.out.println("[ D ] - Delete a Record");
			System.out.println("[ R ] - Reports");
			System.out.println("[ X ] - Exit");
			hr('-', 40);
			System.out.print("Enter your choice: ");
			choice = scan.next().toLowerCase().charAt(0);
			scan.nextLine();
			// String pName;
			// String pPheripheral;
			// String assignedTo;

			submenu: switch (choice) {
				case 'a':
					System.out.println("Adding Peripherals.");
					lastgeneratedCode = lastgeneratedCode + 1;
					peripheralData[0] = getCode(lastgeneratedCode);
					System.out.println("Please enter name: ");
					peripheralData[1] = scan.nextLine();
					boolean asentinel = false;
					char perchoice;
					int numOfTries = 0;
					do {
						System.out.println(
								"Please specify if \n(a) Input Device \n(b) Output Device \n(c) Input/Output device");
						perchoice = scan.next().toLowerCase().charAt(0);
						scan.nextLine();
						switch (perchoice) {
							case 'a':
								peripheralData[2] = "Input Device";
								asentinel = true;
								break;
							case 'b':
								peripheralData[2] = "Output Device";
								asentinel = true;
								break;
							case 'c':
								peripheralData[2] = "Input/Output Device";
								asentinel = true;
								break;
							default:
								numOfTries++;
								System.out.println("Wrong choice! " + numOfTries + "/3 attempt made.");
								break;
						}
						if (numOfTries >= 3) {
							System.out.println("You attempted to input wrong choice multiple times. ");
							System.out.println("Adding of peripheral has been cancelled...");
							break submenu;
						}
					} while (!asentinel);

					boolean empsentinel = false;
					int empchoice;
					do {
						System.out.println("Select employee that the peripheral should be assigned: ");
						for (int i = 0; i < empList.length; i++) {
							System.out.println("[ " + i + " ] " + empList[i].getFname() + " " + empList[i].getLname());
						}
						empchoice = scan.nextInt();
						scan.nextLine();
						if (empchoice < 0 || empchoice > empList.length - 1) {
							System.out.println("Employee not found. Peripheral not assigned.");
							peripheralData[3] = "";
							empsentinel = true;
						} else {
							peripheralData[3] = empList[empchoice].getFname() + " " + empList[empchoice].getLname();
							empsentinel = true;
						}

					} while (!empsentinel);

					addElement(peripheralData);
					System.out.println();
					System.out.println(peripheralData[1] + " has been added.");

					break;
				case 'v':
					System.out.println("View Records.");
					// System.out.println(getCode(0001));
					hr('*', 40);
					char vchoice;
					boolean rsentinel = false;
					do {
						System.out.println(
								"Please choose, if you want to \n(a) View all Peripherals \n(b) View available Peripherals \n(c) View not available peripherals"
										+ "\n(d) View all input devices \n(e) View all output devices \n(f) View all input/output devices \n(g) View all employees");
						vchoice = scan.next().toLowerCase().charAt(0);
						scan.nextLine();
						int records = 0;
						switch (vchoice) {
							case 'a':
								hr('=', 118);
								System.out.println("[ ABC - Viewing All Peripherals ]");
								hr('-', 118);
								System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", "Code", "Name", "Peripheral",
										"Assigned To");
								hr('-', 118);

								for (int i = 0; i < count; i++) {
									System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", perList[i].getCode(),
											perList[i].getName(), perList[i].getPeripheral(),
											perList[i].getAssignedTo());
									records++;
								}
								if (records == 0) {
									System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", "No data", "No data",
											"No data",
											"No data");
								}
								hr('-', 118);
								System.out.println("Viewing " + records + " record(s).");
								hr('-', 118);

								// resets the record count for reusing the variable.
								records = 0;
								// set the sentinel value to true
								rsentinel = true;
								break;
							case 'b':
								hr('=', 118);
								System.out.println("Available Peripherals");
								hr('-', 118);
								System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", "Code", "Name", "Peripheral",
										"Assigned To");
								hr('-', 118);
								for (int i = 0; i < count; i++) {
									if (perList[i].getAssignedTo().isEmpty()) {
										System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", perList[i].getCode(),
												perList[i].getName(), perList[i].getPeripheral(),
												perList[i].getAssignedTo());
										records++;
									}

								}
								hr('-', 118);
								System.out.println("Viewing " + records + " record(s).");
								hr('-', 118);

								// resets the record count for reusing the variable.
								records = 0;
								// set the sentinel value to true
								rsentinel = true;
								break;
							case 'c':
								hr('=', 118);
								System.out.println("Not Available Peripherals");
								hr('-', 118);
								System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", "Code", "Name", "Peripheral",
										"Assigned To");
								hr('-', 118);
								for (int i = 0; i < count; i++) {
									if (!perList[i].getAssignedTo().isEmpty()) {
										System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", perList[i].getCode(),
												perList[i].getName(), perList[i].getPeripheral(),
												perList[i].getAssignedTo());
										records++;
									}

								}
								hr('-', 118);
								System.out.println("Viewing " + records + " record(s).");
								hr('-', 118);

								// resets the record count for reusing the variable.
								records = 0;
								// set the sentinel value to true
								rsentinel = true;
								break;
							case 'd':
								hr('=', 118);
								System.out.println("All Input Devices");
								hr('-', 118);
								System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", "Code", "Name", "Peripheral",
										"Assigned To");
								hr('-', 118);
								for (int i = 0; i < count; i++) {
									if (perList[i].getPeripheral().equalsIgnoreCase("Input Device")) {
										records++;
										System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", perList[i].getCode(),
												perList[i].getName(), perList[i].getPeripheral(),
												perList[i].getAssignedTo());
									}

								}
								hr('-', 118);
								System.out.println("Viewing " + records + " record(s).");
								hr('-', 118);

								// resets the record count for reusing the variable.
								records = 0;
								// set the sentinel value to true
								rsentinel = true;
								break;
							case 'e':
								hr('=', 118);
								System.out.println("All Output Devices");
								hr('-', 118);
								System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", "Code", "Name", "Peripheral",
										"Assigned To");
								hr('-', 118);
								for (int i = 0; i < count; i++) {
									if (perList[i].getPeripheral().equalsIgnoreCase("Output Device")) {
										records++;
										System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", perList[i].getCode(),
												perList[i].getName(), perList[i].getPeripheral(),
												perList[i].getAssignedTo());
									}

								}

								hr('-', 118);
								System.out.println("Viewing " + records + " record(s).");
								hr('-', 118);

								// resets the record count for reusing the variable.
								records = 0;
								// set the sentinel value to true
								rsentinel = true;
								break;
							case 'f':
								hr('=', 118);
								System.out.println("Input/Output Devices");
								hr('-', 118);
								System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", "Code", "Name", "Peripheral",
										"Assigned To");
								hr('-', 118);
								for (int i = 0; i < count; i++) {
									if (perList[i].getPeripheral().equalsIgnoreCase("Input/Output Device")) {
										records++;
										System.out.printf("| %-10s | %-35s | %-30s | %-30s | %n", perList[i].getCode(),
												perList[i].getName(), perList[i].getPeripheral(),
												perList[i].getAssignedTo());
									}

								}
								hr('-', 118);
								System.out.println("Viewing " + records + " record(s).");
								hr('-', 118);

								// resets the record count for reusing the variable.
								records = 0;
								// set the sentinel value to true
								rsentinel = true;
								break;
							case 'g':
								hr('=', 85);
								System.out.println("All Employees");
								hr('-', 85);
								System.out.printf("| %-10s | %-35s | %-29s  | %n", "ID", "First Name", "Last Name");
								hr('-', 85);
								for (int i = 0; i < empList.length; i++) {
									System.out.printf("| %-10s | %-35s | %-30s | %n", empList[i].getId(),
											empList[i].getFname(),
											empList[i].getLname());
								}
								hr('-', 85);
								rsentinel = true;
								break;
							default:
								System.out.println("Wrong choice!");
								rsentinel = false;
								break;

						}

					} while (!rsentinel);

					break;
				case 'u':
					// case for updating records
					boolean updatesentinel = false;
					int updatechoice;
					updatesubmenu: do {

						int records = 0;
						hr('=', 127);
						System.out.println("Select a record to Update");
						hr('-', 127);
						System.out.printf("| %-6s | %-10s | %-35s | %-30s | %-30s | %n", "Option", "Code", "Name",
								"Peripheral", "Assigned To");
						hr('-', 127);
						for (int i = 0; i < count; i++) {
							System.out.printf("| %-6d | %-10s | %-35s | %-30s | %-30s | %n", i, perList[i].getCode(),
									perList[i].getName(), perList[i].getPeripheral(), perList[i].getAssignedTo());
							records++;
						}

						hr('-', 127);
						System.out.println("Viewing " + records + " record(s).");
						hr('-', 127);
						records = 0;

						System.out.println("Please choose which peripheral to update:");
						updatechoice = scan.nextInt();
						scan.nextLine();
						if (updatechoice < 0 || updatechoice > count) {
							System.out.println("Wrong input choice.");
						} else {
							System.out.println("You selected " + perList[updatechoice].getName() + " to update.");
							hr('-', 127);
							System.out.println("Peripheral Code " + perList[updatechoice].getCode() + " (auto).");
							hr('-', 127);
							System.out.println("Enter New Name: ");
							String name = scan.nextLine();
							boolean innerupdatesentinel = false;
							int numOfTriesUpdate = 0;
							String type = "Input Device";
							do {
								hr('-', 127);
								System.out.print("Enter Peripheral Type. ");
								System.out.println(
										"Please specify if \n(a) Input Device \n(b) Output Device \n(c) Input/Output device");
								char typechoice = scan.next().toLowerCase().charAt(0);
								scan.nextLine();
								switch (typechoice) {
									case 'a':
										type = "Input Device";
										innerupdatesentinel = true;
										break;
									case 'b':
										type = "Output Device";
										innerupdatesentinel = true;
										break;
									case 'c':
										type = "Input/Output Device";
										innerupdatesentinel = true;
										break;
									default:
										numOfTriesUpdate++;
										System.out.println("Wrong choice! " + numOfTriesUpdate + "/3 attempt made.");
										break;
								}
								if (numOfTriesUpdate >= 3) {
									System.out.println("You attempted to input wrong choice multiple times. ");
									System.out.println("Updating of peripheral has been cancelled...");
									break updatesubmenu;
								}

							} while (!innerupdatesentinel);

							boolean updateempsentinel = false;
							int updateempchoice;
							String assignedTo = "";
							do {
								System.out.println("Select employee that the peripheral should be assigned: ");
								for (int i = 0; i < empList.length; i++) {
									System.out.println(
											"[ " + i + " ] " + empList[i].getFname() + " " + empList[i].getLname());
								}
								updateempchoice = scan.nextInt();
								scan.nextLine();
								if (updateempchoice < 0 || updateempchoice > empList.length - 1) {
									System.out.println("Employee not found. Peripheral not assigned.");
									assignedTo = "";
									updateempsentinel = true;
								} else {
									assignedTo = empList[updateempchoice].getFname() + " "
											+ empList[updateempchoice].getLname();
									updateempsentinel = true;
								}

							} while (!updateempsentinel);

							perList[updatechoice].setName(name);
							perList[updatechoice].setPeripheral(type);
							perList[updatechoice].setAssignedTo(assignedTo);
							System.out.println("Record has been updated.");
							updatesentinel = true;
						}

					} while (!updatesentinel);
					break;
				case 'd':
					// case for record deletion
					boolean deletionsentinel = false;
					int records = 0;
					int deletechoice;
					do {
						hr('=', 127);
						System.out.println("Select a record to Delete");
						hr('-', 127);
						System.out.printf("| %-6s | %-10s | %-35s | %-30s | %-30s | %n", "Option", "Code", "Name",
								"Peripheral", "Assigned To");
						hr('-', 127);
						for (int i = 0; i < count; i++) {
							System.out.printf("| %-6d | %-10s | %-35s | %-30s | %-30s | %n", i, perList[i].getCode(),
									perList[i].getName(), perList[i].getPeripheral(), perList[i].getAssignedTo());
							records++;
						}

						hr('-', 127);
						System.out.println("Viewing " + records + " record(s).");
						hr('-', 127);

						System.out.println("Please choose which peripheral to delete:");
						deletechoice = scan.nextInt();
						scan.nextLine();
						if (deletechoice < 0 || deletechoice > count) {
							System.out.println("Wrong input choice.");
						} else {
							if (!perList[deletechoice].getAssignedTo().isEmpty()) {
								System.out.println("Oops! The peripheral you have chosen is currently assigned to "
										+ perList[deletechoice].getAssignedTo() + ".");
								System.out.println(
										"Would you like to proceed deleting the assigned employee and delete the peripheral record? (Y/N)");
								char deleteconfirm;
								deleteconfirm = scan.next().toLowerCase().charAt(0);
								scan.nextLine();
								switch (deleteconfirm) {
									case 'y':
										perList[deletechoice].setAssignedTo("");
										removeElement(deletechoice);
										System.out.println("Record deleted.");
										count--;
										deletionsentinel = true;
										break;
									case 'n':
										System.out.println("Record deletion has been cancelled.");
										break;
								}
							} else {
								removeElement(deletechoice);
								System.out.println("Record deleted.");
								count--;
								deletionsentinel = true;
							}
						}

						records = 0;

					} while (!deletionsentinel);
					break;
				case 'r':
					hr('=', 60);
					System.out.println("[ Reports ]");
					hr('-', 60);
					// a = # of available, b = # of assigned, c = # of input, d = # of output, e = #
					// of employees.
					System.out.println("Number of available peripherals: " + reportCounts('a'));
					System.out.println("Number of assigned peripherals: " + reportCounts('b'));
					System.out.println("Number of input devices: " + reportCounts('c'));
					System.out.println("Number of output devices: " + reportCounts('d'));
					System.out.println("Number of employees with peripherals assigned: " + reportCounts('e'));
					hr('-', 60);

					break;
				case 'x':
					System.out.println("Thank you for using ABC Inventory System v2.1.2!");
					break;

				default:

					break;
			}

		} while (choice != 'x');

	}

	/*
	 * ======================================================================
	 * Print char for layout hr
	 *
	 * @param char ch character to print
	 * 
	 * @ param int n number of times the char should be printed.
	 * 
	 * @return void
	 * ======================================================================
	 */
	public static void hr(char ch, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(ch);
		System.out.println();
	}

	/*
	 * ======================================================================
	 * Generate code for the peripheral
	 *
	 * @param int lastgenerated basis for the new auto generated value
	 * 
	 * @return String code generated code for the peripheral.
	 * ======================================================================
	 */
	public static String getCode(int lastgenerated) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date date = new Date();
		String code = dateFormat.format(date);

		NumberFormat nf = NumberFormat.getIntegerInstance();
		nf.setGroupingUsed(false);
		nf.setMinimumIntegerDigits(4);

		return code + nf.format(lastgenerated);
	}

	/*
	 * ======================================================================
	 * Increase array size dynamically
	 *
	 * @param
	 * 
	 * @return String code generated code for the peripheral.
	 * ======================================================================
	 */
	public static void increaseArraySize() {
		Peripheral temp[] = null;

		if (count == sizeofarray) {
			temp = new Peripheral[sizeofarray * 2];
			for (int i = 0; i < sizeofarray; i++) {
				temp[i] = perList[i];
			}
		}

		perList = temp;
		sizeofarray = sizeofarray * 2;
	}

	/*
	 * ======================================================================
	 * Adding element to the array.
	 *
	 * @param int lastgenerated basis for the new auto generated value
	 * 
	 * @return String code generated code for the peripheral.
	 * ======================================================================
	 */
	public static void addElement(String[] per) {
		Peripheral p = new Peripheral(per[0], per[1], per[2], per[3]);
		perList[count] = p;
		count++;
	}

	/*
	 * ======================================================================
	 * Removing element from the array.
	 *
	 * @param int lastgenerated basis for the new auto generated value
	 * 
	 * @return String code generated code for the peripheral.
	 * ======================================================================
	 */
	public static void removeElement(int index) {
		Peripheral[] temp = new Peripheral[100];
		for (int i = 0, j = 0; i < count; i++) {
			if (i != index)
				temp[j++] = perList[i];
		}
		perList = temp;
	}

	/*
	 * ======================================================================
	 * Reusable method for counting reports
	 *
	 * @param int lastgenerated basis for the new auto generated value
	 * 
	 * @return String code generated code for the peripheral.
	 * ======================================================================
	 */
	public static int reportCounts(char report) {
		int repcount = 0;

		switch (report) {
			// available peripherals, not assigned to any employee.
			case 'a':
				for (int i = 0; i < count; i++) {
					if (perList[i].getAssignedTo().isEmpty()) {
						repcount++;
					}

				}
				break;
			// unavailable peripherals, assigned to an employee.
			case 'b':
				for (int i = 0; i < count; i++) {
					if (!perList[i].getAssignedTo().isEmpty()) {
						repcount++;
					}

				}
				break;
			// number of input device.
			case 'c':
				for (int i = 0; i < count; i++) {
					if (perList[i].getPeripheral().equalsIgnoreCase("Input Device")) {
						repcount++;
					}

				}
				break;
			// number of output device.
			case 'd':
				for (int i = 0; i < count; i++) {
					if (perList[i].getPeripheral().equalsIgnoreCase("Output Device")) {
						repcount++;
					}

				}
				break;
			// number of input device.
			case 'e':
				int empcount = 0;
				for (int i = 0; i < empList.length; i++) {
					// if(!perList[i].getPeripheral().equalsIgnoreCase("Input Device")){
					// repcount++;
					// }
					for (int j = 0; j < count; j++) {
						String name = empList[i].getFname() + " " + empList[i].getLname();
						if (name.trim().equalsIgnoreCase(perList[j].getAssignedTo().trim())) {
							empcount++;
							break;
						}
					}

				}
				repcount = empcount;
				break;
		}

		return repcount;
	}

}
