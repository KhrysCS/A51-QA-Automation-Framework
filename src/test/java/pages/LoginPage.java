package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //region A51-L23-Class-Demo
    // LOCATORS USING SELENIUM PAGE FACTORY

    //WebElements
    @FindBy(css = "[type='submit']")
    WebElement submitButtonLocator;
    @FindBy(css = "[type='email']")
    WebElement emailField;

    @FindBy(css = "[type='password']")
    WebElement passwordField;

    //Methods
    public LoginPage clickSubmitBtn(){

        submitButtonLocator.click();
        //click(submitButtonLocator);
        return this;
    }

//    public void clickSubmitBtn(){
//        submitButtonLocator.click();
//    }
//

    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

//    public void provideEmail(String email){
//        emailField.sendKeys(email);
//    }
//

    public LoginPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
//    public void providePassword(String password){
//        passwordField.sendKeys(password);
//    }
    //end region

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //region Locators
  //  By emailField = By.cssSelector("input[type='email']");

  //  By passwordField = By.cssSelector("input[type='password']");

  //  By submitBtn = By.cssSelector("button[type='submit']");
    //endregion

    //region Helper Methods
//    public void provideEmail(String email) {
//        findElement(emailField).sendKeys(email);
//    }
//    public void providePassword(String password) {
//        findElement(passwordField).sendKeys(password);
//    }
//
//    public void clickSubmit() {
//        findElement(submitBtn).click();
//    }

    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        //clickSubmit();
        clickSubmitBtn();
    }

    //Original code
    /*
    //constructor
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //region Locators
    By emailField = By.cssSelector("input[type='email']");

    By passwordField = By.cssSelector("input[type='password']");

    By submitBtn = By.cssSelector("button[type='submit']");
    //endregion

    //region Helper Methods
    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElement(submitBtn).click();
    }

    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }
    //endregion

     */
}
