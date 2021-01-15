package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private static final By input_emailId = By.cssSelector("input[id='login-field']");
    private  static final By input_password= By.id("password-field");
    private  static final By btn_login = By.id("loginButton");
    private static final By link_forgot_pwd=By.xpath("//a[contains(text(),' Forgot your password? ')]");
    private static final By lbl_error_empty_email = By.xpath("//div[@class='mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg']");
    private static final By lbl_error_empty_password = By.xpath("//div[@class='mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg']");

//    enter text in desired field of Logon Page
    public void enterText(String fieldName, String value){
        if(fieldName.equalsIgnoreCase("email")) {
            driver.findElement(input_emailId).click();
            waitForElement(input_emailId);
            if(null != value) {
                driver.findElement(input_emailId).sendKeys(value);
            }
        }
        else if(fieldName.equalsIgnoreCase("password")) {
            driver.findElement(input_password).click();
            if(!value.isEmpty()) {
                waitForElement(input_password);
                driver.findElement(input_password).sendKeys(value);
            }
        }
    }

//    Click desired element on Login Page
    public void clickOnElement(String field)
    {
        if(field.equalsIgnoreCase("email"))
            driver.findElement(input_emailId).click();
        else if(field.equalsIgnoreCase("password"))
            driver.findElement(input_password).click();
        else if(field.equalsIgnoreCase("forgot your password"))
            driver.findElement(link_forgot_pwd).click();
        else if(field.equalsIgnoreCase("login"))
            driver.findElement(btn_login).click();
    }
//Verify error label on Login Page
    public void verifyError(String errorField, String errorMessage)
    {
        if(errorField.equalsIgnoreCase("email")) {
            waitForElement(lbl_error_empty_email);
            Assert.assertEquals(errorMessage, driver.findElement(lbl_error_empty_email).getAttribute("innerText"));
        }
        else if(errorField.equalsIgnoreCase("password")) {
            waitForElement(lbl_error_empty_password);
            Assert.assertEquals(" Password required", driver.findElements(lbl_error_empty_password).get(1).getAttribute("innerText"));
        }
    }

    public void validateLoginButtonIsDisabled()
    {
        Assert.assertEquals("true", driver.findElement(btn_login).getAttribute("disabled"));
    }

}
