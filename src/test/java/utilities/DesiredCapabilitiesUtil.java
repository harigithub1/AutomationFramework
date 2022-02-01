package utilities;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesUtil{
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
//        desiredCapabilities.setCapability("udid", deviceName);
      desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("appPackage", "com.myntra.android");
//        desiredCapabilities.setCapability("appActivity", "com.myntra.android.SplashActivity");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("skipUnlock", "true");
        desiredCapabilities.setCapability("noReset", "false");
      desiredCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        desiredCapabilities.setCapability("browserstack.video","false");
        desiredCapabilities.setCapability("project","Mobile Automation Project");
        desiredCapabilities.setCapability("build","Mobile Automation Build");
        desiredCapabilities.setCapability("name","Mobile Automation Name");



        return desiredCapabilities;
    }
}
