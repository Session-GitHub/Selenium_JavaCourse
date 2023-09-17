package testNGPrograms.parameterizingTestsWithDataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/*
 * @author verma.piyush
 */
public class Midtrans extends BaseClassDataProvider{

    WebDriver driver;
    BaseClassDataProvider baseClass = new BaseClassDataProvider();
    String browser = "chrome";

    @BeforeTest(alwaysRun = true)
    public void openBrowser () {

        driver = baseClass.initializingBrowser(browser);
                baseClass.staticPause(5);
    }

    @Test(priority = 1, dataProvider = "website")
    public void navigateToURL (String url) {

        driver.get(url);
                baseClass.staticPause(5);
    }

    @Test(priority = 2, dataProvider = "title")
    public void verifyTitle (String expectedTitle) {

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle);
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

    @Test(priority = 5 , dataProvider = "details")
    public void enterUserDetails (String city , String email , String phoneNo , String name , String address , String postalCode) {

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

                baseClass.staticPause(5);
    }

    @DataProvider
    public Object[] website() {

        return new Object[]{"https://demo.midtrans.com"};
    }

    @DataProvider
    public Object[][] title() {

        return new Object[][]{{"Sample Store"}};
    }

    @DataProvider
    public Object[][] details() {

        return new Object[][]{{"Meerut" , "verkaku10@gmail.com" , "1234567890" , "Piyush Verma" , "Shastri Nagar, Meerut" , "250001"}};
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser () {

        baseClass.tearDown();
    }
}
