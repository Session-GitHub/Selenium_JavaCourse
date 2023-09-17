package handleMultipleWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetWindowHandles {

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

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Login')]"))).
                moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Partner')])[1]")))
                .click().build().perform();
                        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[contains(text(),'Sign Up')]")).click();
                        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[contains(text(),' Terms & Conditions')]")).click();
                        Thread.sleep(5000);

        //GetWindowHandles method
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switching on child window
        driver.switchTo().window(tabs.get(1));
                        Thread.sleep(5000);

        //handle element on child window
        WebElement articles = driver.findElement(By.xpath("(//a[contains(text(),'Articles')])[1]"));
        articles.click();
                        Thread.sleep(5000);

        //switching on parent window
        driver.switchTo().window(tabs.get(0));
                        Thread.sleep(5000);

        //handle element on parent window
        WebElement contactUs = driver.findElement(By.xpath("//span[@class='login-text']"));
        contactUs.click();
                        Thread.sleep(5000);

        //again switching on child window
        driver.switchTo().window(tabs.get(1));
                        Thread.sleep(5000);

        driver.close();
        driver.quit();
    }
}
