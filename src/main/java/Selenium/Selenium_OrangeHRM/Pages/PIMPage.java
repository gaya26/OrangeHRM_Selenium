package Selenium.Selenium_OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {
    private WebDriver driver;

    @FindBy(css = "input[placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(css = "input.oxd-input--active")
    private WebElement employeeIdInput;

    @FindBy(css = "div.oxd-select-text--active")
    private WebElement employmentStatusDropdown;

    @FindBy(xpath = "//div[@class='oxd-select-text--active'][contains(text(),'-- Select --')]")
    private WebElement includeDropdown;

    @FindBy(css = "input[placeholder='Type for hints...']")
    private WebElement supervisorNameInput;

    @FindBy(css = "div.oxd-select-text--active")
    private WebElement jobTitleDropdown;

    @FindBy(css = "div.oxd-select-text--active")
    private WebElement subUnitDropdown;

    @FindBy(css = "button[type='reset']")
    private WebElement resetButton;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    @FindBy(css = "button.oxd-button--secondary")
    private WebElement addEmployeeButton;

    @FindBy(css = "input.oxd-input--active.orangehrm-firstname")
    private WebElement firstNameInput;

    @FindBy(css = "input.oxd-input--active.orangehrm-middlename")
    private WebElement middleNameInput;

    @FindBy(css = "input.oxd-input--active.orangehrm-lastname")
    private WebElement lastNameInput;

    @FindBy(css = "button.oxd-button--ghost")
    private WebElement cancelButton;

    @FindBy(css = "button.oxd-button--secondary.orangehrm-left-space")
    private WebElement saveButton;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterMiddleName(String middleName) {
        middleNameInput.sendKeys(middleName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void clickAddEmployeeButton() {
        addEmployeeButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void enterEmployeeId(String employeeId) {
        employeeIdInput.sendKeys(employeeId);
    }

    public void selectEmploymentStatus(String status) {
        employmentStatusDropdown.click();
        WebElement statusOption = driver.findElement(By.xpath("//div[contains(text(),'" + status + "')]"));
        statusOption.click();
    }

    public void selectIncludeOption(String option) {
        includeDropdown.click();
        WebElement includeOption = driver.findElement(By.xpath("//div[contains(text(),'" + option + "')]"));
        includeOption.click();
    }

    public void enterSupervisorName(String supervisorName) {
        supervisorNameInput.sendKeys(supervisorName);
    }

    public void selectJobTitle(String jobTitle) {
        jobTitleDropdown.click();
        WebElement jobTitleOption = driver.findElement(By.xpath("//div[contains(text(),'" + jobTitle + "')]"));
        jobTitleOption.click();
    }

    public void selectSubUnit(String subUnit) {
        subUnitDropdown.click();
        WebElement subUnitOption = driver.findElement(By.xpath("//div[contains(text(),'" + subUnit + "')]"));
        subUnitOption.click();
    }
}
