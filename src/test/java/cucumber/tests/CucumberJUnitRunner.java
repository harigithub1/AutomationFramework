package cucumber.tests;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.DesiredCapabilitiesUtil;
import utilities.ThreadLocalDriver;

import java.io.IOException;
import java.net.URL;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        tags = "@Local1",
        features = "src/test/java/cucumber/features",
        glue = "cucumber.stepdefinitions",
        publish = false,
        plugin = {"listener.CucumberListener", "pretty",
                "junit:target/junit-reports/junit.xml", "html:target/cucumber-reports/CucumberReport.html", "json:target/cucumber-reports/cucumber-report.json"})

public class CucumberJUnitRunner {
    private final DesiredCapabilitiesUtil desiredCapabilitiesUtil = new DesiredCapabilitiesUtil();
    public static String         deviceName;
    public static String         platformVersion;

    @BeforeClass
    public static void setup() throws IOException {
         deviceName = "RZ8NA0RM5GK";
          platformVersion = "12.0";
//        DesiredCapabilities caps = desiredCapabilitiesUtil.getDesiredCapabilities(deviceName, platformVersion);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("udid", deviceName);
//      desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.myntra.android");
        desiredCapabilities.setCapability("appActivity", "com.myntra.android.SplashActivity");
//        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
//        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("skipUnlock", "true");
        desiredCapabilities.setCapability("noReset", "false");
//      desiredCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
//        desiredCapabilities.setCapability("browserstack.video","false");
//        desiredCapabilities.setCapability("project","Mobile Automation Project");
//        desiredCapabilities.setCapability("build","Mobile Automation Build");
//        desiredCapabilities.setCapability("name","Mobile Automation Name");




        ThreadLocalDriver.setTLDriver(new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities));
//        ThreadLocalDriver.setTLDriver(new AndroidDriver<>(new URL("http://" + "haribabumaila_Elu5RJ" + ":" + "nSqD7s61yDhRpefqbTRb" + "@" + "hub-cloud.browserstack.com" + "/wd/hub"), caps));
    }


    @AfterClass
    public static  void teardown() {
        ThreadLocalDriver.getTLDriver().quit();
    }


}