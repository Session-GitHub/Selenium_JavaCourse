package automatingOperationsOnVariousElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ButtonOperations {

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

        //Button is Enable or not
        boolean flag1 = driver.findElement(By.xpath("//a[@class='btn buy']")).isEnabled();

        if (flag1) {

            System.out.println("'BUY NOW' Button is Enabled : ");
        } else {

            System.out.println("'BUY NOW' Button is not Enabled : ");
        }
                    Thread.sleep(3000);

        //Display status
        boolean flag2 = driver.findElement(By.xpath("//a[@class='btn buy']")).isDisplayed();

        if (flag2) {

            System.out.println("BUY NOW Button is Displayed on the Screen : ");
        } else {

            System.out.println("BUY NOW Button is not Displayed on the Screen : ");
        }


        //How to get the name or text of the Button
        String btnText = driver.findElement(By.xpath("//a[@class='btn buy']")).getText();
        System.out.println("Button Name is : " + btnText);

        driver.close();
        driver.quit();
    }
}
