package framework.ui.tests;

import framework.base.BaseTest;
import framework.driver.DriverManager;
import framework.ui.pages.RegistrationPage;
import framework.ui.retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @Test(
            groups = {"ui", "sanity"},
            retryAnalyzer = RetryAnalyzer.class
    )
    public void registrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(DriverManager.getDriver());

        registrationPage.enterFirstName("k.paolo");
        registrationPage.enterEmail("k.paolo@cc.com");
        registrationPage.selectCountry("United States");
        registrationPage.clickRegisterBtn();
        String actualMessage = registrationPage.getAlertMessage();
        Assert.assertEquals(actualMessage, "Registration form submitted successfully!");
    }
}
