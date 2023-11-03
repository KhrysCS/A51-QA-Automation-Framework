import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20Draft extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException{

        String uniquePlaylist = "1-HW19-Playlist";
        String deletePlaylistMsg = "Deleted playlist \"1-HW19-Playlist.\"";

        //Pre-condition
        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        //Create empty playlist
        createPlaylist(uniquePlaylist);

        Thread.sleep(4000);

        //Click on empty playlist created
        clickOnPlaylist();

        //delete selected playlist
        clickOnDeleteBtn();
        Thread.sleep(2000);

        //Expected Results
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alertify-logs div.success")));//driver.findElement(By.cssSelector("div.alertify-logs div.success"));

        Assert.assertEquals(deletePlaylistMsg,notificationMsg.getText());

    }

    private void createPlaylist(String uniquePlaylist) {
        clickOnCreateNewPlaylistBtn();
        clickOnMenuNewPlayListMBtn();
        provideNewPlaylistName(uniquePlaylist);
    }

    private void provideNewPlaylistName(String uniquePlaylist) {
        WebElement playListField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));//driver.findElement(By.cssSelector("input[name='name']"));
        playListField.clear();
        playListField.sendKeys(uniquePlaylist);
        playListField.sendKeys(Keys.ENTER);
    }

    private void clickOnMenuNewPlayListMBtn() {
        WebElement newPLBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));//driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        newPLBtn.click();
    }

    private void clickOnCreateNewPlaylistBtn() {

        WebElement addPLBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));//driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));
        addPLBtn.click();
    }

    public void clickOnPlaylist(){
        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));//driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        playList.click();
    }

    public void clickOnDeleteBtn(){
        WebElement deleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));//driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deleteBtn.click();
    }
}
