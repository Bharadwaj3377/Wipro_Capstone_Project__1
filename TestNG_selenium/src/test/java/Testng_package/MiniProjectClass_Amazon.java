package Testng_package;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MiniProjectClass_Amazon {

    WebDriver driver;
    WebDriverWait wait;
    
    // =================== Locators ===================
    // Login
    By emailfield = By.id("ap_email");
    By passwordfield = By.id("ap_password");
    By loginbtn = By.id("signInSubmit");
    
    // Search & Product
    By search = By.id("twotabsearchtextbox");
    By searchbtn = By.id("nav-search-submit-button");
    By firstproduct = By.cssSelector("#landingImage");
    
    // Cart
    By addtocartbtn = By.id("add-to-cart-button");
    By gotocartbtn = By.cssSelector("a[id=\"nav-cart\"]");
    By deletefromcartbtn = By.cssSelector("input[name*='submit.delete']");
    By closeCartPopup = By.cssSelector("span[id='attach-close_sideSheet-link']");
    
    // Account & Profile
    By accountandlists = By.id("nav-link-accountList-nav-line-1");
    By loginandsecurity = By.xpath("//div[contains(text(),'Login & security')]");
    By editname = By.xpath("//a[contains(text(),'Edit')]");
    By newname = By.id("ap_customer_name");
    By savechagebtn = By.id("cnep_1C_submit_button");
    
    // Address
    By youraddress = By.xpath("//div[contains(text(),'Your Addresses')]");
    By editbtn = By.id("ya-myab-address-edit-btn-0");
    By pincodechange = By.id("address-ui-widgets-enterAddressPostalCode");
    By addresschange = By.id("address-ui-widgets-enterAddressLine1");
    By areachange = By.id("address-ui-widgets-enterAddressLine2");
    By citychange = By.id("address-ui-widgets-enterAddressCity");
    By stateDropdown = By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId");
    By addressSaveBtn = By.id("address-ui-widgets-form-submit-button-announce");
    
    // Category & Product
    By categoryDropdown = By.id("searchDropdownBox");
    
    // Language & Country
    By langdrop = By.id("icp-nav-flyout-active-lang-text");
    By countryBtn = By.id("icp-touch-link-country");
    By countryDropdown = By.cssSelector("#icp-select-country");
    By changeCountryBtn = By.cssSelector(".a-button-input");

    // Other
    By todayDealsLink = By.xpath("//a[contains(@href, '/deals?ref_=nav_cs_gb')]");
    
    /**
     * Initializes the WebDriver and WebDriverWait.
     */
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Set the path to your chromedriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    /**
     * Navigates to the Amazon homepage.
     */
    public void navigateToAmazon() {
        driver.get("https://www.amazon.in/");
    }

    /**
     * Logs in to Amazon using provided email and password.
     */
    public void loginToAmazon(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailfield)).sendKeys(email);
        driver.findElement(passwordfield).sendKeys(password);
        driver.findElement(loginbtn).click();
        System.out.println("Login Successful.");
    }

    /**
     * Searches for a product using the search button.
     */
    public void searchProduct(String productName) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(search));
        searchBox.clear();
        searchBox.sendKeys(productName);
        wait.until(ExpectedConditions.elementToBeClickable(searchbtn)).click();
        System.out.println("Product searched: " + productName);
    }

    /**
     * Adds the first product from the search results to the cart.
     */
    public void addFirstProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstproduct)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addtocartbtn)).click();
        // Try closing cart popup if it appears
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeCartPopup)).click();
        } catch (Exception e) {
            System.out.println("Cart popup not shown, skipping.");
        }
        System.out.println("First product added to cart.");
    }

    /**
     * Navigates to the shopping cart page.
     */
    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(gotocartbtn)).click();
        System.out.println("Navigated to the cart.");
    }

    /**
     * Deletes an item from the cart.
     */
    public void deleteItemFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(deletefromcartbtn)).click();
        System.out.println("Item deleted from cart.");
    }
    
    /**
     * Changes the user's account name.
     */
    public void changeName(String newNameTxt) {
        wait.until(ExpectedConditions.elementToBeClickable(accountandlists)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginandsecurity)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editname)).click();
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(newname));
        nameField.clear();
        nameField.sendKeys(newNameTxt);
        driver.findElement(savechagebtn).click();
        System.out.println("Name changed to: " + newNameTxt);
    }
    
    /**
     * Changes the user's primary address details.
     */
    public void changeAddress(String pin, String addr1, String areaTxt, String cityTxt, String stateTxt) {
        wait.until(ExpectedConditions.elementToBeClickable(accountandlists)).click();
        wait.until(ExpectedConditions.elementToBeClickable(youraddress)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editbtn)).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(pincodechange)).clear();
        driver.findElement(pincodechange).sendKeys(pin);
        driver.findElement(addresschange).clear();
        driver.findElement(addresschange).sendKeys(addr1);
        driver.findElement(areachange).clear();
        driver.findElement(areachange).sendKeys(areaTxt);
        driver.findElement(citychange).clear();
        driver.findElement(citychange).sendKeys(cityTxt);

        WebElement stateElement = driver.findElement(stateDropdown);
        Select stateSelect = new Select(stateElement);
        stateSelect.selectByVisibleText(stateTxt);
        
        driver.findElement(By.id("address-ui-widgets-form-submit-button")).click();
        System.out.println("Address changed successfully.");
    }

    /**
     * Selects a category from the dropdown and searches for a product.
     */
    public void shopByCategory() {
        WebElement categoryDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(categoryDropdown));
        Select selectCategory = new Select(categoryDropdownElement);
        selectCategory.selectByValue("search-alias=stripbooks");
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(search));
        searchBox.sendKeys("Harry Potter");
        searchBox.sendKeys(Keys.ENTER);
        System.out.println("Searched for 'Harry Potter' in the Books category.");
    }

    /**
     * Changes the website's display language.
     */
    public void changeLanguage() {
        driver.findElement(langdrop).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='icp-language-translation-hint']/span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='icp-save-button']/span"))).click();
        System.out.println("Language changed.");
    }

    /**
     * Changes the website's country of delivery.
     */
    public void changeCountry() {
        driver.findElement(langdrop).click();
        wait.until(ExpectedConditions.elementToBeClickable(countryBtn)).click();
        WebElement countryDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
        Select selectCountry = new Select(countryDropdownElement);
        selectCountry.selectByValue("US"); 
        wait.until(ExpectedConditions.elementToBeClickable(changeCountryBtn)).click();
        System.out.println("Country changed to United States.");
    }

    /**
     * Navigates to the Today's Deals page.
     */
    public void goToTodayDeals() {
        wait.until(ExpectedConditions.elementToBeClickable(todayDealsLink)).click();
        System.out.println("Navigated to Today's Deals.");
    }

    /**
     * Closes the WebDriver.
     */
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }

    public static void main(String[] args) {
        MiniProjectClass_Amazon project = new MiniProjectClass_Amazon();
        
        try {
            project.setup();
            project.navigateToAmazon();
            
            // Scenario 1: Login, Search and Add to Cart
            project.loginToAmazon("your-email@example.com", "your-password"); // Replace with your credentials
            project.searchProduct("laptop");
            project.addFirstProductToCart();
            project.goToCart();
            project.deleteItemFromCart();
            
            // Scenario 2: Change Account Details
            project.changeName("New Name");
            project.changeAddress("560001", "123 Main Street", "Example Area", "Bengaluru", "KARNATAKA");
            
            // Scenario 3: Explore other features
            project.shopByCategory();
            project.changeLanguage();
            project.changeCountry();
            project.goToTodayDeals();
            
        } catch (Exception e) {
            System.err.println("An error occurred during the test: " + e.getMessage());
            e.printStackTrace();
        } finally {
            project.teardown();
        }
    }
}