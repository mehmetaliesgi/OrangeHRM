package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import pageObjects.PersonalDetailsPage;
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

    @Test
    public void searchEmployee() {
        logger.info("******* Starting Search Employee *******");

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

            pimPage.clickEmployeeList();

            boolean isEmployeeInfo = pimPage.isEmployeeInfoDisplayed();
            Assert.assertTrue(isEmployeeInfo);

            pimPage.searchWithEmployeeID("037931900");
            pimPage.clickSearch();

            boolean isRecordFound = pimPage.isRecordFound();
            Assert.assertTrue(isRecordFound);
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("***** Finished Search Employee *****");
    }

    @Test
    public void editPersonalDetails() {
        logger.info("******* Starting Edit Employee *******");

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

            pimPage.clickEmployeeList();

            boolean isEmployeeInfo = pimPage.isEmployeeInfoDisplayed();
            Assert.assertTrue(isEmployeeInfo);

            pimPage.searchWithEmployeeID("0495");
            Thread.sleep(3000);
            pimPage.clickSearch();

            boolean isRecordFound = pimPage.isRecordFound();
            Assert.assertTrue(isRecordFound);

            pimPage.clickPersonalDetails();

            PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(driver, wait);
            personalDetailsPage.setOtherID(randomNumber());
            personalDetailsPage.setDriverLicense(randomNumber());
            personalDetailsPage.setLicenseExpiryDate("2028-11-11");
            personalDetailsPage.clickAndSelectNationality();
            personalDetailsPage.clickAndSelectMaritalStatus();
            personalDetailsPage.setDateOfBirth("1992-02-02");
            personalDetailsPage.checkGender("Male");
            personalDetailsPage.clickSave();
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("***** Finished Edit Employee *****");
    }
}
