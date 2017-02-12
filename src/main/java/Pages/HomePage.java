package main.java.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 50);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	public WebElement LoginBtn;
	
	@FindBy(xpath="//*[@class='_1AHrFc _2k0gmP']")
	public WebElement HiTag;
	
	@FindBy(xpath="//*[@class='LM6RPg'][@name='q']")
	public WebElement SearchBar;
	
	@FindBys(@FindBy(xpath="//*[@class='_2cLu-l']"))
	public static List<WebElement> SearchResults;
	
	@FindBy(xpath="//*[@class='_3zLR9i _3Plo8Q _19RW-r']")
	public WebElement AddToCartBtn;
	
	@FindBy(xpath="//*[@href='/viewcart']")
	public WebElement CartBtn;	
	
	@FindBy(xpath="//span[@class='title fk-font-14']")
	public List<WebElement> ItemsInCart;
	
	@FindBy(xpath="//div[@class='_1vC4OE _37U4_g']")
	public WebElement Price;
	
	
	
	

}
