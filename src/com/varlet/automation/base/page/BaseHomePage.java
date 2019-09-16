package com.varlet.automation.base.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.varlet.automation.api.page.HomePage;

public abstract class BaseHomePage implements HomePage{

	@FindBy(xpath="//a[text()='Login & Signup']")
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@type='text' and contains(@title,'Search for products')]")
	private WebElement searchBox;
	
	@FindBy(xpath="//input[@type='text' and contains(@title,'Search for products')]/../../button")
	private WebElement searchButton;
	
	private WebDriver driver;
	
	public BaseHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	public void searchForProduct(String productName)
	{
		searchBox.sendKeys(productName);
	}
	
	
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	
	public void myTest() {
		
		System.out.println("Inside Test");
		System.out.println("Inside Test"+driver.getCurrentUrl());
	}
	
	public void verifyTitlePage(String eTitle)
	{
	
		try
		{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs(eTitle));
		Reporter.log("Title is matching",true);
		}
		catch(Exception e)
		{
			Reporter.log("Title is not matching actual :"+driver.getTitle()+" Expected :"+eTitle,true);
		}
		
		
	}
}
