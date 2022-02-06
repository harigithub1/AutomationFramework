package cucumber.tests;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import utilities.DesiredCapabilitiesUtil;
import utilities.ThreadLocalDriver;

import java.io.IOException;
import java.net.URL;


@CucumberOptions(
        monochrome = true,
        tags = "@Local",
        features = "src/test/java/cucumber/features",
        glue = "cucumber.stepdefinitions",
        publish = false,
        plugin = {"listener.CucumberListener", "pretty", "html:target/cucumber-reports/CucumberReport.html", "json:target/cucumber-reports/cucumber-report.json"}
)
public class MultiThreadsTestNGRunnerThroughTestNGXML {

    private TestNGCucumberRunner testNGCucumberRunner;
    private final DesiredCapabilitiesUtil desiredCapabilitiesUtil = new DesiredCapabilitiesUtil();

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod
    @Parameters({"deviceName", "platformVersion"})
    public void setup(String deviceName, String platformVersion) throws IOException {
        DesiredCapabilities caps = desiredCapabilitiesUtil.getDesiredCapabilities(deviceName, platformVersion);
        ThreadLocalDriver.setTLDriver(new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps));
//        ThreadLocalDriver.setTLDriver(new AndroidDriver<>(new URL("http://" + "haribabumaila_Elu5RJ" + ":" + "nSqD7s61yDhRpefqbTRb" + "@" + "hub-cloud.browserstack.com" + "/wd/hub"), caps));
    }

    @Test(groups = "cucumber", description = "Run Cucumber Features.", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterMethod
    public synchronized void teardown() {
        ThreadLocalDriver.getTLDriver().quit();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}