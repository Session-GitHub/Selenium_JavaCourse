package handlingAlerts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SendingMessageAlert {

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
        driver.get("https://demoqa.com/alerts");
                    Thread.sleep(10000);

        //click on prompt button
        WebElement promptElement = driver.findElement(By.xpath("//button[@id='promtButton']"));


        // Javascript executor
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", promptElement);
        promptElement.click();
                    Thread.sleep(5000);

        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        //Capturing alert message.
        String getText = alert.getText();
        //String getText = driver.switchTo().alert().getText();

        //Displaying alert message
        System.out.println("Alert message is  : \n" + getText);


        //Send some text to the alert
        //alert.sendKeys("Piyush Verma");
        driver.switchTo().alert().sendKeys("Piyush Verma");
                    Thread.sleep(5000);

        driver.switchTo().alert().accept();
                    Thread.sleep(10000);


        driver.close();
        driver.quit();
    }
}
