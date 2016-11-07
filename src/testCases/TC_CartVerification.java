package testCases;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import utils.DBConnection;
import utils.ExcelConnection;
import utils.FKProperties;

public class TC_CartVerification {

	private static WebDriver driver;
	static String url, chromeJarAddress;

	@BeforeTest
	public static void setup() throws IOException {

		url = FKProperties.getValue("url");
		chromeJarAddress = FKProperties.getValue("chromeJarAddress");
		System.setProperty("webdriver.chrome.driver", chromeJarAddress);

	}

	@Test
	public static void TC_cartVerification()
			throws SQLException, InterruptedException, IOException, GeneralSecurityException {

		driver = new ChromeDriver();

		HomePage home = new HomePage(driver);
		LoginPage login = new LoginPage(driver);

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String WatchName = ExcelConnection.getEmailExcelPOI("Sheet1", "WatchName");

		// login page opened
		home.LoginBtn.click();

		// Login
		String emailAdd = DBConnection.getEmailFromDB();

		login.Email.sendKeys(DBConnection.getEmailFromDB());
		login.Password.sendKeys(DBConnection.getPasswordFromDB());
		login.LoginBtn.click();
		// Reporter.log("Login successful", true);

		// Search for the Fossil watch 'Fossil CH2600 Decker - M Analog Watch -
		// For Men'
		Thread.sleep(5000);
		WebElement SearchBar = home.SearchBar;
		SearchBar.click();
		SearchBar.sendKeys("Fossil DECKER");
		Thread.sleep(5000);
		SearchBar.sendKeys(Keys.RETURN);

		// Searching for the watch from the Search results
		// List<WebElement> SearchList = driver.findElements(By.xpath("//*[@class='_2cLu-l']"));
		List<WebElement> SearchList = home.SearchResults;
		System.out.println(SearchList.size());

		for (int i = 0; i < SearchList.size(); i++) {
			if ((SearchList.get(i).getText().toString()).equals(WatchName)) {
				System.out.println("Watch found");
				SearchList.get(i).click();
			}
		}
		
		// Clicking on Add to Cart
		home.AddToCartBtn.click();

		// Opening cart
		home.CartBtn.click();

		// Find the added watch in the cart and if found then add it into the DB
		// (cart table)
		java.util.List<WebElement> CartList = home.ItemsInCart;

		for (WebElement webEl : CartList) {
			System.out.println(webEl.getText());
			if ((webEl.getText()).equalsIgnoreCase(WatchName)) {
				System.out.println("Match found for the watch in cart");

				DBConnection.putItemIntoCartDB(webEl.getText(), DBConnection.getIdFromEmailDB(emailAdd));
			}
		}

		driver.close();
		driver.quit();
	}

}