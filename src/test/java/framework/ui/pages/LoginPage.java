package framework.ui.pages;

import framework.core.base.BaseTest;
import framework.ui.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.xpath("//button[contains(text(), 'Login')]");
    By loginSuccess = By.xpath("//div[@id='loginAlert']");
    By formsLink = By.linkText("Forms");
    By usernameError = By.id("usernameError");
    By passwordError = By.id("passwordError");

    public boolean isPageLoaded() {
        WaitUtils.waitForVisible(driver, username);
        return driver.findElement(username).isDisplayed();
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public void clickForms() {
        driver.findElement(formsLink).click();
    }

    public void enterUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String loginSuccessMessage() {
        return driver.findElement(loginSuccess).getText();
    }

    public void verifyValidationErrors() {
        try {
            WebElement usernameErrorElement = driver.findElement(usernameError);
            WebElement passwordErrorElement = driver.findElement(passwordError);
        } catch (Exception e) {
            System.out.println("Error elements not found");
        }
    }
}