import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class MainTest extends AbstractTest {


    @Test
    void mainLoginPozitiv(){

        new MainPage(getWebDriver()).goToAccountPage();
        new LogginPage(getWebDriver())
                .setUserName("LavStar")
                .setPassword("d216d79afd")
                .logginIn();

       Assertions.assertTrue(getWebDriver().findElement(By.xpath("//a[text()='LavStar']")).isEnabled());
    }
    @Test
    void mainLoginNegativ(){

        new MainPage(getWebDriver()).goToAccountPage();
        new LogginPage(getWebDriver())
                .setUserName("LavStar")
                .logginIn();

        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("login"));
    }
//Проверка пограничных значений
    @Test
    void mainLoginLess3Test(){

        new MainPage(getWebDriver()).goToAccountPage();
        new LogginPage(getWebDriver())
                .setUserName("z")
                .setPassword("3b770ebe9b")
                .logginIn();

        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("login"));
    }

    @Test
    void mainLogin3simTest(){

        new MainPage(getWebDriver()).goToAccountPage();
        new LogginPage(getWebDriver())
                .setUserName("zxc")
                .setPassword("5fa72358f0")
                .logginIn();

        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//a[text()='zxc']")).isEnabled());
    }
    @Test
    void mainLogin20simTest(){

        new MainPage(getWebDriver()).goToAccountPage();
        new LogginPage(getWebDriver())
                .setUserName("zxcvbnm1234567890zxc")
                .setPassword("18b7a95853")
                .logginIn();

        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//a[text()='zxcvbnm1234567890zxc']")).isEnabled());
    }

    @Test
    void mainLogin19Test(){

        new MainPage(getWebDriver()).goToAccountPage();
        new LogginPage(getWebDriver())
                .setUserName("zxcvbnm1234567890zx")
                .setPassword("d8c77135de")
                .logginIn();

        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//a[text()='zxcvbnm1234567890zx']")).isEnabled());
    }

    //проверка невалидного логина


}