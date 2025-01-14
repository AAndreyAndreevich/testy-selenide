package service;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNgRetry implements IRetryAnalyzer {

    private int count = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (count < 3) {
                count++;
                return true;
            }
        }
        return false;
    }
}
