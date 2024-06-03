import java.util.*;

public class DataManagement {
    public static void main(String[] args) {
        // ! Instance sa scanner
        Scanner input = new Scanner(System.in);
        // ! Instance sa DataProcessor na class, mao ni ang object
        DataProcessor dataProcessor = new DataProcessor();

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add Data");
            System.out.println("2. Search Data");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            String choice = input.nextLine(); // ! Read the user's choice

            switch (choice) {
                case "1":
                    System.out.print("Enter data to add or if with index(index,data): ");
                    String dataToAdd = input.nextLine(); // ! Read data from the user

                    // ! Mo determine sa enter sa user kung balik na ba ang number na gi input
                    if (dataProcessor.getDataList().contains(dataToAdd)) {
                        System.out.println("Value already in the list!");
                        break;
                    }

                    System.out.print("Data added: ");
                    // ! Para e get ang previous list, gi assign sa kani nga list, para e SOP unya
                    List<String> previousDataList = new ArrayList<>(dataProcessor.getDataList());

                    // ! Mo determines kung ang user input kay apil index
                    if (dataToAdd.contains(",")) {
                        dataProcessor.addDataWithIndex(dataToAdd);

                        // ! e split niya para ang number lang ang ma SOP dili apil ang index ug comma
                        String[] splittedData = dataToAdd.split(",");
                        System.out.println(splittedData[1]);

                    } else { // ! Add data to the data processor

                        dataProcessor.addData(dataToAdd);
                        System.out.println(dataToAdd);

                    }

                    // ! Display the current & previous data list
                    System.out.println("Previous Data List: " + previousDataList);
                    System.out.println("Current Data List: " + dataProcessor.getDataList());
                    dataProcessor.printDataTable(); // ! Print the data table
                    break;
                case "2":
                    System.out.print("Enter data to search: ");
                    String searchData = input.nextLine(); // ! Read data to search for

                    // ! Display the current data list
                    System.out.println("Current data list: " + dataProcessor.getDataList());
                    // ! Search for the index of the data
                    System.out.println("Search result index(es) for " + searchData + ": "
                            + dataProcessor.getDataList().indexOf(searchData));
                    break;
                case "3":
                    System.out.println("Exiting...");
                    input.close(); // ! Close the input scanner
                    System.exit(0); // ! Exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }
}
