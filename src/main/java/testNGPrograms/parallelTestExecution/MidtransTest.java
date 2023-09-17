package testNGPrograms.parallelTestExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/*
 * @author verma.piyush
 */
public class MidtransTest {

    WebDriver driver;
    String url = "https://demo.midtrans.com/";
    BaseClassParallelTesting baseClass = new BaseClassParallelTesting();

    @BeforeTest
    public void openBrowser () {

        driver = baseClass.initializingBrowser();
                baseClass.staticPause(3);
    }

    @Test(priority = 1)
    public void navigateToURL () {

        driver.get(url);
                baseClass.staticPause(3);
    }
    @Test(priority = 2)
    public void verifyTitle () {

        String expectedTitle = "Sample Store";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle);
                baseClass.staticPause(3);
    }

    @Test(priority = 3)
    public void clickOnBuyNowButton () {

        WebElement buyNowBtn = driver.findElement(By.xpath("//a[@class='btn buy']"));
        buyNowBtn.click();
                baseClass.staticPause(3);
    }

    @Test(priority = 4)
    public void verifyShoppingCartPopUp () {

        WebElement shoppingCartPopUp = driver.findElement(By.xpath("//div[@class='cart-head']/span[contains(.,'Shopping Cart')]"));
        Assert.assertTrue(shoppingCartPopUp.isDisplayed());
                baseClass.staticPause(3);
    }

    @Test(priority = 5)
    public void enterUserDetails () {

        String name       = baseClass.getDataFromExcelSheet("name");
        String email      = baseClass.getDataFromExcelSheet("email");
        String phoneNo    = baseClass.getDataFromExcelSheet("phoneNo");
        String city       = baseClass.getDataFromExcelSheet("city");
        String address    = baseClass.getDataFromExcelSheet("address");
        String postalCode = baseClass.getDataFromExcelSheet("postalCode");

        WebElement nameTextField = driver.findElement(By.xpath("((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[1]"));
        WebElement emailTextField = driver.findElement(By.xpath("(//table[@class='table'])[2]//td[@class='input']//input[@type='email']"));
        WebElement phoneNoTextField = driver.findElement(By.xpath("((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[2]"));
        WebElement cityTextField = driver.findElement(By.xpath("((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[3]"));
        WebElement addressTextField = driver.findElement(By.xpath("(//table[@class='table'])[2]//td[@class='input']//textarea"));
        WebElement postalCodeTextField = driver.findElement(By.xpath("((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[4]"));

        nameTextField.clear();
        nameTextField.sendKeys(name);
                baseClass.staticPause(2);
        emailTextField.clear();
        emailTextField.sendKeys(email);
                baseClass.staticPause(2);
        phoneNoTextField.clear();
        phoneNoTextField.sendKeys(phoneNo);
                baseClass.staticPause(2);
        cityTextField.clear();
        cityTextField.sendKeys(city);
                baseClass.staticPause(2);
        addressTextField.clear();
        addressTextField.sendKeys(address);
                baseClass.staticPause(2);
        postalCodeTextField.clear();
        postalCodeTextField.sendKeys(postalCode);

                baseClass.staticPause(3);
    }

    @AfterTest
    public void closeBrowser () {

        baseClass.tearDown();
    }
}
