package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SendKeys_2 {

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

        driver.get("https://www.google.com");
                    Thread.sleep(3000);

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//textarea[@name='q']"))).
                sendKeys("What is sendKeys() in Selenium WebDriver").build().perform();
                    Thread.sleep(3000);

        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.RETURN);
                    Thread.sleep(3000);

        driver.close();
        driver.quit();
    }
}
