package cucumber.stepdefinitions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.HomePage;
import pages.JobPage;
import pages.SelectionPage;
import pages.SplashPage;

public class BaseSteps {
    protected SplashPage splashScreen;
    protected SelectionPage selectionScreen;
    protected HomePage homePage;
    protected JobPage jobScreen;

    public void setupScreens(AndroidDriver<MobileElement> driver) {
        splashScreen = new SplashPage(driver);
        selectionScreen = new SelectionPage(driver);
        homePage = new HomePage(driver);
        jobScreen = new JobPage(driver);
    }
}