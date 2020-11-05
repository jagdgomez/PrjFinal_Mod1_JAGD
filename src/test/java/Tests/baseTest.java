package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest {
    public WebDriver driver;
    private String browser;
    public ChromeOptions chromeOptions;

    public baseTest(String browser) {
        this.browser = browser;
    }

    public String getBaseUrl() {
        return "https://demo.opencart.com/";
    }

    @BeforeMethod (alwaysRun = true)
    public void setUpTest() {
        // Can be used in @BeforeSuite.
        chromeOptions = new ChromeOptions();
        // No argument - then run in default mode!!!
        // Arguments list:
        //chromeOptions.addArguments("--kiosk");
        //chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--window-size=800,600");
        // chromeOptions.addArguments("--incognito");
        //chromeOptions.addArguments("--screenshot");
        this.SetWebDriverConfiguration(browser, chromeOptions);
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    private void SetWebDriverConfiguration(String browser, ChromeOptions options) {
        if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        }
    }
}
