package pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.io.IOException;

public class SelectionPage extends BasePage {
    public SelectionPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    /**Mobile Elements*/
    By CategoriesBy = By.xpath("//*[@text='Categories']");

    /**Actions*/
    public void clickCategories() {
        waitAndClick(CategoriesBy);
        try {
//            Thread.sleep(3000);
            extentTest.log(Status.INFO, "Clicked Categories", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
