import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"login\"]/div[1]/label/input")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"login\"]/div[2]/label/input")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login\"]/div[3]/button")
    private WebElement submit;
    @FindBy(xpath = "//a[contains(text(),'Next Page')]")
    private WebElement nextPage;

    @FindBy(xpath = "//div[@class = 'content']/div/a[1]/img")//картинка поста
    private WebElement img;

    @FindBy(xpath = "//div[@class = 'content']/div/a[1]/h2")//заголовок поста
    private WebElement title;

    @FindBy(xpath = "//div[@class = 'content']/div/a[1]/div")//описание поста
    private WebElement description;
    @FindBy(xpath = "//button[@id='SMUI-form-field-1'and @aria-checked='true']")
    private WebElement notMyPost;

    public void goToAccountPage(){
        username.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://test-stand.gb.ru/"));
    }

    public MainPage(WebDriver driver) {
    super(driver);
    }

    public MainPage img(){
        img.click();
        return this;
    }

    public MainPage title(){
        title.click();
        return this;
    }
    public MainPage notMyPost(){
        notMyPost.click();
        return this;
    }
    public MainPage description(){
        description.click();
        return this;
    }
    public MainPage clicksubmit(){
        submit.click();
        return this;
    }
    public MainPage clicknextPage(){
        submit.click();
        return this;
    }
    public MainPage clickusername(String s){
        username.click();
        return this;
    }
    public MainPage clickpassword(String s){
        password.click();
        return this;
    }
}
