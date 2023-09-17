package automatingOperationsOnVariousElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CalendarOperations_1 {

    public static void main(String[] str) throws InterruptedException {

        WebDriver driver;
        int implicitlyWait = 50;
        int pageloadWait   = 60;
        String requiredDay = "31";
        String requiredMonth = "December";
        String requiredYear = "2025";

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
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
                    Thread.sleep(3000);



        //creating calendar date xpath and click on date text field to open the calendar
        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.click();
                    Thread.sleep(5000);

        //driver will wait for noSuchException
        new WebDriverWait(driver , 5).
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='ui-datepicker-calendar']")));

        //we get the month and year
        String monthYearElement = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();

        //separate the month and year
        String month = monthYearElement.split(" ")[0].trim();
        String year  = monthYearElement.split(" ")[1].trim();

        //Check wrong Day
        if (requiredMonth.equalsIgnoreCase("january") && Integer.parseInt(requiredDay)>31) {

            System.out.println(requiredDay + " does not exists in January :Please enter the correct Day");
            return;
        }if (requiredMonth.equalsIgnoreCase("february") && Integer.parseInt(requiredYear)%4==0 && Integer.parseInt(requiredDay)>29) {

            System.out.println(requiredDay + " does not exists in february " + requiredYear + ", Please enter the correct Day");
            return;
        }if (requiredMonth.equalsIgnoreCase("february") && Integer.parseInt(requiredYear)%4!=0 && Integer.parseInt(requiredDay)>28) {

            System.out.println(requiredDay + " does not exists in february " + requiredYear + ", Please enter the correct Day");
            return;
        }if (requiredMonth.equalsIgnoreCase("March") && Integer.parseInt(requiredDay)>31) {

            System.out.println(requiredDay + " does not exists in March : Please enter the correct Day");
            return;
        }if (requiredMonth.equalsIgnoreCase("April") && Integer.parseInt(requiredDay)>30) {

            System.out.println(requiredDay + " does not exists in April : Please enter the correct Day");
            return;
        }if (requiredMonth.equalsIgnoreCase("May") && Integer.parseInt(requiredDay)>31) {

            System.out.println(requiredDay + " does not exists in May : Please enter the correct Day");
            return;
        }if (requiredMonth.equalsIgnoreCase("june") && Integer.parseInt(requiredDay)>30) {

            System.out.println(requiredDay + " does not exists in June : Please enter the correct Day");
            return;
        }if (requiredMonth.equalsIgnoreCase("july") && Integer.parseInt(requiredDay)>31) {

            System.out.println(requiredDay + " does not exists in July : Please enter the correct Day");
            return;
        }if (requiredMonth.equalsIgnoreCase("august") && Integer.parseInt(requiredDay)>31) {

            System.out.println(requiredDay + " does not exists in August : Please enter the correct Day");
            return;
        }if (requiredMonth.equalsIgnoreCase("september") && Integer.parseInt(requiredDay)>30) {

            System.out.println(requiredDay + " does not exists in September : Please enter the correct Day");
            return;
        }if (requiredMonth.equalsIgnoreCase("october") && Integer.parseInt(requiredDay)>31) {

            System.out.println(requiredDay + " does not exists in October : Please enter the correct Day");
            return;
        }if (requiredMonth.equalsIgnoreCase("November") && Integer.parseInt(requiredDay)>30) {

            System.out.println(requiredDay + " does not exists in November : Please enter the correct Day");
            return;
        }if (requiredMonth.equalsIgnoreCase("December") && Integer.parseInt(requiredDay)>31) {

            System.out.println(requiredDay + " does not exists in December : Please enter the correct Day");
            return;
        }

        //now, we will use while loop for click on next until we don't get the required month and year
        while (!(month.equalsIgnoreCase(requiredMonth) && year.equalsIgnoreCase(requiredYear))) {

            driver.findElement(By.xpath("//a[@title='Next']")).click();
                        Thread.sleep(2000);

            //again we are getting current month and year
            monthYearElement = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();

            //separate the month and year
            month = monthYearElement.split(" ")[0].trim();
            year  = monthYearElement.split(" ")[1].trim();
        }

        //clicking on the required day
        String beforeDateXpath = "//a[contains(text(),'";
        String afterDateXpath  = "')]";
        String day = beforeDateXpath + requiredDay + afterDateXpath;
        driver.findElement(By.xpath(day)).click();
                        Thread.sleep(5000);
////a[contains(text(),'
// 25
// ')]


        driver.close();
        driver.quit();
    }
}
