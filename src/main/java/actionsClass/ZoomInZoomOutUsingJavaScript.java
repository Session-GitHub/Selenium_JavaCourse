package actionsClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ZoomInZoomOutUsingJavaScript {

    public static void main(String[] str) throws InterruptedException {

        WebDriver driver;
        int implicitlyWait = 30;
        int pageLoadWait   = 50;
        String zoomIn  = "document.body.style.zoom = '125%';";
        String zoomOut = "document.body.style.zoom = '100%';";

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();
                    Thread.sleep(3000);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitlyWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadWait , TimeUnit.SECONDS);

        driver.get("https://www.google.com");
                    Thread.sleep(3000);

        //Zoom in using JavaScript
        JavascriptExecutor executorIn = ((JavascriptExecutor) driver);
        executorIn.executeScript(zoomIn);
                    Thread.sleep(5000);

        //Zoom Out using JavaScript
        JavascriptExecutor executorOut = ((JavascriptExecutor) driver);
        executorOut.executeScript(zoomOut);
                    Thread.sleep(5000);

        driver.close();
        driver.quit();
    }
}
