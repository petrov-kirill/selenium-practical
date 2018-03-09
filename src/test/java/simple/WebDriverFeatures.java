package simple;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WebDriverFeatures {

    @Test
    public void browserCapabilities() {
        Map<String, Boolean> capabilitiesMap = new HashMap<>();
        capabilitiesMap.put("takesScreenShot", true);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(capabilitiesMap);
        WebDriver driver = new FirefoxDriver(desiredCapabilities);
        driver.get("http://www.google.com");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println(scrFile.getAbsolutePath());
    }

    @Test
    public void screenShotTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com/");
        File scrFile = ((TakesScreenshot)driver).
                getScreenshotAs(OutputType.FILE);
        System.out.println(scrFile.getAbsolutePath());
    }

    @Test
    public void windowHandling() {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("file://C:\\Users\\Kirill_Petrov\\IdeaProjects\\321\\selenium-practical\\Window.html");
        String window1 = firefoxDriver.getWindowHandle();
        System.out.println("First window is: " + window1);
        firefoxDriver.findElement(By.linkText("Google Search")).click();
        String window2 = firefoxDriver.getWindowHandle();
        System.out.println("Second window is: " + window2);
        System.out.println("Number of window handles: " + firefoxDriver.getWindowHandles().size());
        firefoxDriver.switchTo().window(window1);
    }

    @Test
    public void switchBetweenFrames() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("file://C:\\Users\\Kirill_Petrov\\IdeaProjects\\321\\selenium-practical\\Frames.html");
        Actions action = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement txt = driver.findElement(By.name("frameOne"));
        txt.sendKeys("I'm Frame One");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        txt = driver.findElement(By.name("frameTwo"));
        txt.sendKeys("I'm Frame Two");
    }

    @Test
    public void navigateTest() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        WebElement searchButton = driver.findElement(By.name("btnG"));
        searchButton.click();
        searchBox.clear();
        searchBox.sendKeys("Packt Publishing");
        searchButton.click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
