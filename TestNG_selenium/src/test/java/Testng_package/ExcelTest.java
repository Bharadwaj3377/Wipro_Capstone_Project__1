package Testng_package;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class ExcelTest {
	WebDriver driver;
	@BeforeTest   
	
	
	public void beforetest() throws InterruptedException{
		driver=new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
	}
	

    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
        String excelPath = "C:\\Users\\Bhara\\OneDrive\\Desktop\\excel_test.xlsx";
        
        String sheetName = "Sheet1";

        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = (cell == null) ? "" : cell.toString();
            }
        }
        workbook.close();
        return data;
    }

    @Test(dataProvider = "excelData")
    public void testLogin(String username1, String password1) {
        System.out.println("Username: " + username1 + " |  Password: " + password1);
       
     
                
                driver.findElement(By.id("user_login")).click();
                driver.findElement(By.id("user_login")).sendKeys(username1);
                driver.findElement(By.id("user_password")).click();
                driver.findElement(By.id("user_password")).sendKeys(password1);
                driver.findElement(By.name("submit")).click();
            }
        

    }