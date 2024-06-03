import java.util.*;
import java.io.*;

public class searchBook {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		try {
			File myObj = new File("C:/Jean/books.txt");
			Scanner myReader = new Scanner(myObj);
			boolean bookIDFound = false;
			System.out.print("Enter Keyword to search Books: ");
			String search = in.nextLine().toLowerCase();
			System.out.println("Book ID\t\tBook Title\t\tAuthor\t\t\tPublisher\t\tISBN\t\t\tBook Status");
			System.out.println("----------------------------------------------------------------------------------------------------------------");
			while (myReader.hasNextLine()) {
				String[] details = new String[6];
				String data = myReader.nextLine();
				details = data.split(";");
				if (data.toLowerCase().matches("(.*)" + search + "(.*)")) {
					System.out.println(details[0] + "\t\t" + details[1] + "\t\t\t" + details[2] + "\t\t\t" + details[3]
							+ "\t\t" + details[4] + "\t\t" + details[5]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
