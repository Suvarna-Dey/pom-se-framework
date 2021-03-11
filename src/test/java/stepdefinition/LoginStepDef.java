package stepdefinition;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.BasePage;
import pageobjects.ObjectManager;
import java.util.List;

public class LoginStepDef extends ObjectManager {

    @Given("^user is on gmail login page$")
    public void userIsOnGmailLoginPage() {
        BasePage.navigateToHomePage();
    }

    @When("^user enters <\"([^\"]*)\"> and <\"([^\"]*)\">$")
    public void userEntersAnd(String username, String password) throws Throwable {

    }

    @And("^user clicks on login button$")
    public void userClicksOnLoginButton() {

    }

    @Then("^user should be navigated to gmail inbox$")
    public void userShouldBeNavigatedToGmailInbox() {
    }

    @Then("^user should be presented with an <\"([^\"]*)\">$")
    public void userShouldBePresentedWithAn(String errorMessage) throws Throwable {

    }

    @After
    public void closeBrowser()
    {
        BasePage.closeLoginPage();
    }
}
