package homework1;

import java.util.ArrayList;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int low = 0, high = entries.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int compareResult = entries[mid].getName().compareTo(searchableName);
            if (compareResult == 0) {
                // Name found, now find the start and end indices
                int start = mid, end = mid;

                while (start > 0 && entries[start - 1].getName().equals(searchableName)) {
                    start--;
                }

                while (end < entries.length - 1 && entries[end + 1].getName().equals(searchableName)) {
                    end++;
                }

                return new int[]{start, end};
            }

            if (compareResult < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{};
    }

    private boolean less(Entry v, Entry w) {
        return v.getName().compareTo(w.getName()) < 0;
    }
}
