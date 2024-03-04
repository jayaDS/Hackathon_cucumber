package pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Doctors {
	WebDriver driver;
	public Doctors(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@data-qa-id='doctor_review_count_section']")
	public WebElement patient_stories;
	@FindBy(xpath="//span[text()='10+ Patient Stories']")
	public WebElement patient_stories_option;
	
	@FindBy(xpath="//div[@data-qa-id='years_of_experience_section']")
	public WebElement experience;
	@FindBy(xpath="//span[text()='5+ Years of experience']")
	public WebElement experience_option;
	
	@FindBy(xpath="//span[@data-qa-id='all_filters']")
	public WebElement all_filters;
	@FindBy(xpath="//span[text()='Above ₹500']")
	public WebElement fees;
	@FindBy(xpath="//span[text()='Available Tomorrow']")
	public WebElement availability;
	
	@FindBy(xpath="//span[@data-qa-id='sort_by_selected']")
	public WebElement sort_by;
	@FindBy(xpath="//li[@aria-label='Number of patient stories - High to low']")
	public WebElement relevance;
	
	@FindBy(xpath="//h2[@data-qa-id='doctor_name']")
	public List<WebElement> doc_name;
	
	@FindBy(xpath="//div[@data-qa-id='doctor_experience']")
	public List<WebElement> doc_exp;
	
	@FindBy(xpath="//span[@data-qa-id='doctor_clinic_name']")
	public List<WebElement> doc_clinic;
	
	@FindBy(xpath="//span[@data-qa-id='consultation_fee']")
	public List<WebElement> consultation_fee;
	
	@FindBy(xpath="//span[@data-qa-id='availability_text']")
	public List<WebElement> availability_text;

	
	
	public void applyFilters()
	{
		patient_stories.click();
		patient_stories_option.click();
		experience.click();
		experience_option.click();
		all_filters.click();
		fees.click();
		sort_by.click();
		relevance.click();
		all_filters.click();
		availability.click();	
	}
	public List<List<String>> displayDoctors()
	{
		List<List<String>> doctors_data = new ArrayList<>();
		for(int i=0;i<5;i++)
		{
			List<String> ts = new ArrayList<>();
			ts.add(doc_name.get(i).getText());
			ts.add(doc_exp.get(i).getText());
			ts.add(doc_clinic.get(i).getText());
			ts.add(consultation_fee.get(i).getText());
			ts.add(availability_text.get(i).getText());
			//System.out.println(doc_name.get(i).getText());
			//System.out.println(ts);
			doctors_data.add(ts);
			System.out.println(ts);
			System.out.println(doctors_data);
		}
		System.out.println(doctors_data);
		return doctors_data;
	}
}
