package stepDefinations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basepackage.basic;
import io.cucumber.java.en.*;
import pageobject.Doctors;
import pageobject.Homepage;

public class DisplayDoctors {
	WebDriver driver;
	Homepage hp;
	Doctors d;
	@Given("User present on practo.com Website_one")
	public void user_present_on_practo_com_website_one() {
	    // Write code here that turns the phrase above into concrete actions
		basic.getlogger().info("*****User present on practo.com Website_one**********");
		hp=new Homepage(basic.getDriver());
		d=new Doctors(basic.getDriver());
	}
	@When("User enters city Bangalore in seachbox") 
	public void user_enters_city_bangalore_in_seachbox() {
	    // Write code here that turns the phrase above into concrete actions
		hp.enterCity();
		basic.getlogger().info("User enters city Bangalore in seachbox");
	}

	@When("User clicks on Bangalore option")
	public void user_clicks_on_bangalore_option() {
	    // Write code here that turns the phrase above into concrete actions
		hp.bangaloreClick();
		basic.getlogger().info("User clicks on Bangalore option");
	}

	@When("User enters Medical specialist Cardiologist in seachbox")
	public void user_enters_medical_specialist_cardiologist_in_seachbox() {
	    // Write code here that turns the phrase above into concrete actions
		hp.enterDoctor();
		basic.getlogger().info("User enters Medical specialist Cardiologist in seachbox");
	}

	@When("User clicks on Cardiologist option")
	public void user_clicks_on_cardiologist_option() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		basic.screenShot("loc&doctor_selection");
		hp.doctorClick();
		basic.getlogger().info("User clicks on Cardiologist option");
	}

	@When("User applies filters")
	public void user_applies_filters() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		d.applyFilters();
		basic.screenShot("applies_filters");
		basic.getlogger().info("User applies filters");
	}

	@Then("User displays the first five Doctors")
	public void user_displays_the_first_five_doctors() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		List<List<String>> doc_5 = d.displayDoctors();
		System.out.println("done"+doc_5.size()+doc_5);
		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
	    XSSFSheet s = wb.getSheet("Sheet1");
		int c=2;
		for(int i=0;i<5;i++)
		{
			XSSFRow r =s.createRow(c);
					r.createCell(0).setCellValue(doc_5.get(i).get(0));
					r.createCell(1).setCellValue(doc_5.get(i).get(1));
					r.createCell(2).setCellValue(doc_5.get(i).get(2));
					r.createCell(3).setCellValue(doc_5.get(i).get(3));
					r.createCell(4).setCellValue(doc_5.get(i).get(4));
			c++;
		}
		FileOutputStream fo= new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.xlsx");
		System.out.println("done");
		  wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		basic.screenShot("Doctors");
		basic.getlogger().info("User displays the first five Doctors");
	}

}
