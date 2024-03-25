package Week4;

public class BinaryInsertionSort {

    public static <Data extends Comparable<Data>> void sort(LinkedList<Data> ll) {
        int n = ll.count();
        for (int i = 1; i < n; ++i) {
            // Select the element to be inserted
            Data key = ll.get(i);
            int j = i - 1;

            // Find the correct position to insert key
            int insertionPoint = findInsertionPoint(ll, j, key);

            // Move elements of ll[insertionPoint+1..i-1], that are
            // greater than key, to one position ahead of their
            // current position
            while (j >= insertionPoint) {
                ll.add(j + 1, ll.get(j));
                ll.remove(j);
                j--;
            }
            // Insert the selected element at its correct position
            ll.add(insertionPoint, key);
            ll.remove(i + 1);
        }
    }

    public static <Data extends Comparable<Data>> int findInsertionPoint(LinkedList<Data> ll, int high, Data key) {
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Data midValue = ll.get(mid);
            int comparison = key.compareTo(midValue);
            if (comparison == 0)
                return mid; // Key is found, return its index
            else if (comparison < 0)
                high = mid - 1; // Key is smaller, search in the left half
            else
                low = mid + 1; // Key is larger, search in the right half
        }
        // Key not found, return the insertion point
        return low;
    }
}
