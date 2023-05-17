package pl.coderslab.Task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAddressPage {

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id="field-address1")
    private WebElement address1Input;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement postcodeInput;

    @FindBy(id = "field-id_country")
    private WebElement countrySelect;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(css = ".form-control-submit")
    private WebElement saveButton;

    public CreateNewAddressPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void AddAddress (String alias, String address, String city, String postcode, String country, String phone){
        aliasInput.sendKeys(alias);
        address1Input.sendKeys(address);
        cityInput.sendKeys(city);
        postcodeInput.sendKeys(postcode);
        countrySelect.sendKeys(country);
        phoneInput.sendKeys(phone);
        saveButton.click();
    }

}
