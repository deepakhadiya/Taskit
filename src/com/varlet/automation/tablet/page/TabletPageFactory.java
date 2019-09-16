package com.varlet.automation.tablet.page;

import org.openqa.selenium.WebDriver;

import com.varlet.automation.api.page.PageFactory;
import com.varlet.automation.base.page.HomePage;
import com.varlet.automation.base.page.LoginPage;

public class TabletPageFactory implements PageFactory {
	
	WebDriver driver;

	public TabletPageFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	@Override
	public LoginPage getLoginPage() {
		// TODO Auto-generated method stub
		return new TabletLoginPage(driver)	;
				}

	@Override
	public HomePage getHomePage() {
		// TODO Auto-generated method stub
		 return new TabletHomePage(driver)	;
	} 
}