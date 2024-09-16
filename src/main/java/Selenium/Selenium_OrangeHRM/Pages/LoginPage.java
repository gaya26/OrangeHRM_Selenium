package Selenium.Selenium_OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By loginErrorMessage = By.cssSelector(".oxd-alert-content");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getLoginErrorMessage() {
        return driver.findElement(loginErrorMessage).getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
