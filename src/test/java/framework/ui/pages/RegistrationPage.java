package framework.ui.pages;

import framework.core.base.BaseTest;
import framework.ui.utils.WaitUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BaseTest {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.id("firstName");
    By email = By.id("email");
    By country = By.id("country");
    By registerBtn = By.xpath("//button[contains(text(), 'Register')]");

    public void enterFirstName(String string) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(string);
    }
    public void enterEmail(String string) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(string);
    }
    public void selectCountry(String string) {
        Select countrySelect = new Select(driver.findElement(country));
        countrySelect.selectByVisibleText(string);
    }
    public void clickRegisterBtn() {
        driver.findElement(registerBtn).click();
    }

    public String getAlertMessage() {
        WaitUtils.waitForAlert(driver);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }
}
