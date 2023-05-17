package pl.coderslab.Task2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

public class OrderSteps {
    private WebDriver driver;

    @Given("User is logged in to Mystore {string}")
    public void user_is_logged_in_to_my_store(String pageUrl) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(pageUrl);

        LogInPage LoginPage = new LogInPage(driver);
        LoginPage.LoginAs("kdiybutihdbztlyrxf@tcwlm.com","Przyklad123");
    }

    @When("User choose {string}")
    public void user_choose(String product) {
        MyAccountPage MyAccountPage = new MyAccountPage(driver);
        MyAccountPage.SearchInputClick(product);
        SearchResultsPage SearchResultsPage = new SearchResultsPage(driver);
        SearchResultsPage.productSearchResultClick();
    }

    @When("Choose {string} size")
    public void choose_size(String sizeProduct) {
        ProductPage ProductPage = new ProductPage(driver);
        ProductPage.productSizeChoose(sizeProduct);

    }

    @When("Choose {int} pieces")
    public void choose_pieces(int piecesProduct) {
        ProductPage ProductPage = new ProductPage(driver);
        ProductPage.productPiecesChoose(piecesProduct);

    }
    @When("Add to cart")
    public void add_to_cart() {
        ProductPage ProductPage = new ProductPage(driver);
        ProductPage.productAddToCart();
        ProductPage.productModalCheckout();
    }
    @When("Go to {string}")
    public void go_to(String string) {
        CartPage CartPage = new CartPage(driver);
        CartPage.goToCheckout();
    }
    @When("User selects a delivery address")
    public void user_selects_a_delivery_address() { //user_selects_a_delivery_address
        CheckoutPage CheckoutPage = new CheckoutPage(driver);
        CheckoutPage.confirmAddress();
    }
    @When("Choose a Self pick up - {string}")
    public void choose_a_self_pick_up(String string) { //choose_a_self_pick_up
        CheckoutPage CheckoutPage = new CheckoutPage(driver);
        CheckoutPage.chooseDeliveryPickUp();
    }
    @When("Choose - {string}")
    public void choose(String string) { //choose
        CheckoutPage CheckoutPage = new CheckoutPage(driver);
        CheckoutPage.ChoosePayMethod();
    }
    @When("Click on - {string}")
    public void click_on(String string) {
        CheckoutPage CheckoutPage = new CheckoutPage(driver);
        CheckoutPage.AgreeTermsAndOrder();
    }
    @Then("Take screenshot of the order confirmation and amount")
    public void take_screenshot_of_the_order_confirmation_and_amount() throws IOException {
        File tmpScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "order-"+currentDateTime+".png"));
    }
}
