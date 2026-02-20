package framework.ui.tests;

import framework.base.BaseTest;
import framework.driver.DriverManager;
import framework.ui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUiTest extends BaseTest {

    @Test(groups = {"ui", "smoke"})
    public void loginTest() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login("admin", "password");
        Assert.assertEquals(loginPage.loginSuccessMessage(), "Login successful!");
    }
}
