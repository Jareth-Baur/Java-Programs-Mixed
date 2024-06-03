import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class powerSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			File planeFileSearch = new File("C:/removal/plane.txt");
			Scanner planeFileScanner = new Scanner(planeFileSearch);
			sc = new Scanner(System.in);
			String line = "---------------------------------------------------------";
			System.out.println("Search Plane.\n");
			System.out.print("Input keyword to search: ");
			String PlaneSearch = sc.nextLine();
			System.out.println("Search result for " + PlaneSearch + ": ");
			System.out.println(
					"|    Plane no.\t|\tPlane Name\t|\tPlane Size\t|\tPlane Turbane\t|\tDate Added\t|    Status\t|");
			System.out.println(line + line);
			boolean noPlaneFound = true;
			while (planeFileScanner.hasNextLine()) {
				String[] details = new String[6];
				String content = planeFileScanner.nextLine();
				details = content.split(";");
				noPlaneFound = true;
				if (content.matches("(.*)" + PlaneSearch + "(.*)")) {
					noPlaneFound = false;
					System.out.println("|    " + details[0] + "\t\t|\t" + details[1] + "\t\t|\t" + details[2]
							+ "\t\t|\t" + details[3] + "\t\t|\t" + details[4] + "\t|\t" + details[5] + "\t|");
					System.out.println(line + line);
				}
			}
			if (noPlaneFound) {
				System.out.println("No Plane Matches Your Search.");
			}
		} catch (Exception e) {
			System.out.println("An Error Occured while running the program." + e);
		}
	}
}
