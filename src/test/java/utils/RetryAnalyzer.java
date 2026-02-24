package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int maxRetry =
            Integer.parseInt(ConfigReader.getProperty("retryCount"));  // retry 2 times

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxRetry) {
            count++;
            result.setAttribute("retry", true);
            return true;
        }
        return false;
    }
}