package script;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest {
	
  @Test(priority=0,groups= {"login","smoke"})
  public void testValidLogin() {
	  
	  //enter the valid username
	  LoginPage lp=new LoginPage(driver);
	  lp.setUserName(Lib.getCellValue(XL_PATH, "ValidLogin", 1, 0));
	  
	  //enter the valid password
	  lp.setPassword(Lib.getCellValue(XL_PATH, "ValidLogin", 1, 1));
	  
	  //click on login button
	  lp.clickOnLoginButton();
	  
	  //verify that home page is displayed
	  EnterTimeTrackPage pg=new EnterTimeTrackPage(driver);
	  Reporter.log(Lib.getCellValue(XL_PATH, "ValidLogin", 1 , 2),true);
	  pg.verifyTitlePage(driver, Lib.getCellValue(XL_PATH, "ValidLogin", 1 , 2));
	  
	  
  }
}
