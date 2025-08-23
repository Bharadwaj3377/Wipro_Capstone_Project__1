package Testng_package;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Amazon_miniproject {

    public static void main(String[] args) {
        // --- Test Setup ---
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create an instance of the PageClass
        PageClass amazonPage = new PageClass(driver);

        try {
            // --- Test Scenarios ---
            
            // Navigate to Amazon
            System.out.println("Navigating to Amazon...");
            driver.get("https://www.amazon.in/");

            // Scenario 1: Login, Search, and Cart Operations
            System.out.println("--- Scenario 1: Login, Search, and Cart Operations ---");
            amazonPage.loginToAmazon("your_email@example.com", "your_password"); // Replace with your credentials
            System.out.println("Login successful.");

            amazonPage.searchProduct("smartwatch");
            System.out.println("Product 'smartwatch' searched.");

            amazonPage.addFirstProductToCart();
            System.out.println("First product added to cart.");

            amazonPage.goToCart();
            System.out.println("Navigated to cart.");

            amazonPage.deleteItemFromCart();
            System.out.println("Item deleted from cart.");

            // Scenario 2: Account and Address Update
            System.out.println("\n--- Scenario 2: Account and Address Update ---");
            amazonPage.changeName("Test User");
            System.out.println("Name changed to 'Test User'.");
            
            amazonPage.changeAddress("560001", "123 Test Street", "Test Area", "Bengaluru", "KARNATAKA");
            System.out.println("Address changed successfully.");

            // Scenario 3: Category and Language
            System.out.println("\n--- Scenario 3: Category and Language ---");
            amazonPage.shopByCategory();
            System.out.println("Searched for 'Harry Potter' in the 'Books' category.");

            amazonPage.changeLanguage();
            System.out.println("Language changed.");

            amazonPage.changeCountry();
            System.out.println("Country changed to US.");

            // Scenario 4: Navigate to Today's Deals
            System.out.println("\n--- Scenario 4: Navigating to Deals ---");
            amazonPage.goToTodayDeals();
            System.out.println("Navigated to Today's Deals.");

        } catch (Exception e) {
            System.err.println("An error occurred during the test: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // --- Test Teardown ---
            if (driver != null) {
                driver.quit();
                System.out.println("\nBrowser closed successfully.");
            }
        }
    }
}

