import java.util.Scanner;

public class Mainc {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        Peripheral p = new Peripheral("code", "name", "per", "test");

        Peripheral[] perList = new Peripheral[5];

        perList[0] = p;
        int count = 0;
        int choice;

        do {
            System.out.println("Welcome to BEC - Inventory");

            System.out.println("[ 1 ] - Add Peripheral");
            System.out.println("[ 2 ] - View Records");
            System.out.println("[ 3 ] - Update a Record");
            System.out.println("[ 4 ] - Delete a Record");
            System.out.println("[ 5 ] - Reports");
            System.out.println("[ 6 ] - Exit");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Add record. Please enter details");
                    System.out.println("Enter code: ");
                    String code = scan.nextLine();
                    System.out.println("Enter name: ");
                    String name = scan.nextLine();
                    System.out.println("Enter type: ");
                    String type = scan.nextLine();
                    System.out.println("Enter emp: ");
                    String emp = scan.nextLine();
                    Peripheral px = new Peripheral(code, name, type, emp);
                    perList[count] = px;

                    count++;

                    System.out.println("Record has been added.");

                    break;
                case 2:
                    System.out.println("View record: ");
                    for (int i = 0; i < count; i++) {
                        perList[i].display();
                    }
                    break;
                default:
                    break;
            }

        } while (choice != 6);

        System.out.println("Thank you!");

    }
}