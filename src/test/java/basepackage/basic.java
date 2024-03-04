package basepackage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class basic {

	static WebDriver driver;
	static Properties p;
	static Logger logger;
	
	public static void initilizeBrowser() throws IOException
	{
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{

			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			capabilities.setPlatform(Platform.WIN11);
			//browser
			switch(getProperties().getProperty("browser").toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); 
			return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		    }
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
		{
				
		switch(getProperties().getProperty("browser").toLowerCase())
		{
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		default :
			System.out.println("Invalid browser");
			return;
		}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static Properties getProperties() throws IOException
	{
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		
		p=new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getlogger()
	{
		logger=LogManager.getLogger();
		return logger;
	}
	public static void screenShot(String fileName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File trg= new File(System.getProperty("user.dir")+"\\Screenshots\\"+ fileName+".png");
		FileUtils.copyFile(src, trg);

}


	
	

}
