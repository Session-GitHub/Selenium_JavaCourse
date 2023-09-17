package automatingOperationsOnVariousElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxOperations {

    public static WebDriver driver;
    public static int implicitlyWait = 30;
    public static int pageloadWait   = 50;

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
        driver.get("http://the-internet.herokuapp.com/checkboxes");
                    Thread.sleep(5000);

        //Create WebElement for checkBox
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //Check inability of checkbox
        boolean flag1 = checkBox1.isSelected();
        if (!flag1) {

            System.out.println("CheckBox 1 is not Selected : ");
        } else {

            System.out.println("CheckBox 1 is Selected : ");
        }
                    Thread.sleep(5000);

        //check the checkBox 1
        checkBox1.click();
        boolean flag2 = checkBox1.isSelected();
        if (flag2) {

            System.out.println("CheckBox 1 is Selected : ");
        } else {

            System.out.println("CheckBox 1 is not Selected : ");
        }
                    Thread.sleep(5000);

        //actually checkBox 2 is already checked, So we uncheck first
        checkBox2.click();
        checkBox1.click();
                    Thread.sleep(5000);

        //select both checkBox
        checkBox1.click();
                    Thread.sleep(3000);
        checkBox2.click();
                    Thread.sleep(5000);

        driver.close();
        driver.quit();
    }
}
