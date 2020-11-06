package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class basePage {

    public WebDriver driver;
    public String url;

    public basePage (WebDriver driver) {
        this.driver=driver;
    }


    public basePage (WebDriver driver, String url) {
        this.driver=driver;
        this.url=url;
    }

    //execute go to page
    public void goToPage() {
        this.driver.get(this.url);
    }
}
