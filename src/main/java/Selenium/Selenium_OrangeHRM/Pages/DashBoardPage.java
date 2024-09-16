package Selenium.Selenium_OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage {
    private WebDriver driver;

    // Existing locators for dashboard elements
    private By dashboardTitle = By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    private By upgradeButton = By.cssSelector("button.oxd-glass-button.orangehrm-upgrade-button");
    private By userProfilePicture = By.cssSelector("img.oxd-userdropdown-img");
    private By userName = By.cssSelector("p.oxd-userdropdown-name");
    private By helpButton = By.cssSelector("button.oxd-icon-button[title='Help']");
    private By timeAtWorkWidgetTitle = By.cssSelector("p.oxd-text.oxd-text--p");
    private By timeAtWorkProfileImage = By.cssSelector("img.employee-image");
    private By timeAtWorkState = By.cssSelector("p.orangehrm-attendance-card-state");
    private By timeAtWorkDetails = By.cssSelector("p.orangehrm-attendance-card-details");
    private By timeAtWorkFullTime = By.cssSelector("span.orangehrm-attendance-card-fulltime");
    private By timeAtWorkActionButton = By.cssSelector("button.oxd-icon-button.oxd-icon-button--solid-main.orangehrm-attendance-card-action");
    private By adminMenuItem = By.cssSelector("a.oxd-main-menu-item[href='/web/index.php/admin/viewAdminModule']");

    // New locators for "My Actions" widget
    private By myActionsWidgetTitle = By.cssSelector("p.oxd-text.oxd-text--p.orangehrm-dashboard-widget-name");
    private By myActionsListItems = By.cssSelector(".orangehrm-todo-list-item");
    private By myActionsListItemText = By.cssSelector(".oxd-text.oxd-text--p");

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Existing methods to interact with dashboard elements
    public String getDashboardTitle() {
        return driver.findElement(dashboardTitle).getText();
    }

    public boolean isUpgradeButtonVisible() {
        return driver.findElement(upgradeButton).isDisplayed();
    }

    public boolean isUserProfilePictureVisible() {
        return driver.findElement(userProfilePicture).isDisplayed();
    }

    public String getUserName() {
        return driver.findElement(userName).getText();
    }

    public boolean isHelpButtonVisible() {
        return driver.findElement(helpButton).isDisplayed();
    }

    public String getTimeAtWorkWidgetTitle() {
        return driver.findElement(timeAtWorkWidgetTitle).getText();
    }

    public boolean isTimeAtWorkProfileImageVisible() {
        return driver.findElement(timeAtWorkProfileImage).isDisplayed();
    }

    public String getTimeAtWorkState() {
        return driver.findElement(timeAtWorkState).getText();
    }

    public String getTimeAtWorkDetails() {
        return driver.findElement(timeAtWorkDetails).getText();
    }

    public String getTimeAtWorkFullTime() {
        return driver.findElement(timeAtWorkFullTime).getText();
    }

    public boolean isTimeAtWorkActionButtonVisible() {
        return driver.findElement(timeAtWorkActionButton).isDisplayed();
    }

    public void clickAdminMenuItem() {
        driver.findElement(adminMenuItem).click();
    }

    // New methods for "My Actions" widget
    public String getMyActionsWidgetTitle() {
        return driver.findElement(myActionsWidgetTitle).getText();
    }

    public int getMyActionsListSize() {
        return driver.findElements(myActionsListItems).size();
    }

    public String getMyActionsListItemText(int index) {
        WebElement listItem = driver.findElements(myActionsListItems).get(index);
        return listItem.findElement(myActionsListItemText).getText();
    }
}
