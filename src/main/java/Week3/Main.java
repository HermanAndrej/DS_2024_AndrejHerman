package Week3;

public class Main {
    public static void main(String[] args) {
        // Read IP addresses from a file
        IPAddress[] ipAddresses = FileUtils.readFile("IP2LOCATION.csv");

        // Example IP address to search
        String ipAddressToFind = "255.255.255.260";

        // Search for the IP address
        IPAddress foundIPAddress = IPSearch.search(ipAddresses, ipAddressToFind);

        // Check if the IP address was found
        if (foundIPAddress != null) {
            // Print information about the found IP address
            System.out.println("Found IP address details:");
            System.out.println("Start IP: " + foundIPAddress.getStartIp());
            System.out.println("End IP: " + foundIPAddress.getEndIp());
            System.out.println("Country Code: " + foundIPAddress.getCountryCode());
            System.out.println("Country: " + foundIPAddress.getCountry());
            System.out.println("Region: " + foundIPAddress.getRegion());
            System.out.println("City: " + foundIPAddress.getCity());
        } else {
            System.out.println("IP address not found.");
        }
    }

}
