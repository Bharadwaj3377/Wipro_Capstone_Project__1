package Testng_package;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;


import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import java.util.ArrayList;
import java.util.List;


public class Example_demo {
	WebDriver driver;
  @Test(priority=1)
  public void f() throws InterruptedException {
	       
	        WebElement username = driver.findElement(By.id("ap_email"));
	        username.sendKeys("bharadwaj333.achimsetty@gmail.com");
	        username.sendKeys(Keys.ENTER);
	        Thread.sleep(3000);

	        WebElement pass = driver.findElement(By.id("ap_password"));
	        pass.sendKeys("Bharadwaj333@");

	        WebElement loginButton = driver.findElement(By.id("signInSubmit"));
	        loginButton.click();
	        Thread.sleep(5000);
	    }
  @Test(enabled=false)
  
  public void searchItems() throws InterruptedException {
      List<String> list = new ArrayList<>();
      list.add("Phone");
      list.add("Watches");

      for (String item : list) {
          WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
          search.clear();
          search.sendKeys(item);
          search.sendKeys(Keys.ENTER);
          Thread.sleep(3000);
      }
  }
  
  @Test(priority=3)
  
  public void logout() throws InterruptedException {
	  driver.findElement(By.xpath("(//button[@class=\"nav-flyout-button nav-icon nav-arrow\"])[2]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("(//span[@class='nav-text'])[7]")).click();
	  Thread.sleep(3000);
	  driver.close();

  }




	 

  @BeforeClass
  public void beforeClass() throws InterruptedException{
	  driver=new ChromeDriver();
	  driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	  driver.manage().window().maximize();
      Thread.sleep(5000);
  }

  @AfterClass
  public void afterClass() {
	  
  }

}
