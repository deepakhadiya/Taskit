package com.varlet.automation.mobile.page;

import org.openqa.selenium.WebDriver;

import com.varlet.automation.api.page.PageFactory;
import com.varlet.automation.base.page.HomePage;
import com.varlet.automation.base.page.LoginPage;

public class MobilePageFactory implements PageFactory {
	
	WebDriver driver;

	public MobilePageFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	@Override
	public LoginPage getLoginPage() {
		// TODO Auto-generated method stub
		return new MobileLoginPage(driver)	;
				}

	@Override
	public HomePage getHomePage() {
		// TODO Auto-generated method stub
		 return new MobileHomePage(driver)	;
	} 
}