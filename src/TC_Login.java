import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_Login {

	@Test
	public void TC_login() {
		System.setProperty(
				"webdriver.chrome.driver",
				"jar_files\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://flipkart.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click(); // login page opened
		
		//Login 
		driver.findElement(By.xpath("//*[@class='_2zrpKA']")).sendKeys("nitun024@gmail.com");
		driver.findElement(By.xpath("//*[@class='_2zrpKA _3v41xv']")).sendKeys("suspension");
		driver.findElement(By.xpath("//div[@class='_1avdGP']/button")).click();
		
		driver.close();
		System.out.println("Test Successful");
		
	}

}
