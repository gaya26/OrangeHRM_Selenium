package Selenium.Selenium_OrangeHRM.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Selenium.Selenium_OrangeHRM.Pages.AdminPage;
import Selenium.Selenium_OrangeHRM.Pages.DashBoardPage;
import Selenium.Selenium_OrangeHRM.Pages.LoginPage;

public class AdminTest extends BaseTest {
    private AdminPage adminPage;
    private DashBoardPage dashBoardPage;

    @BeforeClass
    @Override
    public void setup() {
        super.setup();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.clickAdminMenuItem();

        adminPage = new AdminPage(driver);
    }

    @Test
    public void testAdminHeaderElements() {
        String adminTitle = adminPage.getAdminTitle();
        Assert.assertEquals(adminTitle, "Admin", "Admin title is not as expected.");

        String userManagementTitle = adminPage.getUserManagementTitle();
        Assert.assertEquals(userManagementTitle, "User Management", "User Management title is not as expected.");

        Assert.assertTrue(adminPage.isUpgradeButtonVisible(), "Upgrade button is not visible.");

        Assert.assertTrue(adminPage.isUserProfilePictureVisible(), "User profile picture is not visible.");

        String userName = adminPage.getUserName();
        Assert.assertEquals(userName, "manda user", "User name is not as expected.");
    }

    @Test
    public void testAddUserFunctionality() {
        adminPage.clickAddButton();
        adminPage.selectUserRole("Admin");
        adminPage.enterEmployeeName("John Doe");
        adminPage.selectStatus("Enabled");
        adminPage.enterUsername("johndoe");
        adminPage.enterPassword("Password123!");
        adminPage.enterConfirmPassword("Password123!");
        adminPage.clickSaveButton();
    }
    
    @Test
    public void testEditFunctionality() {
        adminPage.clickEditButton();
        adminPage.selectUserRole("Admin1");
        adminPage.enterEmployeeName("John Doe2");
        adminPage.selectStatus("Enabled");
        adminPage.enterUsername("johndoe2");
        adminPage.enterPassword("Password1234!");
        adminPage.enterConfirmPassword("Password1234!");
        adminPage.clickSaveButton();
    }
}
