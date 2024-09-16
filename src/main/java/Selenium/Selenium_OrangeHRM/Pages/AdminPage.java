package Selenium.Selenium_OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
    private WebDriver driver;

    // Selectors for Admin page elements
    private By adminTitle = By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    private By userManagementTitle = By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-level");
    private By upgradeButton = By.cssSelector("button.oxd-glass-button.orangehrm-upgrade-button");
    private By userProfilePicture = By.cssSelector("img.oxd-userdropdown-img");
    private By userName = By.cssSelector("p.oxd-userdropdown-name");
    private By addButton = By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary");
    private By userRoleSelect = By.cssSelector("div.oxd-select-wrapper");
    private By employeeNameInput = By.cssSelector("input[placeholder='Type for hints...']");
    private By statusSelect = By.cssSelector("div.oxd-select-wrapper");
    private By usernameInput = By.cssSelector("input.oxd-input.oxd-input--active");
    private By passwordInput = By.cssSelector("input[type='password']");
    private By confirmPasswordInput = By.cssSelector("input[type='password']");
    private By saveButton = By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
    private By editButton = By.cssSelector("oxd-icon.bi-pencil-fill");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAdminTitle() {
        return driver.findElement(adminTitle).getText();
    }

    public String getUserManagementTitle() {
        return driver.findElement(userManagementTitle).getText();
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

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void clickEditButton() {
        driver.findElement(editButton).click();
    }

    public void selectUserRole(String role) {
        WebElement roleSelectElement = driver.findElement(userRoleSelect);
        roleSelectElement.click();
        driver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + role + "']")).click();
    }

    public void enterEmployeeName(String name) {
        driver.findElement(employeeNameInput).sendKeys(name);
    }

    public void selectStatus(String status) {
        WebElement statusSelectElement = driver.findElement(statusSelect);
        statusSelectElement.click();
        driver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + status + "']")).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        driver.findElement(confirmPasswordInput).sendKeys(password);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }
}
