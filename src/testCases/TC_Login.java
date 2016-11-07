package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import utils.ExcelConnection;
import utils.FKProperties;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Login {

	private static WebDriver driver;
	static String url, chromeJarAddress;
	
	@BeforeTest
	public static void setup() throws IOException {

		url = FKProperties.getValue("url");
		chromeJarAddress = FKProperties.getValue("chromeJarAddress");
		System.setProperty("webdriver.chrome.driver", chromeJarAddress);

	}

	@Test
	public static void TC_login() throws IOException, SQLException, GeneralSecurityException, InterruptedException {

		driver = new ChromeDriver();

		HomePage home = new HomePage(driver);
		LoginPage login = new LoginPage(driver);

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// login page opened
		home.LoginBtn.click();

		/*// Login through DB
		login.Email.sendKeys(DBConnection.getEmailFromDB());
		login.Password.sendKeys(DBConnection.getPasswordFromDB() );*/

		// Login through Excel file
		 login.Email.sendKeys(ExcelConnection.getEmailExcelPOI("Sheet1","Email"));
		 login.Password.sendKeys(ExcelConnection.getEmailExcelPOI("Sheet1", "Password"));

		// Clicked on the login button
		login.LoginBtn.click();

		// Login confirmation
		try {
			String text = home.HiTag.getText().toString();
			String expText = ExcelConnection.getEmailExcelPOI("Sheet1", "ExpTag");
			
			if (text.equals(expText))
				System.out.println("Login Successful");
		} catch (NoSuchElementException e) {
			System.out.println("Login Unsuccessful");
		}
		
		//Search for Apple iPhone 6S Plus (Space Grey, 128 GB)
		WebElement SearchBar = home.SearchBar;
		SearchBar.click();
		SearchBar.sendKeys("iPhone 6s+");
		Thread.sleep(5000);
		SearchBar.sendKeys(Keys.RETURN);
		
		List<WebElement> SearchList = home.SearchResults;
		System.out.println(SearchList.size());

		for (int i = 0; i < SearchList.size(); i++) {
			if ((SearchList.get(i).getText().toString()).equals("Apple iPhone 6S Plus (Space Grey, 16 GB)")) {
				System.out.println("Phone found");
				SearchList.get(i).click();
				break;
			}
		}
		System.out.println(home.Price.getText());
		
		//Put the price of the Phone into the excel file
		ExcelConnection.putEmailExcelPOI("Sheet1", "iPhonePrice", home.Price.getText());

		// driver.close();
		// driver.quit();
		// System.out.println("Test Successful");

	}

}