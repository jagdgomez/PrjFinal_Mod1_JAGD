package Tests;

import PageObjects.landingPage;
import PageObjects.searchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends baseTest {
    public CartTest() {
        super("chrome");
    }

    @Test
    public void addItemToCartAsAnonymous() throws InterruptedException {
        landingPage landingPg = new landingPage(driver, getBaseUrl());
        searchResultsPage searchResults = new searchResultsPage(driver);
        //waits wait = new waits(driver);
        landingPg.goToPage();
        landingPg.doSearch("MacBook");
        Assert.assertEquals(searchResults.getProductTile().size() > 0,true);
        if(!(searchResults.getProductTile().size() > 0)) {
            Assert.fail("Empty list");
        }
        searchResults.addProductToCart();
       // wait.waitForJSandJQueryToLoad();
        Assert.assertEquals(searchResults.getSuccessModal().isDisplayed(), true);
    }

}
