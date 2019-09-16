package com.varlet.automation.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.varlet.automation.api.page.PageFactory;
import com.varlet.automation.mobile.page.MobilePageFactory;
import com.varlet.automation.tablet.page.TabletPageFactory;
import com.varlet.automation.util.Utility;
import com.varlet.automation.web.page.WebPageFactory;

public class CommonTestCase implements IAutoConst{
	
	String platformName=Utility.getPropertyValue(CONFIG_PATH, "platform.name");
	
	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	
	private WebDriver driver;
	private PageFactory pageFactory;
	private DesiredCapabilities dc;
	
	 public WebDriver getDriver() {
		return driver;
	}
	
	
	//below method to open the browser
	@Parameters({"node","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(@Optional("chrome") String browser,@Optional("localhost") String node)
	{
		
		
		dc=new DesiredCapabilities();
		dc.setBrowserName(browser);
		
		if(browser.equals("chrome")) {
			Map<String, String> mobileEmulation = new HashMap<>();
				if(platformName.equals("mobile")) {
					mobileEmulation.put("deviceName", "Nexus 5");
				} else if(platformName.equals("tablet")) {
					mobileEmulation.put("deviceName", "iPad Mini");
				}
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			dc.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		}
		
		URL system = null;
		try {
			system = new URL("http://"+node+":5555/wd/hub");
		} catch (MalformedURLException e) {
		}
		driver=new RemoteWebDriver(system,dc);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(Utility.getPropertyValue(CONFIG_PATH, "ITO")), TimeUnit.SECONDS);
		driver.get(Utility.getPropertyValue(CONFIG_PATH, "URL"));
	}

	@AfterMethod(alwaysRun=true)
	public void closeApplication()
	{
		driver.quit();
	}
	
	
	@BeforeSuite
	@Parameters("platform.name")
	private void getPlatformName(String platformNameFromXml) {
		if(platformName==null) {
			platformName=platformNameFromXml;
		}
	}
	public PageFactory getPageFactory() {
		
		if (pageFactory == null) {
			pageFactory = platformName.equalsIgnoreCase("web") ? new WebPageFactory(driver)
					: platformName.equalsIgnoreCase("mobile") ? new MobilePageFactory(driver)
							: platformName.equalsIgnoreCase("tablet") ? new TabletPageFactory(driver) : null;
		}if (pageFactory == null) {
			Assert.fail("Unable to create page factory instance, please check 'platform.name' parameter");
		}
		return pageFactory;
	}
	

}
