package stepdefinitions;

import stepdefinitions.page_demo;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logout {
    WebDriver driver;
    page_demo page;

    @Given("user is logged to site")
    public void user_is_logged_to_site() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/signin");
        page = new page_demo(driver);
        page.testlogin();
    }

    @When("user logs out")
    public void user_logs_out() throws InterruptedException {
        page.testlogout();
    }

    @Then("user should be redirected to login page")
    public void user_should_be_redirected_to_login_page() {
        System.out.println("✅ User logged out!");
        driver.quit();
    }
}
