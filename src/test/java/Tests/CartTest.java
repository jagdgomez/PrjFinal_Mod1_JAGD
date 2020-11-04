package Tests;

import PageObjects.CartPage;
import PageObjects.itemCatalogPage;
import PageObjects.landingPage;
import PageObjects.searchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.waits;

public class CartTest extends baseTest {
    public CartTest() {
        super("chrome");
    }

    @Test (groups = {"Regression"},description = "User could not purchase out of stock items")

    public void addItemToCartAsAnonymous() throws InterruptedException {
        landingPage landingPg = new landingPage(driver, getBaseUrl());
        searchResultsPage searchResults = new searchResultsPage(driver);
        itemCatalogPage CatalogPage = new itemCatalogPage (driver);
        waits wait = new waits(driver);
        CartPage CartPg = new CartPage(driver);
        String Prod_Name;
        Prod_Name="MacBook";
        landingPg.goToPage();
        landingPg.doSearch(Prod_Name);
        Assert.assertEquals(searchResults.SetProductTile().size() > 0,true);
        System.out.println("Search Results" + searchResults.SetProductTile().size());
        if(!(searchResults.SetProductTile().size() > 0)) {
            Assert.fail("Empty list");
        }
        //Thread.sleep(10000);
        searchResults.SelectItemToOpenCatalog();
       //Thread.sleep(10000);
        System.out.println("Asserts");
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
        Assert.assertEquals(CartPg.SetFailureModal().isDisplayed(),true);
        if (CartPg.SetFailureModal().isDisplayed()) {
            System.out.println("Expected: Could Not Check Out Item: " + Prod_Name );
        }
    }

}
