package utilities;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

public class DesiredCapabilitiesUtil {
    public DesiredCapabilities getDesiredCapabilities(String deviceName, String platformVersion) {
        /*
        for local
        1. udid,
        2. myntra app package and
        3. myntra app activity
        */

        /*
        for BrowserStack
        1. deviceName,
        2. wikipedia appPackage and
        3. wikipedia app activity,
        4. app
        */
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("Cloud").equalsIgnoreCase("true")) {
            desiredCapabilities.setCapability("deviceName", deviceName);
        } else {
            desiredCapabilities.setCapability("udid", deviceName);
        }
        desiredCapabilities.setCapability("platformVersion", platformVersion);
//        desiredCapabilities.setCapability("platformName", "Android");
        if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("Cloud").equalsIgnoreCase("true")) {
            desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
            desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        } else {
            desiredCapabilities.setCapability("appPackage", "com.myntra.android");
            desiredCapabilities.setCapability("appActivity", "com.myntra.android.SplashActivity");
        }
        desiredCapabilities.setCapability("skipUnlock", "true");
        desiredCapabilities.setCapability("noReset", "false");
        if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("Cloud").equalsIgnoreCase("true")) {
            if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platform").equalsIgnoreCase("android"))
                desiredCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
            else
                desiredCapabilities.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");
            desiredCapabilities.setCapability("browserstack.video", "true");
            desiredCapabilities.setCapability("project", "Mobile Automation Project");
            desiredCapabilities.setCapability("build", "Mobile Automation Build");
            desiredCapabilities.setCapability("name", "Mobile Automation Name");
        } else {

        }
        return desiredCapabilities;
    }

    public DesiredCapabilities getDesiredCapabilitiesOnline(String platform, String platformVersion, String browser) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("os", platform);
        desiredCapabilities.setCapability("os_version",platformVersion);
        desiredCapabilities.setCapability("browser",browser);
        if (platform.toLowerCase().contains("windows")){
            desiredCapabilities.setCapability("resolution","1366x768");
        }
        if (platform.toLowerCase().contains("os x")){
            desiredCapabilities.setCapability("resolution","1280x960");
        }
        if (browser.equalsIgnoreCase("safari")){
            desiredCapabilities.setCapability("browser_version","15.1");
        } else {
            desiredCapabilities.setCapability("browser_version","latest");
        }
        desiredCapabilities.setCapability("browserstack.video","true");
        desiredCapabilities.setCapability("project","ProjectName");
        desiredCapabilities.setCapability("build","BuildName");
        desiredCapabilities.setCapability("name","TestName");
        return desiredCapabilities;
    }
}
