package pl.coderslab.Task1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CreateNewAddressSteps {
    private WebDriver driver;

    @Given("Logged in to MyStore {string}")
    public void logged_in_to_my_store(String pageUrl) { //logged_in_to_my_store
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(pageUrl);

        LogInPage loginPage = new LogInPage(driver);
        loginPage.LoginAs("kdiybutihdbztlyrxf@tcwlm.com","Przyklad123");
    }

    @When("Button Addresses clicked goes to {string}")
    public void button_addresses_clicked_goes_to(String string) {  // button_addresses_clicked
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.AddressClick();
    }

    @When("Button clicked {string}")
    public void button_clicked_create_new_address(String string) {  //button_clicked_create_new_address
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.AddressClick();
    }

    @When("Fill form New Address: {string}, {string}, {string}, {string}, {string}, {string}")
    public void fill_form_new_address(String alias, String address, String city, String postcode, String country, String phone) {
        CreateNewAddressPage createNewAddressPage = new CreateNewAddressPage(driver);
        createNewAddressPage.AddAddress(alias, address, city, postcode, country, phone);
    }

    @Then("Check that the address details are correct")
    public void check_that_the_address_details_are_correct() { //check_that_the_address_details_are_correct
        AddressesPage addressesPage = new AddressesPage(driver);
        Assert.assertEquals("Address successfully added!", addressesPage.getAddInformation());
    }

}

