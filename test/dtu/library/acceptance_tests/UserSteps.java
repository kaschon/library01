package dtu.library.acceptance_tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.library.LibraryApp;
import dtu.library.OperationNotAllowedException;
import dtu.library.app.Address;
import dtu.library.app.User;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserSteps {
    private User user;
    private Address address;
    private LibraryApp libraryApp;
    private ErrorMessageHolder errorMessageHolder;

    public UserSteps(LibraryApp libraryApp, ErrorMessageHolder errorMessageHolder) {
        this.libraryApp = libraryApp;
        this.errorMessageHolder = errorMessageHolder;
    }


    @Given("^there is a user with CPR \"([^\"]*)\", name \"([^\"]*)\", e-mail \"([^\"]*)\"$")
    public void thereIsAUserWithCPRNameEMail(String cpr, String name, String email) {
        user = new User(cpr, name, email);
        assertThat(user.getCpr(), is(equalTo(cpr)));
        assertThat(user.getName(), is(equalTo(name)));
        assertThat(user.getEmail(), is(equalTo(email)));

    }

    @And("the user has address street {string}, post code {int}, and city {string}")
    public void theUserHasAddressStreetPostCodeAndCity(String street, int postcode, String city) {
        address = new Address(street, postcode, city);
        assertThat(address.getStreet(), is(equalTo(street)));
        assertThat(address.getPostcode(), is(equalTo(postcode)));
        assertThat(address.getCity(), is(equalTo(city)));
        user.setAddress(address);
        assertThat(user.getAddress(), is(sameInstance(address)));
    }

    @When("the administrator registers the user")
    public void theAdministratorRegistersTheUser() throws Exception {
        try {
            libraryApp.registerUser(user);
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("the user is a registered user of the library")
    public void theUserIsARegisteredUserOfTheLibrary() throws Exception {
        assertThat(libraryApp.getUsers(), hasItem(user));
    }

    @Given("a user is registered with the library")
    public void aUserIsRegisteredWithTheLibrary() throws Exception {
        user = new User("130253-3217", "Julius T. Karlsen", "JuliusTKarlsen@armyspy.com");
        assertThat(user.getCpr(), is(equalTo("130253-3217")));
        assertThat(user.getName(), is(equalTo("Julius T. Karlsen")));
        assertThat(user.getEmail(), is(equalTo("JuliusTKarlsen@armyspy.com")));
        address = new Address("Lundevænget 27", 1325, "København K");
        assertThat(address.getStreet(), is(equalTo("Lundevænget 27")));
        assertThat(address.getPostcode(), is(equalTo(1325)));
        assertThat(address.getCity(), is(equalTo("København K")));
        user.setAddress(address);
        assertThat(user.getAddress(), is(sameInstance(address)));
        libraryApp.adminLogin("adminadmin");
        libraryApp.registerUser(user);
        libraryApp.adminLogout();
        assertThat(libraryApp.getUsers(), hasItem(user));
    }

    @When("the administrator registers the user again")
    public void theAdministratorRegistersTheUserAgain() throws Exception {
        user = new User("130253-3217", "Julius T. Karlsen", "JuliusTKarlsen@armyspy.com");
        assertThat(user.getCpr(), is(equalTo("130253-3217")));
        assertThat(user.getName(), is(equalTo("Julius T. Karlsen")));
        assertThat(user.getEmail(), is(equalTo("JuliusTKarlsen@armyspy.com")));
        address = new Address("Lundevænget 27", 1325, "København K");
        assertThat(address.getStreet(), is(equalTo("Lundevænget 27")));
        assertThat(address.getPostcode(), is(equalTo(1325)));
        assertThat(address.getCity(), is(equalTo("København K")));
        user.setAddress(address);
        assertThat(user.getAddress(), is(sameInstance(address)));
        assertThat(user.getName(), is(user.getName()));
        assertThat(user.getEmail(), is(user.getEmail()));

        try {
            libraryApp.registerUser(user);
        } catch (OperationNotAllowedException e) {
            System.out.println("hahahaahh");
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then(" I get the error message \"([^\"]*)\"$")
    public void iGetTheErrorMessage() throws Exception{

    }

}