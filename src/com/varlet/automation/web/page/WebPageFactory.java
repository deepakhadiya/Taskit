package com.varlet.automation.web.page;

import org.openqa.selenium.WebDriver;

import com.varlet.automation.api.page.HomePage;
import com.varlet.automation.api.page.LoginPage;
import com.varlet.automation.api.page.PageFactory;

public class WebPageFactory implements PageFactory {
	
	WebDriver driver;

	public WebPageFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	@Override
	public LoginPage getLoginPage() {
		// TODO Auto-generated method stub
		return new WebLoginPage(driver)	;
				}

	@Override
	public HomePage getHomePage() {
		// TODO Auto-generated method stub
		 return new WebHomePage(driver)	;
	} 
}