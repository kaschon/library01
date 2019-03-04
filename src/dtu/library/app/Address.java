package dtu.library.app;

public class Address {

    private String street;
    private Integer postcode;
    private String city;

    public Address(String street, int postcode, String city) {
        this.street = street;
        this.postcode = postcode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }
}
