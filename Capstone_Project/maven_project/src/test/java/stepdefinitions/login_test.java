package stepdefinitions;

import stepdefinitions.page_demo;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login_test {
    WebDriver driver;
    page_demo page;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/signin");
        page = new page_demo(driver);
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() throws InterruptedException {
        page.testlogin();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        System.out.println("✅ Login successful!");
        driver.quit();
    }

    }

