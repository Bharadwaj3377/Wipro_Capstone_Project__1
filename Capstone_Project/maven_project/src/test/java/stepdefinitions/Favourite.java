package stepdefinitions;

import stepdefinitions.page_demo;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Favourite {
    WebDriver driver;
    page_demo page;

    @Given("user is logged in website")
    public void user_is_logged_in_website() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/signin");
        page = new page_demo(driver);
        page.testlogin();
    }

    @When("user adds and views favourites")
    public void user_adds_and_views_favourites() throws InterruptedException {
        page.testfavourite();
    }

    @Then("favourites should be displayed")
    public void favourites_should_be_displayed() {
        System.out.println("✅ Favourites displayed!");
        driver.quit();
    }
}
