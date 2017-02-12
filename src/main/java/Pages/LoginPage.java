package main.java.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//*[@class='_2zrpKA']")
	public WebElement Email;
	
	@FindBy(xpath="//*[@class='_2zrpKA _3v41xv']")
	public WebElement Password;
	
	@FindBy(xpath="//div[@class='_1avdGP']/button")
	public WebElement LoginBtn;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
