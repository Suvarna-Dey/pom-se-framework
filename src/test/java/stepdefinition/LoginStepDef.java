package stepdefinition;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.BasePage;
import pageobjects.ObjectManager;
import java.util.List;

public class LoginStepDef extends ObjectManager {

    @Given("^user is at DOJO application login page$")
    public void user_is_at_DOJO_application_login_page() {
        BasePage.navigateToHomePage();
    }

    @Then("^login button should be disabled$")
    public void login_button_should_be_disabled() {
        loginPage.validateLoginButtonIsDisabled();
    }

    @When("^user enters \"([^\"]*)\" in \"([^\"]*)\" field$")
    public void user_enters_in_field(String value, String fieldName) {
        loginPage.enterText(fieldName, value);
    }

    @And("^user clicks on \"([^\"]*)\"$")
    public void userClicksOn(String fieldName){
        loginPage.clickOnElement(fieldName);
    }

    @Then("^user should be presented with \"([^\"]*)\" for \"([^\"]*)\"$")
    public void userShouldBePresentedWithFor(String errorMessage, String errorField){
        loginPage.verifyError(errorField, errorMessage);
    }

    @Then("^user should be able to enter email in reset password screen$")
    public void userShouldBeAbleToEnterEmailInResetPasswordScreen(DataTable table) {
        List<List<String>> data = table.raw();
        resetPasswordPage.enterEmail(data.get(1).get(0));
    }

    @Then("^user should be presented with success message as below$")
    public void userShouldBePresentedWithSuccessMessageAsBelow(DataTable table) {
        List<List<String>> data = table.raw();
        resetPasswordPage.verifySuccessMessageOnReset(data.get(1).get(0));
    }

    @When("^user clicks on email me reset button on reset password screen$")
    public void userClicksOnEmailMeResetButtonOnResetPasswordScreen() {
        resetPasswordPage.clickOnReset();
    }

    @After
    public void closeBrowser()
    {
        BasePage.closeLoginPage();
    }

}
