package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage extends BasePage{
    public PIMPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//h6[normalize-space()='PIM']")
    private WebElement txtPIMHeader;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;

    @FindBy(name = "firstName")
    private WebElement txtFirstName;

    @FindBy(name = "middleName")
    private WebElement txtMiddleName;

    @FindBy(name = "lastName")
    private WebElement txtLastName;

    @FindBy(xpath = "//div/label[normalize-space()='Employee Id']/following::input[1]")
    private WebElement txtEmployeeID;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement btnSave;

    @FindBy(xpath = "//h6[normalize-space()='Personal Details']")
    private WebElement txtPersonalDetails;

    public boolean isPIMHeaderDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(txtPIMHeader));
        try {
            return txtPIMHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAdd() {
        wait.until(ExpectedConditions.visibilityOf(btnAdd));
        btnAdd.click();
    }

    public void setFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(txtFirstName));
        txtFirstName.sendKeys(firstName);
    }

    public void setMiddleName(String middleName) {
        wait.until(ExpectedConditions.visibilityOf(txtFirstName));
        txtMiddleName.sendKeys(middleName);
    }

    public void setLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(txtFirstName));
        txtLastName.sendKeys(lastName);
    }

    public void setEmployeeID(String employeeID) {
        wait.until(ExpectedConditions.visibilityOf(txtEmployeeID));
        txtEmployeeID.clear();
        txtEmployeeID.sendKeys(employeeID);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.visibilityOf(btnSave));
        btnSave.click();
    }

    public boolean isPersonalDetailDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(txtPersonalDetails));
        try {
            return txtPersonalDetails.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
