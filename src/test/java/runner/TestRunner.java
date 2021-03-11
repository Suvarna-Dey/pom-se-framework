package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features" },
        glue = {"stepdefinition" },
        plugin = {"pretty", "html:target/cucumber-report/login.Test",
                "junit:target/cucumber-report/login.cucumber.json"})
public class TestRunner {


}
