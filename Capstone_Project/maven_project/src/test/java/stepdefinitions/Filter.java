package stepdefinitions;

import stepdefinitions.page_demo;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Filter {
    WebDriver driver;
    page_demo page;

    @Given("user is logged to filters")
    public void user_is_logged_to_filters() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/signin");
        page = new page_demo(driver);
        page.testlogin();
    }

    @When("user applies brand and price filters")
    public void user_applies_brand_and_price_filters() throws InterruptedException {
        page.testbrandshopping();
        page.testfilters();
    }

    @Then("filtered products should be displayed")
    public void filtered_products_should_be_displayed() {
        System.out.println("✅ Filters applied!");
        driver.quit();
    }
}
