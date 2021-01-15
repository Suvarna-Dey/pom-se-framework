package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    static WebDriver driver;
    static String browser = null;

    public WebDriver initialiseDriver() {

        if (System.getProperty("browser") != null)
            browser = System.getProperty("browser");
        else
            browser = new PropertyReader().readProperty("BROWSER");

        switch (browser) {
            case "firefox":
                return getFireFoxDriver();
            case "chrome":
            default:
                return getChromeDriver();
        }
    }

    private WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");
        driver=new ChromeDriver();
        return driver;
    }

    private WebDriver getFireFoxDriver() {
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
        driver=new FirefoxDriver();
        return driver;
    }

}
