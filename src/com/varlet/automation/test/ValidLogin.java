package com.varlet.automation.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.varlet.automation.api.page.HomePage;
import com.varlet.automation.api.page.LoginPage;
import com.varlet.automation.common.BaseTest;
import com.varlet.automation.util.Lib;

public class ValidLogin extends BaseTest {

  @Test(priority=1,groups= {"login","smoke"})
  public void testValidLogin() {
	  com.varlet.automation.util.Reporter r=new com.varlet.automation.util.Reporter();
	  r.startStep(new Throwable().getStackTrace()[1].getMethodName(), "entering user name");
	  //enter the valid username
	  LoginPage lp=getPageFactory().getLoginPage();
//	  lp.setUserName(Lib.getCellValue(XL_PATH, "ValidLogin", 1, 0));
	  
	  r.startStep(new Throwable().getStackTrace()[1].getMethodName(), "entering password");
	  //enter the valid password
//	  lp.setPassword(Lib.getCellValue(XL_PATH, "ValidLogin", 1, 1));
	  
	  r.startStep(new Throwable().getStackTrace()[1].getMethodName(), "clicking on login button");
	  //click on login button
//	  lp.clickOnLoginButton();
	  
	  r.startStep(new Throwable().getStackTrace()[1].getMethodName(), "Verifying home page");
	  //verify that home page is displayed
	  HomePage pg=getPageFactory().getHomePage();
	  Reporter.log(Lib.getCellValue(XL_PATH, "ValidLogin", 1 , 2),true);
	  pg.verifyTitlePage(Lib.getCellValue(XL_PATH, "ValidLogin", 1 , 2));
	  
	  
  }
}
