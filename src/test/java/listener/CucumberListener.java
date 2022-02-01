package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.tests.BaseTest;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ThreadLocalDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CucumberListener implements ConcurrentEventListener {

    public static ExtentTest parentExtentTest;
    public static ExtentTest extentTest;
    public static ExtentReports extentReports;
    public static ExtentHtmlReporter extentHtmlReporter;

    public static String takeScreenshotAsBase64(){
        return ((TakesScreenshot) ThreadLocalDriver.getTLDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public static String getCurrentDateAndTime(){
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date =new Date();
        String str =dateFormat.format(date).replace(" ","_").replaceAll("/","_").replaceAll(":","_");
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
            extentHtmlReporter = new ExtentHtmlReporter(new File("target/extent-reports/ExtentReport_"+getCurrentDateAndTime()+".html"));
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentHtmlReporter);
        }
    };
    public EventHandler<TestCaseStarted> eventHandlerTestCaseStarted = new EventHandler<TestCaseStarted>() {
        public void receive(TestCaseStarted event) {
            String testScenarioName = event.getTestCase().getName();
            parentExtentTest = extentReports.createTest(testScenarioName);
        }
    };
    private EventHandler<TestStepStarted> eventHandlerTestStepStarted = new EventHandler<TestStepStarted>() {
        public void receive(TestStepStarted event) {
            if (event.getTestStep() instanceof PickleStepTestStep) {
                String testStepName = ((PickleStepTestStep) event.getTestStep()).getStep().getText();
                extentTest = parentExtentTest.createNode(testStepName);
            }
        }
    };
    private EventHandler<TestStepFinished> eventHandlerTestStepFinished = new EventHandler<TestStepFinished>() {
        public void receive(TestStepFinished event) {
            if (event.getTestStep() instanceof PickleStepTestStep) {
                String testStepName = ((PickleStepTestStep) event.getTestStep()).getStep().getText();
                if (event.getResult().getStatus().toString().equalsIgnoreCase("passed")) {
                    extentTest.log(Status.PASS, "Test step passed"); //here Status.PASS is a field
                } else if (event.getResult().getStatus().toString().equalsIgnoreCase("skipped")) {
                    extentTest.log(Status.SKIP, "Test step skipped"); //here Status.PASS is a field
                } else {
                    try {
                        extentTest.log(Status.FAIL, event.getResult().getError());
                        extentTest.log(Status.FAIL, "Screenshot ->", MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64()).build());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };
    public EventHandler<TestCaseFinished> eventHandlerTestCaseFinished = new EventHandler<TestCaseFinished>() {
        public void receive(TestCaseFinished event) {
        }
    };
    private EventHandler<TestRunFinished> eventHandlerTestRunFinished = new EventHandler<TestRunFinished>() {
        public void receive(TestRunFinished event) {
            if (extentReports != null) {
                extentReports.flush();
            }
        }
    };
}
/*
https://www.javadoc.io/doc/io.cucumber/cucumber-core/4.7.2/cucumber/api/event/Event.html
*/
