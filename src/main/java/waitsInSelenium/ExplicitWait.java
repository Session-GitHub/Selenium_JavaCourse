package waitsInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {

    public static void main(String[] str) throws InterruptedException {

        WebDriver driver;
        int implicitlyWait = 30;
        int pageloadTimeOut = 50;
        WebDriverWait wait;

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitlyWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageloadTimeOut , TimeUnit.SECONDS);
                    Thread.sleep(5000);

        driver.get("https://www.google.com");
                    Thread.sleep(5000);

        wait = new WebDriverWait(driver , 50);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//textarea[@name='q']"))));

        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("What are the waits in selenium");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.RETURN);
                    Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
