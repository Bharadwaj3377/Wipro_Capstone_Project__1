package Testng_package;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Ebay_dependtTesting {

	    WebDriver driver;

	    @BeforeTest
	    public void beforeTest() throws InterruptedException {
	        driver = new FirefoxDriver();
	        driver.get("https://www.ebay.com/");
	        driver.manage().window().maximize();
	    }

	    @Test(priority = 1)
	    public void login() throws InterruptedException {
	    	
	        driver.findElement(By.cssSelector(".gh-identity-signed-out-unrecognized > a:nth-child(1)")).click();
	        Thread.sleep(15000);
	        driver.findElement(By.id("userid")).sendKeys("bharadwaj333.achimsetty@gmail.com");
	        driver.findElement(By.id("signin-continue-btn")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.id("pass")).sendKeys("Bharadwaj333@");
	        driver.findElement(By.id("sgnBt")).click();

//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	        WebElement sfn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passkeys-cancel-btn")));
//	        sfn.click();

	        System.out.println("Sign in simulated");
	        Thread.sleep(3000);
	    }

	    @Test(priority = 2, dependsOnMethods = "login",invocationCount=2)
	    public void multipleSearches() throws InterruptedException {
	        List<String> searchItems = Arrays.asList("Watch", "Phone", "Shoes");

	        for (String item : searchItems) {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	            WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
	            search.clear();
	            search.sendKeys(item);
	            search.sendKeys(Keys.ENTER);
	            Thread.sleep(2000);
	        }

	        System.out.println("Searches completed");
	    }

	    @Test(priority = 3, dependsOnMethods = "login")
	    public void logout() throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        driver.navigate().to("https://www.ebay.com/");
	        WebElement hiMsg = driver.findElement(By.cssSelector("span.gh-identity__greeting"));
		    Actions act = new Actions(driver);
		    act.moveToElement(hiMsg).perform();
		    Thread.sleep(2000);

	        
	        WebElement signOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
	        signOut.click();

	        System.out.println("Logged out successfully");
	        Thread.sleep(2000);
	    }

	    @AfterTest
	    public void afterTest() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
