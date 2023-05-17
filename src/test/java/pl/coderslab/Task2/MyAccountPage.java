package pl.coderslab.Task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy(name="s")
    private WebElement searchInput;


    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void SearchInputClick (String nameProduct) {
        searchInput.sendKeys(nameProduct);
        searchInput.submit();
    }
}