package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class DoubleClick {

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

        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
                    Thread.sleep(7000);


        Actions action = new Actions(driver);

        //WebElement doubleClickElement = driver.findElement(By.xpath("//button[contains(.,'Double-Click Me To See Alert')]"));
        //action.doubleClick(doubleClickElement).build().perform();
        action.doubleClick(driver.findElement(By.xpath("//button[contains(.,'Double-Click Me To See Alert')]"))).build().perform();
                    Thread.sleep(3000);

        String doubleClickText = driver.switchTo().alert().getText();
        Assert.assertEquals(doubleClickText , "You double clicked me.. Thank You..");
                    Thread.sleep(3000);

        driver.switchTo().alert().accept();
                    Thread.sleep(3000);

        driver.close();
        driver.quit();
    }
}
