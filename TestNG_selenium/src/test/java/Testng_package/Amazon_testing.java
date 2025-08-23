package Testng_package;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Amazon_testing {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        driver.manage().window().maximize();
       driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
 
    }
    

    @Test(priority = 0)
    public void login() {
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
        username.sendKeys("bharadwaj333.achimsetty@gmail.com", Keys.ENTER);

        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
        pass.sendKeys("Bharadwaj333@");

        driver.findElement(By.id("signInSubmit")).click();

        // assertion
        WebElement accountName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList-nav-line-1")));
        Assert.assertTrue(accountName.isDisplayed(), "Login failed!");
    }
    /*
  
    @Test(priority = 1)
    public void searchItems() {
        List<String> items = new ArrayList<>();
        items.add("Phone");
        items.add("Watches");

        for (String item : items) {
            WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
            search.clear();
            search.sendKeys(item, Keys.ENTER);

            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.a-color-state")));
            Assert.assertTrue(result.getText().toLowerCase().contains(item.toLowerCase()), "Search failed for " + item);
        }
    }
   
    @Test(priority = 2)
    public void addToCart() {
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.clear();
        search.sendKeys("Shoes");
        driver.findElement(By.id("nav-search-submit-button")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='s-image'])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"))).click();

        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.id("sw-gtc")));
        cart.click();

        Assert.assertTrue(driver.getTitle().contains("Shopping Cart"), "Cart not opened!");
        driver.findElement(By.id("nav-logo-sprites")).click();
    }
   
    @Test(priority = 3)
    public void changeName() {
    	    wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList-nav-line-1"))).click();

    	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='a-color-secondary'])[2]"))).click();

    	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='a-button-text'])[1]"))).click();

    	    WebElement change = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='a-input-text'])[1]")));
    	    change.clear();
    	    change.sendKeys("Mohitha");

    	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='a-button a-button-primary'])[1]"))).click();
    	    wait.until(ExpectedConditions.elementToBeClickable(By.id("cnep_1C_submit_button"))).click();
    	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='nav-logo-link nav-progressive-attribute'])[1]"))).click();
    	}

    @Test(priority = 4)
    public void changeAddress() {
    	    wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList"))).click();
    	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='a-color-secondary'])[4]"))).click();
    	    wait.until(ExpectedConditions.elementToBeClickable(By.id("ya-myab-address-edit-btn-0"))).click();
    	    WebElement fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-ui-widgets-enterAddressFullName")));
    	    fullName.clear();
    	    fullName.sendKeys("Bharadwaj");
    	    WebElement phone = driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber"));
    	    phone.clear();
    	    phone.sendKeys("9876543210");

    	    WebElement pin = driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode"));
    	    pin.clear();
    	    pin.sendKeys("560035");
    	    WebElement address = driver.findElement(By.id("address-ui-widgets-enterAddressLine1"));
    	    address.clear();
    	    address.sendKeys("Marathalli bridge near KLM");
    	    WebElement area = driver.findElement(By.id("address-ui-widgets-enterAddressLine2"));
    	    area.clear();
    	    area.sendKeys("Bangalore");
    	    WebElement city = driver.findElement(By.id("address-ui-widgets-enterAddressCity"));
    	    city.clear();
    	    city.sendKeys("Bangalore");
    	    WebElement stateDropdown = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.name("address-ui-widgets-enterAddressStateOrRegion")));
    	    Select state = new Select(stateDropdown);
    	    state.selectByVisibleText("Karnataka");
    	    WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("(//input[@aria-labelledby=\"address-ui-widgets-form-submit-button-announce\"])[1]")));
    	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);
    	    Assert.assertTrue(driver.getPageSource().contains("Marathalli"), "Address not updated!");
    	}
    @Test(priority = 5)
    public void shopByCategory() {
        Select choose = new Select(driver.findElement(By.id("searchDropdownBox")));
        choose.selectByVisibleText("Electronics");

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.clear();
        search.sendKeys("laptops");
        driver.findElement(By.id("nav-search-submit-button")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='s-image'])[1]"))).click();
    }

    @Test(priority = 6)
    public void particularProduct() {
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.clear();
        search.sendKeys("watches");
        driver.findElement(By.id("nav-search-submit-button")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='s-image'])[1]"))).click();
    }
    @Test(priority = 7)
    public void allMenuNavigation() {
        driver.findElement(By.id("nav-hamburger-menu")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Mobiles, Computers']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("All Mobile Phones"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Android Phones"))).click();
    }
    */

    @Test(priority = 8)
    public void changeLanguage() {
        WebElement languageMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("icp-nav-flyout")));
        languageMenu.click();

        boolean inIframe = false;
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe#icp-flyout-mkt-change")));
            inIframe = true;
        } catch (Exception e) {
            driver.switchTo().defaultContent(); // no iframe
        }

        // ✅ Now safely locate dropdown
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("icp-dropdown")));
        new Select(countryDropdown).selectByVisibleText("Australia");

        // ✅ Save
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("icp-save-button")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);

        if (inIframe) {
            driver.switchTo().defaultContent(); // leave iframe only if we entered it
        }

        // ✅ Wait for page reload
        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("ref=icp"),
            ExpectedConditions.urlContains("customer-preferences")
        ));
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
