package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	public WebElement LoginBtn;
	
	@FindBy(xpath="//*[@class='_1AHrFc _2k0gmP']")
	public WebElement HiTag;
	
	@FindBy(xpath="//*[@class='LM6RPg'][@name='q']")
	public WebElement SearchBar;
	
	@FindBys(@FindBy(xpath="//*[@class='_2cLu-l']"))
	public List<WebElement> SearchResults;
	
	@FindBy(xpath="//*[@class='_3zLR9i _3Plo8Q _19RW-r']")
	public WebElement AddToCartBtn;
	
	@FindBy(xpath="//*[@href='/viewcart']")
	public WebElement CartBtn;	
	
	@FindBy(xpath="//span[@class='title fk-font-14']")
	public List<WebElement> ItemsInCart;
	
	
	

}
