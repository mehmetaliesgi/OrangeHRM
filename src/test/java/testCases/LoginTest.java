package testCases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

import java.time.Duration;

public class LoginTest extends BaseClass {

    @Test
    public void verifyLogin() {
        logger.info("******* Starting LoginTest *******");

        try {
            LoginPage loginPage = new LoginPage(driver, wait);

            loginPage.setUsername(properties.getProperty("username"));
            loginPage.setPassword(properties.getProperty("password"));
            loginPage.clickLogin();

            DashboardPage dashboardPage = new DashboardPage(driver, wait);
            boolean targetPage = dashboardPage.isDashboardPageExist();
            Assert.assertTrue(targetPage);
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("***** Finished LoginTest *****");
    }
}
