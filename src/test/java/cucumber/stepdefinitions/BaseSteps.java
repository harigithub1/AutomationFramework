package cucumber.stepdefinitions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

/**
 * this class is used to initialize page classes with driver.
 */
public class BaseSteps {
  protected OnlineMyntraHomePage onlineMyntraHomePage;
//  protected LocalOnlineMyntraHomePage localOnlineMyntraHomePage;
  protected LocalOnlineMyntraHomePageNoPF localOnlineMyntraHomePageNoPF;
  protected WikiHomePageNoPF wikiHomePageNoPF;
  protected MyntraHomePage myntraHomePage;

  public void setupScreens(AppiumDriver driver) {
    wikiHomePageNoPF = new WikiHomePageNoPF(driver);
    myntraHomePage = new MyntraHomePage(driver);
  }

  public void setupScreensOnline(RemoteWebDriver driver) {
    onlineMyntraHomePage = new OnlineMyntraHomePage(driver);
  }

  public void setupScreensOnlineLocal(WebDriver driver) {
//    localOnlineMyntraHomePage = new LocalOnlineMyntraHomePage(driver);
    localOnlineMyntraHomePageNoPF = new LocalOnlineMyntraHomePageNoPF(driver);
  }
}