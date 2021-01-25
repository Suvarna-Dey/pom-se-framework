package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;

public class ResetPasswordPage extends BasePage{
    private static final By input_emailId = By.id("emailInput");
    private static final By btn_reset = By.id("emailPasswordResetLinkBtn");
    private static By lbl_success_message=By.xpath("//p[contains(text(),'message')]");

    public void clickEmail()
    {
        clickElement(input_emailId);
    }

    public void enterEmail(String email)
    {
        clickEmail();
        enterText(input_emailId,email);
    }

    public void clickOnReset()
    {
        clickElement(btn_reset);
    }

    public void verifySuccessMessageOnReset(String message)
    {
        lbl_success_message=By.xpath("//p[contains(text(),'message')]".replace("message",message));
        waitForElement(lbl_success_message);
        Assert.assertEquals(message, driver.findElement(lbl_success_message).getAttribute("innerText"));
    }


}
