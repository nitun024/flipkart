package main.java.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import main.java.utils.FKProperties;

public class DriverInstantiation {

	public static WebDriver driver = null;
	static String url, chromeJarAddress;

	@BeforeTest
	public static void setup() throws IOException {

		url = FKProperties.getValue("url");
		chromeJarAddress = FKProperties.getValue("chromeJarAddress");
		System.setProperty("webdriver.chrome.driver", chromeJarAddress);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

}
