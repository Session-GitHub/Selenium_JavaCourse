package handlingAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GetTextForAlert {

    static WebDriver driver;
    static int implicitlyWait = 30;
    static int pageloadWait   = 50;

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
        driver.get("https://demo.guru99.com/test/delete_customer.php");
                        Thread.sleep(10000);

        //enter customer ID
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("98765");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
                        Thread.sleep(5000);

        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        //Capturing alert message.
        //String alertMessage = alert.getText();
        String alertMessage = driver.switchTo().alert().getText();

        //Displaying alert message
        System.out.println("Alert message is  : \n" + alertMessage);
    }
}
