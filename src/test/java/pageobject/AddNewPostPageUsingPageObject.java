package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AddNewPostPageUsingPageObject {

    @Test
    public void test() {
        WebDriver driver = new FirefoxDriver();
        AdminLoginPage loginPage = PageFactory.initElements(driver, AdminLoginPage.class);
        AllPostsPage allPostsPage = loginPage.login();
        allPostsPage.createANewPost("Creating New Post using PageObjects", "Its good to use PageObjects");
    }
}
