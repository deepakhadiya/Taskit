package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConst{

	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	public WebDriver driver;
	
	//below method to open the browser
	@Parameters({"node","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(String node,String browser) throws MalformedURLException
	{
//		driver=new ChromeDriver();
		URL whichSystem=new URL(node);
		DesiredCapabilities whichBrowser=new DesiredCapabilities();
		whichBrowser.setBrowserName(browser);
				
		driver=new RemoteWebDriver(whichSystem, whichBrowser);
		driver.get(Lib.getPropertyValue(CONFIG_PATH, "URL"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(Lib.getPropertyValue(CONFIG_PATH, "ITO")), TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApplication()
	{
		driver.close();
	}
}
