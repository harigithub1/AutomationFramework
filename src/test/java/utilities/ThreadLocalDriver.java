package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ThreadLocalDriver {

  private static final ThreadLocal<AppiumDriver<MobileElement>> tlDriver = new ThreadLocal<>();
  private static final ThreadLocal<RemoteWebDriver> tlDriverOnline = new ThreadLocal<>();
  private static final ThreadLocal<WebDriver> tlDriverOnlineLocal = new ThreadLocal<>();

  public static synchronized void setTLDriver(AppiumDriver<MobileElement> driver) {
    tlDriver.set(driver);
  }

  public static synchronized AppiumDriver<MobileElement> getTLDriver() {
    return tlDriver.get();
  }

  public static synchronized void setTLDriverOnline(RemoteWebDriver driver) {
    tlDriverOnline.set(driver);
  }

  public static synchronized RemoteWebDriver getTLDriverOnline() {
    return tlDriverOnline.get();
  }
  public static synchronized void setTLDriverOnlineLocal(WebDriver driver) {
    tlDriverOnlineLocal.set(driver);
  }

  public static synchronized WebDriver getTLDriverOnlineLocal() {
    return tlDriverOnlineLocal.get();
  }
}
