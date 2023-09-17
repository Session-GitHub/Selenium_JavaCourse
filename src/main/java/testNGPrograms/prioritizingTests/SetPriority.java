package testNGPrograms.prioritizingTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/*
 * @author verma.piyush
 */
public class SetPriority extends BaseClassSetPriority {

    BaseClassSetPriority baseClass = new BaseClassSetPriority();
    static String url = "http://demo.guru99.com/test/simple_context_menu.html";

    @BeforeTest
    public void openBrowserAndNavigateToURL() {

        baseClass.initializingBrowser();
                baseClass.staticPause(5);

        driver.get(url);
                baseClass.staticPause(5);
    }

    @Test(priority = 1)
    public void rightClickOnEdit() {

        Actions action = new Actions(driver);
        WebElement rightClickEdit = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        action.contextClick(rightClickEdit).perform();
                baseClass.staticPause(5);
        driver.findElement(By.xpath("//span[contains(text(),'Edit')]")).click();
                baseClass.staticPause(5);
        String actualMsg = driver.switchTo().alert().getText();
        String expectedAlertMsg = "clicked: edit";
        Assert.assertEquals(actualMsg , expectedAlertMsg);
                baseClass.staticPause(5);
        driver.switchTo().alert().accept();
                baseClass.staticPause(5);
        System.out.println("Edit:");
    }

    @Test(priority = 2)
    public void rightClickCut() {

        Actions action = new Actions(driver);
        WebElement rightClickCut = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        action.contextClick(rightClickCut).perform();
                baseClass.staticPause(5);
        driver.findElement(By.xpath("//span[contains(text(),'Cut')]")).click();
                baseClass.staticPause(5);
        String cutText = driver.switchTo().alert().getText();
        Assert.assertEquals(cutText , "clicked: cut");
                baseClass.staticPause(5);
        driver.switchTo().alert().accept();
                baseClass.staticPause(5);
        System.out.println("Cut:");
    }

    @Test(priority = 3)
    public void rightClickCopy() {

        Actions action = new Actions(driver);
        WebElement rightClickCopy = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        action.contextClick(rightClickCopy).build().perform();
                baseClass.staticPause(5);
        driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).click();
                baseClass.staticPause(5);
        String copyText = driver.switchTo().alert().getText();
        Assert.assertEquals(copyText , "clicked: copy");
                baseClass.staticPause(5);
        driver.switchTo().alert().accept();
                baseClass.staticPause(5);
        System.out.println("Copy:");
    }

    @Test(priority = 4)
    public void rightClickPaste() {

        Actions action = new Actions(driver);
        WebElement rightClickPaste = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        action.contextClick(rightClickPaste).perform();
                baseClass.staticPause(5);
        driver.findElement(By.xpath("//span[contains(text(),'Paste')]")).click();
                baseClass.staticPause(5);
        String pasteText = driver.switchTo().alert().getText();
        Assert.assertEquals(pasteText , "clicked: paste");
                baseClass.staticPause(5);
        driver.switchTo().alert().accept();
                baseClass.staticPause(5);
        System.out.println("Paste:");
    }

    @Test(priority = 5)
    public void rightClickDelete() {

        Actions action = new Actions(driver);
        WebElement rightClickDelete = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        action.contextClick(rightClickDelete).perform();
                baseClass.staticPause(5);
        driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
                baseClass.staticPause(5);
        String deleteText = driver.switchTo().alert().getText();
        Assert.assertEquals(deleteText , "clicked: delete");
                baseClass.staticPause(5);
        driver.switchTo().alert().accept();
                baseClass.staticPause(5);
        System.out.println("Delete:");
    }

    @Test(priority = 6)
    public void rightClickQuit() {

        Actions action = new Actions(driver);
        WebElement rightClickQuit = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        action.contextClick(rightClickQuit).perform();
                baseClass.staticPause(5);
        driver.findElement(By.xpath("//span[contains(text(),'Quit')]")).click();
                baseClass.staticPause(5);
        String quitText = driver.switchTo().alert().getText();
        Assert.assertEquals(quitText , "clicked: quit");
                baseClass.staticPause(5);
        driver.switchTo().alert().accept();
                baseClass.staticPause(5);
        System.out.println("Quit:");
    }

    @AfterTest
    public void closeBrowser () {

        baseClass.tearDown();
    }
}
/*
Edit
Cut
Copy
Paste
Delete
Quit
 */