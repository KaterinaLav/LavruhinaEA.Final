import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LogginPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"login\"]/div[1]/label/input")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"login\"]/div[2]/label/input")
    private WebElement password;

    @FindBy(xpath = "//button/span[text()='Login']")
    private WebElement submit;

    public LogginPage(WebDriver driver){
        super(driver);
    }

    public void logginIn(){
        this.submit.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://test-stand.gb.ru/"));
    }


    public LogginPage setUserName(String userName){
        this.username.sendKeys(userName);
        return this;
    }

    public LogginPage setPassword(String password){
        this.password.click();
        this.password.sendKeys(password);
        return this;
    }
}
