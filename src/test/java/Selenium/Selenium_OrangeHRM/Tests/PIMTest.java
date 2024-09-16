package Selenium.Selenium_OrangeHRM.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Selenium.Selenium_OrangeHRM.Pages.PIMPage;

public class PIMTest extends BaseTest {
    private PIMPage pimPage;

    @BeforeClass
    @Override
    public void setup() {
        super.setup();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        pimPage = new PIMPage(driver);
    }

    @Test
    public void testEmployeeNameInput() {
        pimPage.enterFirstName("John Doe");
    }

    @Test
    public void testEmployeeIdInput() {
        pimPage.enterEmployeeId("E12345");
    }

    @Test
    public void testEmploymentStatusDropdown() {
        pimPage.selectEmploymentStatus("Active");
    }

    @Test
    public void testIncludeDropdown() {
        pimPage.selectIncludeOption("Current Employees Only");
    }

    @Test
    public void testSupervisorNameInput() {
        pimPage.enterSupervisorName("Jane Smith");
    }

    @Test
    public void testJobTitleDropdown() {
        pimPage.selectJobTitle("Developer");
    }

    @Test
    public void testSubUnitDropdown() {
        pimPage.selectSubUnit("IT");
    }

    @Test
    public void testAddEmployee() {
        pimPage.clickAddEmployeeButton();
        pimPage.enterFirstName("John");
        pimPage.enterMiddleName("A");
        pimPage.enterLastName("Doe");
        pimPage.clickSaveButton();
    }

    @Test
    public void testCancelAddEmployee() {
        pimPage.clickAddEmployeeButton();
        pimPage.enterFirstName("John");
        pimPage.enterMiddleName("A");
        pimPage.enterLastName("Doe");
        pimPage.clickCancelButton();
    }
}
