package pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Surgeries {
	WebDriver driver;
	public Surgeries(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[text()='Popular Surgeries']")
	public WebElement scroll;
	
	@FindBy(xpath="//*[@class='flex flex-col items-center text-center']")
	public List<WebElement> surgeries_list;
	
	public List<String> displaySurgeries()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();",scroll);
	    List<String> list=new ArrayList<String>();
		for(WebElement top:surgeries_list) {
			list.add(top.getText());
		}
		return list;
	}
}
