package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//		dryRun = true,
		monochrome = true,
//		strict = true,
		plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" },
		features = "src/main/java/Features/login.feature", // It tells where your feature files are, full path is also acceptable here
		glue = {"stepDefinitions"} // It tells where your step Definition files are, full path is also acceptable here
		)

public class TestRunner {

}

//Tags:
//	ORed : tags = {"@SmokeTest, @RegressionTest"}
//	Anded : tags = {"@SmokeTest", "@RegressionTest"}
//  Ignore scenarios with tag @SmokeTest : tags = {"~@SmokeTest, @RegressionTest"}