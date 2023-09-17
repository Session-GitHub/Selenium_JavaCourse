package automatingOperationsOnVariousElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LinkOperations {

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
        driver.get("https://www.tutorialspoint.com/index.htm");
                    Thread.sleep(3000);

        //Return the link name
        /*String linkName = driver.findElement(By.linkText("Coding Ground")).getAttribute("href");
        System.out.println("Link is : " + linkName);
         */

        String linkName = driver.findElement(By.linkText("Coding Ground")).getAttribute("href");
        System.out.println("Link is : " + linkName);

        //Clicking on link
        driver.findElement(By.linkText("Coding Ground")).click();
                    Thread.sleep(5000);

        driver.close();
        driver.quit();
    }
}
