package Testng_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testclass2 {
	WebDriver driver;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
//		driver = new ChromeDriver();
		Thread.sleep(3000);
//        driver.manage().window().maximize();
         }
	@Test(priority=1)
	  public void flipkart() throws InterruptedException
	  {
		  driver = new ChromeDriver();
		  driver.get("https://www.flipkart.com/"); 
		  String expectedtitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		  String actualtitle=driver.getTitle();
		  Assert.assertEquals(actualtitle, expectedtitle,"Title validation fail");
		  Thread.sleep(3000);
		  System.out.println("Flipkart - Thread ID : "+ Thread.currentThread().getId());
		  driver.quit();
	  }
	
}