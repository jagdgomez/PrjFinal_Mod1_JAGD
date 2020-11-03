package Tests;

import PageObjects.dashboardPage;
import PageObjects.loginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest extends baseTest{

    //select browser
    loginTest (){
        super ("chrome");
    }

   // @Test


    public void doLogin() throws InterruptedException {

        loginPage login = new loginPage(driver, getBaseUrl());
        dashboardPage dashboard = new dashboardPage(driver);

        login.goToPage();
        login.doLogin("alexgf08@gmail.com","Test123");

        Assert.assertEquals(dashboard.SetAccountContainer().isDisplayed(),true);

        Thread.sleep(5000);

    }

}



