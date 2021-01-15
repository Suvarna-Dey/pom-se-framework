package pageobjects;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;
import utilities.PropertyReader;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;

    public static void navigateToHomePage() {
        driver= new DriverManager().initialiseDriver();
        String url=new PropertyReader().readProperty("URL");
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public static void waitForElement(By element)
    {
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    //    closing browser after test execution
    @AfterClass
    public static void closeLoginPage() {
        driver.close();
    }
}
