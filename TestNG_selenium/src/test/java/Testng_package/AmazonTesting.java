package Testng_package;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import java.time.Duration;

public class AmazonTesting {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
    }

    @Test(priority = 0)
    public void login() {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("bharadwaj333.achimsetty@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("Bharadwaj333@");
        driver.findElement(By.id("signInSubmit")).click();
    }

    @Test(priority = 1)
    public void searchItems() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Phone");
        driver.findElement(By.id("nav-search-submit-button")).click();

        driver.findElement(By.id("twotabsearchtextbox")).clear();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Watches");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Test(priority = 2)
    public void addToCart() {
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Shoes");
        driver.findElement(By.id("nav-search-submit-button")).click();

        // click first product
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.s-image"))).click();
        // add to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"))).click();

        // close popup if appears
        try {
            WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("a.a-link-normal.attach-close-button")));
            popup.click();
        } catch (Exception e) {
            System.out.println("Cart popup not shown, skipping...");
        }
    }

    @Test(priority = 3)
    public void changeName() {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.linkText("Your Account")).click();
        driver.findElement(By.linkText("Login & security")).click();
        driver.findElement(By.id("auth-cnep-edit-name-button")).click();
        driver.findElement(By.id("ap_customer_name")).clear();
        driver.findElement(By.id("ap_customer_name")).sendKeys("Mohitha");
        driver.findElement(By.id("cnep_1C_submit_button")).click();
    }

    @Test(priority = 4)
    public void changeAddress() {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.linkText("Your Account")).click();
        driver.findElement(By.linkText("Your Addresses")).click();
        driver.findElement(By.id("ya-myab-address-add-link")).click();

        driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("560035");
        driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("Marathalli bridge near KLM");
        driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Bangalore");

        new Select(driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")))
                .selectByVisibleText("KARNATAKA");

        driver.findElement(By.id("address-ui-widgets-use-as-my-default")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Test(priority = 5)
    public void changeLanguage() {
        driver.findElement(By.id("icp-nav-flyout")).click();
        driver.findElement(By.cssSelector("input[name='LOCALE'][value='en_IN']")).click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @Test(priority = 6)
    public void allMenuNavigation() {
        driver.findElement(By.id("nav-hamburger-menu")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Mobiles, Computers"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("All Mobile Phones"))).click();
    }

    @Test(priority = 7)
    public void shopByCategoryPage() {
        driver.findElement(By.id("nav-hamburger-menu")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Shop By Category"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Books"))).click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
