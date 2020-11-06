package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class searchResultsPage extends basePage{

    public searchResultsPage (WebDriver driver) {
        super(driver);
        }
    private By productTile = By.xpath("//div[contains(@class,'product-layout')]");
    private By SelectItemCatalog=  By.xpath("//div[contains(@class,'caption')]//h4/a");

    public List<WebElement> SetProductTile() {
        return driver.findElements(this.productTile);
    }

    public WebElement SetSelectItemCatalog() {
        return driver.findElement(this.SelectItemCatalog);
    }

    @Step("Click on Item to open Item Description Page")
    public void SelectItemToOpenCatalog(){
        this.SetSelectItemCatalog().click();


    }

}
