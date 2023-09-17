package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class RightClick2 {

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

        Actions action = new Actions(driver);

        WebElement rightClickCopy = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        action.contextClick(rightClickCopy).build().perform();
                        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).click();
                        Thread.sleep(3000);

        String copyText = driver.switchTo().alert().getText();
        Assert.assertEquals(copyText , "clicked: copy");
                        Thread.sleep(3000);

        driver.switchTo().alert().accept();
                        Thread.sleep(3000);


        driver.close();
        driver.quit();
    }
}
