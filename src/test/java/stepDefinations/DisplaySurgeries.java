package stepDefinations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import basepackage.basic;
import io.cucumber.java.en.*;
import pageobject.Homepage;
import pageobject.Surgeries;

public class DisplaySurgeries {
	WebDriver driver;
	Homepage hp;
	Surgeries s;
	@Given("User present on practo.com Website_two")
	public void user_present_on_practo_com_website() {
	    // Write code here that turns the phrase above into concrete actions
		hp=new Homepage(basic.getDriver());
		s=new Surgeries(basic.getDriver());
		basic.getlogger().info("*****User present on practo.com Website_two**********");
	}
	@When("User clicks on Surgeries")
	public void user_clicks_on_surgeries() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		basic.screenShot("Surgeries_click");
		hp.surgerie();
		basic.getlogger().info("User clicks on Surgeries");
	}

	@Then("User displays the Surgeries list")
	public void user_displays_the_surgeries_list() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		List<String> sur_list = s.displaySurgeries();
		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
	    XSSFSheet s = wb.getSheet("Sheet2");
	    int c=1;
		for(String ts:sur_list)
		{
			System.out.println(ts);
			XSSFRow r;
			if(s.getRow(c)==null)
			    r =s.createRow(c);
			else
				r =s.getRow(c);
			r.createCell(0).setCellValue(ts);
			c++;
		}
		FileOutputStream fo= new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.xlsx");
		System.out.println("done");
		  wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		basic.screenShot("Surgeries_list");
		basic.getlogger().info("User displays the Surgeries list");
	}
}
