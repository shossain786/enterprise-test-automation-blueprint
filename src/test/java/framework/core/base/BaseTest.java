package framework.core.base;

import com.utem.reporter.testng.WebDriverRegistry;
import framework.core.base.config.ConfigManager;
import framework.core.driver.DriverManager;
import framework.ui.utils.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.get(ConfigManager.get("baseUrl"));
        WebDriverRegistry.register(driver);
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
        WebDriverRegistry.unregister();
    }

    public static void waitTime(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            logger.error("Interrupted while waiting for sleep.\n{}", e.getMessage());
        }
    }
}
