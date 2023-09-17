package automatingOperationsOnVariousElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebPageOperations {

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
        driver.get("https://www.google.com/");
                    Thread.sleep(3000);

        //Getting the page Title
        String getPageTitle = driver.getTitle();
        System.out.println("WebPage Title is : " + getPageTitle);

        //Getting the URL of the page
        String getPageURL = driver.getCurrentUrl();
        System.out.println("WebPage URL is : " + getPageURL);
                    Thread.sleep(3000);

        driver.close();
        driver.quit();
    }
}
