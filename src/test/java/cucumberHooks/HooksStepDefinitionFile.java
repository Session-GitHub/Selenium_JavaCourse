package cucumberHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HooksStepDefinitionFile {

    public static WebDriver driver;
    public static int implicitWait = 30;
    public static int pageLodeWait = 40;

    @Before
    public void initializingBrowser() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver" , "src//main//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitWait , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLodeWait , TimeUnit.SECONDS);

        Thread.sleep(5000);
        driver.navigate().to("https://www.google.com/");

        Thread.sleep(5000);
    }

    //Hooks Scenario 1
    @Given("^google page1 opened$")
    public void google_page1_opened() {

        System.out.println("Google Page1 Opened : ");
    }

    @When("^i am on google page1$")
    public void i_am_on_google_page1() {

        System.out.println("I am on Google Page1 : ");
    }

    @Then("^hello google1$")
    public void hello_google1() {

        System.out.println("Hello Google1 : ");

        try {

            Thread.sleep(10000);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println();
    }


    //Hooks Scenario 2
    @Given("^google page2 opened$")
    public void google_page2_opened() {

        System.out.println("Google Page2 Opened : ");
    }

    @When("^i am on google page2$")
    public void i_am_on_google_page2() {

        System.out.println("I am on Google Page2 : ");
    }

    @Then("^hello google2$")
    public void hello_google2() {

        System.out.println("Hello Google2 : ");

        try {

            Thread.sleep(10000);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println();
    }


    //Hooks Scenario 3
    @Given("^google page3 opened$")
    public void google_page3_opened() {

        System.out.println("Google Page3 Opened : ");
    }

    @When("^i am on google page3$")
    public void i_am_on_google_page3() {

        System.out.println("I am on Google Page3 : ");
    }

    @Then("^hello google3$")
    public void hello_google3() {

        System.out.println("Hello Google3 : ");

        try {

            Thread.sleep(10000);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }


    @After
    public void tearDown() {

        driver.close();
        driver.quit();
    }
}
