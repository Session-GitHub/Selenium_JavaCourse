package automatingOperationsOnVariousElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EditBoxOperations {

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
        driver.get("https://demo.midtrans.com/");
                    Thread.sleep(3000);

        driver.findElement(By.xpath("//a[normalize-space()='BUY NOW']")).click();
                    Thread.sleep(5000);

        //Clear the text
        driver.findElement(By.xpath("//td[contains(.,'Name')]/following-sibling::td/input")).clear();
                    Thread.sleep(5000);

        //Enter the value
        driver.findElement(By.xpath("//td[contains(.,'Name')]/following-sibling::td/input")).sendKeys("Piyush Verma");
                    Thread.sleep(5000);

        //getting entered text from a text box from customer details
        String name = driver.findElement(By.xpath("//td[contains(.,'Name')]/following-sibling::td/input")).getAttribute("value");
        System.out.println("Entered value is : " + name);


        driver.close();
        driver.quit();
    }
}
