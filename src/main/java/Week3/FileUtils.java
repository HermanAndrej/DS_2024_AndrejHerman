package Week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static IPAddress[] readFile(String filePath) {
        List<IPAddress> ipList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (line.equals('-')){
                    return null;
                }
                else {
                    long startIp = Long.parseLong(parts[0]);
                    long endIp = Long.parseLong(parts[1]);
                    String countryCode = parts[2];
                    String country = parts[3];
                    String region = parts[4];
                    String city = parts[5];
                    IPAddress ipAddress = new IPAddress(startIp, endIp, countryCode, country, region, city);
                    ipList.add(ipAddress);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ipList.toArray(new IPAddress[0]);
    }
}