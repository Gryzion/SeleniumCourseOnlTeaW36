package pl.coderslab.Task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    @FindBy(css="#checkout-addresses-step > div > div > form > div > button")
    private WebElement confirmAddressButton;

    @FindBy(css="#js-delivery > div > div > div > label > div > div > span")
    //@FindBy(css="#js-delivery > div > div > div")
    private WebElement deliveryChoosePickUp;

    @FindBy(css="#js-delivery > button")
    private WebElement deliveryContinueButton;

    @FindBy(css="#payment-option-1")
    private WebElement payByCheckInput;

    @FindBy(css="#conditions_to_approve\\[terms-and-conditions\\]")
    private WebElement conditionsToApproveButton;

    @FindBy(css="#payment-confirmation > div > button")
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void confirmAddress() {
        confirmAddressButton.click();
    }
    public void chooseDeliveryPickUp() {
        deliveryChoosePickUp.click();
        deliveryContinueButton.click();
    }
    public void ChoosePayMethod() {
        payByCheckInput.click();
    }
    public void AgreeTermsAndOrder() {
        conditionsToApproveButton.click();
        placeOrderButton.click();
    }
}
