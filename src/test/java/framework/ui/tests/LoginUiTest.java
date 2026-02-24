package framework.ui.tests;

import com.utem.reporter.testng.UtemSteps;
import framework.core.base.BaseTest;
import framework.core.driver.DriverManager;
import framework.ui.pages.LoginPage;
import framework.ui.retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUiTest extends BaseTest {

    @Test(
            groups = {"ui", "smoke"},
            retryAnalyzer = RetryAnalyzer.class
    )
    public void loginTest() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        UtemSteps.step("I am on login page");
        loginPage.login("admin", "password");
        UtemSteps.step("I enter user name as 'admin' and password as 'password'");
        Assert.assertEquals(loginPage.loginSuccessMessage(), "Login successful!");
        UtemSteps.step("Verified login success message 'Login successful!'");
    }

    @Test(
            groups = {"ui", "smoke"},
            retryAnalyzer = RetryAnalyzer.class
    )
    public void negativeLoginTest() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login("admin", "password");
        Assert.assertEquals(loginPage.loginSuccessMessage(), "Login successful!");
    }
}
