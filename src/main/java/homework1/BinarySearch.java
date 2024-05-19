package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableValue, String attribute) {
        int low = 0, high = entries.length - 1;
        searchableValue = searchableValue.trim().toLowerCase(); // Trim and convert to lower case

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midValue = getAttributeValue(entries[mid], attribute).toLowerCase(); // Convert to lower case for comparison

            int compareResult = midValue.compareTo(searchableValue);
            if (compareResult == 0) {
                // Value found, now find the start and end indices
                int start = mid, end = mid;

                while (start > 0 && getAttributeValue(entries[start - 1], attribute).toLowerCase().equals(searchableValue)) {
                    start--;
                }

                while (end < entries.length - 1 && getAttributeValue(entries[end + 1], attribute).toLowerCase().equals(searchableValue)) {
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

    private static String getAttributeValue(Entry entry, String attribute) {
        switch (attribute.toLowerCase()) {
            case "name":
                return entry.getName();
            case "streetaddress":
                return entry.getStreetAddress();
            case "city":
                return entry.getCity();
            case "postcode":
                return entry.getPostcode();
            case "country":
                return entry.getCountry();
            case "phonenumber":
                return entry.getPhoneNumber();
            default:
                throw new IllegalArgumentException("Invalid attribute: " + attribute);
        }
    }
}
