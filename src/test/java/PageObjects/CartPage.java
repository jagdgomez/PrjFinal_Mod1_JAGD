package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends basePage {
    private By CartContainer= By.xpath("//div[contains(@id,'checkout-cart')]");
    private By ProductNameTbContainer= By.xpath("//div[contains(@class,'table-responsive')]");
    private By CheckOutButton = By.xpath ("//div[contains(@class,'buttons clearfix')]//a[.='Checkout']");
    private By failureModal =  By.xpath("//div[contains(@class, 'alert alert-danger alert-dismissible')]");
    private String ProdNameXpathContainer = "//div[contains(@class,'table-responsive')]";


    public CartPage (WebDriver driver) {
        super(driver);
    }

    public WebElement SetCartContainer() {
        return driver.findElement(this.CartContainer);
    }
    public WebElement SetProdNameTbContainer(String Prod_Name) {
        ProductNameTbContainer = By.xpath(ProdNameXpathContainer + "//a[.='" + Prod_Name +"']");
        System.out.println("Xpath Generated " + ProductNameTbContainer);
        return driver.findElement(this.ProductNameTbContainer);
    }
    public WebElement SetCheckOutButton() {
        return driver.findElement(this.CheckOutButton);
    }

    public WebElement SetFailureModal() {
        return driver.findElement(this.failureModal);
    }

    public void DoCheckOut() {
    this.SetCheckOutButton().click();
    }




}
