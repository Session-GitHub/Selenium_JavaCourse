package cucumberFunctionality.simpleCucumberFun;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class MidtransStepDefinition {

    WebDriver driver;
    @Given("^user initializing the chrome browser SC$")
    public void user_initializing_the_chrome_browser_SC() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50 , TimeUnit.SECONDS);

            Thread.sleep(5000);
    }

    @When("^user navigate to \"(.*)\" SC$")
    public void user_navigate_to_SC(String url) throws InterruptedException {

        driver.navigate().to(url);
            Thread.sleep(5000);
    }

    @Then("^user verify the logo SC$")
    public void user_verify_the_logo_SC() throws InterruptedException {

        WebElement title = driver.findElement(By.xpath("//div[@class='title']"));
        Assert.assertTrue(title.isDisplayed());
        System.out.println("Title is displaying on home page: ");
            Thread.sleep(3000);
    }

    @Then("^user clicks on BUY NOW Button SC$")
    public void user_clicks_on_BUY_NOW_Button_SC() throws InterruptedException {

        WebElement buyNowBtn = driver.findElement(By.xpath("//a[@class='btn buy']"));
        buyNowBtn.click();
            Thread.sleep(4000);
    }

    @Then("^user verify shopping cart popup SC$")
    public void user_verify_shopping_cart_popup_SC() throws InterruptedException {

        WebElement popup = driver.findElement(By.xpath("//div[@class='cart-head']/span[contains(.,'Shopping Cart')]"));
        Assert.assertTrue(popup.isDisplayed());
        System.out.println("We are on shopping cart popup : ");
            Thread.sleep(4000);
    }

    @Then("^user clear the name text field and enter the name as \"(.*)\" SC$")
    public void user_clear_the_name_text_field_and_enter_the_name_as_SC(String name) throws InterruptedException {

        WebElement nameEle = driver.findElement(By.xpath("(//td[@class='input'])[1]/input"));
        nameEle.clear();
        nameEle.sendKeys(name);
            Thread.sleep(2000);
    }

    @Then("^user clear the email text field and enter the email as \"(.*)\" SC$")
    public void user_clear_the_email_text_field_and_enter_the_email_as_SC(String email) throws InterruptedException {

        WebElement emailEle = driver.findElement(By.xpath("(//td[@class='input'])[2]/input"));
        emailEle.clear();
        emailEle.sendKeys(email);
            Thread.sleep(2000);
    }

    @Then("^user clear the phoneNo text field and enter the phoneNo as \"(.*)\" SC$")
    public void user_clear_the_phoneNo_text_field_and_enter_the_phoneNo_as_SC(String phoneNo) throws InterruptedException {

        WebElement phoneEle = driver.findElement(By.xpath("(//td[@class='input'])[3]/input"));
        phoneEle.clear();
        phoneEle.sendKeys(phoneNo);
            Thread.sleep(2000);
    }

    @Then("^user clear the city city text field and enter the city as \"(.*)\" SC$")
    public void user_clear_the_city_city_text_field_and_enter_the_city_as_SC(String city) throws InterruptedException {

        WebElement cityEle = driver.findElement(By.xpath("(//td[@class='input'])[4]/input"));
        cityEle.clear();
        cityEle.sendKeys(city);
            Thread.sleep(2000);
    }

    @Then("^user clear the address text field and enter the address as \"(.*)\" SC$")
    public void user_clear_the_address_text_field_and_enter_the_address_as_SC(String address) throws InterruptedException {

        WebElement addressEle = driver.findElement(By.xpath("//td[@class='input']/textarea"));
        addressEle.clear();
        addressEle.sendKeys(address);
            Thread.sleep(2000);
    }

    @Then("^user clear the pincode text fields and enter the pincode as \"(.*)\" SC$")
    public void user_clear_the_pincode_text_fields_and_enter_the_pincode_as_SC(String pincode) throws InterruptedException {

        WebElement pincodeEle = driver.findElement(By.xpath("(//td[@class='input'])[6]/input"));
        pincodeEle.clear();
        pincodeEle.sendKeys(pincode);
            Thread.sleep(2000);
    }

    @Then("^user closes the chrome browser SC$")
    public void user_closes_the_chrome_browser_SC() {

        driver.close();
        driver.quit();
    }
}
