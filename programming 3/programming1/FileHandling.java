import java.util.*;

import java.io.*;

public class FileHandling {
	public static void main(String[] pos) {
		boolean end = true;
		try {
			do {
				Scanner in = new Scanner(System.in);
				File myObj = new File("C:/java programs/txt files/product.txt");
				Scanner myReader = new Scanner(myObj);
				FileWriter myWriter = new FileWriter("C:/java programs/txt files/product.txt", true);
				FileWriter myWriterP = new FileWriter("C:/java programs/txt files/purchase.txt", true);

				System.out.println("---Menu---");
				System.out.println("1 = Add Product");
				System.out.println("2 = Search Product");
				System.out.println("3 = Purchase Product");
				System.out.println("4 = Edit Product Details");
				System.out.println("5 = Delete Product");
				System.out.println("6 = Exit");
				int choice = in.nextInt();

				switch (choice) {
				case 1:
					// ADD NEW PRODUCT

					System.out.println("---Add Product Details Form---");
					in = new Scanner(System.in);
					System.out.println("Enter Product Code: ");
					String pcode = in.nextLine();

					System.out.println("Enter Product Name: ");
					String pname = in.nextLine();

					System.out.println("Enter Product Description: ");
					String pdesc = in.nextLine();

					System.out.println("Enter Product Price: ");
					Double pprice = in.nextDouble();

					myWriter.write(pcode + ";" + pname + ";" + pdesc + ";" + pprice + ";1\n");

					myWriter.close();
					System.out.println("Product successfully added!");
					// ADD NEW PRODUCT
				
					// DISLPAY ALL PRODUCT

					System.out.println("Product Code\t\tProduct Name\t\tProduct Description\t\t\tPrice\t\tStatus");
					System.out.println(
							"--------------------------------------------------------------------------------------------------");
					while (myReader.hasNextLine()) {
						String[] details = new String[5];
						String data = myReader.nextLine();
						details = data.split(";");
						System.out.println(details[0] + "\t\t\t" + details[1] + "\t\t\t" + details[2] + "\t\t\t"
								+ details[3] + "\t\t" + details[4]);

					}
					myReader.close();
					// DISLPAY ALL PRODUCT

					break;

					case 2:
					File myObj11 = new File("C:/java programs/txt files/product.txt");
					Scanner myReader11 = new Scanner(myObj11);
					System.out.println("Search Product");
					// DISLPAY ALL PRODUCT
					in = new Scanner(System.in);
					System.out.print("Input product to search: ");
					String search = in.nextLine();

					System.out.println("Search result for " + search);

					System.out.println("Product Code\t\tProduct Name\t\tProduct Description\t\t\tPrice\t\tStatus");
					System.out.println(
							"--------------------------------------------------------------------------------------------------");
					while (myReader11.hasNextLine()) {
						String[] details = new String[5];
						String data = myReader11.nextLine();
						details = data.split(";");
						if (search.equalsIgnoreCase(details[1])) {
							System.out.println(details[0] + "\t\t\t" + details[1] + "\t\t\t" + details[2] + "\t\t\t"
									+ details[3] + "\t\t" + details[4]);
						}
					}
					myReader11.close();
					// DISLPAY ALL PRODUCT
					break;

				case 3:
					ArrayList<String> cart = new ArrayList<String>();
					System.out.println("Purchase Product");
					in = new Scanner(System.in);
					String cont = "y";
					double totalAmount = 0.0;
					do {
						File myObj2 = new File("C:/java programs/txt files/product.txt");
						Scanner myReader2 = new Scanner(myObj2);

						System.out.print("Enter product code: ");
						String search2 = in.nextLine();

						System.out.print("Enter quantity: ");
						int quantity = in.nextInt();

						while (myReader2.hasNextLine()) {
							String[] details = new String[5];
							String data = myReader2.nextLine();
							details = data.split(";");
							if (search2.equalsIgnoreCase(details[0])) {
								totalAmount += (Double.parseDouble(details[3]) * quantity);
								cart.add(details[0] + ";" + details[1] + ";" + details[3] + ";" + quantity + ";"
										+ (Double.parseDouble(details[3]) * quantity));
							}
						}

						for (int a = 0; a < cart.size(); a++) {
							System.out.println(cart.get(a));
						}
						System.out.println("________________________");
						System.out.println("Total Amount: " + totalAmount);
						in = new Scanner(System.in);
						System.out.print("Do you want to add more? y or n");
						cont = in.nextLine();

						myReader2.close();
					} while (cont.equalsIgnoreCase("y"));

					String cartCheckOut = "n";
					if (cart.size() > 0) {
						System.out.print("Do you want check out your cart? y or n");
						cartCheckOut = in.nextLine();
					}

					if (cartCheckOut.equalsIgnoreCase("y")) {
						for (int a = 0; a < cart.size(); a++) {
							myWriterP.write(cart.get(a) + "\n");
						}
					}
					myWriterP.close();

					break;

				case 4:
					System.out.println("Edit Product Details");

					in = new Scanner(System.in);

					File myObj2 = new File("C:/java programs/txt files/product.txt");
					Scanner myReader2 = new Scanner(myObj2);

					System.out.print("Enter product code: ");
					String search3 = in.nextLine();

					while (myReader2.hasNextLine()) {
						String[] details = new String[5];
						String data = myReader2.nextLine();
						details = data.split(";");
						if (search3.equalsIgnoreCase(details[0])) {
							System.out.println("Product Name: " + details[1]);
							System.out.println("Product Description: " + details[2]);
							System.out.println("Product Price: " + details[3]);

							String stat = "Inactive";
							if (details[4].equals("1")) {
								stat = "Active";
							}
							System.out.println("Product Status: " + stat);
						}
					}

					myReader2.close();
					System.out.println("--Edit Product Form--");
					System.out.println("Enter New Product Name: ");
					String npname = in.nextLine();

					System.out.println("Enter New Product Description: ");
					String npdesc = in.nextLine();

					System.out.println("Enter New Product Price: ");
					Double npprice = in.nextDouble();

					File myObj3 = new File("E:/POS/product.txt");
					Scanner myReader3 = new Scanner(myObj3);

					ArrayList<String> prev = new ArrayList<String>();
					while (myReader3.hasNextLine()) {
						String data = myReader3.nextLine();
						prev.add(data);
					}
					myReader3.close();

					FileWriter myWriterPs = new FileWriter("C:/java programs/txt files/product.txt");
					for (int a = 0; a < prev.size(); a++) {
						String[] details = new String[5];
						details = prev.get(a).split(";");
						if (search3.equalsIgnoreCase(details[0])) {
							myWriterPs.write(
									search3 + ";" + npname + ";" + npdesc + ";" + npprice + ";" + details[4] + "\n");
						} else {
							myWriterPs.write(prev.get(a) + "\n");
						}
					}
					myWriterPs.close();

					break;

				case 5:
					System.out.println("Delete Product");
					break;

				case 6:
					System.exit(1);
					break;

				default:
					System.out.println("Invalid choice!");
					break;

				}
			} while (end);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void print(String a) {
		System.out.print(a);
	}

	static void println(String a) {
		System.out.println(a);
	}
}