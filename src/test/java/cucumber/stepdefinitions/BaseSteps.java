package cucumber.stepdefinitions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.CandidateMainScreen;
import pages.JobScreen;
import pages.SelectionScreen;
import pages.SplashScreen;

public class BaseSteps {
    protected SplashScreen        splashScreen;
    protected SelectionScreen     selectionScreen;
    protected CandidateMainScreen candidateMainScreen;
    protected JobScreen           jobScreen;

    public void setupScreens(AndroidDriver<MobileElement> driver) {
        splashScreen = new SplashScreen(driver);
        selectionScreen = new SelectionScreen(driver);
        candidateMainScreen = new CandidateMainScreen(driver);
        jobScreen = new JobScreen(driver);
    }
}