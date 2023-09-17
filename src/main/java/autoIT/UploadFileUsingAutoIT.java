package autoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UploadFileUsingAutoIT {

    public static void main(String[] str) throws InterruptedException, IOException {

        WebDriver driver;
        int implicitlyWait = 30;
        int pageloadTimeOut = 50;

        System.setProperty("webdriver.gecko.driver" , "src//main//resources//drivers//geckodriver.exe");

        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitlyWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageloadTimeOut , TimeUnit.SECONDS);
        Thread.sleep(5000);

        driver.get("https://the-internet.herokuapp.com/upload");
        Thread.sleep(5000);

        WebElement buttonUpload = driver.findElement(By.xpath("//input[@id='file-upload']"));
        Actions action = new Actions(driver);
        action.moveToElement(buttonUpload).click().build().perform();
        Thread.sleep(5000);

        // execute the action of window element using AutoIT script(.exe file)
        Runtime.getRuntime().exec("D://FileUploadScript.exe" + " " + "D:\\FileForUploading.docx");
        Thread.sleep(5000);

        WebElement buttonSubmit = driver.findElement(By.xpath("//input[@id='file-submit']"));
        action.moveToElement(buttonSubmit).click().build().perform();
        Thread.sleep(5000);

        WebElement validation = driver.findElement(By.xpath("//div[@class='example']//h3[contains(.,'File Uploaded!')]"));
        Assert.assertTrue(validation.isDisplayed());
        Thread.sleep(5000);

        driver.close();
    }
}
// D://FileUpload.exe
// D:\FileForUploading.docx