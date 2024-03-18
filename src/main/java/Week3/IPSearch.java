package Week3;

public class IPSearch {
    public static IPAddress search(IPAddress[] ipAddresses, String ipAddress) {
        long ipToSearch = ipToLong(ipAddress);

        if(!isValidIP(ipAddress)){
            return null;
        }

        int low = 0;
        int high = ipAddresses.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            IPAddress currentIp = ipAddresses[mid];

            if (ipToSearch >= currentIp.getStartIp() && ipToSearch <= currentIp.getEndIp()) {
                return currentIp;
            } else if (ipToSearch < currentIp.getStartIp()) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }



    private static long ipToLong(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        long result = 0;
        for (String part : parts) {
            result = result << 8 | Integer.parseInt(part);
        }
        return result;
    }

    private static boolean isValidIP(String ipAddress){
        String[] parts = ipAddress.split("\\.");

        for(String part : parts){
            if(Integer.parseInt(part) < 0 || Integer.parseInt(part) > 255){
                return false;
            }
        }
        return true;
    }
}