package Testng_package;


import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Logintest {

  @Test
  @Parameters({"username","password"})
  public void logintest(@Optional("admin") String username, @Optional("admin@123") String password) 
  {
	  System.out.println("Enter username and password : ");
	  
	  System.out.println("username : " + username);
	  System.out.println("password : " + password);
	  
	  if(username.equals("admin") && password.equals("admin@123")) 
	  {
		  System.out.println("Successfully Logged in ");
	  }
	  else 
	  {
		  System.out.println("Invalid username (or) password ");
	  }
  }
}
