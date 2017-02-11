package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class try1 extends DriverInstantiation {
	
	@Test
	public void try1() throws InterruptedException, IOException {
		
	//	System.setProperty("webdriver.chrome.driver", "jar_files\\chromeDriver\\chromedriver.exe");
	//	WebDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("nitun024");
		driver.findElement(By.xpath("//input[@id='next']")).click();
		driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("suspension");
		driver.findElement(By.xpath("//input[@id='signIn']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[text()='COMPOSE' and @role='button']")).click();
		driver.findElement(By.xpath("//div[@id=':qe']")).click();;
		
		// Auto It part
		Runtime.getRuntime().exec("E:\\AutoIT\\FileUpload.exe");
		
		
	}

}
