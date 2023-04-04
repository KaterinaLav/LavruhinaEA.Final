import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyPostTest extends AbstractTest{

    // отсутствие постов у нового пользователя
    @Test
    void noMyPost(){
        new MainPage(getWebDriver()).goToAccountPage();
        new LogginPage(getWebDriver())
                .setUserName("zxc")
                .setPassword("5fa72358f0")
                .logginIn();

        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//*[@id=\"app\"]/main/div/div[3]/p")).isEnabled());
    }

    @Test
    void myPostNext() throws InterruptedException{

        new LogginPage(getWebDriver())
                .setUserName("LavStar")
                .setPassword("d216d79afd")
                .logginIn();

        WebElement nextPage = getWebDriver().findElement(By.xpath("//a[contains(text(),'Next Page')]"));
        nextPage.click();
        TimeUnit.SECONDS.sleep(2);


        Assertions.assertNotNull(getWebDriver().findElements(By.xpath("//a[@href='/?page=2']")));
    }

    @Test
    void viewNotMyPosts() throws InterruptedException {

        new LogginPage(getWebDriver())
                .setUserName("LavStar")
                .setPassword("d216d79afd")
                .logginIn();
        TimeUnit.SECONDS.sleep(2);
        WebElement switchBox = getWebDriver().findElement(By.xpath("//button[@id='SMUI-form-field-1']"));
        switchBox.click();
        TimeUnit.SECONDS.sleep(1);
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//a[@href='/?page=2&owner=notMe']")));
    }



    @Test
    void aboutProgectPage() throws InterruptedException {

        new LogginPage(getWebDriver())
                .setUserName("LavStar")
                .setPassword("d216d79afd")
                .logginIn();
        TimeUnit.SECONDS.sleep(2);
        WebElement about = getWebDriver().findElement(By.xpath("\"//ul[@class=\\\"svelte-1rc85o5\\\"]/li[1]\""));
        about.click();
        TimeUnit.SECONDS.sleep(1);
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//h1[contains(text(),'About Page')]")));
    }

    @Test
    public void viewImage() throws InterruptedException {
        new LogginPage(getWebDriver())
                .setUserName("LavStar")
                .setPassword("d216d79afd")
                .logginIn();
        TimeUnit.SECONDS.sleep(1);
        WebElement switchBox = getWebDriver().findElement(By.xpath("//button[@id='SMUI-form-field-1']"));
        switchBox.click();
        TimeUnit.SECONDS.sleep(2);
        WebElement imegePost = getWebDriver().findElement(By.xpath("//*[@id=\"app\"]/main/div/div[3]/div[1]/a[1]/img"));
        imegePost.click();
        TimeUnit.SECONDS.sleep(2);
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("posts/1"));
    }
}