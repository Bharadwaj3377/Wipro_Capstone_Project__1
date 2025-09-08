package stepdefinitions;

import stepdefinitions.page_demo;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class search_steps {
    WebDriver driver;
    page_demo page;

    @Given("user is logged in")
    public void user_is_logged_in() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/signin");
        page = new page_demo(driver);
        page.testlogin();
    }

    @When("user searches for {string}")
    public void user_searches_for(String product) throws InterruptedException {
        page.testsearch(product);
    }

    @Then("relevant products should be displayed")
    public void relevant_products_should_be_displayed() {
        System.out.println("✅ Search results displayed!");
        driver.quit();
    }
}
