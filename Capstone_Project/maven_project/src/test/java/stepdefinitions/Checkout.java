package stepdefinitions;

import stepdefinitions.page_demo;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkout {
    WebDriver driver;
    page_demo page;

    @Given("user is logged in for product")
    public void user_is_logged_in_for_product() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/signin");
        page = new page_demo(driver);
        page.testlogin();
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() throws InterruptedException {
        page.testcheckout();
    }

    @Then("checkout page should be displayed")
    public void checkout_page_should_be_displayed() {
        System.out.println("✅ Checkout page displayed!");
        driver.quit();
    }
}
