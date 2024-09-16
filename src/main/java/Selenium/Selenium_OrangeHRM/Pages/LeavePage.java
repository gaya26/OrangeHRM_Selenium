package Selenium.Selenium_OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='oxd-select-text-input' and text()='-- Select --']")
    private WebElement leaveTypeDropdown;

    @FindBy(xpath = "//input[@placeholder='yyyy-dd-mm'][1]")
    private WebElement fromDateInput;

    @FindBy(xpath = "//input[@placeholder='yyyy-dd-mm'][2]")
    private WebElement toDateInput;

    @FindBy(css = "textarea.oxd-textarea--active")
    private WebElement commentsTextArea;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Apply')]")
    private WebElement applyButton;

    @FindBy(xpath = "//h5[text()='My Leave List']")
    private WebElement myLeaveListTitle;

    @FindBy(xpath = "//button[contains(@class, 'oxd-icon-button')]//i[contains(@class, 'bi-caret-up-fill')]")
    private WebElement toggleButton;

    @FindBy(xpath = "//label[contains(text(),'From Date')]")
    private WebElement fromDateLabel;

    @FindBy(xpath = "//label[contains(text(),'To Date')]")
    private WebElement toDateLabel;

    @FindBy(xpath = "//div[@class='oxd-select-text-input' and contains(text(),'Select')]")
    private WebElement statusDropdown;

    @FindBy(xpath = "//span[contains(text(),'Rejected')]")
    private WebElement rejectedStatusChip;

    @FindBy(xpath = "//span[contains(text(),'Cancelled')]")
    private WebElement cancelledStatusChip;

    @FindBy(xpath = "//span[contains(text(),'Pending Approval')]")
    private WebElement pendingApprovalStatusChip;

    @FindBy(xpath = "//span[contains(text(),'Scheduled')]")
    private WebElement scheduledStatusChip;

    @FindBy(xpath = "//span[contains(text(),'Taken')]")
    private WebElement takenStatusChip;

    @FindBy(xpath = "//button[@type='reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Search')]")
    private WebElement searchButton;

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectLeaveType(String leaveType) {
        leaveTypeDropdown.click();
    }

    public void enterFromDate(String fromDate) {
        fromDateInput.clear();
        fromDateInput.sendKeys(fromDate);
    }

    public void enterToDate(String toDate) {
        toDateInput.clear();
        toDateInput.sendKeys(toDate);
    }

    public void enterComments(String comments) {
        commentsTextArea.sendKeys(comments);
    }

    public void clickApply() {
        applyButton.click();
    }

    public String getLeaveListTitle() {
        return myLeaveListTitle.getText();
    }

    public void toggleLeaveList() {
        toggleButton.click();
    }

    public String getFromDateLabel() {
        return fromDateLabel.getText();
    }

    public String getToDateLabel() {
        return toDateLabel.getText();
    }

    public void openStatusDropdown() {
        statusDropdown.click();
    }

    public void selectStatus(String status) {
        openStatusDropdown();
        switch (status.toLowerCase()) {
            case "rejected":
                rejectedStatusChip.click();
                break;
            case "cancelled":
                cancelledStatusChip.click();
                break;
            case "pending approval":
                pendingApprovalStatusChip.click();
                break;
            case "scheduled":
                scheduledStatusChip.click();
                break;
            case "taken":
                takenStatusChip.click();
                break;
        }
    }

    public void resetSearch() {
        resetButton.click();
    }

    public void clickSearch() {
        searchButton.click();
    }
}
