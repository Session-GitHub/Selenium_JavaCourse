package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class RightClick1 {

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
                    Thread.sleep(10000);

        Actions action = new Actions(driver);

        WebElement rightClickEdit = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        action.contextClick(rightClickEdit).build().perform();

                    Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Edit')]")).click();
                    Thread.sleep(3000);

        String editText = driver.switchTo().alert().getText();
        Assert.assertEquals(editText , "clicked: edit");
                    Thread.sleep(3000);

        driver.switchTo().alert().accept();
                    Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}
