package Selenium.Selenium_OrangeHRM.Tests;

import Selenium.Selenium_OrangeHRM.Pages.LeavePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LeaveTest extends BaseTest {

    private LeavePage leavePage;

    @BeforeClass
    @Override
    public void setup() {
        super.setup();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        leavePage = new LeavePage(driver);
    }

    @Test
    public void testApplyLeave() {
        leavePage.selectLeaveType("Annual Leave");
        leavePage.enterFromDate("2023-01-01");
        leavePage.enterToDate("2023-01-05");  
        leavePage.enterComments("Vacation leave for personal reasons.");
        leavePage.clickApply();

    }

    @Test
    public void testInvalidLeaveApplication() {
        leavePage.selectLeaveType("Annual Leave");
        leavePage.enterFromDate("2023-05-01");
        leavePage.enterToDate("2023-04-30"); 
        leavePage.enterComments("Testing invalid date range.");
        leavePage.clickApply();

    }

    @Test
    public void testApplyLeaveWithoutLeaveType() {
        leavePage.enterFromDate("2023-02-10");
        leavePage.enterToDate("2023-02-12");  
        leavePage.enterComments("Attempt to submit leave without selecting leave type.");
        leavePage.clickApply();
    }

    @Test
    public void testApplyLeaveWithoutDates() {
        leavePage.selectLeaveType("Sick Leave");
        leavePage.enterComments("Attempt to submit leave without providing dates.");
        leavePage.clickApply();
    }

    @Test
    public void testApplyLeaveWithMultipleStatuses() {
        leavePage.selectLeaveType("Casual Leave");
        leavePage.enterFromDate("2023-06-15");
        leavePage.enterToDate("2023-06-20");  
        leavePage.enterComments("Submit leave with multiple leave statuses.");
        leavePage.clickApply();
    }

    @Test
    public void testApplyCasualLeave() {
        leavePage.selectLeaveType("Casual Leave");
        leavePage.enterFromDate("2023-03-01");
        leavePage.enterToDate("2023-03-03");  
        leavePage.enterComments("Taking casual leave for personal reasons.");
        leavePage.clickApply();
    }

    @Test
    public void testApplyFutureLeaveBeyondLimit() {
        leavePage.selectLeaveType("Annual Leave");
        leavePage.enterFromDate("2025-12-01");
        leavePage.enterToDate("2025-12-05");    
        leavePage.enterComments("Testing future leave beyond allowed date.");
        leavePage.clickApply();
    }
}
