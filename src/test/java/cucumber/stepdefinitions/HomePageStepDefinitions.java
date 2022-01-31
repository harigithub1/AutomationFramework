package cucumber.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ThreadLocalDriver;

public class HomePageStepDefinitions extends BaseSteps {

    @Before
    public void setupLoginSteps() {
        setupScreens(ThreadLocalDriver.getTLDriver());
    }

    @Given("User is on home page and taps Categories")
    public void userisonhomepageandtapsCategories() {
       // splashScreen.skipSplashScreen();
        selectionScreen.clickCategories();
//        candidateMainScreen.allowNotification();
    }

    @When("User clicks Studio {int}")
    public void userclicksStudio(int index) {
    //    candidateMainScreen.clickToJob(index);
        homePage.clickStudio();

    }

    @Then("Verify Explore button")
    public void verifyExplorebutton() {
        jobScreen.assertExploreTitleIsExpected();
    }

    @When("User clicks on Profile")
    public void userClicksOnProfile() {
        homePage.clickProfile();

    }

    @And("User clicks on Home")
    public void userClicksOnHome() {
        homePage.clickHome();
    }
}
