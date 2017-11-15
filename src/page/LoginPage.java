package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;



public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginButton;
	
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errorMessage;
	
	public LoginPage(WebDriver driver)
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
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
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
