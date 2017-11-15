package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage {
	
	@FindBy(xpath="//div[contains(text(),'Help')]")
	private WebElement helpMenu;
	
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutMenu;
	
	@FindBy(xpath="//span[starts-with(text(),'actiTIME')]")
	private WebElement version;
	
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closeButton;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnHelpMenu()
	{
		helpMenu.click();
	}
	
	public void clickOnAbout()
	{
		aboutMenu.click();
	}
	
	public void verifyVersion(String eVersion)
	{
		String aVersion=version.getText();
		Assert.assertEquals(aVersion, eVersion);
	}
	
	public void clickOnCloseButton()
	{
		closeButton.click();
	}
	
	public void clickOnLogoutLink()
	{
		logoutLink.click();
	}
	
	public void verifyTitlePage(WebDriver driver,String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try
		{
		
		wait.until(ExpectedConditions.titleIs(eTitle));
		Reporter.log("Title is matching",true);
		}
		catch(Exception e)
		{
			Reporter.log("Title is not matching",true);
			Assert.fail();
		}
		
		
	}
}
