package com.varlet.automation.base.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.varlet.automation.api.page.LoginPage;



public abstract class BaseLoginPage implements LoginPage{
	
	@FindBy(xpath="//*[text()='Enter Email/Mobile number']/ancestor::div/input")
	private WebElement unTB;
	
	@FindBy(xpath="//*[text()='Enter Password']/ancestor::div/input")
	private WebElement pwTB;
	
	@FindBy(xpath="//*[text()='Login']/ancestor::div/button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//*[text()='Your username or password is incorrect']")
	private WebElement errorMessage;

	private WebDriver driver;
	
	
	
	public BaseLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
		Reporter.log(pw+" Entered successfully", true);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
		Reporter.log("Login button successfully clicked", true);
	}
	

	public void verifyErrorMessageIsDisplayed()
	{
		WebDriverWait wait=new WebDriverWait(driver, 3);
		try
		{
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		Reporter.log("Error message is displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Error message is not displayed",true);
			Assert.fail();
		}
	}

}
