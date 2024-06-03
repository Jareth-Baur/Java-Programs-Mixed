import java.util.*;
import java.io.*;
import java.time.*;

public class POS {
	public static void main(String[] pos) {
		try {
			boolean loginSuccess = false, nameFound = true, noProductFound = true;
			boolean signUp = false;
			LocalDate localdate = LocalDate.now();
			do {
				FileWriter myWriter = new FileWriter("C:/Bacala/product.txt", true);
				FileWriter myWriterP = new FileWriter("C:/Bacala/purchase.txt", true);
				FileWriter myUsers = new FileWriter("C:/Bacala/users.txt", true);
				File login = new File("C:/Bacala/users.txt");
				Scanner in = new Scanner(System.in);
				File myObj = new File("C:/Bacala/product.txt");
				Scanner myReader = new Scanner(myObj);
				ArrayList<String> allProductNumber = new ArrayList<>();
				ArrayList<String> allProductName = new ArrayList<>();
				Scanner duplicate = new Scanner(myObj);
				while (duplicate.hasNextLine()) {
					String[] details = new String[7];
					String data = duplicate.nextLine();
					details = data.split(";");
					allProductNumber.add(details[0]);
					allProductName.add(details[1]);
				}
				int choice1 = 0, signUp2 = 0;
				if (!loginSuccess) {
					do {
						in = new Scanner(System.in);
						try {
							System.out.println("1 = Login\n2 = Signup\n3 = Exit");
							System.out.print("Enter Choice: ");
							choice1 = in.nextInt();
						} catch (Exception e) {
						}
						if (choice1 <= 0 || choice1 > 3) {
							System.out.println("Invalid Input! Please Enter fron 1 to 3 only.");
						}
					} while (choice1 <= 0 || choice1 > 3);
				}
				if (loginSuccess == false) {

					switch (choice1) {
					case 1:
						Scanner loginReader = new Scanner(login);
						String uname = "", pword = "";
						if (loginSuccess == false) {
							System.out.println("---------------------");
							System.out.println("|     LOGIN FORM    |");
							System.out.println("---------------------");
							do {
								in = new Scanner(System.in);
								System.out.print("Username: ");
								uname = in.nextLine();
							} while (uname.isBlank());
							do {
								System.out.print("Password: ");
								pword = in.nextLine();
							} while (pword.isBlank());
						}
						while (loginReader.hasNextLine()) {
							String[] details = new String[3];
							String data = loginReader.nextLine();
							details = data.split(";");
							if (uname.equals(details[1]) && pword.equals(details[2])) {
								loginSuccess = true;
								break;
							}
						}
						break;
					case 2:
						String sname = "", name = "", word = "";
						File signUpFile = new File("C:/Bacala/users.txt");
						Scanner signUpScanner = new Scanner(signUpFile);
						ArrayList<String> allUserName = new ArrayList<String>();
						while (signUpScanner.hasNextLine()) {
							String[] details = new String[3];
							String data = signUpScanner.nextLine();
							details = data.split(";");
							allUserName.add(details[1]);
						}
						do {
							in = new Scanner(System.in);
							System.out.print("FullName: ");
							sname = in.nextLine();
							if (sname.isBlank()) {
								System.out.println("Empty space failed. Try again.");
							}
						} while (sname.isBlank());
						do {
							nameFound = false;
							do {
								in = new Scanner(System.in);
								System.out.print("Username: ");
								name = in.nextLine().trim();
							} while (name.isBlank());
							for (int i = 0; i < allUserName.size(); i++) {
								if (name.equalsIgnoreCase(allUserName.get(i))) {
									nameFound = true;
								}
							}
						} while (nameFound);
						do {
							in = new Scanner(System.in);
							System.out.print("Password: ");
							word = in.nextLine().trim();
						} while (word.isBlank());
						myUsers.write(sname + ";" + name + ";" + word + "\n");

						myUsers.close();
						System.out.println("Sign-up Successfully");
						signUp = true;
						break;
					case 3:
						System.out.println("Exiting the program...");
						System.exit(0);
						break;
					}
				}
				int choice = 0;
				if (loginSuccess == true) {
					do {
						in = new Scanner(System.in);
						try {
							System.out.println("|-----------------------------------------------|");
							System.out.println("|			     MENU               |");
							System.out.println("|-----------------------------------------------|");
							System.out.println("|		1 = Add Product                	|");
							System.out.println("|		2 = Search Product		|");
							System.out.println("|		3 = Purchase Product           	|");
							System.out.println("|		4 = View All Purchase Product  	|");
							System.out.println("|		5 = Edit Product Details       	|");
							System.out.println("|		6 =  Activate/Deactivate Product|");
							System.out.println("|		7 = Logout			|");
							System.out.println("|-----------------------------------------------|");
							System.out.print("Enter your choice: ");
							choice = in.nextInt();
						} catch (Exception e) {
						}
						if (choice <= 0 || choice > 7) {
							System.out.println("Invalid Choice! Try again.");
						}
					} while (choice <= 0 || choice > 7);
				} else {
					if (!signUp && signUp2 == 0) {
						System.out.println("Invalid Username or Password!");
					}
				}
				if (loginSuccess == true) {
					switch (choice) {
					case 1:
						Scanner addScanner = new Scanner(myObj);
						System.out.println("------------------------------");
						System.out.println("|     Add Product Details    |");
						System.out.println("------------------------------");
						String pdesc = "", pname = "";
						int pcode = 0;
						double pprice = 0;
						boolean found = false;
						String tempcode = "";
						do {
							in = new Scanner(System.in);
							try {
								found = false;
								System.out.print("Enter Product Code: ");
								pcode = in.nextInt();
								tempcode = pcode + "";
								for (int i = 0; i < allProductNumber.size(); i++) {
									if (allProductNumber.get(i).equalsIgnoreCase(tempcode)) {
										found = true;
									}
								}
								if (found) {
									System.out
											.println("Product Code Already taken. Please Enter another product Code.");
								}
							} catch (Exception e) {
								System.out.println("Invalid Input!");
								found = true;
							}
						} while (found);
						allProductNumber.add(tempcode);
						do {
							found = false;
							in = new Scanner(System.in);
							System.out.print("Enter Product Name: ");
							pname = in.nextLine();
							for (int i = 0; i < allProductName.size(); i++) {
								if (allProductName.get(i).equalsIgnoreCase(pname)) {
									found = true;
								}
							}
							if (found) {
								System.out.println("Product Name Already taken. Please Enter another product name.");
							}
						} while (found);
						allProductName.add(pname);
						in = new Scanner(System.in);
						System.out.print("Enter Product Description: ");
						pdesc = in.nextLine();

						do {
							in = new Scanner(System.in);
							try {
								System.out.print("Enter Product Price: ");
								pprice = in.nextDouble();
							} catch (Exception e) {
							}
						} while (pprice <= 0);
						int pstock = 0;
						do {
							in = new Scanner(System.in);
							try {
								System.out.print("Enter Product Stock: ");
								pstock = in.nextInt();
							} catch (Exception e) {
							}
							if (pstock <= 0) {
								System.out.println("Invalid Product Stock.");
							}
						} while (pstock <= 0);
						myWriter.write(pcode + ";" + pname + ";" + pdesc + ";" + pprice + ";" + localdate + ";" + pstock
								+ ";1\n");
						myWriter.close();
						System.out.println("Product successfully added!");
						System.out.println(
								"---------------------------------------------------------------------------------------------------------------------------------");
						System.out.println(
								"Product Code\tProduct Name\tProduct Description\tProduct Price\t\tDate\t\tProduct Stock\t\tProduct Status");
						System.out.println(
								"-------------------------------------------------------------------------------------------------------------------------------");
						while (myReader.hasNextLine()) {
							String[] details = new String[7];
							String data = myReader.nextLine();
							details = data.split(";");
							System.out.println(details[0] + "\t\t" + details[1] + "\t\t" + details[2] + "\t\t\t"
									+ details[3] + "\t\t\t" + details[4] + "\t\t\t" + details[5] + "\t\t" + details[6]);
						}
						myReader.close();
						break;
					case 2:
						File myObj11 = new File("C:/Bacala/product.txt");
						Scanner myReader11 = new Scanner(myObj11);
						System.out.println("------------------------------");
						System.out.println("|       Search Product       |");
						System.out.println("------------------------------");
						in = new Scanner(System.in);
						System.out.print("Input product to search: ");
						String search = in.nextLine();
						noProductFound = true;
						System.out.println("Search result for " + search);
						System.out.println(
								"----------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println(
								"Product Code\tProduct Name\tProduct Description\tProduct Price\t\tDate\t\t\tProduct Stock\t\tProduct Status");
						System.out.println(
								"---------------------------------------------------------------------------------------------------------------------------------------------");
						while (myReader11.hasNextLine()) {
							String[] details = new String[7];
							String data = myReader11.nextLine().toLowerCase();
							details = data.split(";");
							if (data.matches("(.*)" + search + "(.*)")) {
								System.out.println(
										details[0] + "\t\t" + details[1] + "\t\t" + details[2] + "\t\t\t" + details[3]
												+ "\t\t\t" + details[4] + "\t\t" + details[5] + "\t\t\t" + details[6]);
								noProductFound = false;
							}
						}
						if (noProductFound) {
							System.out.println("No Product found!");
						}
						myReader11.close();
						break;
					case 3:
						boolean noProductToBuy = false;
						myObj = new File("C:/Bacala/product.txt");
						Scanner testScanner = new Scanner(myObj);
						ArrayList<String> cart = new ArrayList<String>();
						ArrayList<String> allID = new ArrayList<String>();
						ArrayList<String> allProductDetails = new ArrayList<>();
						File myObj2 = new File("C:/Bacala/product.txt");
						Scanner myReader2 = new Scanner(myObj2);
						System.out.println("------------------------------");
						System.out.println("|      PURCHASE PRODUCT      |");
						System.out.println("------------------------------");
						in = new Scanner(System.in);
						String cont = "y";
						String det = "";
						double totalAmount = 0.0;
						String cartCheckOut = "n";
						do {
							int search2 = 0, quantity = 0;
							String searchV2 = "";
							int stockLimit = 0;
							found = false;
							boolean active = false, zeroStock = false;
							do {
								allProductDetails.clear();
								myReader2 = new Scanner(myObj2);
								while (myReader2.hasNextLine()) {
									String[] details = new String[7];
									String data = myReader2.nextLine();
									details = data.split(";");
									allProductDetails.add(data);
								}
								search2 = 0;
								quantity = 0;
								stockLimit = 0;
								found = false;
								active = false;
								zeroStock = false;
								in = new Scanner(System.in);
								try {
									System.out.print("Enter product code: ");
									search2 = in.nextInt();
									testScanner = new Scanner(myObj2);
									while (testScanner.hasNextLine()) {
										String[] details = new String[8];
										String data = testScanner.nextLine();
										details = data.split(";");
										searchV2 = search2 + "";
										if (searchV2.equalsIgnoreCase(details[0])) {
											stockLimit = Integer.parseInt(details[5]);
											allID.add(details[0]);
											found = true;
											if (details[5].equals("0")) {
												zeroStock = true;
											}
											if (details[6].equals("1")) {
												active = true;
											} else {
												System.out.println("Cannot Purchase Product!");
											}
										}

									}
									if (!found) {
										System.out.println("No Product Matches your Code entered.");
									}
									if (zeroStock) {
										System.out.println("Cannot Buy Product. Out of stock.");
									}
								} catch (Exception e) {
									System.out.println("Invalid Input. Please Enter Valid Product Code.");
								}
							} while (zeroStock || !active || !found);
							do {
								in = new Scanner(System.in);
								try {
									System.out.print("Enter quantity: ");
									quantity = in.nextInt();
								} catch (Exception e) {
								}
								if (quantity > stockLimit) {
									System.out.println("Insufficient Stock.");
								}
								if (quantity < 1) {
									System.out.println("Invalid Quantity.");
								}
							} while (quantity < 1 || quantity > stockLimit);
							int allStock = 0;
							myReader2 = new Scanner(myObj2);
							while (myReader2.hasNextLine()) {
								String[] details = new String[8];
								String data = myReader2.nextLine();
								details = data.split(";");
								if (searchV2.equalsIgnoreCase(details[0])) {
									det = details[0];
									totalAmount += (Double.parseDouble(details[3]) * quantity);
									if (allID.contains(details[0])) {
									}
									cart.add(details[0] + ";" + details[1] + ";" + details[3] + ";" + quantity + ";"
											+ localdate + ";" + (Double.parseDouble(details[3]) * quantity));
								}
							}
							FileWriter productReWriter = new FileWriter("C:/Bacala/product.txt", false);
							PrintWriter pwOb = new PrintWriter(productReWriter, false);
							pwOb.flush();
							pwOb.close();
							FileWriter productWriter = new FileWriter("C:/Bacala/product.txt", true);
							for (int i = 0; i < allProductDetails.size(); i++) {
								String[] details = new String[7];
								String data = allProductDetails.get(i);
								details = data.split(";");
								int newQuantity = 0, tempQuantity = 0;
								if (searchV2.equalsIgnoreCase(details[0])) {
									newQuantity = stockLimit - quantity;
									productWriter
											.write(details[0] + ";" + details[1] + ";" + details[2] + ";" + details[3]
													+ ";" + localdate + ";" + newQuantity + ";" + details[6] + "\n");
								} else {
									productWriter.write(data + "\n");
								}
							}
							productWriter.close();
							for (int a = 0; a < cart.size(); a++) {
								System.out.println(cart.get(a));
							}
							if (searchV2.equalsIgnoreCase(det)) {
								System.out.println("____________________");
								System.out.println("Total Amount: " + totalAmount);
								in = new Scanner(System.in);
								do {
									System.out.print("Do you want to add more? y or n: ");
									cont = in.nextLine();
								} while (!(cont.equalsIgnoreCase("y")) && !(cont.equalsIgnoreCase("n")));
							}
							if (cont.equalsIgnoreCase("n")) {
								in = new Scanner(System.in);
								if (cart.size() > 0) {
									do {
										System.out.print("Do you want check out your cart? y or n: ");
										cartCheckOut = in.nextLine();
									} while (!(cartCheckOut.equalsIgnoreCase("y"))
											&& !(cartCheckOut.equalsIgnoreCase("n")));
								}
							}
							myReader2 = new Scanner(myObj2);
							while (myReader2.hasNextLine()) {
								noProductToBuy = false;
								String[] details = new String[7];
								String data = myReader2.nextLine();
								details = data.split(";");
								if (details[5].equals("0")) {
									noProductToBuy = true;
								} else {
									break;
								}
							}
							if (noProductToBuy) {
								System.out.println("No product left to buy.");
								break;
							}
						} while (cartCheckOut.equalsIgnoreCase("n"));
						for (int a = 0; a < cart.size(); a++) {
							myWriterP.write(cart.get(a) + "\n");
						}
						myWriterP.close();
						System.out.println("Product Purchased Successfully.");
						break;
					case 4:
						File viewpurchase = new File("C:/Bacala/purchase.txt");
						Scanner vpscanner = new Scanner(viewpurchase);
						System.out.println("-------------------------------");
						System.out.println("|  View All Purchase Product  |");
						System.out.println("-------------------------------");
						in = new Scanner(System.in);
						System.out.print("Enter keyword to search purchase products: ");
						String searchPurchase = in.nextLine().toLowerCase();
						System.out.println(
								"------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println(
								"Product Code\tProduct Name\t\tProduct Price\t\tProduct Stock\t\tDate of Purchase\t\tProduct SubTotal Amount");
						System.out.println(
								"------------------------------------------------------------------------------------------------------------------------------------------------");
						while (vpscanner.hasNextLine()) {
							String[] details = new String[6];
							String data = vpscanner.nextLine();
							details = data.split(";");
							if (data.toLowerCase().matches("(.*)" + searchPurchase + "(.*)")) {
								System.out.println(details[0] + "\t\t" + details[1] + "\t\t\t" + details[2] + "\t\t\t"
										+ details[3] + "\t\t\t" + details[4] + "\t\t\t" + details[5]);
							}
						}
						break;
					case 5:
						System.out.println("------------------------------");
						System.out.println("|    EDIT PRODUCT DETAILS    |");
						System.out.println("------------------------------");
						in = new Scanner(System.in);

						File myObj3 = new File("C:/Bacala/product.txt");
						Scanner myReader3 = new Scanner(myObj3);
						int search3 = 0;
						do {
							in = new Scanner(System.in);
							try {
								System.out.print("Enter product code: ");
								search3 = in.nextInt();
							} catch (Exception e) {
							}
						} while (search3 <= 0);
						String searchV3 = search3 + "";
						while (myReader3.hasNextLine()) {
							String[] details = new String[8];
							String data = myReader3.nextLine();
							details = data.split(";");
							if (searchV3.equalsIgnoreCase(details[0])) {
								System.out.println("Product Code: " + details[0]);
								System.out.println("Product Name: " + details[1]);
								System.out.println("Product Description: " + details[2]);
								System.out.println("Product Price: " + details[3]);
								System.out.println("Date: " + details[4]);
								System.out.println("Product Stock: " + details[5]);

								String stat = "Inactive";
								if (details[6].equals("1")) {
									stat = "Active";
								}
								System.out.println("Product Status: " + stat);
							}
						}
						myReader3.close();
						System.out.println("--Edit Product Form--");
						in = new Scanner(System.in);
						System.out.print("Enter New Product Name: ");
						String npname = in.nextLine();

						System.out.print("Enter New Product Description: ");
						String npdesc = in.nextLine();
						Double npprice = 0.0;
						do {
							in = new Scanner(System.in);
							try {
								System.out.print("Enter New Product Price: ");
								npprice = in.nextDouble();
							} catch (Exception e) {
							}
						} while (npprice <= 0);
						int nstock = 0;
						do {
							try {
								in = new Scanner(System.in);
								System.out.print("Enter new stock: ");
								String input = in.nextLine();
								nstock = Integer.parseInt(input);
							} catch (Exception e) {
							}
						} while (nstock < 1);
						File myObj4 = new File("C:/Bacala/product.txt");
						Scanner myReader4 = new Scanner(myObj4);

						ArrayList<String> prev = new ArrayList<String>();
						while (myReader4.hasNextLine()) {
							String data = myReader4.nextLine();
							prev.add(data);
						}
						FileWriter myWriterPs = new FileWriter("C:/Bacala/product.txt");
						for (int a = 0; a < prev.size(); a++) {
							String[] details = new String[7];
							details = prev.get(a).split(";");
							if (searchV3.equalsIgnoreCase(details[0])) {
								myWriterPs.write(search3 + ";" + npname + ";" + npdesc + ";" + npprice + ";" + localdate
										+ ";" + nstock + ";" + details[6] + "\n");
							} else {
								myWriterPs.write(prev.get(a) + "\n");
							}
						}
						myWriterPs.close();
						System.out.println("Successfully Edited Product Details.");
						break;
					case 6:
						System.out.println("-------------------------------");
						System.out.println("| ACTIVATE/DEACTIVATE PRODUCT |");
						System.out.println("-------------------------------");
						in = new Scanner(System.in);
						boolean noProductToDeactivate = true;
						File myObj6 = new File("C:/Bacala/product.txt");
						Scanner myReader6 = new Scanner(myObj6);
						int search6 = 0;
						do {
							in = new Scanner(System.in);
							try {
								System.out.print("Enter product code: ");
								String input = in.nextLine().trim();
								search6 = Integer.parseInt(input);
							} catch (Exception e) {
							}
							if (search6 <= 0) {
								System.out.println("Invalid Product Code.");
							}
						} while (search6 <= 0);
						String stat = "Inactive", searchV6 = search6 + "";
						while (myReader6.hasNextLine()) {
							String[] details = new String[7];
							String data = myReader6.nextLine();
							details = data.split(";");
							if (searchV6.equalsIgnoreCase(details[0])) {
								noProductToDeactivate = false;
								System.out.println("Product Name: " + details[1]);
								System.out.println("Product Description: " + details[2]);
								System.out.println("Product Price: " + details[3]);
								System.out.println("Date: " + details[4]);
								System.out.println("Product Stock: " + details[5]);

								if (details[6].equals("1")) {
									stat = "Active";
								}
								System.out.println("Product Status: " + stat);
							}
						}
						String newStat = "0";
						myReader6.close();
						if (stat.equals("Active")) {
							newStat = "0";
							System.out.println("Product " + search6 + " has been deactivated successfully");
						} else {
							if (!noProductToDeactivate) {
								newStat = "1";
								System.out.println("Product " + search6 + " has been activated successfully");
							} else {
								System.out.println("There is no Product to Activate/Deactivate!");
							}
						}

						File myObj63 = new File("C:/Bacala/product.txt");
						Scanner myReader63 = new Scanner(myObj63);

						ArrayList<String> prev6 = new ArrayList<String>();
						while (myReader63.hasNextLine()) {
							String data = myReader63.nextLine();
							prev6.add(data);
						}
						myReader63.close();
						FileWriter myWriterPs6 = new FileWriter("C:/Bacala/product.txt");
						for (int a = 0; a < prev6.size(); a++) {
							String[] details = new String[7];
							details = prev6.get(a).split(";");
							if (searchV6.equalsIgnoreCase(details[0])) {
								myWriterPs6.write(search6 + ";" + details[1] + ";" + details[2] + ";" + details[3] + ";"
										+ details[4] + ";" + details[5] + ";" + newStat + "\n");
							} else {
								myWriterPs6.write(prev6.get(a) + "\n");
							}
						}
						myWriterPs6.close();
						loginSuccess = true;
						break;
					case 7:
						System.out.println("Logging out...");
						choice1 = 0;
						loginSuccess = false;
						break;
					case 8:

						break;
					default:
						System.out.println("Invalid choice!");
						break;
					}
				}
			} while (true == true);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}