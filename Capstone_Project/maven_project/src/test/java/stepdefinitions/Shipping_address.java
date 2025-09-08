package stepdefinitions;

import stepdefinitions.page_demo;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shipping_address {
    WebDriver driver;
    page_demo page;

    @Given("user is on shipping address page")
    public void user_is_on_shipping_address_page() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com/signin");
        page = new page_demo(driver);
        page.testlogin();
        page.testcheckout();
    }

    @When("user enters {string}, {string}, {string}, {string}, {string}")
    public void user_enters_shipping_details(String firstName, String lastName, String address, String state, String pincode) throws InterruptedException {
        page.testshippingaddress(firstName, lastName, address, state, pincode);
    }

    @Then("order summary should be displayed")
    public void order_summary_should_be_displayed() {
        System.out.println("✅ Shipping details submitted!");
        driver.quit();
    }
}
