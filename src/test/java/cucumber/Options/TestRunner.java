package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
                 glue = { "Step_Defination" }, 
                 plugin = { "pretty","html:target/HTLMReports/cucumber-reports.html" ,
				"json:target/jsonReports/cucumber.json",
				"junit:target/junitReports/cucumber.xml" },
                 monochrome = true
                //tags = "@addPlace"
                 )
public class TestRunner {

}
