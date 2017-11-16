package script;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class VerifyVersion extends BaseTest {

	@Test(priority=1,groups={"version"})
	public void testVerifyVersion() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		  lp.setUserName(Lib.getCellValue(XL_PATH, "ValidLogin", 1, 0));
		  
		  //enter the valid password
		  lp.setPassword(Lib.getCellValue(XL_PATH, "ValidLogin", 1, 1));
		  
		  //click on login button
		  lp.clickOnLoginButton();
		
		  WebDriverWait wait=new WebDriverWait(driver, 7);
		  wait.until(ExpectedConditions.titleIs(Lib.getCellValue(XL_PATH, "ValidLogin", 1, 2)));
		  
		  //click on help menu
		EnterTimeTrackPage pg=new EnterTimeTrackPage(driver);
		Thread.sleep(5000);
		pg.clickOnHelpMenu();
		Thread.sleep(5000);
		//click on about link 
		pg.clickOnAbout();
		Thread.sleep(2000);
		//verify the version
		pg.verifyVersion("actiTIME 2017.2");
		
		//click on the close button
		pg.clickOnCloseButton();
		
		//click on logout link
		pg.clickOnLogoutLink();
	}
	
}
