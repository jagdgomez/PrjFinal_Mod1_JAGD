package Tests;

import PageObjects.registerPage;
import org.testng.annotations.Test;

public class registerTest extends baseTest {

    registerTest() {
        super("chrome");
    }


    @Test

    public void doRegister() throws InterruptedException {
        registerPage register = new registerPage(driver, getBaseUrl());
        register.goToPage();
        register.doRegister("Johnny","Gómez","jgtest1@test.com",
                "70110555","Test#123","Test#123");
        Thread.sleep(10000);
        //pending create asserts Your accounts was succesfully created!!!

    }
}