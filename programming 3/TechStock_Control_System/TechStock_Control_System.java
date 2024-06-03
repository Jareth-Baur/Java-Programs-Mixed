import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class TechStock_Control_System {
	private static int currentYear = LocalDate.now().getYear(), currentCode = 1;
	private static String ln = "-----------------------------------------------------------------------------------";
	private static Scanner mainScanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException{
		try {
			FileWriter mainFile = new FileWriter("c:/inventory/inventory.txt", true);
			do {
				String choice = "";
				System.out.println(
						"------------------------------------\n      Inventory System Menu\n------------------------------------");
				System.out.println(
						"1. Add Peripheral\n2. View Record\n3. Edit Record\n4. Delete Record\n5. Generate Report\n6. Exit\n------------------------------------");
				System.out.print("Please enter your choice: ");
				choice = mainScanner.nextLine();
				switch (choice) {
				case "1":
					add();
					break;
				case "2":
					view();
					break;
				case "3":
					edit();
					break;
				case "4":
					delete();
					break;
				case "5":
					report();
					break;
				case "6":
					System.out.println("Exiting...");
					System.exit(1000);
					break;
				default:
					System.out.println("Invalid Input. Please try again.");
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println("An Error Occured While Running The System.\n" + e);
		}
	}

	private static void add() {
		try {
			FileWriter allPeripherals = new FileWriter("c:/inventory/inventory.txt", true);
			File inventory = new File("c:/inventory/inventory.txt");
			Scanner inventoryScanner = new Scanner(inventory);
			System.out.println("-----ADD NEW PHERIPHERAL-----");
			String hardwareName = "", peripheralKind = "", employeeName = "";
			do {
				mainScanner = new Scanner(System.in);
				System.out.print("Enter the PC hardware: ");
				hardwareName = mainScanner.nextLine().trim();
				if (hardwareName.equalsIgnoreCase("cancel")) {
					System.out.println("Cancelled");
					return;
				}
				if (containsSpecialCharacters(hardwareName)) {
					System.out.println("Invalid Name.Please try again.");
				}
			} while (containsSpecialCharacters(hardwareName));
			System.out.println("-----Peripheral Type-----");
			System.out.println("1. Input\n2. Output\n3. Input & Output");
			do {
				mainScanner = new Scanner(System.in);
				System.out.print("Enter peripheral type (1-3): ");
				String input = mainScanner.nextLine();
				if (input.equalsIgnoreCase("cancel")) {
					System.out.println("Cancelled");
					return;
				}
				if (input.matches("[1-3]")) {
					if (input.equals("1")) {
						peripheralKind = "input";
					}
					if (input.equals("2")) {
						peripheralKind = "output";
					}
					if (input.equals("3")) {
						peripheralKind = "input&output";
					}
					break;
				}
				System.out.println("Invalid Peripheral Kind. Please try again.");
			} while (true);
			do {
				mainScanner = new Scanner(System.in);
				System.out.print("Enter name of employee to assign: ");
				employeeName = mainScanner.nextLine().trim();
				if (employeeName.equalsIgnoreCase("cancel")) {
					System.out.println("Cancelled");
					return;
				}
				if (employeeName.isBlank()) {
					break;
				}
			} while (containsSpecialCharacters(employeeName));
			while (inventoryScanner.hasNextLine()) {
				String[] data = new String[4];
				String temp = inventoryScanner.nextLine();
				data = temp.split(";");
				currentCode++;
			}
			if (employeeName.isBlank()) {
				employeeName = "Unassigned";
			}
			String formatedCode = String.format("%04d", currentCode);
			String code = currentYear + "-" + formatedCode;
			allPeripherals.write(code + ";" + hardwareName + ";" + peripheralKind + ";" + employeeName + "\n");
			allPeripherals.close();
			System.out.println("Peripheral successfully added.");
		} catch (Exception e) {
			System.out.println("An Error Occured While Running The System.\n" + e);
		}
	}

	private static void view() {
		boolean viewEnd;
		try {
			File inventory = new File("c:/inventory/inventory.txt");
			Scanner inventoryScanner = new Scanner(inventory);
			ArrayList<String> unAssigned = new ArrayList<>();
			ArrayList<String> assigned = new ArrayList<>();
			ArrayList<String> input = new ArrayList<>();
			ArrayList<String> output = new ArrayList<>();
			ArrayList<String> inAndOut = new ArrayList<>();
			ArrayList<String> allEmployees = new ArrayList<>();
			while (inventoryScanner.hasNextLine()) {
				String[] data = new String[4];
				String line = inventoryScanner.nextLine();
				data = line.split(";");
				if (!data[3].equalsIgnoreCase("unassigned")) {
					allEmployees.add(data[3]);
					assigned.add(data[1]);
				}
				if (data[3].equalsIgnoreCase("unassigned")) {
					unAssigned.add(data[1]);
				}
				if (data[2].equalsIgnoreCase("input")) {
					input.add(data[1]);
				} else if (data[2].equalsIgnoreCase("output")) {
					output.add(data[1]);
				} else if (data[2].equalsIgnoreCase("input&output")) {
					inAndOut.add(data[1]);
				}
			}
			do {
				viewEnd = true;
				System.out.print(
						"\n------------------------------------\n            View Record\n------------------------------------\n");
				System.out.println(
						"1. View all peripherals\n2. View available peripherals\n3. View not available peripherals\n4. View all input devices\n5. View all output devices\n6. View all input/output devices\n7. View all employees\n8. Back to menu");
				System.out.print("Please enter your choice: ");
				String choice = mainScanner.nextLine();
				switch (choice) {
				case "1":
					System.out.println("Viewing All Peripherals:");
					System.out.printf("| %-10s | %-20s | %-20s | %-20s |\n", "Code", "Name", "Type", "Assigned To");
					System.out.println(ln);
					inventoryScanner = new Scanner(inventory);
					while (inventoryScanner.hasNextLine()) {
						String[] data = new String[4];
						String line = inventoryScanner.nextLine();
						data = line.split(";");
						System.out.printf("| %-10s | %-20s | %-20s | %-20s |\n", data[0], data[1], data[2], data[3]);
					}
					System.out.println(ln);
					break;
				case "2":
					System.out.println("\n-----------------------\nUnassigned Peripherals: ");
					for (int i = 0; i < unAssigned.size(); i++) {
						System.out.print(unAssigned.get(i) + ", ");
					}
					if (unAssigned.isEmpty()) {
						System.out.println("All peripherals have been assigned.");
					}
					break;
				case "3":
					System.out.println("\n-----------------------\nAssigned Peripherals: ");
					for (int i = 0; i < assigned.size(); i++) {
						System.out.print(assigned.get(i) + ", ");
					}
					if (assigned.isEmpty()) {
						System.out.println("There are currently no assigned peripherals.");
					}
					break;
				case "4":
					System.out.println("\n-----------------------\nInput Devices: ");
					for (int i = 0; i < input.size(); i++) {
						System.out.print(input.get(i) + ", ");
					}
					if (input.isEmpty()) {
						System.out.println("There are no input devices from the inventory.");
					}
					break;
				case "5":
					System.out.println("\n-----------------------\nOutput Devices: ");
					for (int i = 0; i < output.size(); i++) {
						System.out.print(output.get(i) + ", ");
					}
					if (output.isEmpty()) {
						System.out.println("There are no output devices listed.");
					}
					break;
				case "6":
					System.out.println("\n-----------------------\nInput & Output Devices: ");
					for (int i = 0; i < inAndOut.size(); i++) {
						System.out.print(inAndOut.get(i) + ", ");
					}
					if (inAndOut.isEmpty()) {
						System.out.println("Currently, there are no input/output devices available.");
					}
					break;
				case "7":
					System.out.println("\n-----------------------\nAll Employees: ");
					for (int i = 0; i < allEmployees.size(); i++) {
						System.out.print(allEmployees.get(i) + ", ");
					}
					if (allEmployees.isEmpty()) {
						System.out.println("No employees have been assigned to any peripherals yet.");
					}
					break;
				case "8":
					viewEnd = false;
					break;

				default:
					System.out.println("Invalid input! Please try again.");
					break;
				}

			} while (viewEnd);
			System.out.println();
		} catch (Exception e) {
			System.out.println("An Error Occured While Running The System.\n" + e);
		}
	}

	private static void edit() {
		System.out.println("-----EDIT RECORD-----");
		try {
			File inventory = new File("c:/inventory/inventory.txt");
			Scanner inventoryScanner = new Scanner(inventory);
			System.out.println("Existing Peripherals:");
			System.out.printf("| %-10s | %-20s | %-20s | %-20s |\n", "Code", "Name", "Type", "Assigned To");
			System.out.println(ln);
			while (inventoryScanner.hasNextLine()) {
				String[] data = new String[4];
				String line = inventoryScanner.nextLine();
				data = line.split(";");
				System.out.printf("| %-10s | %-20s | %-20s | %-20s |\n", data[0], data[1], data[2], data[3]);
			}
			System.out.print(ln + "\nEnter code you want to edit: ");
			String codeInput = mainScanner.nextLine();
			if (codeInput.equalsIgnoreCase("cancel")) {
				System.out.println("Editing cancelled");
				return;
			}
			String choice = "";
			ArrayList<String> tempRecord = new ArrayList<>();
			inventoryScanner = new Scanner(inventory);
			while (inventoryScanner.hasNextLine()) {
				String[] data = new String[4];
				String line = inventoryScanner.nextLine();
				tempRecord.add(line);
				data = line.split(";");
				if (codeInput.equalsIgnoreCase(data[0])) {
					System.out.println("Code: " + data[0]);
					System.out.println("Name: " + data[1]);
					System.out.println("Type: " + data[2]);
					System.out.println("Assigned To: " + data[3] + "\n");
					System.out.println("Are you sure you want to edit this record?");
					do {
						mainScanner = new Scanner(System.in);
						System.out.print("Y for yes | N for no: ");
						choice = mainScanner.nextLine().trim();
						if (choice.equalsIgnoreCase("cancel")) {
							System.out.println("Editing cancelled");
							return;
						}
						if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
							System.out.println("Invalid Input. Please try again.");
						}
					} while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));
				}
			}
			if (choice.isBlank()) {
				System.out.println("No peripheral found with the entered code.");
			}
			if (choice.equalsIgnoreCase("y")) {
				String newHardwareName = "", newPeripheralKind = "", newEmployeeName = "";
				do {
					mainScanner = new Scanner(System.in);
					System.out.print("Enter the PC hardware: ");
					newHardwareName = mainScanner.nextLine().trim();
					if (newHardwareName.equalsIgnoreCase("cancel")) {
						System.out.println("Editing cancelled");
						return;
					}
					if (containsSpecialCharacters(newHardwareName)) {
						System.out.println("Invalid Name.Please try again.");
					}
				} while (containsSpecialCharacters(newHardwareName) || newHardwareName.isEmpty());
				System.out.println("-----Peripheral Type-----");
				System.out.println("1. Input\n2. Output\n3. Input & Output");
				do {
					mainScanner = new Scanner(System.in);
					System.out.print("Enter peripheral type (1-3): ");
					String input = mainScanner.nextLine();
					if (input.equalsIgnoreCase("cancel")) {
						System.out.println("Editing cancelled");
						return;
					}
					if (input.matches("[1-3]")) {
						if (input.equals("1")) {
							newPeripheralKind = "input";
						}
						if (input.equals("2")) {
							newPeripheralKind = "output";
						}
						if (input.equals("3")) {
							newPeripheralKind = "input&output";
						}
						break;
					}
					System.out.println("Invalid Peripheral Kind. Please try again.");
				} while (true);
				do {
					mainScanner = new Scanner(System.in);
					System.out.print("Enter name of employee to assign: ");
					newEmployeeName = mainScanner.nextLine().trim();
					if (newEmployeeName.equalsIgnoreCase("cancel")) {
						System.out.println("Editing cancelled");
						return;
					}
					if (newEmployeeName.isBlank()) {
						break;
					}
				} while (containsSpecialCharacters(newEmployeeName));
				choice = "";
				System.out.println("Are you sure you want to save this new record?");
				do {
					mainScanner = new Scanner(System.in);
					System.out.print("Y for yes | N for no: ");
					choice = mainScanner.nextLine().trim();
					if (choice.equalsIgnoreCase("cancel")) {
						System.out.println("Editing cancelled");
						return;
					}
					if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
						System.out.println("Invalid Input. Please try again.");
					}
				} while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));
				if (choice.equalsIgnoreCase("y")) {
					FileWriter editRecord = new FileWriter("c:/inventory/inventory.txt");
					int newCode = 1;
					for (int i = 0; i < tempRecord.size(); i++) {
						String[] data = new String[4];
						data = tempRecord.get(i).split(";");
						String newCode2 = currentYear + "-" + newCode + "";
						if (data[0].equalsIgnoreCase(codeInput)) {
							editRecord.write(data[0] + ";" + newHardwareName + ";" + newPeripheralKind + ";"
									+ newEmployeeName + "\n");
						} else {
							editRecord.write(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + "\n");
						}
					}
					editRecord.close();
					System.out.println("Peripheral edited successfully.");
				} else {
					System.out.println("Editing Cancelled.");
					return;
				}
			} else {
				System.out.println("Editing Cancelled.");
			}
		} catch (Exception e) {
			System.out.println("An Error Occured While Running The System.\n" + e);
		}
	}

	private static void delete() {
		System.out.println(
				"------------------------------------\n            DELETE RECORD\n------------------------------------");
		try {
			File inventory = new File("c:/inventory/inventory.txt");
			Scanner inventoryScanner = new Scanner(inventory);
			System.out.println("Existing Peripherals:");
			System.out.printf("| %-10s | %-20s | %-20s | %-20s |\n", "Code", "Name", "Type", "Assigned To");
			System.out.println(ln);
			while (inventoryScanner.hasNextLine()) {
				String[] data = new String[4];
				String line = inventoryScanner.nextLine();
				data = line.split(";");
				System.out.printf("| %-10s | %-20s | %-20s | %-20s |\n", data[0], data[1], data[2], data[3]);
			}
			System.out.print(ln + "\nEnter code you want to delete: ");
			String codeInput = mainScanner.nextLine();
			if (codeInput.equalsIgnoreCase("cancel")) {
				System.out.println("Deletion Cancelled");
			}
			String choice = "";
			ArrayList<String> tempRecord = new ArrayList<>();
			inventoryScanner = new Scanner(inventory);
			while (inventoryScanner.hasNextLine()) {
				String[] data = new String[4];
				String line = inventoryScanner.nextLine();
				tempRecord.add(line);
				data = line.split(";");
				if (codeInput.equalsIgnoreCase(data[0])) {
					System.out.println("Code: " + data[0]);
					System.out.println("Name: " + data[1]);
					System.out.println("Type: " + data[2]);
					System.out.println("Assigned To: " + data[3] + "\n");
					System.out.println("Are you sure you want to delete this record? This will be removed forever.");
					do {
						mainScanner = new Scanner(System.in);
						System.out.print("Y for yes | N for no: ");
						choice = mainScanner.nextLine().trim();
						if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
							System.out.println("Invalid Input. Please try again.");
						}
					} while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));
				}
			}
			if (choice.isBlank()) {
				System.out.println("No peripheral found with the entered code.");
				return;
			}
			if (choice.equalsIgnoreCase("y")) {
				FileWriter deleteRecord = new FileWriter("c:/inventory/inventory.txt");
				int newCode = 1;
				for (int i = 0; i < tempRecord.size(); i++) {
					String[] data = new String[4];
					data = tempRecord.get(i).split(";");
					String formatedCode = String.format("%04d", newCode);
					String newCode2 = currentYear + "-" + formatedCode;
					if (!data[0].equalsIgnoreCase(codeInput)) {
						deleteRecord.write(newCode2 + ";" + data[1] + ";" + data[2] + ";" + data[3] + "\n");
						newCode++;
					}
				}
				deleteRecord.close();
				System.out.println("Successfully deleted record.");
			} else {
				System.out.println("Deletion Cancelled.");
			}
		} catch (Exception e) {
			System.out.println("An Error Occured While Running The System.\n" + e);
		}
	}

	private static void report() {
		System.out.println(
				"------------------------------------\n              REPORT\n------------------------------------");
		try {
			File inventory = new File("c:/inventory/inventory.txt");
			Scanner inventoryScanner = new Scanner(inventory);
			int[] report = new int[5];
			while (inventoryScanner.hasNextLine()) {
				String string = inventoryScanner.nextLine();
				String[] data = new String[4];
				data = string.split(";");
				if (data[3].equalsIgnoreCase("unassigned")) {
					report[0]++;
				}
				if (data[2].equalsIgnoreCase("input")) {
					report[1]++;
				}
				if (data[2].equalsIgnoreCase("output")) {
					report[2]++;
				}
				if (data[2].equalsIgnoreCase("input&output")) {
					report[3]++;
				}
				if (!data[3].equalsIgnoreCase("unassigned")) {
					report[4]++;
				}
			}
			System.out.println("Number of available peripherals: " + report[0]);
			System.out.println("Number of Input devices: " + report[1]);
			System.out.println("Number of Output devices: " + report[2]);
			System.out.println("Number of Input & Output devices: " + report[3]);
			System.out.println("Number of Employees with peripherals assigned: " + report[4]);
		} catch (Exception e) {
			System.out.println("An Error Occured While Running The System.\n" + e);
		}
	}

	private static boolean containsSpecialCharacters(String name) {
		return !name.matches("[a-zA-Z ]+");
	}
}
