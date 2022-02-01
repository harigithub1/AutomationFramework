package cucumber.tests;

import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import listener.CucumberListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utilities.DesiredCapabilitiesUtil;
import utilities.ThreadLocalDriver;

public class BaseTest extends CucumberListener {
    private final DesiredCapabilitiesUtil desiredCapabilitiesUtil = new DesiredCapabilitiesUtil();

    @BeforeMethod
    @Parameters({ "deviceName", "platformVersion" })
    public void setup(String deviceName, String platformVersion) throws IOException {
        DesiredCapabilities caps = desiredCapabilitiesUtil.getDesiredCapabilities(deviceName, platformVersion);
//        ThreadLocalDriver.setTLDriver(new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps));
        ThreadLocalDriver.setTLDriver(new AndroidDriver<>(new URL("http://" + "haribabumaila_Elu5RJ" + ":" + "nSqD7s61yDhRpefqbTRb" + "@" + "hub-cloud.browserstack.com" + "/wd/hub"), caps));

    }

    @AfterMethod
    public synchronized void teardown() {
        ThreadLocalDriver.getTLDriver().quit();
    }
}
