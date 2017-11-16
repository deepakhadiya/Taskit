package script;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import page.LoginPage;

public class InvalidLogin extends BaseTest {
	
	@Test(priority=2,groups={"login"})
	public void testInvalidLogin() throws InterruptedException
	{
		for(int i=1;i<=Lib.getRowCount(XL_PATH, "InValidLogin");i++) 
		{
			//enter the invalid username
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(Lib.getCellValue(XL_PATH, "InValidLogin", i, 0));
			
			//enter the invalid password
			lp.setPassword(Lib.getCellValue(XL_PATH, "InValidLogin", i, 1));
			
			//click on the login button
			lp.clickOnLoginButton();
			
			//Thread.sleep(1000);
			//verify error message is displayed
			lp.verifyErrorMessageIsDisplayed();
			driver.navigate().refresh();
			
		
		
		
		}
	}

}
