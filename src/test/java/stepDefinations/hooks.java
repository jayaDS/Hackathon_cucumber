package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import basepackage.basic;
import io.cucumber.java.*;

public class hooks {

	WebDriver driver;
	Properties p;
	
	@Before
	public void setup()throws IOException
	{
		basic.initilizeBrowser();
		driver=basic.getDriver();
		
		p=basic.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@After
	public void close(Scenario scenario)
	{
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		
		
	}
	
	
	
}
