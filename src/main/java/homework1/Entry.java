package homework1;

public class Entry implements Comparable<Entry> {

    private String name;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String name, String streetAddress, String city, String postcode, String country, String phoneNumber){
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return
                "Name: " + name + '\n' +
                "Street Address: " + streetAddress + '\n' +
                "City: " + city + '\n' +
                "Postcode: " + postcode + '\n' +
                "Country: " + country + '\n' +
                "Phone Number: " + phoneNumber;
    }

    @Override
    public int compareTo(Entry other) {
        // implement the actual compareTo logic (remove next line)
        return 0;
    }


}