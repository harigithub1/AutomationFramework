package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WikiHomePageNoPF extends BaseScreenMobile {
  public WikiHomePageNoPF(AppiumDriver<MobileElement> driver) {
    super(driver);
  }

  // XPath locators for android and ios
  private final By ListByAndroid = By.xpath("//*[@resource-id='com.example:id/username' or @content-desc='username']");
  private final By ListByIOS = By.xpath("//*[@name='username' or @label='username']");

  private final By HistoryOrOkAndroid = By.xpath("//*[@resource-id='com.example:id/password' or @content-desc='password']");
  private final By HistoryOrOkIOS = By.xpath("//*[@name='password' or @label='password']");

  private By ListBy() {
    return isAndroid() ? ListByAndroid : ListByIOS;
  }

  private By HistoryOrOk() {
    return isAndroid() ? HistoryOrOkAndroid : HistoryOrOkIOS;
  }

  /**
   * Actions
   */
  @SneakyThrows
  public void clickListElement() {
    waitAndClick(ListBy());
//    test.get().log(Status.INFO, "Clicked List/Alert", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
  }

  @SneakyThrows
  public void clickHistoryElement() {
    waitAndClick(HistoryOrOk());
//    test.get().log(Status.INFO, "Clicked History/OK", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
  }
}