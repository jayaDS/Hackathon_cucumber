package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

 

@RunWith(Cucumber.class)
@CucumberOptions(features= {".//FeatureFiles/hackathon.feature"},
//		features= {"@target/reurn.txt"},
		glue="stepDefinations",plugin= {"pretty","html:reports/myreport.html", "rerun:target/reurn.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
dryRun=false, monochrome=true,
publish=true
//tags="@sanity"
//tags="@sanity" and @regression"
//tags="@sanity" and not @regression"
//tags="@sanity" or @regression"

		
		)

public class testrun extends AbstractTestNGCucumberTests  {
	
	
	
	

}
