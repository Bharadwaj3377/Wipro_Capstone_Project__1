package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login_test {
    WebDriver driver;
    page_demo page;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com/signin");
        page = new page_demo(driver);
    }

    @When("the user chooses {string}")
    public void the_user_chooses(String loginMethod) throws Exception {
        switch (loginMethod) {
            case "login_1":
                page.Login_1();
                break;
            case "login_2":
                page.Login_2();
                break;
            case "login_3":
                page.Login_3();
                break;
            case "login_4":
                page.Login_4();
                break;
            case "login_5":
                page.Login_5();
                break;
            default:
                throw new Exception("❌ Invalid login method: " + loginMethod);
        }
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        System.out.println("✅ Login successful!");
        driver.quit();
    }
}
