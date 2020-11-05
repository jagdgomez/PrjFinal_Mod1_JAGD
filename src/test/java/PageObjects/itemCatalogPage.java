package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class itemCatalogPage extends basePage {

    private By ItemCatalogContainer= By.xpath("//div[contains(@id,'content')]//h1");
    private By ItemCatalogAddToCardButton = By.id("button-cart");
    private By ItemAddedToCartContainer = By.xpath("//div[contains(@class,'alert alert-success alert-dismissible')]");
    private By GoToCartButton = By.xpath("//*[contains(@title,'Shopping Cart')]");
    private By ItemPriceContainer = By.xpath("//*[contains(@class,'list-unstyled')]//h2");
    private By CurrencySelector = By.id ("form-currency");
    private By CurrencyOptionEUR = By.xpath("//*[@class='currency-select btn btn-link btn-block'][@name='EUR']");
    private By CurrencyOptionGBP = By.xpath("//*[@class='currency-select btn btn-link btn-block'][@name='GBP']");
    private By CurrencyOptionUSD = By.xpath("//*[@class='currency-select btn btn-link btn-block'][@name='USD']");
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
    public WebElement SetItemPriceContainer(){
        return driver.findElement(this.ItemPriceContainer);
    }
    public WebElement SetCurrencySelector(){
        return driver.findElement(this.CurrencySelector);
    }
    public WebElement SetCurrencyOptionEUR(){
        return driver.findElement(this.CurrencyOptionEUR);
    }
    public WebElement SetCurrencyOptionGBP(){
        return driver.findElement(this.CurrencyOptionGBP);
    }
    public WebElement SetCurrencyOptionUSD(){
        return driver.findElement(this.CurrencyOptionUSD);
    }


    public void addItemToCartFrmCatalog () {
        this.SetItemCatalogAddToCardButton().click();
    }

    public void GoToCart(){
        this.SetGoToCartButton().click();
    }

    public void selectCurrencyEUR(){
        this.SetCurrencySelector().click();
        this.SetCurrencyOptionEUR().click();
    }
    public void selectCurrencyGBP(){
        this.SetCurrencySelector().click();
        this.SetCurrencyOptionGBP().click();
    }
    public void selectCurrencyUSD(){
        this.SetCurrencySelector().click();
        this.SetCurrencyOptionUSD().click();
    }
}
