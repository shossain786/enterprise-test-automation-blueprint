package framework.base;

import framework.config.ConfigManager;
import framework.driver.DriverManager;
import framework.ui.utils.ScreenshotUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.initDriver();
        DriverManager.getDriver().get(ConfigManager.get("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtil.takeScreenShot(
                    DriverManager.getDriver(),
                    result.getMethod().getMethodName()
            );
        }
        DriverManager.quitDriver();
    }
}
