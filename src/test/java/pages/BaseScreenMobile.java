package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseScreenMobile {
    protected AppiumDriver driver;
    protected WebDriverWait                wait;

    public BaseScreenMobile(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,  Duration.ofSeconds(15));
    }

    protected boolean isAndroid() {
        return driver.getCapabilities().getPlatformName().toString().toLowerCase().contains("android");
    }

    protected boolean isIOS() {
        return driver.getCapabilities().getPlatformName().toString().toLowerCase().contains("ios");
    }

    protected void waitAndClick(By by) { wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click(); }

    protected void click(By by) {
        driver.findElement(by).click();
    }

    protected void hideKeyboard() { driver.navigate().back(); }

    protected List<WebElement> waitAndFindElements(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected WebElement waitAndFindElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected String getText(By by) {
        return waitAndFindElement(by).getText();
    }

    protected void sendKey(By by, String text) {
        waitAndFindElement(by).sendKeys(text);
    }
}
