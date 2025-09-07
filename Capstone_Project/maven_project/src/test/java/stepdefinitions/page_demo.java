package stepdefinitions;

		
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;

		public class page_demo {
		    WebDriver driver;

		    public page_demo(WebDriver driver) {
		        this.driver = driver;
		    }
		    By usernameDropdown = By.id("username");
		    By usernameOption = By.xpath("//div[@id='react-select-2-option-0-0']");
		    By passwordDropdown = By.id("password");
		    By passwordOption = By.xpath("//div[@id='react-select-3-option-0-0']");
		    By loginBtn = By.id("login-btn");

		    By searchBox = By.xpath("//input[@placeholder='Search']");
		    By searchButton = By.cssSelector("button.bg-gray-100");

		    By addToCartBtn = By.xpath("(//div[@class='shelf-item__buy-btn'])");
		    By removeItemBtn = By.xpath("//div[@class='shelf-item__del']");
		    By closeCartBtn = By.xpath("//div[@class='float-cart__close-btn']");
		    By checkoutBtn = By.xpath("//div[@class='buy-btn']");

		    By firstName = By.id("firstNameInput");
		    By lastName = By.id("lastNameInput");
		    By address = By.id("addressLine1Input");
		    By province = By.id("provinceInput");
		    By postcode = By.id("postCodeInput");
		    By continueBtn = By.id("checkout-shipping-continue");
		    By cancelBtn = By.xpath("//button[@class='button button--tertiary optimizedCheckout-buttonSecondary']");

		    By favIcon = By.xpath("//span[@class='MuiIconButton-label']");
		    By favouritesLink = By.xpath("//a[@id='favourites']");
		    By homeLogo = By.xpath("//img[@class='Navbar_logo__image__3Blki']");
		    By offersLink = By.id("offers");

		    By brandCheckbox = By.xpath("//span[@class='checkmark'][1]");
		    By lowestPriceFilter = By.xpath("//option[@value='lowestprice']");
		    By highestPriceFilter = By.xpath("//option[@value='highestprice']");

		    By logoutLink = By.xpath("//span[@class='Navbar_link__3Blki logout-link mt-2']");
		    
		    public void testlogin() throws InterruptedException {
		    driver.findElement(usernameDropdown).click();
	        driver.findElement(usernameOption).click();
	        Thread.sleep(3000);
	        driver.findElement(passwordDropdown).click();
	        Thread.sleep(3000);
	        driver.findElement(passwordOption).click();
	        Thread.sleep(3000);
	        // Click login button
	        driver.findElement(loginBtn).click();
	        Thread.sleep(2000);
	}
		    public void testsearch(String product) throws InterruptedException {
		    	 driver.findElement(searchBox).sendKeys(product);
		         Thread.sleep(3000);
		         driver.findElement(searchButton).click();
		         Thread.sleep(3000);
		    }
		    public void testaddtocart() throws InterruptedException {
		    	driver.findElement(addToCartBtn).click();
		        Thread.sleep(3000);
		        driver.findElement(removeItemBtn).click();
		        Thread.sleep(3000);
		        driver.findElement(closeCartBtn).click();
		        Thread.sleep(3000);
		    }
		    public void testcheckout() throws InterruptedException {
		    	driver.findElement(addToCartBtn).click();
		        Thread.sleep(3000);
		        driver.findElement(checkoutBtn).click();
		        Thread.sleep(3000);
		    }
		    public void testshippingaddress(String fname,String lname, String Address, String state, String pincode) throws InterruptedException {
		    	driver.findElement(firstName).sendKeys(fname);
		    	Thread.sleep(3000);
		    	driver.findElement(lastName).sendKeys(lname);
		    	Thread.sleep(3000);
		    	driver.findElement(address).sendKeys(Address);
		    	Thread.sleep(3000);
		    	driver.findElement(province).sendKeys(state);
		    	Thread.sleep(3000);
		    	driver.findElement(postcode).sendKeys(pincode);
		    	Thread.sleep(3000);
		    	driver.findElement(continueBtn).click();
		    	Thread.sleep(3000);
		    	driver.findElement(cancelBtn).click();
		    	Thread.sleep(3000);
		    }
		    public void testfavourite() throws InterruptedException {
		    	driver.findElement(favIcon).click();
		    	Thread.sleep(3000);
		    	driver.findElement(favouritesLink).click();
		    	Thread.sleep(3000);
		    	driver.findElement(homeLogo).click();
		    	Thread.sleep(3000);
		    }
		    public void testoffers() throws InterruptedException {
		    	driver.findElement(offersLink).click();
		    	Thread.sleep(3000);
		    	driver.findElement(homeLogo).click();
		    	Thread.sleep(3000);
		    	
		    }
		    public void testbrandshopping() throws InterruptedException {
		       driver.findElement(brandCheckbox).click();
		  	   Thread.sleep(3000);
		  	   driver.findElement(homeLogo).click();
		       Thread.sleep(3000);
		    }
		    public void testfilters() throws InterruptedException {
		       driver.findElement(lowestPriceFilter).click();
		 	   Thread.sleep(3000);
		 	   
		 	   driver.findElement(highestPriceFilter).click();
		 	   Thread.sleep(3000);
		    }
		    public void testlogout() throws InterruptedException {
		    	driver.findElement(logoutLink).click();
		 	   Thread.sleep(3000);
		    }

}
