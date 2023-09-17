package automatingOperationsOnVariousElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TextAreaOperations {

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
        driver.get("https://www.grazitti.com/resource/articles/automating-different-input-fields-using-selenium-webdriver/");
                    Thread.sleep(3000);

        //WebElement for Text Area
        WebElement textArea = driver.findElement(By.xpath("//textarea[@id='commentCapture']"));

        //Enter Text in Text Area
        textArea.sendKeys("Selenium is a very good Automation Testing Tool : ");
                    Thread.sleep(5000);

        //Getting entered Text from Text Area
        String comment = textArea.getAttribute("value");
        System.out.println("Entered Text is : " + "'" + comment + "'");

        //clear the entered Text from Text Area
        textArea.clear();
                    Thread.sleep(5000);

        driver.close();
        driver.quit();
    }
}
