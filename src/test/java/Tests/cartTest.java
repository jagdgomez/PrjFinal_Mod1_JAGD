package Tests;

import DataProviders.productsDataProvider;
import PageObjects.CartPage;
import PageObjects.itemCatalogPage;
import PageObjects.landingPage;
import PageObjects.searchResultsPage;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.productData;
import utilities.waits;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Epic("Automation Project Johnny Gomez")
@Story("Cart Test")
public class cartTest extends baseTest {
    public cartTest() {
        super("chrome");
    }

    @Test (groups = {"Regression"},description = "User could not purchase out of stock items",dataProvider = "getProductsDataFromJson",dataProviderClass = productsDataProvider.class)
    @Description ("Users are able to Search Product, View Product description page, add the product into Cart but could not purchase out of stock products")
    @Severity(SeverityLevel.BLOCKER)
    //@Attachment (value = "Screenshot", type = "image/png")
    public void addItemToCartAsAnonymous(productData _productData) throws FileNotFoundException {
        landingPage landingPg = new landingPage(driver, getBaseUrl());
        searchResultsPage searchResults = new searchResultsPage(driver);
        itemCatalogPage CatalogPage = new itemCatalogPage (driver);
        waits wait = new waits(driver);
        CartPage CartPg = new CartPage(driver);
        String Prod_Name;
        Prod_Name=_productData.getName();
        landingPg.goToPage();
        landingPg.doSearch(Prod_Name);
        Assert.assertEquals(searchResults.SetProductTile().size() > 0,true);
        System.out.println("Search Results =" + searchResults.SetProductTile().size());
        if(!(searchResults.SetProductTile().size() > 0)) {
            Assert.fail("Empty list");
        }
        searchResults.SelectItemToOpenCatalog();
        System.out.println("Validating Results");
         Assert.assertEquals (CatalogPage.SetItemCatalogContainer().getText(),Prod_Name);
        if (!(CatalogPage.SetItemCatalogContainer().getText().equals(Prod_Name))) {
            Assert.fail("No Item Selected");
        }
        System.out.println("Add Item to Cart from Catalog Page");
        CatalogPage.addItemToCartFrmCatalog();
        wait.waitForJSandJQueryToLoad();
        Assert.assertEquals(CatalogPage.SetItemAddedToCartContainer().isDisplayed(),true);
        if (!(CatalogPage.SetItemAddedToCartContainer().isDisplayed())) {
            Assert.fail("Item not included in Cart");
        }
       CatalogPage.GoToCart();
        Assert.assertEquals(CartPg.SetCartContainer().isDisplayed(),true);
        if (!(CartPg.SetCartContainer().isDisplayed())) {
            Assert.fail("Cart Page not displayed");
        }
        System.out.println("Cart Page Displayed");
        Assert.assertEquals(CartPg.SetProdNameTbContainer(Prod_Name).isDisplayed(),true);
        System.out.println("Validated Product in List: " + Prod_Name);
        CartPg.DoCheckOut();
        wait.waitForJSandJQueryToLoad();

        Allure.addAttachment("image", new FileInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)));
        Assert.assertEquals(CartPg.SetFailureModal().isDisplayed(),true);
        if (CartPg.SetFailureModal().isDisplayed()) {
            System.out.println("Expected: Could Not Check Out Item: " + Prod_Name );
        }
    }

}
