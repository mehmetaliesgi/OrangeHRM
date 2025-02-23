package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class AdminTest extends BaseClass {
    @Test
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
}
