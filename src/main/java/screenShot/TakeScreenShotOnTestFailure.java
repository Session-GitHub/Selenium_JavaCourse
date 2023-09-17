package screenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakeScreenShotOnTestFailure {

    static WebDriver driver;
    static int implicitlyWait = 30;
    static int pageloadWait   = 50;


    //method for taking screenShot
    public static void takingScreenShotOnTestFailure () {

        //destination path
        String destPath = "screenShots" + "\\\\" + "testName" + "_.jpeg";

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scr = ((TakesScreenshot) driver);

        //Call getScreenshotAs method to create image file
        File src = scr.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File dest = new File(destPath);

        //Copy file at destination
        try {

            FileUtils.copyFile(src , dest);
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }


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
        driver.get("https://demo.midtrans.com/");
        Thread.sleep(3000);

        //let's say, here my test has failed, and it takes screenShot
        takingScreenShotOnTestFailure();
        System.out.println("Screen Shot successfully saved : ");

        driver.close();
        driver.quit();
    }
}
