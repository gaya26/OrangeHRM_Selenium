package Selenium.Selenium_OrangeHRM.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Selenium.Selenium_OrangeHRM.Pages.LoginPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Override
    @BeforeClass
    public void setup() {
        super.setup();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginSuccess() {
        loginPage.navigateToLoginPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        boolean isDashboardVisible = driver.findElements(By.cssSelector("div[class='dashboard']")).size() > 0;
        Assert.assertTrue(isDashboardVisible, "Login failed. Dashboard is not visible after login.");
    }

    @Test
    public void testLoginFailure() {
        loginPage.navigateToLoginPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        loginPage.enterUsername("InvalidUser");
        loginPage.enterPassword("InvalidPassword");
        loginPage.clickLogin();

        String errorMessage = loginPage.getLoginErrorMessage();
        Assert.assertTrue(errorMessage.contains("Invalid credentials"), "Error message not as expected!");

        boolean isLoginPageStillVisible = driver.findElements(By.name("username")).size() > 0;
        Assert.assertTrue(isLoginPageStillVisible, "Login page should still be visible after failed login.");
    }
}
