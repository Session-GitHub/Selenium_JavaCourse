package testNGPrograms.parallelTestExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/*
 * @author verma.piyush
 */
public class ExampleTest extends BaseClassParallelTesting{

    WebDriver driver;
    String url = "https://www.example.com/";
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

        String expectedTitle = "Example Domain";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle);
                baseClass.staticPause(3);
    }

    @Test(priority = 3)
    public void verifyLogo () {

        WebElement logo = driver.findElement(By.xpath("//h1[normalize-space()='Example Domain']"));
        baseClass.explicitlyWaitForElementVerify(driver , 50 , logo);
                baseClass.staticPause(3);
    }

    @Test(priority = 4)
    public void clickOnMoreInformation () {

        WebElement clickElement = driver.findElement(By.xpath("//a[normalize-space()='More information...']"));
        baseClass.explicitWaitForClick(driver , 50 , clickElement);
                baseClass.staticPause(3);
    }

    @Test(priority = 5)
    public void clickOnAbout () {

        WebElement about = driver.findElement(By.xpath("//a[normalize-space()='About']"));
        baseClass.explicitWaitForClick(driver , 60 , about);
                baseClass.staticPause(3);
    }

    @Test(priority = 6)
    public void verifyText () {

        WebElement text = driver.findElement(By.xpath("//h1[.='About us']"));
        Assert.assertTrue(text.isDisplayed());
                baseClass.staticPause(3);
    }

    @AfterTest
    public void closeBrowser () {

        baseClass.tearDown();
    }
}
