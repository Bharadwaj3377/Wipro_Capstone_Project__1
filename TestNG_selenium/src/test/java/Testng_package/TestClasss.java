package Testng_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClasss {
	WebDriver driver;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
//		driver = new ChromeDriver();
		Thread.sleep(3000);
//        driver.manage().window().maximize();
         }
	
	public void amazon() throws InterruptedException
	  {
		  driver = new ChromeDriver();
		  driver.get("https://www.amazon.in/"); 
		  String expectedurl="https://www.amazon.in/";
		  String actualurl=driver.getCurrentUrl();
		  Assert.assertEquals(actualurl, expectedurl,"Url validation fail");
		  Thread.sleep(3000);
		  System.out.println("Amazon - Thread ID : "+ Thread.currentThread().getId());
		  driver.quit();
		  
		  
	  }
}
