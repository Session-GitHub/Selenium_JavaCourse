package cucumberFunctionality.scenarioOutline;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ScenarioOutlineStepDefinition {

    WebDriver driver;

    @Given("user initializing the chrome browser SO")
    public void user_initializing_the_chrome_browser_SO() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50 , TimeUnit.SECONDS);

        Thread.sleep(5000);
    }

    @When("user navigate to {string} SO")
    public void user_navigate_to_SO(String url) throws InterruptedException {

        driver.navigate().to(url);

        Thread.sleep(5000);
    }

    @Then("user verify logo SO")
    public void user_verify_logo_SO() throws InterruptedException {

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='title']")).isDisplayed());
        System.out.println("Logo is present : ");

        Thread.sleep(5000);
    }

    @Then("user clicks on BUY NOW Button SO")
    public void user_clicks_on_BUY_NOW_Button_SO() throws InterruptedException {

        driver.findElement(By.xpath("//a[@class='btn buy']")).click();

        Thread.sleep(5000);
    }

    @Then("user verify shopping cart popup SO")
    public void user_verify_shopping_cart_popup_SO() throws InterruptedException {

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='cart-head']/span[contains(.,'Shopping Cart')]")).isDisplayed());
        System.out.println("Shopping Cart PopUp is displayed : ");

        Thread.sleep(5000);
    }

    @Then("user clear name textField and enter name {string} SO")
    public void user_clear_name_textField_and_enter_name_SO(String name) throws InterruptedException {

        WebElement nameTextField = driver.findElement(By.xpath("((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[1]"));
        nameTextField.clear();
        nameTextField.sendKeys(name);

        Thread.sleep(2000);
    }

    @Then("user clear email textField and enter email {string} SO")
    public void user_clear_email_textField_and_enter_email_SO(String email) throws InterruptedException {

        WebElement emailTextField = driver.findElement(By.xpath("(//table[@class='table'])[2]//td[@class='input']//input[@type='email']"));
        emailTextField.clear();
        emailTextField.sendKeys(email);

        Thread.sleep(2000);
    }

    @Then("user clear phoneNo textField and enter phoneNo {string} SO")
    public void user_clear_phoneNo_textField_and_enter_phoneNo_SO(String phoneNo) throws InterruptedException {

        WebElement phoneNoTextField = driver.findElement(By.xpath("((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[2]"));
        phoneNoTextField.clear();
        phoneNoTextField.sendKeys(phoneNo);

        Thread.sleep(2000);
    }

    @Then("user clear city textField and enter city {string} SO")
    public void user_clear_city_textField_and_enter_city_SO(String city) throws InterruptedException {

        WebElement cityTextField = driver.findElement(By.xpath("((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[3]"));
        cityTextField.clear();
        cityTextField.sendKeys(city);

        Thread.sleep(2000);
    }

    @Then("user clear address textField and enter address {string} SO")
    public void user_clear_address_textField_and_enter_address_SO(String address) throws InterruptedException {

        WebElement addressTextField = driver.findElement(By.xpath("(//table[@class='table'])[2]//td[@class='input']//textarea"));
        addressTextField.clear();
        addressTextField.sendKeys(address);

        Thread.sleep(2000);
    }

    @Then("user clear pincode textField and enter pincode {string} SO")
    public void user_clear_pincode_textField_and_enter_pincode_SO(String pincode) throws InterruptedException {

        WebElement postalCodeTextField = driver.findElement(By.xpath("((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[4]"));
        postalCodeTextField.clear();
        postalCodeTextField.sendKeys(pincode);

        Thread.sleep(5000);
    }

    @Then("user closes the browser SO")
    public void user_closes_the_browser_SO() {

        driver.close();
        driver.quit();
    }
}
