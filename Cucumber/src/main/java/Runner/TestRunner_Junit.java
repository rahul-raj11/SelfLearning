//package Runner;
//
//import org.junit.runner.RunWith;
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//		features = "D:\\Selenium\\eclipse-workspace\\Cucumber\\src\\main\\java\\Features" // path of feature files
//		,glue= {"stepDefinations"} // path of step defination file
//		,format= {"pretty","html:test-outout", "json:json_output"}
//		,monochrome = true // generate meaningful/ clean output
//		,strict = true // it will check if any step defination in not defined in step defination file 		
//		,dryRun = false // to check if mapping is proper between feature file and step defination file
//		//,tags = {"~@SmokeTest"}
//		)
//
//public class TestRunner_Junit {
//
//	// ~ is used to ignore specific tagged tests
//	//OR : tags = {"@SmokeTest, @Regression"} --- execute all tests tagged as @SmokeTest OR @Regression
//	//AND : tags = {"@SmokeTest", "@Regression"} --- execute all tests tagged as @SmokeTest AND @Regression
//	
//	// @Before and @After from cucumber for running pre and post steps(Global hooks)
//}
