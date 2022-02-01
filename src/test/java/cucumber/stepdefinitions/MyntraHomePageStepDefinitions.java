package cucumber.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ThreadLocalDriver;

public class MyntraHomePageStepDefinitions extends BaseSteps {

    @Before
    public void setupLoginSteps() {
        setupScreens(ThreadLocalDriver.getTLDriver());
    }

    @Given("User is on home page One")
    public void userisonhomepageandtapsCategories() {
       // splashScreen.skipSplashScreen();
        myntraHomePage.userOnHomePage();
//        candidateMainScreen.allowNotification();
    }

    @When("User clicks Studio {int} Three")
    public void userclicksStudio(int index) {
    //    candidateMainScreen.clickToJob(index);
        myntraHomePage.clickStudio();

    }

    @Then("Verify Explore button")
    public void verifyExplorebutton() {
        jobScreen.assertExploreTitleIsExpected();
    }

    @When("User clicks on Profile Five")
    public void userClicksOnProfile() {
        myntraHomePage.clickProfile();

    }

    @And("User clicks on Home Six")
    public void userClicksOnHome() {
        myntraHomePage.clickHome();
    }

    @When("User clicks on Explore Four")
    public void userClicksOnExplore() {
        myntraHomePage.clickExplore();
    }

    @When("User clicks on Categories Two")
    public void userClicksOnCategories() {
        myntraHomePage.clickCategories();
    }
}
