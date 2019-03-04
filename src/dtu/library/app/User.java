package dtu.library.app;

public class User {

    private String cpr;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User) {
            User u2 = (User)obj;
            return this.cpr == u2.cpr && this.name == u2.name && this.email == u2.email;
        }
        return false;
    }


    private String name;
    private String email;
    private Address address;

    public User(String cpr, String name, String email) {
        this.cpr = cpr;
        this.name = name;
        this.email = email;

    }

    public String getCpr() {
        return cpr;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
