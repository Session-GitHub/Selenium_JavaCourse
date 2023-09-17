package automatingOperationsOnVariousElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropDownListOperations {

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
        driver.get("http://the-internet.herokuapp.com/dropdown");
                    Thread.sleep(3000);


        //Create first object of "Select" class by giving xPath or any locator of DropDown List
        //Select item = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        Select item = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        //select item by Visible Text
        //item.selectByVisibleText("Option 1");
        item.selectByVisibleText("Option 1");
                    Thread.sleep(8000);

        //select item by index
        item.selectByIndex(2);
                    Thread.sleep(8000);

        //select item by value
        item.selectByValue("1");
                    Thread.sleep(8000);


        driver.close();
        driver.quit();
    }
}
