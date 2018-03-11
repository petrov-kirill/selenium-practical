package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.testng.Assert.assertTrue;

public class AdminLoginPageUsingLoadableComponent extends LoadableComponent<AdminLoginPageUsingLoadableComponent> {

    WebDriver driver;
    @FindBy(how = How.ID, using = "user_login")
    WebElement email;
    @FindBy(how = How.ID, using = "user_pass")
    WebElement password;
    @FindBy(how = How.ID, using = "wp-submit")
    WebElement submit;

    public AdminLoginPageUsingLoadableComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AllPostsPage login() {
        email.sendKeys("pageobjectpattern@gmail.com");
        password.sendKeys("webdriver123");
        submit.click();
        return PageFactory.initElements(driver, AllPostsPage.class);
    }

    @Override
    protected void load() {
        driver.get("http://pageobjectpattern.wordpress.com/wpadmin");
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(driver.getCurrentUrl().contains("wpadmin"));
    }
}
