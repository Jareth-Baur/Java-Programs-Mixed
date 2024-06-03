import java.util.*;
import java.io.*;

public class help {
	public static void main(String[] pos) {
		Scanner Manching = new Scanner(System.in);
		boolean found = false;
		try {
			FileWriter poolWriter = new FileWriter("C:/CreateFile/pools.txt", true);
			File pools = new File("C:/CreateFile/pools.txt");
			Scanner poolReader = new Scanner(pools);

			System.out.println("-----Edit Pool Status-----");
			Scanner poolStatusScanner = new Scanner(pools);
			ArrayList<String> tempPoolStatusDetails = new ArrayList<String>();
			while (poolStatusScanner.hasNextLine()) {
				tempPoolStatusDetails.add(poolStatusScanner.nextLine());
			}
			poolStatusScanner.close();
			Manching = new Scanner(System.in);
			found = false;
			System.out.print("Enter Pool number to edit Status: ");
			String searchEditStatusPool = Manching.nextLine();
			while (poolReader.hasNextLine()) {
				String[] details0 = new String[4];
				String data = poolReader.nextLine();
				details0 = data.split(";");
				if (searchEditStatusPool.equalsIgnoreCase(details0[0])) {
					found = true;
					System.out.println("Search Result for " + searchEditStatusPool + ": ");
					System.out.println("Pool Number: " + details0[0]);
					System.out.println("Pool Type: " + details0[1]);
					System.out.println("Price: " + details0[2]);
					System.out.println("Status: " + details0[3]);
					System.out.println();
				}
			}
			if (found) {
				int Status = 0;
				System.out.println("------Status------");
				System.out.println("1 = Active\n2 = Inactive");
				do {
					Manching = new Scanner(System.in);
					try {
						System.out.print("Please Choose New Status: ");
						Status = Manching.nextInt();
					} catch (Exception e) {
					}
					if (Status <= 0 || Status > 2) {
						System.out.println("Invalid Input!");
					}
				} while (Status <= 0 || Status > 2);
				FileWriter poolWriter2 = new FileWriter("C:/CreateFile/pools.txt");
				for (int i = 0; i < tempPoolStatusDetails.size(); i++) {
					String[] details1 = new String[4];
					details1 = tempPoolStatusDetails.get(i).split(";");
					if (searchEditStatusPool.equalsIgnoreCase(details1[0])) {
						poolWriter2.write(details1[0] + ";" + details1[1] + ";" + details1[2] + ";" + Status + "\n");
					} else {
						poolWriter2.write(tempPoolStatusDetails.get(i) + "\n");
					}
				}
				poolWriter2.close();
				System.out.println("Status Edited successfully.");
			} else {
				System.out.println("Noting Matches your Number entered.");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}