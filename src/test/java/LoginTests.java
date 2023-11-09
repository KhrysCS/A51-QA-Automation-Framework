import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {


    //region Tests
    @Test//This method uses POM (Page Object Model) design pattern
    public void loginValidEmailPasswordTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

       // loginPage.provideEmail("demo@class.com").providePassword("te$t$tudent").clickSubmitBtn();
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
       // Assert.assertTrue(homePage.getUserAvatar());


     //LoginPage loginPage = new LoginPage(driver);
      //  HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        Thread.sleep(3000);
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar());

    }
    @Test
    public void loginValidEmailPassword(){

        navigateToPage();

        //Steps
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com").providePassword("te$t$tudent").clickSubmitBtn();

        //Expected Result
       // WebElement avatarImg = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(homePage.getUserAvatar());

    }
    

    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
/*        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
    //endregion

}
