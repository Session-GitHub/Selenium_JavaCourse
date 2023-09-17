package handlingFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SwitchToIFrame {

    static WebDriver driver;
    static int implicitlyWait = 30;
    static int pageloadWait   = 50;

    static String url = "https://demo.midtrans.com/";

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
                    Thread.sleep(3000);


        //move to the iFrame
        driver.findElement(By.xpath("//a[@class='btn buy']")).click();
                    Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='cart-checkout']")).click();
                    Thread.sleep(10000);


        //handling iFrame--------------------------------------------
        String expectedHeader = "Rp20.000";

        //switching to iframe by index value
        //driver.switchTo().frame(0);

        //switching to iframe by id
        driver.switchTo().frame("snap-midtrans");

        //switching to iframe by name
        //driver.switchTo().frame("popup_1687443071775");
        //driver.switchTo().frame("popup_1687443903080");

        //switching to iframe by web-element
        WebElement frameEle = driver.findElement(By.xpath("//iframe[@id='snap-midtrans']"));
        driver.switchTo().frame(frameEle);

        //verifying heading
        WebElement actualHeader = driver.findElement(By.xpath("//div[contains(.,'Rp20.000')]"));
        Assert.assertTrue(actualHeader.isDisplayed());
        System.out.println("Successfully switch to iframe : ");
        System.out.println("Header is Present : ");

        //switch to main frame
        driver.switchTo().defaultContent();
        System.out.println("Successfully switch to main frame : ");


        driver.close();
        driver.quit();
    }
}
