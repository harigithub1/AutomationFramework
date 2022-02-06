package pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;

public class JobPage extends BasePage {
    public JobPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    /**Mobile Elements*/
    By ExploreTitleBy   = By.xpath("//*[@text='Explore']");

    /**Actions*/
    public void assertExploreTitleIsExpected() {
        String toolBarTitleStr = wait.until(ExpectedConditions.visibilityOfElementLocated(ExploreTitleBy)).getText();
        try {
          //  Thread.sleep(3000);
            test.get().log(Status.INFO, "Verify Explore button", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(toolBarTitleStr.contains("Explore"));
    }
}
