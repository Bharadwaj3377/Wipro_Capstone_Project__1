package Testng_package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ebay_ActiveInactive {
	
    WebDriver driver;
	
	@BeforeTest 
	public void beforeTest() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		//Thread.sleep(2000);
	}
	@Test(enabled= false)
    public void shopByallCatTest() throws InterruptedException {
      
        driver.findElement(By.id("gh-cat")).click();
        driver.findElement(By.id("gh-search-btn")).click();
        Assert.assertTrue(true,"Search button is not working");
        Thread.sleep(3000);
    }
	
	@Test(enabled = true)

    public void languageChange() throws InterruptedException {
        driver.navigate().to("https://www.ebay.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement country = driver.findElement(By.cssSelector("button[class=\"gf-flag__button\"]"));
		country.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		driver.findElement(By.linkText("Italy")).click();
		Thread.sleep(2000);

	}
	
	
     @AfterTest 
     public void afterTest() {
	     driver.quit();
	     System.out.println("Browser closed. Test completed.");
     }
}
