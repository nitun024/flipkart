package pack;

import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class TC_Login {

	@Test
	public void TC_login() throws SQLException {
		/*System.setProperty("webdriver.chrome.driver", "jar_files\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();*/
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://flipkart.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click(); // login page opened

		// Login

		driver.findElement(By.xpath("//*[@class='_2zrpKA']")).sendKeys(DBConnection.getEmailFromDB());
		driver.findElement(By.xpath("//*[@class='_2zrpKA _3v41xv']")).sendKeys(DBConnection.getPasswordFromDB());
		driver.findElement(By.xpath("//div[@class='_1avdGP']/button")).click();
		//Reporter.log("Login succesful", true);

		// driver.close();
		// System.out.println("Test Successful");

	}

}