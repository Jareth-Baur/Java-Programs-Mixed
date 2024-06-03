import java.util.*;
import java.io.*;
import java.time.*;

public class reservationPractice {
	public static void main(String[] manch) {

		try {
			Scanner Manching = new Scanner(System.in);
			boolean login = false;
			do {
				FileWriter roomWriter = new FileWriter("C:/CreateFile/Finals/rooms.txt", true);
				File rooms = new File("C:/CreateFile/Finals/rooms.txt");
				Scanner roomReader = new Scanner(rooms);
				LocalDate localDate = LocalDate.now();
				int choice = 0;
				if (login == false) {
					try {
						Manching = new Scanner(System.in);
						System.out.println("**Welcome to Booking/Reservation**");
						System.out.println("1=Add Rooms");
						System.out.println("2=Edit Rooms");
						System.out.println("3=Exit");
						System.out.print("Please enter your choice: ");
						choice = Manching.nextInt();
						System.out.println();

					} catch (Exception e) {
						System.out.println(e);
					}
				}

				if (login == false) {
					switch (choice) {
					case 1:
						int room = 0, type = 0, status = 0, room1 = 0;
						String name = "", size = "", stat = "", type1 = "";
						double price = 0.00;

						System.out.println("--Adding Rooms---");
						do {
							Manching = new Scanner(System.in);
							try {
								System.out.print("Enter Room ID: ");
								room = Manching.nextInt();

							} catch (Exception e) {
								System.out.println(e);
							}
							if (room < 0) {
								System.out.println("Invalid Room ID");
							}
						} while (room < 0);

						Manching = new Scanner(System.in);
						try {
							System.out.print("Enter Room Name: ");
							name = Manching.nextLine();

						} catch (Exception e) {
							System.out.println(e);
						}

						Manching = new Scanner(System.in);
						try {
							System.out.print("Enter Room size (Single, Double, Family): ");
							size = Manching.nextLine();

						} catch (Exception e) {
							System.out.println(e);
						}

						do {
							Manching = new Scanner(System.in);
							try {
								System.out.print("Enter Room type (1=Airconditioned, 2=Non-Aircon): ");
								type = Manching.nextInt();

							} catch (Exception e) {
								System.out.println(e);
							}
							if (type <= 0 || type > 2) {
								System.out.println("Invalid Room ID");
							}
							if (type == 1) {
								type1 = "Airconditioned";
							}
							if (type == 2) {
								type1 = "Non-Aircon";
							}
						} while (type <= 0 || type > 2);

						do {
							Manching = new Scanner(System.in);
							try {
								if (type == 1) {
									System.out.print("Room price for Airconditioned Room: ");
									price = Manching.nextDouble();
								}
								if (type == 2) {
									System.out.print("Room price for Non-Airconditioned Room: ");
									price = Manching.nextDouble();
								}

							} catch (Exception e) {
								System.out.println(e);
							}
							if (type <= 0 || type > 2) {
								System.out.println("Invalid Room ID");
							}
						} while (type <= 0 || type > 2);

						do {
							Manching = new Scanner(System.in);
							try {
								System.out.print("Enter Room Status (1=Available, 2=Booked), 3=Under Repair): ");
								status = Manching.nextInt();

							} catch (Exception e) {
								System.out.println(e);
							}
							if (status <= 0 || status > 3) {
								System.out.println("Invalid Room Status");
							}
							if (status == 1) {
								stat = "Available";
							}
							if (status == 2) {
								stat = "Booked";
							}
							if (status == 3) {
								stat = "Under Repair";
							}
						} while (status <= 0 || status > 3);

						roomWriter.write(room + ";" + name + ";" + size + ";" + type + "(" + type1 + ")" + ";" + price
								+ ";" + stat + "\n");
						roomWriter.close();
						System.out.println("Adding Room Successfully!");
						System.out.println();

						break;

					case 2:
						Scanner roomEdit = new Scanner(rooms);
						roomReader = new Scanner(rooms);
						room = 0;
						type = 0;
						status = 0;
						room1 = 0;
						name = "";
						type1 = "";
						size = "";
						stat = "";
						price = 0.00;

						System.out.println("---Edit Rooms---");
						boolean found = false;

						ArrayList<String> tempRoomDetails = new ArrayList<String>();

						while (roomEdit.hasNextLine()) {
							tempRoomDetails.add(roomEdit.nextLine());
						}

						Manching = new Scanner(System.in);
						System.out.print("Enter room number to edit details: ");
						String roomEditSearch = Manching.nextLine();
						roomEdit = new Scanner(rooms);
						while (roomEdit.hasNextLine()) {
							String[] details = new String[6];
							String data = roomEdit.nextLine();
							details = data.split(";");

							if (roomEditSearch.equals(details[0])) {
								found = true;
								System.out.println("Room ID: " + details[0]);
								System.out.println("Room Name: " + details[1]);
								System.out.println("Room Size: " + details[2]);
								System.out.println("Room Type: " + details[3]);
								System.out.println("Room Price: " + details[4]);
								System.out.println("Room Status: " + details[5]);
							}
						}

						if (found) {
							do {
								Manching = new Scanner(System.in);
								try {
									System.out.print("Enter new room ID: ");
									room = Manching.nextInt();

								} catch (Exception e) {
									System.out.println(e);
								}
								if (room < 0) {
									System.out.println("Invalid new room ID");
								}
							} while (room < 0);

							Manching = new Scanner(System.in);
							try {
								System.out.print("Enter new Room Name: ");
								name = Manching.nextLine();

							} catch (Exception e) {
								System.out.println(e);
							}

							Manching = new Scanner(System.in);
							try {
								System.out.print("Enter new Room size (Single, Double, Family): ");
								size = Manching.nextLine();

							} catch (Exception e) {
								System.out.println(e);
							}

							do {
								Manching = new Scanner(System.in);
								try {
									System.out.print("Enter new oom type (1=Airconditioned, 2=Non-Aircon): ");
									type = Manching.nextInt();

								} catch (Exception e) {
									System.out.println(e);
								}
								if (type <= 0 || type > 2) {
									System.out.println("Invalid new room ID");
								}
								if (type == 1) {
									type1 = "Airconditioned";
								}
								if (type == 2) {
									type1 = "Non-Aircon";
								}
							} while (type <= 0 || type > 2);

							do {
								Manching = new Scanner(System.in);
								try {
									if (type == 1) {
										System.out.print("Enter new room price for Airconditioned Room: ");
										price = Manching.nextDouble();
									}
									if (type == 2) {
										System.out.print("Enter new room price for Non-Airconditioned Room: ");
										price = Manching.nextDouble();
									}

								} catch (Exception e) {
									System.out.println(e);
								}
								if (type <= 0 || type > 2) {
									System.out.println("Invalid new room ID");
								}
							} while (type <= 0 || type > 2);

							do {
								Manching = new Scanner(System.in);
								try {
									System.out
											.print("Enter new room Status (1=Available, 2=Booked), 3=Under Repair): ");
									status = Manching.nextInt();

								} catch (Exception e) {
									System.out.println(e);
								}
								if (status <= 0 || status > 3) {
									System.out.println("Invalid new room Status");
								}
								if (status == 1) {
									stat = "Available";
								}
								if (status == 2) {
									stat = "Booked";
								}
								if (status == 3) {
									stat = "Under Repair";
								}
							} while (status <= 0 || status > 3);

							FileWriter roomEditWriter = new FileWriter("C:/CreateFile/Finals/rooms.txt");
							for (int i = 0; i < tempRoomDetails.size(); i++) {
								String[] details2 = new String[6];
								details2 = tempRoomDetails.get(i).split(";");

								if (roomEditSearch.equalsIgnoreCase(details2[0])) {
									roomEditWriter.write(room + ";" + name + ";" + size + ";" + type + "(" + type1 + ")"
											+ ";" + price + ";" + stat + "\n");
								} else {
									roomEditWriter.write(tempRoomDetails.get(i) + "\n");
								}
							}
							roomEditWriter.close();
							System.out.println("You edit Successfully!");

						} else {
							System.out.println("Incorrect room number");
						}
						break;

					case 3:
						System.out.println("Exiting/Logout");
						System.exit(0);
						break;

					default:
						System.out.println("Please enter 1,2 or 3 only");

					}
				}
			} while (true);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}