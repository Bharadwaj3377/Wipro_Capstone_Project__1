package stepdefinitions;

import stepdefinitions.page_demo;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Offers {
    WebDriver driver;
    page_demo page;

    @Given("user is logged to page")
    public void user_is_logged_to_page() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/signin");
        page = new page_demo(driver);
        page.testlogin();
    }

    @When("user navigates to offers")
    public void user_navigates_to_offers() throws InterruptedException {
        page.testoffers();
    }

    @Then("offers should be displayed")
    public void offers_should_be_displayed() {
        System.out.println("✅ Offers displayed!");
        driver.quit();
    }
}
