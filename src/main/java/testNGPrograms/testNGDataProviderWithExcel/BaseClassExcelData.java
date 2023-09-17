package testNGPrograms.testNGDataProviderWithExcel;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
 * @author verma.piyush
 */
public class BaseClassExcelData {

    static WebDriver driver;
    static int implicitlyWait = 30;
    static int pageLoadWait   = 50;
    static String zoomIn  = "document.body.style.zoom  = '125%';";
    static String zoomOut = "document.body.style.zoom  = '70%' ;";
    static DataFormatter formatter = new DataFormatter();

    public WebDriver initializingBrowser () {

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitlyWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadWait , TimeUnit.SECONDS);
        return driver;
    }

    public void staticPause (int sec) {

        try {
            Thread.sleep(1000*sec);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String currentDateTime () {

        SimpleDateFormat formatter = new SimpleDateFormat("_dd-MM-yyyy_HH-mm-ss-ms_");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    public void takeScreenShotOnTestFailure (String testName) {

        String dateTime = currentDateTime();
        String scrPath  = "screenShots" + "\\\\" + dateTime + ".jpeg";

        TakesScreenshot scr = ((TakesScreenshot) driver);
        File src = scr.getScreenshotAs(OutputType.FILE);
        File dest = new File(scrPath);

        try {
            FileUtils.copyFile(src , dest);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void explicitWaitForSendKeys(int timeOuts , WebElement element , String value) {

        new WebDriverWait(driver , timeOuts).
                until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }
    public void explicitWaitForClick(WebDriver driver , int timeOuts , WebElement element) {

        new WebDriverWait(driver , timeOuts).
                until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
    public void explicitlyWaitForElementVerify (WebDriver driver , int timeOuts , WebElement element) {

        new WebDriverWait(driver , timeOuts).
                until(ExpectedConditions.visibilityOf(element));
    }

    public void zoomInByRobot (int zoomingSteps) {

        try {

            Robot robot = new Robot();

            for (int i=0;i<zoomingSteps;i++) {

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ADD);

                robot.keyRelease(KeyEvent.VK_ADD);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            }
        } catch (AWTException e) {
            System.out.println(e.getMessage());
        }
    }
    public void zoomOutByRobot (int zoomingSteps) {

        try {

            Robot robot = new Robot();

            for (int i=0;i<zoomingSteps;i++) {

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_SUBTRACT);

                robot.keyRelease(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            }
        } catch (AWTException e) {
            System.out.println(e.getMessage());
        }
    }

    public void zoomInByJavaScript () {

        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript(zoomIn);
    }
    public void zoomOutByJavaScript () {

        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript(zoomOut);
    }

    //taking data from Excel Sheet
    public String getDataFromExcelSheet (String giveColName) {

        String cellVal = null;
        try {

            FileInputStream fis = new FileInputStream("src//main//resources//excelSheet//midtransData.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            //XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("src//main//resources//excelSheet//midtransData.xlsx"));
            XSSFSheet sheet = workbook.getSheet("midtrans");

            int rowNum = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;

            for (int i=0;i<rowNum;i++) {

                XSSFRow row = sheet.getRow(i);

                if (formatter.formatCellValue(row.getCell(0)).equalsIgnoreCase(giveColName)) {

                    cellVal = formatter.formatCellValue(row.getCell(1));
                }
            }

            fis.close();
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

        return cellVal;
    }

    public void tearDown () {

        driver.close();
        driver.quit();
    }
}
