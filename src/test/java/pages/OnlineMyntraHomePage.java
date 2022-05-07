package pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.ThreadLocalDriver;

import java.io.IOException;

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
    try {
      //Thread.sleep(3000);
      test.get().log(Status.INFO, "Clicked Studio", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64Online()).build());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void clickCategories() {
    getWomenCategoryButton().click();
    try {
      test.get().log(Status.INFO, "Clicked Home", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64Online()).build());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void userOnHomePage() {
      ThreadLocalDriver.getTLDriverOnline().get("https://www.myntra.com/");
    try {
      test.get().log(Status.INFO, "Home Page", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64Online()).build());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
