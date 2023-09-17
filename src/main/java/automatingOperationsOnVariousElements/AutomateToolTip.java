package automatingOperationsOnVariousElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AutomateToolTip {

    public static void main(String[] str) throws InterruptedException {

        WebDriver driver;
        int implicitlyWait = 30;
        int pageloadWait   = 50;

        //SettingUp the Property of driver
        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");

        //Launching the browser
        driver = new ChromeDriver();

        //Maximizing the browser
        driver.manage().window().maximize();

        //Apply the implicitlyWait and PageLoadTimeout
        driver.manage().timeouts().implicitlyWait(implicitlyWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageloadWait , TimeUnit.SECONDS);
                    Thread.sleep(3000);

        //Navigating to a specific web page
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-tooltip-in-selenium.html");
                    Thread.sleep(3000);

        //
        WebElement hoverElement = driver.findElement(By.xpath("//div[@class='tooltip']"));
        Actions action = new Actions(driver);
        action.moveToElement(hoverElement).build().perform();
                    Thread.sleep(3000);

        //validate the ToolTip Text
        WebElement toolTipElement = driver.findElement(By.xpath("//span[contains(text() , 'Tooltip text')]"));
        String actualHelpText = toolTipElement.getText();
        String expectedHelpText = "Tooltip text";
        Assert.assertEquals(actualHelpText , expectedHelpText);
                    Thread.sleep(5000);

        driver.close();
        driver.quit();
    }
}
