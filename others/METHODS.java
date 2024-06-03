import java.text.*;
import java.util.*;
import java.util.regex.*;

public class METHODS {
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		boolean isValidDate = false;
		while (!isValidDate) {
			try (Scanner sc = new Scanner(System.in)) {
				System.out.print("Enter flight date (yyyy-MM-dd): ");
				String flightDate = sc.nextLine();
				try {
					Date tryDate = dateFormat.parse(flightDate);
					isValidDate = true;
				} catch (ParseException e) {
					System.out.println("Invalid date format. Please try again.");
				}
			}
		}
	}

	private static boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private static boolean containsSpecialCharacters(String name) {
		return !name.matches("[a-zA-Z ]+");
	}

	private static boolean isValidTimeFormat(String time) {
		String[] timeParts = time.split(":");
		if (timeParts.length != 2) {
			return false;
		}
		try {
			int hours = Integer.parseInt(timeParts[0]);
			int minutes = Integer.parseInt(timeParts[1]);

			if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}