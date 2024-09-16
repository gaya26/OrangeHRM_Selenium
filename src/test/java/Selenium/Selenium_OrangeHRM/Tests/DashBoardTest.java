package Selenium.Selenium_OrangeHRM.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Selenium.Selenium_OrangeHRM.Pages.DashBoardPage;
import Selenium.Selenium_OrangeHRM.Pages.LoginPage;

public class DashBoardTest extends BaseTest {
    private DashBoardPage dashBoardPage;

    @BeforeClass
    @Override
    public void setup() {
        super.setup();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        dashBoardPage = new DashBoardPage(driver);
    }

    @Test
    public void testDashboardHeaderElements() {
        String title = dashBoardPage.getDashboardTitle();
        Assert.assertEquals(title, "Dashboard", "Dashboard title is not as expected.");

        Assert.assertTrue(dashBoardPage.isUpgradeButtonVisible(), "Upgrade button is not visible.");

        Assert.assertTrue(dashBoardPage.isUserProfilePictureVisible(), "User profile picture is not visible.");

        String userName = dashBoardPage.getUserName();
        Assert.assertTrue(userName.contains("user"), "User name is not as expected.");

        Assert.assertTrue(dashBoardPage.isHelpButtonVisible(), "Help button is not visible.");
    }

    @Test
    public void testTimeAtWorkWidget() {
        String widgetTitle = dashBoardPage.getTimeAtWorkWidgetTitle();
        Assert.assertEquals(widgetTitle, "Time at Work", "Time at Work widget title is not as expected.");

        Assert.assertTrue(dashBoardPage.isTimeAtWorkProfileImageVisible(), "Profile image in Time at Work widget is not visible.");

        String stateText = dashBoardPage.getTimeAtWorkState();
        Assert.assertEquals(stateText, "Punched Out", "Time at Work state text is not as expected.");

        String detailsText = dashBoardPage.getTimeAtWorkDetails();
        Assert.assertTrue(detailsText.contains("Punched Out"), "Time at Work details text is not as expected.");

        String fullTimeText = dashBoardPage.getTimeAtWorkFullTime();
        Assert.assertTrue(fullTimeText.contains("0h 2m"), "Time at Work full time text is not as expected.");

        Assert.assertTrue(dashBoardPage.isTimeAtWorkActionButtonVisible(), "Action button in Time at Work widget is not visible.");
    }

    @Test
    public void testClickAdminMenuItem() {
        dashBoardPage.clickAdminMenuItem();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/admin/viewAdminModule"), "Failed to navigate to Admin page.");
    }

    @Test
    public void testMyActionsWidget() {
        String widgetTitle = dashBoardPage.getMyActionsWidgetTitle();
        Assert.assertEquals(widgetTitle, "My Actions", "My Actions widget title is not as expected.");

        int listSize = dashBoardPage.getMyActionsListSize();
        Assert.assertTrue(listSize > 0, "My Actions list is empty.");

        // Verify the first item as an example
        String firstItemText = dashBoardPage.getMyActionsListItemText(0);
        Assert.assertTrue(firstItemText.contains("Pending Self Review") || firstItemText.contains("Pending Approval"), 
                          "First item in My Actions list is not as expected.");
    }
}
