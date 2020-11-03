package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class searchResultsPage extends basePage{

    public searchResultsPage (WebDriver driver) {
        super(driver);
        }
    private By productTile = By.xpath("//div[contains(@class,'product-layout')]");
    private By addToCartButton = By.xpath("//div[contains(@class,'product-layout')]//button[contains(span,'Add to Cart')]");
    private By successModal =  By.xpath("//div[contains(@class, 'alert alert-success alert-dismissible')]");
    private By SelectItemCatalog=  By.xpath("//div[contains(@class,'caption')]//h4/a");

    public List<WebElement> SetProductTile() {
        return driver.findElements(this.productTile);
    }

    public  WebElement SetAddToCartButton() {
        return driver.findElement(this.addToCartButton);
    }

    public WebElement SetSuccessModal() {
        return driver.findElement(this.successModal);
    }
    public WebElement SetSelectItemCatalog() {
        return driver.findElement(this.SelectItemCatalog);
    }
    public void addProductToCart() {
        this.SetAddToCartButton().click();
    }

    public void SelectItemToOpenCatalog(){
        this.SetSelectItemCatalog().click();


    }

}
