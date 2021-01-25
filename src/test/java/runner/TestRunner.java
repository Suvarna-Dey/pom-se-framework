package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features" },
        glue = {"stepdefinition" },
        plugin = {"pretty", "html:target/reports",
                "junit:target/reports/sample-framework.xml",
                "json:target/reports/sample-framework.json"},
        monochrome = true)
public class TestRunner {


}
