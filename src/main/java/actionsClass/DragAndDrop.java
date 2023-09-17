package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {

    public static void main(String[] str) throws InterruptedException {

        WebDriver driver;
        int implicitlyWait = 30;
        int pageLoadWait   = 50;

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();

                    Thread.sleep(3000);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitlyWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadWait , TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/test/drag_drop.html");

        Actions action = new Actions(driver);

        WebElement debitSideAccountFrom = driver.findElement(By.cssSelector("div#products>div>ul>li:nth-of-type(5)>a"));
        WebElement debitSideAccountTo = driver.findElement(By.cssSelector("ol#bank>li.placeholder"));
        WebElement debitSideAmountFrom = driver.findElement(By.cssSelector("div#products>div>ul>li:nth-of-type(2)>a"));
        WebElement debitSideAmountTo = driver.findElement(By.cssSelector("div#products+table>tbody>tr>td:nth-of-type(1)>table>tbody>tr>td:nth-of-type(2)>div#shoppingCart4>div>ol>li:nth-of-type(1)"));

        action.dragAndDrop(debitSideAccountFrom , debitSideAccountTo).build().perform();
                    Thread.sleep(3000);

        action.dragAndDrop(debitSideAmountFrom , debitSideAmountTo).build().perform();
                    Thread.sleep(3000);

        WebElement creditSideAccountFrom = driver.findElement(By.cssSelector("div#products>div>ul>li:nth-of-type(6)>a"));
        WebElement creditSideAccountTo = driver.findElement(By.cssSelector("ol#loan>li"));
        WebElement creditSideAmountFrom = driver.findElement(By.cssSelector("div#products>div>ul>li:nth-of-type(2)>a"));
        WebElement creditSideAmountTo = driver.findElement(By.cssSelector("div#products+table>tbody>tr>td:nth-of-type(2)>table>tbody>tr>td:nth-of-type(2)>div>div>ol>li"));

        action.dragAndDrop(creditSideAccountFrom , creditSideAccountTo).build().perform();
                    Thread.sleep(3000);

        action.dragAndDrop(creditSideAmountFrom , creditSideAmountTo).build().perform();
                    Thread.sleep(3000);

        WebElement perfectResult = driver.findElement(By.cssSelector("div[class^='span']>div>div:nth-of-type(5)>a"));
        Assert.assertTrue(perfectResult.isDisplayed());

                    Thread.sleep(3000);

        driver.close();
        driver.quit();
    }
}
