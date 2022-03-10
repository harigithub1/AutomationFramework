package cucumber.stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.*;

public class BaseSteps {
    protected WikiHomePage bsAppScreen;
    protected MyntraHomePage myntraHomePage;

    public void setupScreens(AppiumDriver<MobileElement> driver) {
        myntraHomePage = new MyntraHomePage(driver);
        bsAppScreen = new WikiHomePage(driver);
    }
}