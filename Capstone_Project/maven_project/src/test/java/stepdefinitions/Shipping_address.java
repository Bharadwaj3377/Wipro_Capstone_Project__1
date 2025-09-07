package stepdefinitions;

import stepdefinitions.page_demo;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

public class Shipping_address {
    WebDriver driver;
    page_demo page;

    @Given("user is on shipping address page")
    public void user_is_on_shipping_address_page() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/signin");
        page = new page_demo(driver);
        page.testlogin();
        page.testcheckout();
    }

    @When("user enters shipping details")
    public void user_enters_shipping_details(DataTable dataTable) throws InterruptedException {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        page.testshippingaddress(
                data.get("FirstName"),
                data.get("LastName"),
                data.get("Address"),
                data.get("State"),
                data.get("Pincode")
        );
    }

    @Then("order summary should be displayed")
    public void order_summary_should_be_displayed() {
        System.out.println("✅ Shipping details submitted!");
        driver.quit();
    }
}
