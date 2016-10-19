package pack;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_CartVerification {

	//@Test
	public static void TC_cartVerification() throws SQLException, InterruptedException {

		// TC_Login.TC_login();
		System.setProperty("webdriver.chrome.driver", "jar_files\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String WatchName = "Fossil CH2622 Decker Analog Watch - For Men";

		// WebDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// login page opened
		driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();

		// Login
		String emailAdd = DBConnection.getEmailFromDB();
		driver.findElement(By.xpath("//*[@class='_2zrpKA']")).sendKeys(emailAdd);
		driver.findElement(By.xpath("//*[@class='_2zrpKA _3v41xv']")).sendKeys(DBConnection.getPasswordFromDB());
		driver.findElement(By.xpath("//div[@class='_1avdGP']/button")).click();
		Reporter.log("Login succesful", true);

		// Search for the Fossil watch 'Fossil CH2601I DECKER - M Analog Watch -
		// For Men'
		Thread.sleep(5000);
		WebElement SearchBar = driver.findElement(By.xpath("//*[@class='LM6RPg'][@name='q']"));
		SearchBar.click();
		SearchBar.sendKeys("Fossil DECKER");
		Thread.sleep(5000);
		SearchBar.sendKeys(Keys.RETURN);

		// Searching for the watch from the Search results
		java.util.List<WebElement> SearchList = driver.findElements(By.xpath(".//*[@class='_2cLu-l']"));

		for (WebElement webEl : SearchList) {
			if ((webEl.getText()).equals(WatchName)) {
				System.out.println("Watch found");
				webEl.click();
			}
		}

		// Clicking on Add to Cart
		driver.findElement(By.xpath("//*[@class='_3zLR9i _3Plo8Q _19RW-r']")).click();

		// opening cart
		driver.findElement(By.xpath(".//*[@href='/viewcart']")).click();

		// Find the added watch in the cart and if found then add it into the DB
		// (cart table)
		java.util.List<WebElement> CartList = driver.findElements(By.xpath("//span[@class='title fk-font-14']"));

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