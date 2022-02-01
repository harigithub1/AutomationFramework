package pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;

public class WikiHomePage extends BasePage {
    public WikiHomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    /**Mobile Elements*/
    By searchElementBy = By.xpath("//*[@text='Search Wikipedia']");
    By insertTextElementBy           = By.id("org.wikipedia.alpha:id/search_src_text");
    By profileIconBy    = By.xpath("//android.widget.LinearLayout[4]/android.widget.ImageView");
    By StudioBy = By.xpath("//*[@text='Studio']");
    By ProfileBy = By.xpath("//*[@text='Profile']");
    By HomeBy = By.xpath("//*[@text='Home']");
    By ListBy = By.xpath("//android.widget.FrameLayout[@content-desc=\"My lists\"]/android.view.ViewGroup");
    By HistoryBy = By.xpath("//android.widget.FrameLayout[@content-desc=\"History\"]/android.widget.ImageView");
    By NearbyBy = By.xpath("//android.widget.FrameLayout[@content-desc=\"Nearby\"]/android.view.ViewGroup");
    By ExploreBy = By.xpath("//android.widget.FrameLayout[@content-desc=\"Explore\"]/android.view.ViewGroup");
    By InTheNewsTitleBy = By.xpath("//*[@text='In the news']");


    /**Actions*/
    public void allowNotification() {
    }

    @SneakyThrows
    public void clickToJob(int index) {
        Thread.sleep(4000);
    }
    public void clicksearchElement() {
        waitAndClick(searchElementBy);
        try {
            //Thread.sleep(3000);
            extentTest.log(Status.INFO, "Clicked searchElement", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickinsertTextElementBy() {
        waitAndClick(insertTextElementBy);
        try {
            extentTest.log(Status.INFO, "Clicked insertTextElement", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
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

    public void clickListElement() {
        waitAndClick(ListBy);
        try {
            extentTest.log(Status.INFO, "Clicked Home", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickHistoryElement() {
        waitAndClick(HistoryBy);
        try {
            extentTest.log(Status.INFO, "Clicked Home", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickNearbyElement() {
        waitAndClick(NearbyBy);
        try {
            extentTest.log(Status.INFO, "Clicked Home", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickExploreElement() {
        waitAndClick(ExploreBy);
        try {
            extentTest.log(Status.INFO, "Clicked Home", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void assertInTheNewsTitleIsAsExpected() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String toolBarTitleStr = wait.until(ExpectedConditions.visibilityOfElementLocated(InTheNewsTitleBy)).getText();
        try {
            //  Thread.sleep(3000);
            extentTest.log(Status.INFO, "Verify Explore button", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(toolBarTitleStr.contains("In the news"));
    }

    public void userOnWikiHomePage() {
        try {
            //  Thread.sleep(3000);
            extentTest.log(Status.INFO, "Verify Explore button", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
