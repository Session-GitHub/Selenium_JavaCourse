package testNGPrograms.createXML;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * @author verma.piyush
 */
public class TestForXMLFile extends BaseClassCreateXML {

    BaseClassCreateXML baseClass = new BaseClassCreateXML();
    static String url = "https://www.google.com";


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
    public void searchText () {

        String text = "what is testng";
        baseClass.explicitWaitForSendKeys(60, driver.findElement(By.xpath("//textarea[@name='q']")), text);
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.RETURN);
        baseClass.staticPause(5);
    }

    @AfterTest
    public void closeBrowser () {

        baseClass.tearDown();
    }
}
