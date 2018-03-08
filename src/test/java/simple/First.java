package simple;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class First {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void simpleFunctionalityTest() throws InterruptedException {
        driver.get("http://www.google.com");
        WebElement btn = driver.findElement(By.name("btnK"));
        System.out.println("font " + btn.getCssValue("font-family"));
        System.out.println("background color: " + btn.getCssValue("background-color"));
        System.out.println("location: " + btn.getLocation());
        System.out.println("size: " + btn.getSize());
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(Keys.chord(Keys.SHIFT, "space supernova"));
        searchBox.submit();
//        driver.findElement(By.xpath("div.hdtb-mitem:nth-child(2) > a")).click();
        Thread.currentThread().sleep(2000L);
    }

}
