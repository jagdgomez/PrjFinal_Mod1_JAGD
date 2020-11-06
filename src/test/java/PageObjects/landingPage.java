package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage extends basePage {

    public landingPage (WebDriver driver, String url) {
        super(driver, url);
    }

    private By searchTextBox = By.xpath("//input[@name='search']");

    public WebElement getSearchTextbox() {
        return driver.findElement(this.searchTextBox);
    }

    @Step("Search Product Name")
    public void doSearch (String productName) {
        getSearchTextbox().sendKeys(productName);
        System.out.println("Searching= "+productName);
        getSearchTextbox().sendKeys(Keys.ENTER);
    }
}
