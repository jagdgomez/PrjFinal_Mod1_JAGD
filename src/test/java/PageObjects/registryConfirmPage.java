package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registryConfirmPage extends basePage {
    private By registryCreatedContainer = By.xpath("//*[@id='common-success']//h1");

    public registryConfirmPage(WebDriver driver) {
        super(driver);
    }

    public WebElement SetRegistryCreatedContainer() {
        return driver.findElement(this.registryCreatedContainer);

    }
}
