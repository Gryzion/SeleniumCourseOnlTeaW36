package pl.coderslab.Task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(css="#main > div > div > div > div > div > a")
    private WebElement goToCheckoutButton;

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void goToCheckout () {
        goToCheckoutButton.click();
    }
}
