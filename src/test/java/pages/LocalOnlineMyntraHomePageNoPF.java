package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ThreadLocalDriver;

public class LocalOnlineMyntraHomePageNoPF extends BaseScreenWeb {
  public LocalOnlineMyntraHomePageNoPF(WebDriver driver) {super(driver);}

  /**Mobile Elements*/
  By womenCategoryButton = By.xpath("//*[text()='Women']");
  By kidsCategoryButton = By.xpath("//*[text()='Kids']");

  /**
   * Actions
   */
  public void clickStudio() {
    waitAndClick(kidsCategoryButton);
//    test.get().log(Status.INFO, "Clicked Studio", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64Online()).build());
  }

  public void clickCategories() {
    waitAndClick(womenCategoryButton);
//    test.get().log(Status.INFO, "Clicked Home", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64OnlineLocal()).build());
  }

  public void userOnHomePage() {
      ThreadLocalDriver.getWebDriverThreadLocal().get("https://www.myntra.com/");
//      test.get().log(Status.INFO, "Home Page", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64OnlineLocal()).build());
  }
}