package cucumber.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import utilities.ThreadLocalDriver;

/**
 * this class contains java implementation for steps in feature files
 */
public class MyntraHomePageStepDefinitions extends BaseSteps {

    @Before
    public void setupLoginSteps() {
        if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Mobile")) {
            //mobile code - for both cloud/local
            setupScreensMobile(ThreadLocalDriver.getAppiumDriverThreadLocal());
        } else if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Online")) {
            //web code - for cloud
            setupScreensWebCloud(ThreadLocalDriver.getRemoteWebDriverThreadLocal());
        } else {
            //web code - for local
            setupScreensWebLocal(ThreadLocalDriver.getWebDriverThreadLocal());
        }
    }

    @Given("User is on home page")
    public void userisonhomepageandtapsCategories() {
        if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Mobile")) {
            //mobile code - for both cloud/local
        } else if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Online")) {
            //web code - for cloud
            webCloudOnlineMyntraHomePage.userOnHomePage();
        } else {
            //web code - for local
            webLocalOnlineMyntraHomePage.userOnHomePage();
        }
    }

    @When("User clicks Studio {int} Two")
    public void userclicksStudio(int index) {
        if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Mobile")) {
        } else if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Online")) {
            webCloudOnlineMyntraHomePage.clickStudio();
        } else {
            webLocalOnlineMyntraHomePage.clickStudio();
        }
    }

    @When("User clicks on Categories One")
    public void userClicksOnCategories() {
        if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Mobile")) {
        } else if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Online")) {
            webCloudOnlineMyntraHomePage.clickCategories();
        } else {
            webLocalOnlineMyntraHomePage.clickCategories();
        }
    }
}
