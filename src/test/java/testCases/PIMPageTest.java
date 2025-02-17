package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class PIMPageTest extends BaseClass {
    @Test
    public void addNewEmployee() {
        logger.info("******* Starting Add New Employee *******");

        try {
            LoginPage loginPage = new LoginPage(driver, wait);

            loginPage.setUsername(properties.getProperty("username"));
            loginPage.setPassword(properties.getProperty("password"));
            loginPage.clickLogin();

            DashboardPage dashboardPage = new DashboardPage(driver, wait);
            boolean targetPage = dashboardPage.isDashboardPageExist();
            Assert.assertTrue(targetPage);

            dashboardPage.clickPIM();
            PIMPage pimPage = new PIMPage(driver, wait);
            boolean accessPimPage = pimPage.isPIMHeaderDisplayed();
            Assert.assertTrue(accessPimPage);
            pimPage.clickAdd();
            pimPage.setFirstName("John");
            pimPage.setLastName("Doe");
            pimPage.setEmployeeID(randomNumber());
            pimPage.clickSave();
            boolean appearPersonalDetails = pimPage.isPersonalDetailDisplayed();
            Assert.assertTrue(appearPersonalDetails);
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("***** Finished Add New Employee *****");
    }
}
