import java.util.*;
import java.io.*;

public class editbook {
	public static void main(String[] args) {
		boolean bookIDFound = false, ISBNFound = false, bookTitleFound = false;
		Scanner in = new Scanner(System.in);
		try {

			FileWriter myWriter = new FileWriter("C:/Jean/books.txt", true);

			File myObj = new File("C:/Jean/books.txt");
			Scanner myReader = new Scanner(myObj);
			File bookFile = new File("C:/Jean/books.txt");
			Scanner bookFileScanner = new Scanner(bookFile);

			System.out.print("Enter Book ID: ");
			String iD = in.nextLine();

			boolean found = false;

			String stat = "Inactive";
			while (myReader.hasNextLine()) {
				String[] details = new String[7];
				String data = myReader.nextLine();
				details = data.split(";");
				if (iD.equals(details[0])) {
					found = true;
					System.out.println("Book Title: " + details[1]);
					System.out.println("Book Author: " + details[2]);
					System.out.println("Book Publisher: " + details[3]);
					System.out.println("Book Edition: " + details[4]);
					System.out.println("Book ISBN: " + details[5]);

					if (details[6].equals("1")) {
						stat = "Active";
					}
				}

			}
			myReader.close();

			if (found == false) {
				System.out.print("No Book ID Registered in this Number.");
				System.exit(0);
			}

			System.out.println("Status: " + stat);

			System.out.println("---Book Edit Form--");

			String tt = "", ed = "", pu = "", au = "";
			int bookID = 0, ISBN = 0;
			do {
				in = new Scanner(System.in);
				bookIDFound = false;
				try {
					System.out.print("Enter Book ID: ");
					String input = in.nextLine().trim();
					bookID = Integer.parseInt(input);
					bookFileScanner = new Scanner(bookFile);
					while (bookFileScanner.hasNextLine()) {
						String[] details = new String[7];
						String data = bookFileScanner.nextLine();
						details = data.split(";");
						if (input.equals(details[0])) {
							bookIDFound = true;
						}
					}
				} catch (Exception e) {
					System.out.println("Invalid Book ID. Please try again.");
				}
				if (bookIDFound) {
					System.out.println("Book ID already Existing. Please try again.");
				}
			} while (bookIDFound);
			do {
				bookTitleFound = false;
				System.out.print("Enter New Book Title: ");
				tt = in.nextLine();
				bookFileScanner = new Scanner(bookFile);
				while (bookFileScanner.hasNextLine()) {
					String[] details = new String[7];
					String data = bookFileScanner.nextLine();
					details = data.split(";");
					if (tt.equalsIgnoreCase(details[1])) {
						bookTitleFound = true;
					}
				}
				if (tt.isBlank()) {
					System.out.println("Invalid Book Title. Please try again.");
				}
				if (bookTitleFound) {
					System.out.println("Book Title already Existing.");
				}
			} while (tt.isBlank() || bookTitleFound);

			do {
				System.out.print("Enter New Book Author: ");
				au = in.nextLine();
				if (au.isBlank()) {
					System.out.println("Invalid Book Author. Please try again.");
				}
			} while (au.isBlank());

			do {
				System.out.print("Enter New Book Edition: ");
				ed = in.nextLine();
				if (ed.isBlank()) {
					System.out.println("Invalid Book Edition. Please try again.");
				}
			} while (ed.isBlank());

			do {
				System.out.print("Enter New Book Publisher: ");
				pu = in.nextLine();
				if (pu.isBlank()) {
					System.out.println("Invalid Book Publisher. Please try again.");
				}
			} while (pu.isBlank());

			do {
				in = new Scanner(System.in);
				ISBNFound = false;
				try {
					System.out.print("Enter New Book ISBN: ");
					String input = in.nextLine().trim();
					ISBN = Integer.parseInt(input);
					bookFileScanner = new Scanner(bookFile);
					while (bookFileScanner.hasNextLine()) {
						String[] details = new String[7];
						String data = bookFileScanner.nextLine();
						details = data.split(";");
						if (input.equals(details[5])) {
							ISBNFound = true;
						}
					}
				} catch (Exception e) {
					System.out.println("Invalid ISBN. Please try again.");
				}
				if (ISBNFound) {
					System.out.println("Book ISBN already Existing. Please try again.");
				}
				if (ISBN < 1) {
					System.out.println("Invalid ISBN. Please try again.");
				}
			} while (ISBNFound || ISBN < 1);

			File myObj2 = new File("C:/Jean/books.txt");
			Scanner myReader2 = new Scanner(myObj2);

			ArrayList<String> prev = new ArrayList<String>();
			while (myReader2.hasNextLine()) {
				String data = myReader2.nextLine();
				prev.add(data);
			}
			myReader2.close();

			// CHANGE THE INFO

			FileWriter myWriterPs44 = new FileWriter("C:/Jean/books.txt");
			for (int a = 0; a < prev.size(); a++) {
				String[] details2 = prev.get(a).split(";");
				if (details2.length >= 4 && iD.equals(details2[0])) {
					myWriterPs44.write(iD + ";" + tt + ";" + au + ";" + ed + ";" + pu + ";" + ISBN + ";" + "1\n");
				} else {
					myWriterPs44.write(prev.get(a) + "\n");
				}
			}
			myWriterPs44.close();

			// CHANGE THE INFO

		} catch (Exception e) {

		}
	}
}
