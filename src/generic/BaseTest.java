package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst{

	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	public WebDriver driver;
	
	//below method to open the browser
	@BeforeMethod(alwaysRun=true)
	public void openApplication()
	{
		driver=new ChromeDriver();
		driver.get(Lib.getPropertyValue(CONFIG_PATH, "URL"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(Lib.getPropertyValue(CONFIG_PATH, "ITO")), TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApplication()
	{
		driver.close();
	}
}
