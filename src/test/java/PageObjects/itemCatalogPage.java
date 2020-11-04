package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class itemCatalogPage extends basePage {

    private By ItemCatalogContainer= By.xpath("//div[contains(@id,'content')]//h1");
    private By ItemCatalogAddToCardButton = By.id("button-cart");
    private By ItemAddedToCartContainer = By.xpath("//div[contains(@class,'alert alert-success alert-dismissible')]");
    private By GoToCartButton = By.xpath("//*[contains(@title,'Shopping Cart')]");
    public itemCatalogPage (WebDriver driver) {
        super(driver);
    }

    public WebElement SetItemCatalogContainer() {
        return driver.findElement(this.ItemCatalogContainer);
    }

    public WebElement SetItemCatalogAddToCardButton() {
        return driver.findElement(this.ItemCatalogAddToCardButton);
    }

    public WebElement SetItemAddedToCartContainer() {
        return driver.findElement(this.ItemAddedToCartContainer);
    }

    public WebElement SetGoToCartButton() {
        return driver.findElement(this.GoToCartButton);
    }
    public void addItemToCartFrmCatalog () {
        this.SetItemCatalogAddToCardButton().click();
    }

    public void GoToCart(){
        this.SetGoToCartButton().click();
    }

}
