package Runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
		features = "D:\\Selenium\\eclipse-workspace\\Cucumber\\src\\main\\java\\Features" // path of feature files
		,glue= {"stepDefinations"} // path of step defination file
		,format= {
				"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt",
				}
		,plugin = "json:target/cucumber-reports/CumberTestReports.json"
		,monochrome = true // generate meaningful/ clean output
		,strict = true // it will check if any step defination in not defined in step defination file 		
		,dryRun = false // to check if mapping is proper between feature file and step defination file
		,tags = {"~@Ignore"}
		)

public class TestRunner {
	
	private TestNGCucumberRunner cucumberRunner;
	
	@BeforeClass(alwaysRun = true)
	public void setupClass() throws Exception {
		cucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "cucumber", description = "Run Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper featureWrapper) {
		cucumberRunner.runCucumber(featureWrapper.getCucumberFeature());
	}
	
	@DataProvider
	public Object[][] features() {
		return cucumberRunner.provideFeatures();
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		cucumberRunner.finish();
	}

}
