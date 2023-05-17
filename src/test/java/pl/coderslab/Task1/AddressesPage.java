package pl.coderslab.Task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {
    @FindBy(css = ".addresses-footer > a")
    private WebElement addAddressLink;

    @FindBy(css = "#notifications > div > article > ul > li")
    private WebElement confirmAddAddressInfo;

    public AddressesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void AddressClick (){
        addAddressLink.click();
    }

    public String getAddInformation(){
        return confirmAddAddressInfo.getText();
    }
}