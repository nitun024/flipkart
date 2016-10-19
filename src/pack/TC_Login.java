package pack;

import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class TC_Login {

	//@Test
	public static void TC_login() throws SQLException {
		
		String expText = "Hi Nitun!";
		System.setProperty("webdriver.chrome.driver", "jar_files\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://flipkart.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// login page opened
		driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click(); 

		// Login
		driver.findElement(By.xpath("//*[@class='_2zrpKA']")).sendKeys(DBConnection.getEmailFromDB());
		driver.findElement(By.xpath("//*[@class='_2zrpKA _3v41xv']")).sendKeys(DBConnection.getPasswordFromDB());
		driver.findElement(By.xpath("//div[@class='_1avdGP']/button")).click();
		
		// Login confirmation
		WebElement text = driver.findElement(By.xpath("//*[@class='_1AHrFc _2k0gmP']"));
		if(text.equals(expText))
		System.out.println("Login Successful");
		
		

		driver.close();
		driver.quit();
		// System.out.println("Test Successful");

	}

}