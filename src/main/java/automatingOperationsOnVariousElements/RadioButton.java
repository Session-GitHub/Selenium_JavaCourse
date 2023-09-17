package automatingOperationsOnVariousElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButton {

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
        driver.get("https://www.spicejet.com/");
                    Thread.sleep(3000);

        //for "Family & Friends"
        WebElement familyAndFriends = driver.findElement(By.xpath("//div[contains(text(),'Family & Friends')]"));
        familyAndFriends.click();
                    Thread.sleep(3000);
        boolean flag1 = familyAndFriends.isSelected();
        if (flag1) {

            System.out.println("Family & Friends option is selected : ");
        } else {

            System.out.println("Family & Friends option is not selected : ");
        }
                    Thread.sleep(5000);

        //for "Senior Citizen"
        WebElement seniorCitizen = driver.findElement(By.xpath("(//div[contains(text(),'Senior Citizen')])[2]"));
        seniorCitizen.click();
                    Thread.sleep(5000);

        //for "Unaccompanied Minor"
        WebElement unaccompaniedMinor = driver.findElement(By.xpath("(//div[contains(text(),'Unaccompanied Minor')])[1]"));
        unaccompaniedMinor.click();
                    Thread.sleep(5000);

        //for "Students"
        WebElement student = driver.findElement(By.xpath("//div[contains(text(),'Students')]"));
        student.click();
                    Thread.sleep(5000);

        //for "Armed Forces"
        WebElement armedForces = driver.findElement(By.xpath("(//div[contains(text(),'Armed Forces')])[2]"));
        armedForces.click();
                    Thread.sleep(5000);

        //for "Govt. Employee"
        WebElement govtEmployees = driver.findElement(By.xpath("(//div[contains(text(),'Govt. Employee')])[2]"));
        govtEmployees.click();
                    Thread.sleep(5000);

        //for checking "Family & Friends" is enabled or not
        WebElement familyAndFriends1 = driver.findElement(By.xpath("//div[contains(text(),'Family & Friends')]"));
        boolean flag2 = familyAndFriends1.isEnabled();
        System.out.println(flag2);
        if (flag2) {

            System.out.println("Family & Friends option is selected : ");
        } else {

            System.out.println("Family & Friends option is not selected : ");
        }
                    Thread.sleep(5000);


        driver.close();
        driver.quit();
    }
}
