package simple;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AdvancedInteractions {

    @Test
    public void fileActionBuildPerform() {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:\\Users\\Kirill_Petrov\\IdeaProjects\\321\\selenium-practical\\Selectable.html");
        WebElement one = driver.findElement(By.name("one"));
        WebElement three = driver.findElement(By.name("three"));
        WebElement five = driver.findElement(By.name("five"));

        //add all actions into the Actions builder.
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL)
                .click(one)
                .click(three)
                .click(five)
                .keyUp(Keys.CONTROL);
        //generate composite action
        Action compositeAction = builder.build();

        //perform composite action
        compositeAction.perform();
    }

    @Test
    public void clickOnWebElement() {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:\\Users\\Kirill_Petrov\\IdeaProjects\\321\\selenium-practical\\Selectable.html");
        WebElement one = driver.findElement(By.name("one"));
        WebElement three = driver.findElement(By.name("three"));
        WebElement five = driver.findElement(By.name("five"));
        Actions builder = new Actions(driver);
        builder.click(one).click(three).click(five);
        builder.build().perform();
    }

    @Test
    public void clickAndHold() {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:\\Users\\Kirill_Petrov\\IdeaProjects\\321\\selenium-practical\\Sortable.html");
        WebElement three = driver.findElement(By.name("three"));
        WebElement two = driver.findElement(By.name("two"));
        Actions builder = new Actions(driver);
        builder.clickAndHold(three).release(two).perform();
//        builder.clickAndHold(three).moveByOffset(120,0).release().perform();
    }

    @Test
    public void dragMe() {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:\\Users\\Kirill_Petrov\\IdeaProjects\\321\\selenium-practical\\DragMe.html");
        WebElement dragMe = driver.findElement(By.id("draggable"));
        WebElement dropHere = driver.findElement(By.id("droppable"));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(dragMe, dropHere).perform();
//        builder.dragAndDropBy(dragMe, 150, 0).perform();
    }

    @Test
    public void doubleClick() {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:\\Users\\Kirill_Petrov\\IdeaProjects\\321\\selenium-practical\\DoubleClick.html");
        WebElement dblClick = driver.findElement(By.name("dblClick"));
        Actions actions = new Actions(driver);
        actions.doubleClick(dblClick).perform();
        actions.moveToElement(dblClick).doubleClick().perform();
    }

    @Test
    public void contextClick() {
        WebDriver driver = new FirefoxDriver();
        driver.get("file://C:\\Users\\Kirill_Petrov\\IdeaProjects\\321\\selenium-practical\\ContextClick.html");
        WebElement contextMenu = driver.findElement(By.id("div-context"));
        Actions builder = new Actions(driver);
//        builder.contextClick(contextMenu).click(driver.findElement(By.name("Item 4"))).perform();
        builder.moveToElement(contextMenu).contextClick().click(driver.findElement(By.name("Item 4"))).perform();
    }
}
