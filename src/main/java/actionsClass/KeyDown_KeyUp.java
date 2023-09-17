package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class KeyDown_KeyUp {

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

        driver.get("https://guide.blazemeter.com/");
                    Thread.sleep(3000);


        WebElement gettingStartedEle = driver.findElement(By.xpath("(//a[@class='parent'][contains(.,'Getting Started')])[1]"));
        gettingStartedEle.click();
                    Thread.sleep(3000);

        WebElement theBasicsEle = driver.findElement(By.xpath("//span[contains(.,'The Basics')]"));
        theBasicsEle.click();
                    Thread.sleep(5000);

        //how to use keyDown/keyUp
        WebElement welcomeToBlazeMeterDocsEle = driver.findElement(By.xpath("//a[contains(.,'Welcome to BlazeMeter Docs')]"));
        Actions action = new Actions(driver);
        action.moveToElement(welcomeToBlazeMeterDocsEle).
                keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
                    Thread.sleep(10000);


        //define switching window
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
                    Thread.sleep(10000);
        driver.switchTo().window(tabs.get(0));
                    Thread.sleep(3000);


        driver.close();
        driver.quit();
    }
}
