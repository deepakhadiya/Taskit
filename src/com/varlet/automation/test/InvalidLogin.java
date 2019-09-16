package com.varlet.automation.test;

import org.testng.annotations.Test;

import com.varlet.automation.api.page.HomePage;
import com.varlet.automation.api.page.LoginPage;
import com.varlet.automation.common.CommonTestCase;
import com.varlet.automation.util.Utility;

public class InvalidLogin extends CommonTestCase {
	
	@Test(priority=90001,groups={"login"})
	public void testInvalidLogin()
	{
		for(int i=1;i<=Utility.getRowCount(XL_PATH, "InValidLogin");i++) 
		{
			HomePage homePage=getPageFactory().getHomePage();
			homePage.verifyTitlePage("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
			
			//enter the invalid username
			LoginPage loginPage=getPageFactory().getLoginPage();
//			loginPage.setUserName(Utility.getCellValue(XL_PATH, "InValidLogin", i, 0));
//			
//			//enter the invalid password
//			loginPage.setPassword(Utility.getCellValue(XL_PATH, "InValidLogin", i, 1));
//			
//			//click on the login button
//			loginPage.clickOnLoginButton();
//			
//			//Thread.sleep(1000);
//			//verify error message is displayed
//			loginPage.verifyErrorMessageIsDisplayed();
//			getdriver().navigate().refresh();
			
		
		
		
		}
	}

}
