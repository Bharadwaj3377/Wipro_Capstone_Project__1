package Testng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Asserts_demo {
	WebDriver driver;
  @Test
  public void f() {
	  
	  String expectedtitle = "Selenium"; // Expected title
      String actualtitle = driver.getTitle(); 
	  Assert.assertEquals(actualtitle, expectedtitle,"Tile Validation failed");
	  System.out.println("Actual Title: "+actualtitle);
	  System.out.println("Expected Title: "+expectedtitle);
  }
  @BeforeClass
  public void beforeClass() {
	  driver=new ChromeDriver();
	  driver.get("https://www.selenium.dev/");
	  driver.manage().window().maximize();
	  
	  
  }
  @Test
  
  public void url()
  {
	  String expectedurl="https://www.selenium.dev/";
	  String actualurl=driver.getCurrentUrl();
	  Assert.assertEquals(actualurl, expectedurl,"URL validation failed");
	  System.out.println("Expected URL : "+expectedurl);
	  System.out.println("Actual URL : "+actualurl);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
