package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registerPage extends basePage {

    //declare Register page webObjects

    private By regFirstNameTxtBox = By.id("input-firstname");
    private By regLastNameTxtBox = By.id("input-lastname");
    private By regEmailTxtBox = By.id("input-email");
    private By regTelephoneTxtBox = By.id("input-telephone");
    private By regPasswordTxtBox = By.id("input-password");
    private By regPwdConfirmTxtBox = By.id("input-confirm");
    private By policyAgreement = By.xpath("//input[@name='agree']");
    private By continueButton = By.xpath("//input[@type='submit']");



    public registerPage(WebDriver driver, String url){
        super (driver, url + "index.php?route=account/register");
    }

    public WebElement setFirstNameTxtBox() {
        return driver.findElement (this.regFirstNameTxtBox);
        }
    public WebElement setLastNameTxtBox() {
        return driver.findElement (this.regLastNameTxtBox);
    }
    public WebElement SetEmailTxtBox (){
        return driver.findElement(this.regEmailTxtBox);
    }
    public WebElement SetTelephoneTxtBox (){
        return driver.findElement(this.regTelephoneTxtBox);
    }
    public WebElement SetPasswordTxtBox (){
        return driver.findElement(this.regPasswordTxtBox);
    }
    public WebElement SetPwdConfirmTxtBox (){
        return driver.findElement(this.regPwdConfirmTxtBox);
    }
    public WebElement SetContinueButton (){
        return driver.findElement(this.continueButton);
    }
    public WebElement SetPolicyAgreement (){
        return driver.findElement(this.policyAgreement);
    }
    public void doRegister(String RegFirstName, String RegLastName, String RegEmail,
                           String RegTelephone,String RegPassword, String RegPwdConfirm){

        this.setFirstNameTxtBox().sendKeys(RegFirstName);
        this.setLastNameTxtBox().sendKeys(RegLastName);
        this.SetEmailTxtBox().sendKeys(RegEmail);
        this.SetTelephoneTxtBox().sendKeys(RegTelephone);
        this.SetPasswordTxtBox().sendKeys(RegPassword);
        this.SetPwdConfirmTxtBox().sendKeys(RegPwdConfirm);
        this.SetPolicyAgreement().click();
        this.SetContinueButton().click();
    }
}
