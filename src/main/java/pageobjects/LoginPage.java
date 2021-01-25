package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class LoginPage extends BasePage {

    private static final By input_emailId = By.cssSelector("input[id='login-field']");
    private static final By input_password = By.id("password-field");
    private static final By btn_login = By.id("loginButton");
    private static final By link_forgot_pwd = By.xpath("//a[contains(text(),' Forgot your password? ')]");
    private static final By lbl_error_empty_email = By.xpath("//div[@class='mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg']");
    private static final By lbl_error_empty_password = By.xpath("//div[@class='mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg']");


    //Verify error label on Login Page
    public void verifyError(String errorField, String errorMessage) {
        if (errorField.equalsIgnoreCase("email")) {
            waitForElement(lbl_error_empty_email);
            Assert.assertEquals(errorMessage, driver.findElement(lbl_error_empty_email).getAttribute("innerText"));
        } else if (errorField.equalsIgnoreCase("password")) {
            waitForElement(lbl_error_empty_password);
            Assert.assertEquals(" Password required", driver.findElements(lbl_error_empty_password).get(1).getAttribute("innerText"));
        }
    }

    public void validateLoginButtonIsDisabled() {
        Assert.assertEquals("true", driver.findElement(btn_login).getAttribute("disabled"));
    }

    public void enterEmail(String email)
    {
        if(email !=null) {
            clickElement(input_emailId);
            enterText(input_emailId, email);
        }
    }

    public void enterPassword(String password)
    {
        clickElement(input_password);
        if(password !=null) {
            String js = "arguments[0].setAttribute('value','"+password+"')";
            ((JavascriptExecutor) driver).executeScript(js, driver.findElement(input_password));
        }
    }

    public void clickLogin()
    {
        clickElement(btn_login);
    }

    public void clickForgotPassword()
    {
        clickElement(link_forgot_pwd);
    }

    public void clickEmail()
    {
        clickElement(input_emailId);
    }
    public void clickPassword()
    {
        clickElement(input_password);
    }

}
