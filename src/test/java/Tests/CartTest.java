package Tests;

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

    @Test
    public void addItemToCartAsAnonymous() throws InterruptedException {
        landingPage landingPg = new landingPage(driver, getBaseUrl());
        searchResultsPage searchResults = new searchResultsPage(driver);
        itemCatalogPage CatalogPage = new itemCatalogPage (driver);
        waits wait = new waits(driver);
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
        Thread.sleep(10000);
        CatalogPage.GoToCard();
        Thread.sleep(10000);





        //searchResults.addProductToCart();
        //wait.waitForJSandJQueryToLoad();
        //Assert.assertEquals(searchResults.SetSuccessModal().isDisplayed(), true);
    }

}
