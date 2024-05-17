package homework1;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PhonebookV1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Loading the entries...");
        List<Entry> entries = List.of(FileUtils.readFile("C:\\Users\\andre\\DS_2024_AndrejHerman\\DS_2024_AndrejHerman\\src\\main\\java\\homework1\\raw_phonebook_data.csv"));
        Entry[] entryArray = entries.toArray(new Entry[0]);

        System.out.println("Sorting the entries...");
        MergeSort.sort(entryArray);

        System.out.println("Writing entries to a file...");
        FileUtils.writeToFile(entryArray, "sorted_phonebook.csv");

        System.out.println("=========================== \n" + "System is ready to use!");

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Enter the name to search (format: 'Surname, Name'), or -1 to exit: \n");
            String searchableName = scanner.nextLine();

            if(searchableName.equals("-1")){
                System.out.println("Exiting the program...");
                break;
            }

            int[] result = BinarySearch.search(entryArray, searchableName);
            if (result.length == 0) {
                System.out.println("No entries found for the given name.");
            } else {
                int numOfEntries = result[1] - result[0] + 1;
                System.out.println(numOfEntries + " entries found.");
                System.out.println("Entries found from index " + result[0] + " to " + result[1] + "\n");
                for (int i = result[0]; i <= result[1]; i++) {
                    System.out.println(entryArray[i] + "\n");
                }
            }

        }

        scanner.close();

    }
}
