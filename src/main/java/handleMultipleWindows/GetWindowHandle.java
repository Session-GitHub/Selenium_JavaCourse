package handleMultipleWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GetWindowHandle {

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



        //getWindowHandle method
        String windowID = driver.getWindowHandle();
        System.out.println("Window Id of current Page is : " + windowID);
                    Thread.sleep(3000);


        driver.close();
        driver.quit();
    }
}

//AB30157C11C191B21B38EB29DBE147CB
//DC53CE477743B3DFB4705FE18E9F01E3