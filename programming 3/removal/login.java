import java.io.File;
import java.util.Scanner;

public class login {
	public static void main(String[] args) {
		boolean loginSuccessful = false;
		Scanner sc = new Scanner(System.in);
		try {
			File loginFile = new File("C:/removal/login.txt");
			Scanner loginFileScanner = new Scanner(loginFile);
			String username = "", password = "", data = "";
			System.out.println("------Log in Form------");
			sc = new Scanner(System.in);
			System.out.print("Enter Username: ");
			username = sc.nextLine();
			System.out.print("Enter Password: ");
			password = sc.nextLine();
			while (loginFileScanner.hasNextLine()) {
				String[] details = new String[2];
				data = loginFileScanner.nextLine();
				details = data.split(";");
				if (username.equals(details[0]) && password.equals(details[1])) {
					System.out.println("Log in Successful.");
					loginSuccessful = true;
				}
			}
			if (data.isBlank()) {
				System.out.println("No Registered Users / Staff found! Please Register first.");
			}
			if (!loginSuccessful) {
				System.out.println("Invalid Username or Password try again.");
			}
			loginFileScanner.close();
		} catch (Exception e) {
			System.out.println("An Error Occured while running the program." + e);
		}
	}
}
