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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo.productData;
import utilities.waits;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Epic("Automation Project Johnny Gomez")
@Story("Currency Change Test")
public class currencyTest extends baseTest {
    public currencyTest() {
        super("chrome");
    }

    @Test(groups = {"Regression"}, description = "Use is able to select the Currency of item Price", dataProvider = "getProductsDataFromJson", dataProviderClass = productsDataProvider.class)
    @Description("User is able to select the product and change the currency of the item displayed")
    @Severity(SeverityLevel.NORMAL)
    public void currencyValidation(productData _productData) throws FileNotFoundException {
        landingPage landingPg = new landingPage(driver, getBaseUrl());
        searchResultsPage searchResults = new searchResultsPage(driver);
        itemCatalogPage CatalogPage = new itemCatalogPage(driver);
        waits wait = new waits(driver);
        String Prod_Name;
        Prod_Name=_productData.getName();
        landingPg.goToPage();
        landingPg.doSearch(Prod_Name);
        Assert.assertEquals(searchResults.SetProductTile().size() > 0,true);
        System.out.println("Search Results= " + searchResults.SetProductTile().size());
        if(!(searchResults.SetProductTile().size() > 0)) {
            Assert.fail("Empty list");
        }
        searchResults.SelectItemToOpenCatalog();
        wait.untilElementExists(CatalogPage.SetItemCatalogContainer());
        System.out.println("Validate Item was displayed in Catalog Page");
        System.out.println(CatalogPage.SetItemCatalogContainer().getText());
        Assert.assertEquals (CatalogPage.SetItemCatalogContainer().getText(),Prod_Name);
        if (!(CatalogPage.SetItemCatalogContainer().getText().equals(Prod_Name))) {
            Assert.fail("No Item Selected");
        }
        CatalogPage.selectCurrencyEUR();
        wait.waitForJSandJQueryToLoad();
        System.out.println("EUR Obtained=" +CatalogPage.SetProductPrice(CatalogPage.SetItemPriceContainer().getText())+"  Expected=" + _productData.getEuroPrice());
        Allure.addAttachment("imageEUR", new FileInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)));
        Assert.assertEquals (CatalogPage.SetProductPrice(CatalogPage.SetItemPriceContainer().getText()),_productData.getEuroPrice());
        if (!(CatalogPage.SetProductPrice(CatalogPage.SetItemPriceContainer().getText()).equals(_productData.getEuroPrice()))) {
            Assert.fail("Wrong Price Displayed-EUR");
        }
        CatalogPage.selectCurrencyGBP();
        wait.waitForJSandJQueryToLoad();
        System.out.println("GBP Obtained=" +CatalogPage.SetProductPrice(CatalogPage.SetItemPriceContainer().getText())+ "  Expected=" + _productData.getPoundSterlingPrice());
        Allure.addAttachment("imageGBP", new FileInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)));
        Assert.assertEquals (CatalogPage.SetProductPrice(CatalogPage.SetItemPriceContainer().getText()),_productData.getPoundSterlingPrice());
        if (!(CatalogPage.SetProductPrice(CatalogPage.SetItemPriceContainer().getText()).equals(_productData.getPoundSterlingPrice()))) {
            Assert.fail("Wrong Price Displayed-GBP");
        }
        CatalogPage.selectCurrencyUSD();
        wait.waitForJSandJQueryToLoad();
        System.out.println("USD Obtained=" +CatalogPage.SetProductPrice(CatalogPage.SetItemPriceContainer().getText())+ "  Expected=" + _productData.getDollarPrice());
        Allure.addAttachment("imageUSD", new FileInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)));
        Assert.assertEquals (CatalogPage.SetProductPrice(CatalogPage.SetItemPriceContainer().getText()),_productData.getDollarPrice());
        if (!(CatalogPage.SetProductPrice(CatalogPage.SetItemPriceContainer().getText()).equals(_productData.getDollarPrice()))) {
            Assert.fail("Wrong Price Displayed-USD");
            }
        }
     }
