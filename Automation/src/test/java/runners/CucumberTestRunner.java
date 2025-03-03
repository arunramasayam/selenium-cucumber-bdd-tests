package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/", // Path to your feature files
        glue = "stepDefinitions", // Package containing step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests{
}
