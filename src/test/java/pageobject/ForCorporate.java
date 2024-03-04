package pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForCorporate {
	WebDriver driver;
	WebDriverWait wait;
	static List<String> data;
	public ForCorporate(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='name']")
	public WebElement name;
	
	@FindBy(xpath="//*[@id='organizationName']")
	public WebElement organizationName;
	
	@FindBy(xpath="//*[@id='contactNumber']")
	public WebElement contactNumber;
	
	@FindBy(xpath="//*[@id='officialEmailId']")
	public WebElement email;
	
	@FindBy(xpath="//*[@id='organizationSize']")
	public WebElement organizationSize;
	
	@FindBy(xpath="//*[@id='interestedIn']")
	public WebElement interestedIn;
	
	@FindBy(xpath="//*[text()='Schedule a demo'][@type='submit']")
	public WebElement button;
	public void getData() throws IOException
	{
		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet s = wb.getSheet("Sheet3");
		int r=1;
		data = new ArrayList<>();
		while(true) {
			if(s.getRow(r)==null)
				break;
			data.add(s.getRow(r).getCell(0).toString());
			r++;
		}
		wb.close();
		fi.close();
		System.out.println(data.get(0));
	}
	
	public void entersAllNon_emailFieldsInTheForm() throws IOException
	{
		getData();
		System.out.println(data.get(0));
		name.sendKeys(data.get(0));
		organizationName.sendKeys(data.get(1));
		contactNumber.sendKeys("9122785643");
		Select s =new Select(organizationSize);
		s.selectByIndex(1);
		Select s1 =new Select(interestedIn);
		s1.selectByIndex(1);
	}
	public void entersInvalidEmail()
	{
		email.sendKeys(data.get(3));
	}
	public boolean validateScheduleADemoButton()
	{
		if(button.isEnabled())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void entersValidEmail()
	{
		email.clear();
		email.sendKeys(data.get(4));
	}
	public void clickScheduleADemoButton()
	{
		button.click();
	}
	public boolean msg()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement thank_you = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='THANK YOU']")));
		if(thank_you.isDisplayed()) {
     		return true;
     	}
     	else {
     		return false;
     	}
	}
}
