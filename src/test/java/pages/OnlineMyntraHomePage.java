package pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import utilities.ThreadLocalDriver;

public class OnlineMyntraHomePage extends BasePage {
  public OnlineMyntraHomePage(RemoteWebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  /**
   * Mobile Elements
   */
  @FindBy(xpath = "//*[text()='Women']")
  WebElement womenCategoryButton;

  public WebElement getWomenCategoryButton() {
    return womenCategoryButton;
  }

  @FindBy(xpath = "//*[text()='Kids']")
  WebElement kidsCategoryButton;

  public WebElement getKidsCategoryButton() {
    return kidsCategoryButton;
  }

  /**
   * Actions
   */
  public void clickStudio() {
    getKidsCategoryButton().click();
    test.get().log(Status.INFO, "Clicked Studio", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64Online()).build());
  }

  public void clickCategories() {
    getWomenCategoryButton().click();
    test.get().log(Status.INFO, "Clicked Home", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64Online()).build());
  }

  public void userOnHomePage() {
    if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("Cloud").equalsIgnoreCase("true")) {
      ThreadLocalDriver.getTLDriverOnline().get("https://www.myntra.com/");
      test.get().log(Status.INFO, "Home Page", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64Online()).build());
    } else {
      ThreadLocalDriver.getTLDriverOnlineLocal().get("https://www.myntra.com/");
      test.get().log(Status.INFO, "Home Page", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64OnlineLocal()).build());
    }
  }
}
