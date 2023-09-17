package automatingOperationsOnVariousElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BrowserOperations {

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
        driver.get("https://www.renewbuy.com/");
                    Thread.sleep(3000);

        //Refreshing the browser
        driver.navigate().refresh();
                    Thread.sleep(3000);

        //Close the current browser
        //driver.close();


        //Closing every browser opened by WebDriver at the time of execution
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Login')]"))).
                moveToElement(driver.findElement(By.xpath("(//a[contains(.,'Partner')])[1]"))).click().build().perform();
                    Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@class='sign-up-text']")).click();
                    Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(.,'Terms & Conditions')]")).click();

        //switching to new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
                    Thread.sleep(5000);

        driver.close();

        driver.quit();

    }
}
