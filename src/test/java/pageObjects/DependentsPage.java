package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DependentsPage extends BasePage{
    @FindBy(xpath = "//h6[normalize-space()='Assigned Dependents']/following::button[1]")
    private WebElement btnAssignedDependents;

    @FindBy(xpath = "//label[normalize-space()='Name']/following::input[1]")
    private WebElement txtName;

    @FindBy(xpath = "//label[normalize-space()='Relationship']/following::div[4]")
    private WebElement slctRelationship;

    @FindBy(xpath = "//label[normalize-space()='Date of Birth']/following::input[1]")
    private WebElement txtDateOfBirth;

    @FindBy(xpath = "//p[normalize-space()='* Required']/following::button[normalize-space()='Save']")
    private WebElement btnSaveDependents;

    @FindBy(xpath = "//h6[normalize-space()='Attachments']/following::button[normalize-space()='Add']")
    private WebElement btnAddAttachment;

    @FindBy(xpath = "//div[normalize-space()='Browse']")
    private WebElement divBrowse;

    @FindBy(xpath = "//textarea[@placeholder='Type comment here']")
    private WebElement txtareaComment;

    @FindBy(xpath = "//h6[normalize-space()='Add Attachment']/following::button[normalize-space()='Save']")
    private WebElement btnSaveAttachments;

    @FindBy(xpath = "//div[contains(span, 'Record Found')]")
    private WebElement txtRecordFound;

    public DependentsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAddDependents() {
        wait.until(ExpectedConditions.visibilityOf(btnAssignedDependents));
        btnAssignedDependents.click();
    }

    public void setName(String name) {
        wait.until(ExpectedConditions.visibilityOf(txtName));
        txtName.sendKeys(name);
    }

    public void setRelationship() {
        slctRelationship.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void setDateOfBirth(String date) {
        txtDateOfBirth.sendKeys(date);
    }

    public void clickSaveDependents() {
        btnSaveDependents.click();
    }

    public void clickAddAttachment() {
        btnAddAttachment.click();
    }

    public void clickBrowse(String url) {
        wait.until(ExpectedConditions.visibilityOf(divBrowse));
        divBrowse.click();
        addAttachmentFile(url);
    }

    public void setComment(String comment) {
        txtareaComment.sendKeys(comment);
    }

    public void clickSaveAttachment() {
        btnSaveAttachments.click();
    }

    public boolean isRecordFound() {
        wait.until(ExpectedConditions.visibilityOf(txtRecordFound));
        try {
            return txtRecordFound.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
