package pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;

public class JobScreen extends BaseScreen{
    public JobScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    /**Mobile Elements*/
    By toolBarTitleBy   = By.xpath("//*[@text='Explore']");

    /**Actions*/
    public void assertToolBarTitleIsExpected() {
        String toolBarTitleStr = wait.until(ExpectedConditions.visibilityOfElementLocated(toolBarTitleBy)).getText();
        try {
            Thread.sleep(3000);
            extentTest.log(Status.INFO, "Verify Explore button", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(toolBarTitleStr.contains("Explore"));
    }
}
