package Testng_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.org.apache.bcel.internal.generic.Select;

public class PageClass {
    WebDriver driver;

    By emailField = By.id("ap_email");
    By passwordField = By.id("ap_password");
    By loginBtn = By.id("signInSubmit");

    By searchBox = By.id("twotabsearchtextbox");
    By searchBtn = By.id("nav-search-submit-button");
    By allMenu = By.id("nav-hamburger-menu");
    
    By firstProduct = By.xpath("(//img[@class='s-image'])[1]");
    By addToCartBtn = By.id("add-to-cart-button");
    By goToCartBtn = By.xpath("//*[@id='sw-gtc']/span/a");
    By proceedToBuyBtn = By.xpath("(//input[@type='submit'])[3]");
    
    By accountList = By.id("nav-link-accountList-nav-line-1");
    By profileEditBtn = By.xpath("(//span[@class='a-color-secondary'])[2]");
    By editNameBtn = By.xpath("(//a[@class='a-button-text'])[1]");
    By nameField = By.xpath("(//input[@class='a-input-text'])");
    By saveBtn = By.xpath("(//span[@class='a-button a-button-primary'])");
    By confirmBtn = By.id("cnep_1C_submit_button");
    
    By addressSection = By.xpath("(//span[@class='a-color-secondary'])[4]");
    By editAddressBtn = By.id("ya-myab-address-edit-btn-0");
    By pincode = By.id("address-ui-widgets-enterAddressPostalCode");
    By addressLine1 = By.id("address-ui-widgets-enterAddressLine1");
    By area = By.id("address-ui-widgets-enterAddressLine2");
    By city = By.id("address-ui-widgets-enterAddressCity");
    By state = By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_15");
    By saveAddressBtn = By.xpath("(//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce'])");
    

    
    By langBtn1 = By.xpath("//*[@id='icp-nav-flyout']/button");
    By changeMarket1 = By.xpath("//*[@id='icp-flyout-mkt-change']/span/div");
    By countryDropdown1 = By.id("icp-dropdown");
    By australiaOption1 = By.xpath("//a[text()='Australia']");
    By saveBtn11 = By.id("icp-save-button");  // ✅ add this back
    
     By shopByCategoryBtn = By.cssSelector("button[aria-controls='s0-1-4-12-0-1-dialog']");
     By electronicsLink = By.cssSelector("a[_sp='m570.l3410']");
     By mobilesLink = By.xpath("//ul/li[3]/span/a"); // Better: use text-based locator if possible
     By firstCategoryLink = By.xpath("//nav/ul/li[1]/a");

 
 

        public PageClass(WebDriver driver) {
            this.driver = driver;
        }

  


    public void loginToAmazon(String email, String password) {
        driver.findElement(emailField).sendKeys(email, Keys.ENTER);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
    public void searchItem(String item) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(item, Keys.ENTER);
    }

    public void openAllMenu() {
        driver.findElement(allMenu).click();
    }
    public void addFirstProductToCart() {
        driver.findElement(firstProduct).click();
        driver.findElement(addToCartBtn).click();
        driver.findElement(goToCartBtn).click();
        driver.findElement(proceedToBuyBtn).click();
    }
    public void changeName(String newName) {
        driver.findElement(accountList).click();
        driver.findElement(profileEditBtn).click();
        driver.findElement(editNameBtn).click();
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(newName);
        driver.findElement(saveBtn).click();
        driver.findElement(confirmBtn).click();
    }
    public void changeAddress(String pin, String addr1, String areaTxt, String cityTxt, String stateTxt) {
        driver.findElement(accountList).click();
        driver.findElement(addressSection).click();
        driver.findElement(editAddressBtn).click();
        driver.findElement(pincode).clear();
        driver.findElement(pincode).sendKeys(pin);
        driver.findElement(addressLine1).clear();
        driver.findElement(addressLine1).sendKeys(addr1);
        driver.findElement(area).clear();
        driver.findElement(area).sendKeys(areaTxt);
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(cityTxt);
        driver.findElement(state).clear();
        driver.findElement(state).sendKeys(stateTxt);
        driver.findElement(saveAddressBtn).click();
    }
    public void changeLanguage() {
		   driver.findElement(langBtn1).click();
		    driver.findElement(changeMarket1).click();
		    driver.findElement(countryDropdown1).click();
		    driver.findElement(australiaOption1).click();   driver.findElement(langBtn1).click();
		    driver.findElement(changeMarket1).click();
		    driver.findElement(countryDropdown1).click();
		    driver.findElement(australiaOption1).click();
		    driver.findElement(saveBtn11).click();
	}


@Test

    public void navigateFromAllMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click All Menu
        wait.until(ExpectedConditions.elementToBeClickable(allMenu)).click();

        // Click on Electronics (instead of hardcoding 7th arrow, use text)
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[text()='Electronics']/following-sibling::i[@class='nav-sprite hmenu-arrow-next']")))
            .click();

        // Navigate step by step using text-based locators
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Mobiles & Accessories"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("All Mobile Phones"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Android Phones"))).click();
    }


/*
public void testShopByCategory() {
    driver.findElement()
}



		/*public void changeLanguage() {
			   driver.findElement(langBtn1).click();
			    driver.findElement(changeMarket1).click();
			    driver.findElement(countryDropdown1).click();
			    driver.findElement(australiaOption1).click();   driver.findElement(langBtn1).click();
			    driver.findElement(changeMarket1).click();
			    driver.findElement(countryDropdown1).click();
			    driver.findElement(australiaOption1).click();
			    driver.findElement(saveBtn11).click();
		}
		*/

	
		}

		
	

