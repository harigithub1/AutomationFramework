package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import utilities.ExtentManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utilities.ThreadLocalDriver.getTLDriver;

public class CucumberListener extends ThreadLocal implements ConcurrentEventListener {

    public static ExtentReports extent = ExtentManager.createInstance();

    public static ThreadLocal<ExtentTest> ptest = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static String takeScreenshotAsBase64() {
        return ((TakesScreenshot) getTLDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public static String getCurrentDateAndTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String str = dateFormat.format(date).replace(" ", "_").replaceAll("/", "_").replaceAll(":", "_");
        return str;
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, eventHandlerTestRunStarted);
        publisher.registerHandlerFor(TestCaseStarted.class, eventHandlerTestCaseStarted);
        publisher.registerHandlerFor(TestStepStarted.class, eventHandlerTestStepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, eventHandlerTestStepFinished);
        publisher.registerHandlerFor(TestCaseFinished.class, eventHandlerTestCaseFinished);
        publisher.registerHandlerFor(TestRunFinished.class, eventHandlerTestRunFinished);
    }

    public EventHandler<TestRunStarted> eventHandlerTestRunStarted = new EventHandler<TestRunStarted>() {
        public void receive(TestRunStarted event) {
            System.out.println("Cucumber Event TestRunStarted");
        }
    };
    public EventHandler<TestCaseStarted> eventHandlerTestCaseStarted = new EventHandler<TestCaseStarted>() {
        public void receive(TestCaseStarted event) {
            String testScenarioName = event.getTestCase().getName();
           String deviceName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("deviceModel");
            // String deviceName = String.valueOf(getTLDriver().getCapabilities().getCapability("deviceModel"));
            String os_version = String.valueOf(getTLDriver().getCapabilities().getCapability("platformVersion"));
            ExtentTest extentTest = extent.createTest(deviceName + " v" + os_version + ": " + testScenarioName);
            ptest.set(extentTest);
        }
    };
    private EventHandler<TestStepStarted> eventHandlerTestStepStarted = new EventHandler<TestStepStarted>() {
        public void receive(TestStepStarted event) {
            if (event.getTestStep() instanceof PickleStepTestStep) {
                String testStepName = ((PickleStepTestStep) event.getTestStep()).getStep().getText();
                ExtentTest extentTest = ptest.get().createNode(testStepName);
                test.set(extentTest);
            }
        }
    };
    private EventHandler<TestStepFinished> eventHandlerTestStepFinished = new EventHandler<TestStepFinished>() {
        public void receive(TestStepFinished event) {
            if (event.getTestStep() instanceof PickleStepTestStep) {
                if (event.getResult().getStatus().toString().equalsIgnoreCase("passed")) {
                    test.get().pass("Test passed");
                } else if (event.getResult().getStatus().toString().equalsIgnoreCase("failed")){
                    test.get().fail("Test failed: "+event.getResult().getError());
                } else {
                    test.get().pass("Test skipped");
                }
            }
        }
    };
    public EventHandler<TestCaseFinished> eventHandlerTestCaseFinished = new EventHandler<TestCaseFinished>() {
        public void receive(TestCaseFinished event) {
            extent.flush();
        }
    };
    private EventHandler<TestRunFinished> eventHandlerTestRunFinished = new EventHandler<TestRunFinished>() {
        public void receive(TestRunFinished event) {
            }

    };
}
/*
https://www.javadoc.io/doc/io.cucumber/cucumber-core/4.7.2/cucumber/api/event/Event.html
*/
