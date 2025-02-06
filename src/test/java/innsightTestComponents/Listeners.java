package innsightTestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import innsight_resources.ExtentReporter;

public class Listeners extends BaseTest implements ITestListener {
    ExtentReports extent = ExtentReporter.getReportObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test entry in the report when the test starts
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log a success event in the report
        if (test != null) {
            test.pass("Test passed: " + result.getMethod().getMethodName());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log a failure event in the report
        if (test != null) {
            test.fail("Test failed: " + result.getMethod().getMethodName());
            test.fail(result.getThrowable());
            try {
                driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                e.printStackTrace();
            }

            String filePath = null;
            try {
                filePath = getScreenShot(result.getMethod().getMethodName(), driver);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (filePath != null) {
                test.addScreenCaptureFromBase64String(filePath, result.getMethod().getMethodName());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log a skipped event in the report
        if (test != null) {
            test.skip("Test skipped: " + result.getMethod().getMethodName());
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        // Flush the report at the end of the test suite
        if (extent != null) {
            extent.flush();
        }
    }
}
