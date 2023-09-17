package automatingOperationsOnVariousElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HTMLTableOperations {

    public static void main(String[] str) throws Exception {

        WebDriver driver;
        int implicitlyWait = 500;
        int pageloadWait   = 60;
        int expectedColsNum = 5;
        int expectedRowNums = 7;
        int i = 0;
        int j = 0;

        String[] headers = {"Status" , "Company" , "Montact" , "Country" , "Action"};
        String[] row1Value = {"" , "FlipKart" , "Sachin Bansal" , "India" , ""};
        String[] row2Value = {"" , "Amazon" , "Jeff Bezos" , "USA" , ""};
        String[] row3Value = {"" , "Ola" , "Bhavish Aggarwal" , "Bangalore" , ""};
        String[] row4Value = {"" , "Selenium" , "Open Source" , "USA" , ""};
        String[] row5Value = {"" , "Jenkins" , "Open Source" , "UK" , ""};
        String[] row6Value = {"" , "Java" , "Sun microsystems" , "California" , ""};
        String[] expectedLinkText  = {"Know More" , "Know More" , "Know More" , "Know Mor" , "Know More" , "Know More"};

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
        driver.get("http://seleniumpractise.blogspot.com/2021/08/webtable-in-html.html");
                        Thread.sleep(3000);


        //verify the counting of columns
        ArrayList<WebElement> colNums = new ArrayList<>(driver.findElements(By.xpath("//table[@id='customers']//th")));
        int actualColsNum = colNums.size();
        try {

            Assert.assertEquals(actualColsNum , expectedColsNum);
            System.out.println("Actual Columns number and Expected Columns number are equal : ");
        } catch (AssertionError e) {

            System.out.println("Actual Columns number and Expected Columns number are not equal : ");
            System.out.println(e.getMessage());
        }



        //verify the counting of rows
        ArrayList<WebElement> rowNums = new ArrayList<>(driver.findElements(By.xpath("//table[@id='customers']//tr")));
        int actualRowNums = rowNums.size();
        try {

            Assert.assertEquals(actualRowNums , expectedRowNums);
            System.out.println("Actual Rows number and Expected Rows number are equal : ");
        } catch (AssertionError e) {

            System.out.println("Actual Rows number and Expected Rows number are not equal : ");
            System.out.println(e.getMessage());
        }


        //verify header's values
        List<WebElement> headerValue = driver.findElements(By.xpath("//table[@id='customers']//th"));
        for (WebElement headerEle : headerValue) {

            String actualHeaderValue = headerEle.getText();
            String expectedHeaderValue = headers[i];

            if (actualHeaderValue.equalsIgnoreCase(expectedHeaderValue)) {

                System.out.println("Header " + "'" + expectedHeaderValue + "'" + " is matched : ");
            } else {

                System.out.println("Header " + "'" + expectedHeaderValue + "'" + " is not matched : ");
            }
            i++;

            //Assert.assertEquals(actualHeaderValue , expectedHeaderValue);
        }

        //to check that checkBoxes are working fine
        List<WebElement> checkBoxEle = driver.findElements(By.xpath("//input[@type='checkbox']"));

        //checkin check boxes
        for (WebElement checkEle : checkBoxEle) {

            checkEle.click();
                        Thread.sleep(2000);
        }

        //checkout check boxes
        for (WebElement checkEle : checkBoxEle) {

            checkEle.click();
                        Thread.sleep(2000);
        }


        //creating a list of link WebElements
        List<WebElement> linkElements = driver.findElements(By.xpath("//table[@id='customers']//tr/td[5]"));


        //verify link text
        for (WebElement ele : linkElements) {

            String actualLinkText = ele.getText();
            try {

                Assert.assertEquals(actualLinkText , expectedLinkText[j]);
                System.out.println("Actual link Text and Expected Link Text are same : ");
            } catch (AssertionError e) {

                System.out.println("Actual link Text and Expected Link Text are not same : ");
                System.out.println(e.getMessage());
            }
            j++;
        }


        //verify Action links are working fine
        for (WebElement linkEle : linkElements) {

            new WebDriverWait(driver , 30).
                    until(ExpectedConditions.elementToBeClickable(linkEle));
            linkEle.click();
                        Thread.sleep(2000);
            driver.navigate().back();
                        Thread.sleep(2000);
        }

        driver.close();
        driver.quit();
    }
}
