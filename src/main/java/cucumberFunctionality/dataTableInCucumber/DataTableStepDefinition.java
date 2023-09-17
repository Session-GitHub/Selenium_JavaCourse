package cucumberFunctionality.dataTableInCucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataTableStepDefinition {

    WebDriver driver;
    @Given("^user opens the chrome browser DT$")
    public void user_opens_the_chrome_browser_DT() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50 , TimeUnit.SECONDS);
            Thread.sleep(5000);
    }

    @When("^user navigate to URL DT$")
    public void user_navigate_to_URL_DT() throws InterruptedException {

        String url = "https://demo.midtrans.com/";
        driver.navigate().to(url);
            Thread.sleep(5000);
    }

    @Then("^user verify logo DT$")
    public void user_verify_logo_DT() throws InterruptedException {

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='title']")).isDisplayed());
        System.out.println("Logo is present : ");
            Thread.sleep(5000);
    }

    @Then("^user clicks on BUY NOW Button DT$")
    public void user_clicks_on_BUY_NOW_Button_DT() throws InterruptedException {

        driver.findElement(By.xpath("//a[@class='btn buy']")).click();
            Thread.sleep(5000);
    }

    @Then("^user verify shopping cart popup DT$")
    public void user_verify_shopping_cart_popup_DT() throws InterruptedException {

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='cart-head']/span[contains(.,'Shopping Cart')]")).isDisplayed());
        System.out.println("Shopping Cart PopUp is displayed : ");
            Thread.sleep(5000);
    }

    @Then("^user enter credentials DT$")
    public void user_enter_credentials_DT(DataTable credentials) throws InterruptedException {

        List<String> data = credentials.row(0);

        WebElement nameTextField = driver.findElement(By.xpath("((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[1]"));
        String name = data.get(0);
        nameTextField.clear();
        nameTextField.sendKeys(name);
            Thread.sleep(2000);

        WebElement emailTextField = driver.findElement(By.xpath("(//table[@class='table'])[2]//td[@class='input']//input[@type='email']"));
        String email = data.get(1);
        emailTextField.clear();
        emailTextField.sendKeys(email);
            Thread.sleep(2000);

        WebElement phoneNoTextField = driver.findElement(By.xpath("((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[2]"));
        String phoneNO = data.get(2);
        phoneNoTextField.clear();
        phoneNoTextField.sendKeys(phoneNO);
            Thread.sleep(2000);

        WebElement cityTextField = driver.findElement(By.xpath("((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[3]"));
        String city = data.get(3);
        cityTextField.clear();
        cityTextField.sendKeys(city);
            Thread.sleep(2000);

        WebElement addressTextField = driver.findElement(By.xpath("(//table[@class='table'])[2]//td[@class='input']//textarea"));
        String address = data.get(4);
        addressTextField.clear();
        addressTextField.sendKeys(address);
            Thread.sleep(2000);

        WebElement postalCodeTextField = driver.findElement(By.xpath("((//table[@class='table'])[2]//td[@class='input']//input[@type='text'])[4]"));
        String postalCode = data.get(5);
        postalCodeTextField.clear();
        postalCodeTextField.sendKeys(postalCode);
            Thread.sleep(5000);
    }

    @Then("^user closes the browser DT$")
    public void user_closes_the_browser_DT() {

        driver.close();
        driver.quit();
    }
}
