import java.util.*;
import java.io.*;
import java.time.*;

public class sample {
	public static void main(String[] manch) {
		Scanner Manching = new Scanner(System.in);
		try {
			FileWriter reservationWriter = new FileWriter("C:/CreateFile/reservation.txt", true);
			File reservation = new File("C:/CreateFile/reservation.txt");
			Scanner reservationReader = new Scanner(reservation);
			FileWriter poolWriter = new FileWriter("C:/CreateFile/pools.txt", true);
			File pools = new File("C:/CreateFile/pools.txt");
			Scanner poolReader = new Scanner(pools);
			FileWriter cottageWriter = new FileWriter("C:/CreateFile/cottage.txt", true);
			File cottage = new File("C:/CreateFile/cottage.txt");
			Scanner cottageScanner = new Scanner(cottage);
			FileWriter roomWriter = new FileWriter("C:/CreateFile/rooms.txt", true);
			File rooms = new File("C:/CreateFile/rooms.txt");
			Scanner roomReader = new Scanner(rooms);
			FileWriter functionWriter = new FileWriter("C:/CreateFile/function.txt", true);
			File function = new File("C:/CreateFile/function.txt");
			Scanner functionReader = new Scanner(function);
			LocalDate reservationgDate = LocalDate.now();
			System.out.println("-----Add Reservation-----");
			String reservationAmenitiesChoice = "";
			boolean found;
			int reservationNumber = 0, reservationDate = 0, reservationPeriod = 0, reservationStatus = 0,
					reservationChoice = 0;
			String reservationClientName = "", reservationClientAddress = "", reservationClientContactNum = "";
			double SumReservationPrice = 0;
			ArrayList<String> allAmenitiesReserved = new ArrayList<>();
			do {
				Manching = new Scanner(System.in);
				try {
					System.out.print("Enter Reservation Number: ");
					reservationNumber = Manching.nextInt();
				} catch (Exception e) {
				}
				if (reservationNumber <= 0) {
					System.out.println("Invalid Input!");
				}
			} while (reservationNumber <= 0);
			Manching = new Scanner(System.in);
			do {
				System.out.print("Enter Client Name: ");
				reservationClientName = Manching.nextLine();
			} while (reservationClientName.isBlank());
			do {
				System.out.print("Enter Client Address: ");
				reservationClientAddress = Manching.nextLine();
			} while (reservationClientAddress.isBlank());
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
					Scanner scan = new Scanner(rooms);
					ArrayList<String> allRoomNumbers = new ArrayList<String>();
					rooms = new File("C:/CreateFile/rooms.txt");
					roomReader = new Scanner(rooms);
					found = false;
					System.out.println("Available Rooms:");
					System.out.println("|\tRoom Number\t|\tRoom type\t|\tRoom Price\t|\tStatus\t|");
					System.out.println(
							"----------------------------------------------------------------------------------------------");
					while (roomReader.hasNextLine()) {
						String[] details = new String[4];
						details = roomReader.nextLine().split(";");
						allRoomNumbers.add(details[0]);
						System.out.println("|\t" + details[0] + "\t\t|\t" + details[1] + "\t\t|\t" + details[2]
								+ "\t\t|\t" + details[3] + "\t|");
					}
					String roomNumberReserve = "";
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
					while (scan.hasNextLine()) {
						String[] details = new String[4];
						details = scan.nextLine().split(";");
						if (roomNumberReserve.equals(details[0])) {
							allAmenitiesReserved
									.add(details[0] + ":" + details[1] + ":" + details[2] + ":" + details[3] + ",");
							SumReservationPrice += (Double.parseDouble(details[2]));
						}
					}
					roomReader.close();
					break;
				case 2:
					scan = new Scanner(cottage);
					found = false;
					cottage = new File("C:/CreateFile/cottage.txt");
					cottageScanner = new Scanner(cottage);
					ArrayList<String> allCottageNumbers = new ArrayList<String>();
					System.out.println("Available Cottage:");
					System.out.println("|\tCottage Number\t|\tCottage type\t|\tCottage Price\t|\tStatus\t|");
					System.out.println(
							"----------------------------------------------------------------------------------------------");
					while (functionReader.hasNextLine()) {
						String[] details = new String[4];
						details = functionReader.nextLine().split(";");
						allCottageNumbers.add(details[0]);
						System.out.println("|\t" + details[0] + "\t\t|\t" + details[1] + "\t\t|\t" + details[2]
								+ "\t\t|\t" + details[3] + "\t|");
					}
					String cottageNumberReserve = "";
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
					while (scan.hasNextLine()) {
						String[] details = new String[4];
						details = scan.nextLine().split(";");
						if (cottageNumberReserve.equals(details[0])) {
							allAmenitiesReserved
									.add(details[0] + ":" + details[1] + ":" + details[2] + ":" + details[3] + ",");
							SumReservationPrice += (Double.parseDouble(details[2]));
						}
					}
					break;
				case 3:
					scan = new Scanner(function);
					found = false;
					function = new File("C:/CreateFile/function.txt");
					functionReader = new Scanner(function);
					ArrayList<String> allFunctionNumbers = new ArrayList<String>();
					System.out.println("Available Function Halls:");
					System.out.println(
							"|\tFunction Hall Number\t|\tFunction Hall type\t|\tFunction Hall Price\t|\tStatus\t|");
					System.out.println(
							"--------------------------------------------------------------------------------------------------------------------");
					while (functionReader.hasNextLine()) {
						String[] details = new String[4];
						details = functionReader.nextLine().split(";");
						allFunctionNumbers.add(details[0]);
						System.out.println("|\t" + details[0] + "\t\t\t|\t" + details[1] + "\t\t\t|\t" + details[2]
								+ "\t\t\t|\t" + details[3] + "\t|");
					}
					String funcNumberReserve = "";
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
					while (scan.hasNextLine()) {
						String[] details = new String[4];
						details = scan.nextLine().split(";");
						if (funcNumberReserve.equals(details[0])) {
							allAmenitiesReserved
									.add(details[0] + ":" + details[1] + ":" + details[2] + ":" + details[3] + ",");
							SumReservationPrice += (Double.parseDouble(details[2]));
						}
					}
					break;
				case 4:
					scan = new Scanner(pools);
					found = false;
					pools = new File("C:/CreateFile/pools.txt");
					poolReader = new Scanner(pools);
					ArrayList<String> allPoolNumbers = new ArrayList<String>();
					System.out.println("Available Pools:");
					System.out.println("|\tPool Number\t|\tPool type\t|\tPool Price\t|\tStatus\t|");
					System.out.println(
							"--------------------------------------------------------------------------------------------------------------------");
					while (poolReader.hasNextLine()) {
						String[] details = new String[4];
						details = poolReader.nextLine().split(";");
						allPoolNumbers.add(details[0]);
						System.out.println("|\t" + details[0] + "\t\t|\t" + details[1] + "\t\t|\t" + details[2]
								+ "\t\t|\t" + details[3] + "\t|");
					}
					String poolNumberReserve = "";
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
					while (scan.hasNextLine()) {
						String[] details = new String[4];
						details = scan.nextLine().split(";");
						if (poolNumberReserve.equals(details[0])) {
							allAmenitiesReserved
									.add(details[0] + ":" + details[1] + ":" + details[2] + ":" + details[3] + ",");
							SumReservationPrice += (Double.parseDouble(details[2]));
						}
					}
					break;
				default:
					break;
				}
				if (SumReservationPrice > 0) {
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
				try {
					System.out.println("---Reservation Period---\n1 = Day tour\n2 = Overnight");
					System.out.print("Enter Reservation Period: ");
					reservationPeriod = Manching.nextInt();
				} catch (Exception e) {
				}
				if (reservationPeriod <= 0 || reservationPeriod > 2) {
					System.out.println("Invalid Input!");
				}
			} while (reservationPeriod <= 0 || reservationPeriod > 2);
			int reservePayment = 0;
			do {
				Manching = new Scanner(System.in);
				try {
					System.out.println("1 = Partial");
					System.out.println("2 = Full payment");
					System.out.print("Choose payment Status: ");
					reservePayment = Manching.nextInt();
				} catch (Exception e) {
				}
				if (reservePayment >= 0 || reservePayment > 2) {
					System.out.println("Invalid Input!");
				}

			} while (reservePayment >= 0 || reservePayment > 2);
			do {
				Manching = new Scanner(System.in);
				try {
					System.out.println("---Reservation Status---\n1 = Booked\n2 = Done\n3 = Cancelled");
					System.out.print("Enter Reservation Period: ");
					reservationStatus = Manching.nextInt();
				} catch (Exception e) {
				}
				if (reservationStatus <= 0 || reservationStatus > 3) {
					System.out.println("Invalid Input!");
				}
			} while (reservationStatus <= 0 || reservationStatus > 3);
			String allreserved = "";
			for (int i = 0; i < allAmenitiesReserved.size(); i++) {
				allreserved += allAmenitiesReserved.get(i);
			}
			reservationWriter.write(reservationNumber + ";" + reservationClientName + ";" + reservationClientAddress
					+ ";" + reservationgDate + ";" + allreserved + ";" + SumReservationPrice + ";" + reservePayment
					+ ";" + reservationPeriod + ";" + reservationStatus + "\n");
			reservationWriter.close();
			System.out.println("Successfully Added Reservation.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
