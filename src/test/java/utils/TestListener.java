package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object retry = result.getAttribute("retry");

        if (retry == null) {
            ScreenshotUtil.captureScreenshot(result.getName());
        }
    }
}