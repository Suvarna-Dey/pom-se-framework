package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features" },
        glue = {"stepdefinition" },
        plugin = {"pretty", "html:target/cucumber-report/com.dojo-login.Test",
                "junit:target/cucumber-report/com.dojo-login.cucumber.xml"})
public class TestRunner {


}
