package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MoveToElement {

    public static void main(String[] str) throws InterruptedException {

        WebDriver driver;
        int implicitlyWait = 30;
        int pageLoadWait   = 50;

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();
                    Thread.sleep(3000);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitlyWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadWait , TimeUnit.SECONDS);

        driver.get("https://www.renewbuy.com/");
                    Thread.sleep(3000);


        Actions action = new Actions(driver);
        WebElement insuranceEle = driver.findElement(By.xpath("(//a[contains(text(),'Insurance')])[1]"));
        WebElement motorInsuranceEle = driver.findElement(By.xpath("(//a[contains(text(),'Motor Insurance')])[1]"));
        WebElement carInsuranceEle = driver.findElement(By.xpath("(//a[contains(text(),'Car Insurance')])[1]"));
        WebElement newCarInsuranceEle = driver.findElement(By.xpath("(//a[contains(text(),'New Car Insurance')])[1]"));

        action.moveToElement(insuranceEle).
                moveToElement(motorInsuranceEle).
                moveToElement(carInsuranceEle).
                moveToElement(newCarInsuranceEle).click().build().perform();
                    Thread.sleep(5000);

        driver.close();
        driver.quit();
    }
}
