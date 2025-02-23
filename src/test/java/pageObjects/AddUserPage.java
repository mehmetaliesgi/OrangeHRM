package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUserPage extends BasePage{
    @FindBy(xpath = "//label[normalize-space()='User Role']/following::div[4]")
    private WebElement slctUserRole;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement txtEmployeeName;

    @FindBy(xpath = "//label[normalize-space()='Status']/following::div[4]")
    private WebElement slctUserStatus;

    @FindBy(xpath = "//label[normalize-space()='Username']/following::input[1]")
    private WebElement txtUsername;

    @FindBy(xpath = "//label[normalize-space()='Password']/following::input[1]")
    private WebElement txtPassword;

    @FindBy(xpath = "//label[normalize-space()='Confirm Password']/following::input[1]")
    private WebElement txtConfirmPassword;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement btnSave;

    public AddUserPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void setUserRole() {
        wait.until(ExpectedConditions.visibilityOf(slctUserRole));
        slctUserRole.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void setEmployeeName(String employeeName) throws InterruptedException {
        txtEmployeeName.sendKeys(employeeName);
        Thread.sleep(2000);
        txtEmployeeName.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void setUserStatus() {
        slctUserStatus.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void setUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        txtConfirmPassword.sendKeys(password);
    }

    public void clickSaveUser() {
        btnSave.click();
    }
}
