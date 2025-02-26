package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class AdminTest extends BaseClass {
/*    @Test
    public void addUserTest() {
        logger.info("******* Starting Add User Test *******");

        try {
            LoginPage loginPage = new LoginPage(driver, wait);

            loginPage.setUsername(properties.getProperty("username"));
            loginPage.setPassword(properties.getProperty("password"));
            loginPage.clickLogin();

            DashboardPage dashboardPage = new DashboardPage(driver, wait);
            boolean targetPage = dashboardPage.isDashboardPageExist();
            Assert.assertTrue(targetPage);

            dashboardPage.clickAdmin();

            AdminPage adminPage = new AdminPage(driver, wait);
            Assert.assertTrue(adminPage.isAdminHeaderDisplayed());
            adminPage.clickAddUser();

            AddUserPage addUser = new AddUserPage(driver, wait);
            addUser.setUserRole();
            addUser.setEmployeeName("Rebecca Harmony");
            addUser.setUserStatus();
            String username = randomString(10);
            addUser.setUsername(username);
            String password = randomAlphanumericString(8);
            System.out.println(password);
            addUser.setPassword(password);
            addUser.setConfirmPassword(password);
            addUser.clickSaveUser();

            Assert.assertTrue(adminPage.isSystemUsersTextDisplayed());
            adminPage.searchEmployeeWithUsername(username);
            adminPage.clickSearchEmployee();
            Assert.assertTrue(adminPage.isRecordFoundDisplayed());

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("***** Finished Add User Test *****");
    }

    @Test
    public void addJobTitleTest() {
        logger.info("******* Starting Add Job Title Test *******");

        try {
            LoginPage loginPage = new LoginPage(driver, wait);

            loginPage.setUsername(properties.getProperty("username"));
            loginPage.setPassword(properties.getProperty("password"));
            loginPage.clickLogin();

            DashboardPage dashboardPage = new DashboardPage(driver, wait);
            boolean targetPage = dashboardPage.isDashboardPageExist();
            Assert.assertTrue(targetPage);

            dashboardPage.clickAdmin();

            AdminPage adminPage = new AdminPage(driver, wait);
            Assert.assertTrue(adminPage.isAdminHeaderDisplayed());
            adminPage.clickJob();
            adminPage.clickJobTitles();

            JobTitlesPage jobTitlesPage = new JobTitlesPage(driver, wait);
            jobTitlesPage.clickAddJobTitles();

            AddJobTitlePage jobTitlePage = new AddJobTitlePage(driver, wait);
            jobTitlePage.setJobTitle(randomString(5));
            jobTitlePage.setJobDescription(randomString(50));
            jobTitlePage.addJobSpesification("C:\\Users\\mehme\\Desktop\\Selenium_Projects\\OrangeHRM\\src\\test\\resources\\resumeMehmetAliEsgi.pdf");
            jobTitlePage.addNote(randomString(70));
            jobTitlePage.clickSaveJobTitle();
            Assert.assertTrue(jobTitlesPage.isRecordFoundDisplayed());

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("***** Finished Add Job Title Test *****");
    }
*/
    @Test
    public void addWorkShiftTest() {
        logger.info("******* Starting Add Work Shift Test *******");

        try {
            LoginPage loginPage = new LoginPage(driver, wait);

            loginPage.setUsername(properties.getProperty("username"));
            loginPage.setPassword(properties.getProperty("password"));
            loginPage.clickLogin();

            DashboardPage dashboardPage = new DashboardPage(driver, wait);
            boolean targetPage = dashboardPage.isDashboardPageExist();
            Assert.assertTrue(targetPage);

            dashboardPage.clickAdmin();

            AdminPage adminPage = new AdminPage(driver, wait);
            Assert.assertTrue(adminPage.isAdminHeaderDisplayed());
            adminPage.clickJob();
            adminPage.clickWorkShifts();

            WorkShiftsPage workShiftsPage = new WorkShiftsPage(driver, wait);
            Assert.assertTrue(workShiftsPage.isWorkShiftsPageDisplayed());
            workShiftsPage.clickAddWorkShiftButton();

            AddWorkShiftPage workShiftPage = new AddWorkShiftPage(driver, wait);
            Assert.assertTrue(workShiftPage.isWorkShiftPageDisplayed());
            String shiftName = randomString(8);
            System.out.println(shiftName);
            workShiftPage.setShiftName(shiftName);
            workShiftPage.setFromHour("07", "30", "am");
            workShiftPage.setToHour("07", "30","pm");
            workShiftPage.setAssignedEmployees("A");
            workShiftPage.clickSave();

            Assert.assertTrue(workShiftsPage.doesInsetedDataDisplayed(shiftName));

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("***** Finished Add Work Shift Test *****");
    }
}
