package pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class MyntraHomePage extends BasePage {
    public MyntraHomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    /**Mobile Elements*/
    By allowWhenUsingBy = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    By jobsBy           = By.id("com.isinolsun.app:id/rootRelativeView");
    By profileIconBy    = By.xpath("//android.widget.LinearLayout[4]/android.widget.ImageView");
    By StudioBy = By.xpath("//*[@text='Studio']");
    By ProfileBy = By.xpath("//*[@text='Profile']");
    By HomeBy = By.xpath("//*[@text='Home']");
    By ExploreBy = By.xpath("//*[@text='Explore']");
    By CategoriesBy = By.xpath("//*[@text='Categories']");

    /**Actions*/
    public void allowNotification() {
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(allowWhenUsingBy)).isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(allowWhenUsingBy)).click();
        }
    }

    @SneakyThrows
    public void clickToJob(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jobsBy)).get(index).click();
        Thread.sleep(4000);
    }
    public void clickStudio() {
        waitAndClick(StudioBy);
        try {
            //Thread.sleep(3000);
            extentTest.log(Status.INFO, "Clicked Studio", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickProfile() {
        waitAndClick(ProfileBy);
        try {
            extentTest.log(Status.INFO, "Clicked Profile", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickHome() {
        waitAndClick(HomeBy);
        try {
            extentTest.log(Status.INFO, "Clicked Home", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickExplore() {
        waitAndClick(ExploreBy);
        try {
            extentTest.log(Status.INFO, "Clicked Home", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickCategories() {
        waitAndClick(CategoriesBy);
        try {
            extentTest.log(Status.INFO, "Clicked Home", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userOnHomePage() {
        try {
            extentTest.log(Status.INFO, "Home Page", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
