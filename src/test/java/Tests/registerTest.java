package Tests;

import PageObjects.registerPage;
import PageObjects.registryConfirmPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class registerTest extends baseTest {

    registerTest() {
        super("chrome");
    }


    @Test

    public void doRegister() throws InterruptedException {
        registerPage register = new registerPage(driver, getBaseUrl());
        registryConfirmPage RegisterConfirm = new registryConfirmPage(driver);
        register.goToPage();
        register.doRegister("Johnny","Gómez","jgtest3@test.com",
                "70110555","Test#123","Test#123");
        //   System.out.println("Container results: "+RegisterConfirm.SetRegistryCreatedContainer().getText());
        Assert.assertEquals(RegisterConfirm.SetRegistryCreatedContainer().getText(),"Your Account Has Been Created!");
    }
}