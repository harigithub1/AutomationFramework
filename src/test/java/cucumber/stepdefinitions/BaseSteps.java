package cucumber.stepdefinitions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

/**
 * this class is used to initialize page classes with driver.
 */
public class BaseSteps {
    protected WebCloudOnlineMyntraHomePage webCloudOnlineMyntraHomePage;
    protected WebLocalOnlineMyntraHomePage webLocalOnlineMyntraHomePage;
    protected MobileWikiHomePage mobileWikiHomePage;

    public void setupScreensMobile(AppiumDriver driver) {
        mobileWikiHomePage = new MobileWikiHomePage(driver);
    }

    public void setupScreensWebCloud(RemoteWebDriver driver) {
        webCloudOnlineMyntraHomePage = new WebCloudOnlineMyntraHomePage(driver);
    }

    public void setupScreensWebLocal(WebDriver driver) {
        webLocalOnlineMyntraHomePage = new WebLocalOnlineMyntraHomePage(driver);
    }
}