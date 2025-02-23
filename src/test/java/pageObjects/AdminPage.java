package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage{
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;

    @FindBy(xpath = "//h6[normalize-space()='Admin']")
    private WebElement txtAdminHeader;

    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    private WebElement txtUsers;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement btnSearchEmployee;

    @FindBy(xpath = "//label[normalize-space()='Username']/following::input[1]")
    private WebElement txtUsername;

    @FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    private WebElement txtRecordFound;

    @FindBy(xpath = "//span[normalize-space()='Job']")
    private WebElement slctJob;

    @FindBy(xpath = "//span[normalize-space()='Job']/following::li[normalize-space()='Job Titles']")
    private WebElement slctJobTitles;

    public AdminPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isAdminHeaderDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(txtAdminHeader));
        try {
            return txtAdminHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAddUser() {
        wait.until(ExpectedConditions.visibilityOf(btnAdd));
        btnAdd.click();
    }

    public boolean isSystemUsersTextDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(txtUsers));
        try {
            return txtUsers.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void searchEmployeeWithUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public void clickSearchEmployee() {
        btnSearchEmployee.click();
    }

    public boolean isRecordFoundDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(txtRecordFound));
        try {
            return txtRecordFound.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickJob() {
        wait.until(ExpectedConditions.visibilityOf(slctJob));
        slctJob.click();
    }

    public void clickJobTitles() {
        wait.until(ExpectedConditions.visibilityOf(slctJobTitles));
        slctJobTitles.click();
    }
}
