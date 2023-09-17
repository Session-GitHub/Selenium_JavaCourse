package testNGPrograms.parallelTestExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/*
 * @author verma.piyush
 */
public class GoogleTest extends BaseClassParallelTesting{

    WebDriver driver;
    static String url = "https://www.google.com";
    BaseClassParallelTesting baseClass = new BaseClassParallelTesting();

    @BeforeTest
    public void openBrowser () {

        driver = baseClass.initializingBrowser();
                baseClass.staticPause(3);
    }

    @Test(priority = 1)
    public void navigateToURL () {

        driver.get(url);
                baseClass.staticPause(3);
    }
    @Test(priority = 2)
    public void verifyTitle () {

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle);
                baseClass.staticPause(3);
    }

    @Test(priority = 3)
    public void verifyLogo () {

        WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));
        Assert.assertTrue(logo.isDisplayed());
                baseClass.staticPause(3);
    }

    @Test(priority = 4)
    public void searchText () {

        WebElement searchElement = driver.findElement(By.xpath("//textarea[@name='q']"));
        String text = "How to execute tests parallelly in TestNG";
        baseClass.explicitWaitForSendKeys(50, searchElement, text);
        searchElement.sendKeys(Keys.RETURN);
                baseClass.staticPause(3);
    }

    @AfterTest
    public void closeBrowser () {

        baseClass.tearDown();
    }
}
