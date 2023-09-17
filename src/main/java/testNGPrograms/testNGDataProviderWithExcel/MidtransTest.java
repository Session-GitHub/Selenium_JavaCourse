package testNGPrograms.testNGDataProviderWithExcel;

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
public class MidtransTest extends BaseClassExcelData{

    public static WebDriver driver;
    BaseClassExcelData baseClass = new BaseClassExcelData();

    @BeforeTest
    public void openBrowser () {

        driver = baseClass.initializingBrowser();
                baseClass.staticPause(4);
    }

    @Test(priority = 1)
    public void launchURL () {

        String url = baseClass.getDataFromExcelSheet("url");
        driver.get(url);
    }

    @Test(priority = 2)
    public void verifyHomePageLogo () {

        WebElement logo = driver.findElement(By.xpath("//a[contains(.,'Coco')]"));
        Assert.assertTrue(logo.isDisplayed());
                baseClass.staticPause(5);
    }

    @Test(priority = 3)
    public void clickOnBuyNowButton () {

        WebElement buyNowBtn = driver.findElement(By.xpath("//a[@class='btn buy']"));
        buyNowBtn.click();
                baseClass.staticPause(4);
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

        emailTextField.clear();
        emailTextField.sendKeys(email);

        phoneNoTextField.clear();
        phoneNoTextField.sendKeys(phoneNo);

        cityTextField.clear();
        cityTextField.sendKeys(city);

        addressTextField.clear();
        addressTextField.sendKeys(address);

        postalCodeTextField.clear();
        postalCodeTextField.sendKeys(postalCode);

                baseClass.staticPause(5);
    }

    @AfterTest
    public void closeBrowser () {

        baseClass.tearDown();
    }
}
