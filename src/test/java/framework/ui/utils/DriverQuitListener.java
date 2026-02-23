package framework.ui.utils;

import com.utem.reporter.testng.WebDriverRegistry;
import framework.core.driver.DriverManager;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Quits the Selenium driver AFTER the UTEM listener has captured its screenshot.
 *
 * Registration order in testng.xml matters:
 *   1. UtemTestNGListener  — captures screenshot in onTestFailure
 *   2. DriverQuitListener  — quits driver after UTEM is done
 *
 * BaseTest.tearDown() must NOT call DriverManager.quitDriver() or
 * WebDriverRegistry.unregister(); those are handled here instead.
 */
public class DriverQuitListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        cleanupDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        cleanupDriver();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        cleanupDriver();
    }

    private void cleanupDriver() {
        WebDriverRegistry.unregister();
        DriverManager.quitDriver();
    }
}
