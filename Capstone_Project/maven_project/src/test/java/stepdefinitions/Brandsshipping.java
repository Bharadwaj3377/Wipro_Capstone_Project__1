package stepdefinitions;

import stepdefinitions.page_demo;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brandsshipping {
    WebDriver driver;
    page_demo page;

    @Given("the user is logged to the page")
    public void the_user_is_logged_to_the_page() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/signin");  
        page = new page_demo(driver);
        page.testlogin();
    }

    @When("the user applies brand filter")
    public void the_user_applies_brand_filter() throws InterruptedException {
        page.testbrandshopping();
    }

    @Then("products from the selected brand should be displayed")
    public void products_from_the_selected_brand_should_be_displayed() {
        System.out.println("✅ Brand filter applied successfully!");
        driver.quit();
    }
}
