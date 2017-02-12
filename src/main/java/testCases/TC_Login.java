package main.java.testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.java.Pages.HomePage;
import main.java.Pages.LoginPage;

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

public class TC_Login extends DriverInstantiation {

	// private static WebDriver driver;

	@Test
	public static void TC_login() throws IOException, SQLException, GeneralSecurityException, InterruptedException {

		HomePage home = new HomePage(driver);
		LoginPage login = new LoginPage(driver);

		// login page opened
		home.LoginBtn.click();

		// Login through Excel file
		login.Email.sendKeys("nitun024@gmail.com");
		login.Password.sendKeys("suspension");

		// Clicked on the login button
		login.LoginBtn.click();

		// Login confirmation
		try {
			String text = home.HiTag.getText().toString();
			String expText = "Hi Nitun!";

			if (text.equals(expText))
				System.out.println("Login Successful");
		} catch (NoSuchElementException e) {
			System.out.println("Login Unsuccessful");
		}

		// Search for Apple iPhone 6S Plus (Space Grey, 128 GB)
		WebElement SearchBar = home.SearchBar;
		SearchBar.click();
		SearchBar.sendKeys("iPhone 6s+");
		Thread.sleep(5000);
		SearchBar.sendKeys(Keys.RETURN);

		List<WebElement> SearchList = home.SearchResults;
		System.out.println(SearchList.size());

		for (int i = 0; i < SearchList.size(); i++) {
			if ((SearchList.get(i).getText().toString()).equals("Apple iPhone 6S (Rose Gold, 32 GB)")) {
				System.out.println("Phone found");
				SearchList.get(i).click();
				break;
			}
		}
		System.out.println(home.Price.getText());

		// Put the price of the Phone into the excel file
	//	ExcelConnection.putEmailExcelPOI("Sheet1", "iPhonePrice", home.Price.getText());

		 driver.close();
		// driver.quit();
		// System.out.println("Test Successful");

	}

}