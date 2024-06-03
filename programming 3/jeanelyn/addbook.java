import java.util.*;
import java.io.*;

public class addbook {
	public static void main(String[] args) {
		boolean bookIDFound = false, ISBNFound = false, bookTitleFound = false;
		try {
			Scanner in = new Scanner(System.in);
			FileWriter myWriter = new FileWriter("C:/Jean/books.txt", true);
			File bookFile = new File("C:/Jean/books.txt");
			Scanner bookFileScanner = new Scanner(bookFile);
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
				System.out.print("Enter Book Title: ");
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
				System.out.print("Enter Book Author: ");
				au = in.nextLine();
				if (au.isBlank()) {
					System.out.println("Invalid Book Author. Please try again.");
				}
			} while (au.isBlank());

			do {
				System.out.print("Enter Book Edition: ");
				ed = in.nextLine();
				if (ed.isBlank()) {
					System.out.println("Invalid Book Edition. Please try again.");
				}
			} while (ed.isBlank());

			do {
				System.out.print("Enter Book Publisher: ");
				pu = in.nextLine();
				if (pu.isBlank()) {
					System.out.println("Invalid Book Publisher. Please try again.");
				}
			} while (pu.isBlank());

			do {
				in = new Scanner(System.in);
				ISBNFound = false;
				try {
					System.out.print("Enter Book ISBN: ");
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
			myWriter.write(bookID + ";" + tt + ";" + au + ";" + ed + ";" + pu + ";" + ISBN + ";" + "1\n");
			myWriter.close();
			System.out.println("Book Successfully Added.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}