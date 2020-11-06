package Tests;

import PageObjects.registerPage;
import PageObjects.registryConfirmPage;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.emailGenerator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Epic("Automation Project Johnny Gomez")
@Story("Register Test")
public class registerTest extends baseTest {

    registerTest() {
        super("chrome");
    }
    @Test (groups = {"Functional"}, description ="Register New User")
    @Description("New User is able to Register in the Page")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("https://demo.opencart.com/index.php?route=account/register")
    public void doRegister() throws FileNotFoundException {
        registerPage register = new registerPage(driver, getBaseUrl());
        registryConfirmPage RegisterConfirm = new registryConfirmPage(driver);
        register.goToPage();
        //Generate email
        String GenericMail= emailGenerator.RandomEmail(6);
        System.out.println("Generic Email: "+ GenericMail);

        //Execute and Create new registry
        register.doRegister("Johnny","Gomez",GenericMail,
                "70110555","Test#123","Test#123");

        Allure.addAttachment("imageRegister", new FileInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)));
        Assert.assertEquals(RegisterConfirm.SetRegistryCreatedContainer().getText(),"Your Account Has Been Created!");
    }


}

