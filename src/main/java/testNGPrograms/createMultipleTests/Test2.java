package testNGPrograms.createMultipleTests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * @author verma.piyush
 */
public class Test2 extends BaseClassMultipleTests {

    BaseClassMultipleTests baseClass = new BaseClassMultipleTests();
    static String url = "https://www.example.com";


    @BeforeTest
    public void openBrowser () {

        baseClass.initializingBrowser();
                baseClass.staticPause(5);
    }

    @Test
    public void navigateToURL () {

        driver.get(url);
                baseClass.staticPause(5);
    }

    @Test
    public void clickOnMoreInformation () {

        baseClass.explicitWaitForClick(driver, 60, driver.findElement(By.xpath("//a[contains(.,'More information..')]")));
                baseClass.staticPause(5);
    }

    @AfterTest
    public void closeBrowser () {

        baseClass.tearDown();
    }
}
