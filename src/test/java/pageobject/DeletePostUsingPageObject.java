package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DeletePostUsingPageObject {

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kirill_Petrov\\IdeaProjects\\321\\selenium-practical\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        AdminLoginPage loginPage = PageFactory.initElements(driver, AdminLoginPage.class);
        AllPostsPage allPostsPage = loginPage.login();
        allPostsPage.deleteAPost("Creating New Post using PageObjects");
    }
}
