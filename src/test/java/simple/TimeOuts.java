package simple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TimeOuts {

    @Test
    public void implicitWaitTime() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
    }

    @Test
    public void explicitWaitTime() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        WebElement element = (new WebDriverWait(driver, 20)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.name("q"));
            }
        });
    }
}
