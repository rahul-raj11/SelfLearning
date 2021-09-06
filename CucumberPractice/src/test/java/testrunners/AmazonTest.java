package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.core.backend.Glue;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/AppFeatures"},
		glue = {"stepdefinations"},
		monochrome = true,
		plugin = {"pretty"}
		)

public class AmazonTest {
	
	

}
