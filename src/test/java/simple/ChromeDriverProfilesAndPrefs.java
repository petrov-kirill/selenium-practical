package simple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeDriverProfilesAndPrefs {

    @Test
    public void basic() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Kirill_Petrov\\IdeaProjects\\321\\selenium-practical\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Chrome Driver");
    }
}
