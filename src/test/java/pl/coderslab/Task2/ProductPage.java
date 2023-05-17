package pl.coderslab.Task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ProductPage {
    @FindBy(css = "#group_1")
    private WebElement productSizeSelect;

    @FindBy(css = "#quantity_wanted")
    private WebElement productPiecesInput;

    @FindBy(css="#add-to-cart-or-refresh > div > div > div > button")
    private WebElement addToCartButton;

    @FindBy(css="#blockcart-modal > div > div > div > div > div > div > div > a")
    private WebElement goToCheckoutModalButton;


    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void productSizeChoose(String sizeProduct) {
        productSizeSelect.sendKeys(sizeProduct);
    }

    public void productPiecesChoose(int piecesProduct) {
        productPiecesInput.sendKeys(Integer.toString(piecesProduct));
    }

    public void productAddToCart() {
        addToCartButton.click();
    }
    public void productModalCheckout() {
        goToCheckoutModalButton.click();
    }
}
