package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-locality']")
	public WebElement city_searrch;
	
	@FindBy(xpath="//div[@data-qa-id='omni-suggestion-main' and text()='Bangalore']")
	public WebElement city;
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-keyword']")
	public WebElement doctor_searrch;
	
	@FindBy(xpath="//div[@data-qa-id='omni-suggestion-main'and text()='Cardiologist']")
	public WebElement doctor;
	
	@FindBy(xpath="//div[contains(text(),'Surgeries') and @class='product-tab__title']")
	public WebElement surgeries;
	
	@FindBy(xpath="//span[text()='For Corporates'][@class='nav-interact']")
	public WebElement for_corporates;
	
	@FindBy(xpath="//a[text()='Health & Wellness Plans']")
	public WebElement health_and_Wellness_Plan;
	
	public void enterCity()
	{
		city_searrch.clear();
		city_searrch.sendKeys("Bangalo");
		
		
	}
	public void bangaloreClick()
	{
		city.click();
	}
	public void enterDoctor()
	{
		doctor_searrch.clear();
		doctor_searrch.sendKeys("Cardiolo");
		
	}
	public void doctorClick()
	{
		doctor.click();
	}
	public void surgerie()
	{
		surgeries.click();
	}
	public void for_corporate()
	{
		for_corporates.click();
	}
	public void healthAndWellnessPlan()
	{
		health_and_Wellness_Plan.click();
	}
}
