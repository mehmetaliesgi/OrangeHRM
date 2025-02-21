package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
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

            pimPage.clickEmployeeDetails();

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


    @Test
    public void editContactDetails() {
        logger.info("******* Starting Edit Contact Details for Employee *******");

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

            pimPage.searchWithEmployeeID("0300");
            pimPage.clickSearch();

            boolean isRecordFound = pimPage.isRecordFound();
            Assert.assertTrue(isRecordFound);

            pimPage.clickEmployeeDetails();
            pimPage.clickContactDetails();

            ContactDetailsPage contactDetails = new ContactDetailsPage(driver, wait);
            contactDetails.setStreet1(randomString(10));
            contactDetails.setStreet2(randomString(8));
            contactDetails.setCity(randomString(5));
            contactDetails.setStateProvince(randomString(10));
            contactDetails.setPostalCode(randomNumber());
            contactDetails.setCountry();
            contactDetails.setPhoneHome(randomNumber());
            contactDetails.setTxtPhoneMobile(randomNumber());
            contactDetails.setTxtPhoneWork(randomNumber());
            contactDetails.setEmailWork(randomString(10) + "@example.com");
            contactDetails.setEmailOther(randomString(12) + "@example.com");
            contactDetails.clickSaveContactDetails();

            contactDetails.clickAddAttachment();
            contactDetails.addAttachment("C:\\Users\\mehme\\Desktop\\Selenium_Projects\\OrangeHRM\\src\\test\\resources\\resumeMehmetAliEsgi.pdf");
            contactDetails.setComment(randomString(50));
            contactDetails.clickSaveAttachment();
            boolean isAttachmentSave = contactDetails.isRecordFound();
            Assert.assertTrue(isAttachmentSave);

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("***** Finished Edit Contact Details for Employee *****");
    }
}
