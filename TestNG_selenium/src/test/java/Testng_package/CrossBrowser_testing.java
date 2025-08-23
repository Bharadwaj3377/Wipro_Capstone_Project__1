package Testng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CrossBrowser_testing {
	WebDriver driver;
	
	public void implicitwait() {
		driver=new ChromeDriver
	}
	
  @Test
  public void firefoxbrowser() throws InterruptedException {
	  driver=new FirefoxDriver();
	  driver.get("https://www.flipkart.com/");
	  String expectedtitle = "Online shopping site for Mobiles, Electronics, Furniture";
	  String actualtitle=driver.getTitle();
	  Assert.assertEquals(, 0)
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
