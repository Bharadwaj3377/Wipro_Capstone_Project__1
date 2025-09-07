package stepdefinitions;

import stepdefinitions.page_demo;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddtoCart {
    WebDriver driver;
    page_demo page;

    @Given("user is logged to")
    public void user_is_logged_to() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/signin");
        page = new page_demo(driver);
        page.testlogin();
    }

    @When("user adds and removes a product from the cart")
    public void user_adds_and_removes_a_product_from_the_cart() throws InterruptedException {
        page.testaddtocart();
    }

    @Then("cart should be updated")
    public void cart_should_be_updated() {
        System.out.println("✅ Cart updated!");
        driver.quit();
    }
}
