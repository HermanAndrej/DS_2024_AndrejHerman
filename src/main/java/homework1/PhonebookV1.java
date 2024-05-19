package homework1;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookV1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Loading the entries...");
        Entry[] entries = FileUtils.readFile("");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the attribute to sort by:");
        System.out.println("1. Name");
        System.out.println("2. Street Address");
        System.out.println("3. City");
        System.out.println("4. Postcode");
        System.out.println("5. Country");
        System.out.println("6. Phone Number");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String sortAttribute = "";
        switch (choice) {
            case 1:
                sortAttribute = "name";
                break;
            case 2:
                sortAttribute = "streetaddress";
                break;
            case 3:
                sortAttribute = "city";
                break;
            case 4:
                sortAttribute = "postcode";
                break;
            case 5:
                sortAttribute = "country";
                break;
            case 6:
                sortAttribute = "phonenumber";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to sort by name.");
                sortAttribute = "name";
                break;
        }

        System.out.println("Sorting the entries by " + sortAttribute + "...");
        MergeSort.sort(entries, Entry.getComparator(sortAttribute));

        System.out.println("Writing entries to a file...");
        FileUtils.writeToFile(entries, "sorted_phonebook.csv");

        System.out.println("=========================== \n" + "System is ready to use!");

        while (true) {
            System.out.print("Enter the value to search for " + sortAttribute + ", or -1 to exit: \n");
            String searchableValue = scanner.nextLine();

            if (searchableValue.equals("-1")) {
                System.out.println("Exiting the program...");
                break;
            }

            int[] result = BinarySearch.search(entries, searchableValue, sortAttribute);
            if (result.length == 0) {
                System.out.println("No entries found for the given " + sortAttribute + ".");
            } else {
                int numOfEntries = result[1] - result[0] + 1;
                System.out.println(numOfEntries + " entries found.");
                System.out.println("Entries found from index " + result[0] + " to " + result[1] + "\n");
                for (int i = result[0]; i <= result[1]; i++) {
                    System.out.println(entries[i] + "\n");
                }
            }
        }

        scanner.close();
    }
}
