package Testng_package;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Explicit_wait {
  @Test
  public void f() {
	  WebDriver driver=new ChromeDriver();
	  driver.get("http://zero.webappsecurity.com/login.html");
	  
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	  
	  WebElement user=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));
	  user.sendKeys("username");
	  driver.close();
  }
}
		/*WebDriver driver=new ChromeDriver();
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		
		WebElement user=wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("user_login"));
			}
		}
		user.sendKeys("username");
		driver.close();
*/