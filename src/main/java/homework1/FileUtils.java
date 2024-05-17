package homework1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws IOException {
        List<Entry> informationList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while((line = br.readLine()) != null){
            String parts[] = line.split(";");
            String name = parts[0];
            String streetAddress = parts[1];
            String city = parts[2];
            String postcode = parts[3];
            String country = parts[4];
            String phoneNumber = parts[5];
            Entry entry = new Entry(name, streetAddress, city, postcode, country, phoneNumber);
            informationList.add(entry);
        }
        br.close();


        return informationList.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));

        for(Entry entry : entries){
            bufferedWriter.write(entry.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
