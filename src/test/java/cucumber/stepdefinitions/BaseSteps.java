package cucumber.stepdefinitions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.*;

public class BaseSteps {
    protected SplashPage splashScreen;
    protected SelectionPage selectionScreen;
    protected WikiHomePage bsAppScreen;
    protected MyntraHomePage myntraHomePage;
    protected JobPage jobScreen;

    public void setupScreens(AndroidDriver<MobileElement> driver) {
        splashScreen = new SplashPage(driver);
        selectionScreen = new SelectionPage(driver);
        myntraHomePage = new MyntraHomePage(driver);
        jobScreen = new JobPage(driver);
        bsAppScreen = new WikiHomePage(driver);

    }
}