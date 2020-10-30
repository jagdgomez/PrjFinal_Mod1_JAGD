package Tests;

import PageObjects.registerPage;
import PageObjects.registryConfirmPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static utilities.emailGenerator.RandomString;

public class registerTest extends baseTest {

    registerTest() {
        super("chrome");
    }


    @Test

    public void doRegister() throws InterruptedException {
        registerPage register = new registerPage(driver, getBaseUrl());
        registryConfirmPage RegisterConfirm = new registryConfirmPage(driver);
        register.goToPage();
        //Generate email
        String GenericMail= RandomString(6)+"@test.com";
        System.out.println("Generic Email: "+ GenericMail);
        //Execute and Create new registry
        register.doRegister("Johnny","Gómez",GenericMail,
                "70110555","Test#123","Test#123");
        //   System.out.println("Container results: "+RegisterConfirm.SetRegistryCreatedContainer().getText());
        Assert.assertEquals(RegisterConfirm.SetRegistryCreatedContainer().getText(),"Your Account Has Been Created!");
    }


}

