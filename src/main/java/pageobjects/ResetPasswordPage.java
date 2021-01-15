package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;

public class ResetPasswordPage extends BasePage{
    private static final By input_emailId = By.id("emailInput");
    private static final By btn_reset = By.id("emailPasswordResetLinkBtn");
    private static By lbl_success_message=By.xpath("//p[contains(text(),'message')]");

    public void enterEmail(String email) {
        driver.findElement(input_emailId).click();
        waitForElement(input_emailId);
        driver.findElement(input_emailId).sendKeys(email);
    }

    public void clickOnReset()
    {
        driver.findElement(btn_reset).click();
    }

    public void verifySuccessMessageOnReset(String message)
    {
        lbl_success_message=By.xpath("//p[contains(text(),'message')]".replace("message",message));
        waitForElement(lbl_success_message);
        Assert.assertEquals(message, driver.findElement(lbl_success_message).getAttribute("innerText"));
    }
}
