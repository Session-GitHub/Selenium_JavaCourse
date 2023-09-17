package handlingFrames;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SizeOfIFrames {

    static WebDriver driver;
    static int implicitlyWait = 30;
    static int pageloadWait   = 50;

    static String url = "https://demo.midtrans.com/";
    //static String url = "https://www.selenium.dev/";
    //static String url = "https://www.guru99.com/guide-to-install-jmeter.html";
    //static String url = "https://demo.guru99.com/test/guru99home/";

    public static void main(String[] str) throws InterruptedException {

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
        driver.get(url);
                    Thread.sleep(5000);


        //to find how many iFrames are on the web-page
        int numberOfIFrames = driver.findElements(By.tagName("iframes")).size();
        System.out.println("Total number of iframes on " + "'" + url + "'" + " web-page are : " + numberOfIFrames);

        driver.close();
        driver.quit();
    }
}
