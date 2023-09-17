package cucumberFunctionality.cucumberTags;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TagsStepDefinition {

    WebDriver driver;
    int implicitWait = 30;
    int pageLoadWait = 50;


    //for @google tag
    @Given("^user open chrome browser1$")
    public void user_open_chrome_browser1() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadWait , TimeUnit.SECONDS);

        Thread.sleep(5000);
    }

    @When("^user enter \"(.*)\" url1$")
    public void user_enter_url1(String url) throws Exception {

            Thread.sleep(4000);
        driver.navigate().to(url);
            Thread.sleep(4000);
    }

    @Then("^user is on Google Home Page1$")
    public void user_is_on_Google_Home_Page1() {

        System.out.println("User is on Google Home Page : ");
    }

    @Then("^user close the browser1$")
    public void user_close_the_browser1() {

        driver.close();
        driver.quit();
    }



    //for @facebook tag
    @Given("^user open chrome browser2$")
    public void user_open_chrome_browser2() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadWait , TimeUnit.SECONDS);

        Thread.sleep(5000);
    }

    @When("^user enter \"(.*)\" url2$")
    public void user_enter_url2(String url) throws Exception {

        Thread.sleep(4000);
        driver.navigate().to(url);
        Thread.sleep(4000);
    }

    @Then("^user is on Facebook Home Page2$")
    public void user_is_on_Facebook_Home_Page2() {

        System.out.println("User is on Facebook Home Page : ");
    }

    @Then("^user close the browser2$")
    public void user_close_the_browser2() {

        driver.close();
        driver.quit();
    }



    //for @renewbuy tag
    @Given("^user open chrome browser3$")
    public void user_open_chrome_browser3() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadWait , TimeUnit.SECONDS);

        Thread.sleep(5000);
    }

    @When("^user enter \"(.*)\" url3$")
    public void user_enter_url3(String url) throws Exception {

            Thread.sleep(4000);
        driver.navigate().to(url);
            Thread.sleep(4000);
    }

    @Then("^user is on renewBuy Home Page3$")
    public void user_is_on_renewBuy_Home_Page3() {

        System.out.println("User is on renewBuy Home Page : ");
    }

    @Then("^user close the browser3$")
    public void user_close_the_browser3() {

        driver.close();
        driver.quit();
    }



    //for @youtube tag
    @Given("^user open chrome browser4$")
    public void user_open_chrome_browser4() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadWait , TimeUnit.SECONDS);

        Thread.sleep(5000);
    }

    @When("^user enter \"(.*)\" url4$")
    public void user_enter_url4(String url) throws Exception {

            Thread.sleep(4000);
        driver.navigate().to(url);
            Thread.sleep(4000);
    }

    @Then("^user is on youtube Home Page4$")
    public void user_is_on_youtube_Home_Page4() {

        System.out.println("User is on Youtube Home Page : ");
    }

    @Then("^user close the browser4$")
    public void user_close_the_browser4() {

        driver.close();
        driver.quit();
    }
}
