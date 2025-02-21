package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmergencyContactsPage extends BasePage{

    @FindBy(xpath = "//h6[normalize-space()='Assigned Emergency Contacts']/following::button[1]")
    private WebElement btnAddEmergencyContact;

    @FindBy(xpath = "//label[normalize-space()='Name']/following::input[1]")
    private WebElement txtName;

    @FindBy(xpath = "//label[normalize-space()='Relationship']/following::input[1]")
    private WebElement txtRelationship;

    @FindBy(xpath = "//label[normalize-space()='Home Telephone']/following::input[1]")
    private WebElement txtHomePhone;

    @FindBy(xpath = "//label[normalize-space()='Mobile']/following::input[1]")
    private WebElement txtMobilePhone;

    @FindBy(xpath = "//label[normalize-space()='Work Telephone']/following::input[1]")
    private WebElement txtWorkPhone;

    @FindBy(xpath = "//p[normalize-space()='* Required']/following::button[normalize-space()='Save']")
    private WebElement btnSaveEmergencyContact;

    @FindBy(xpath = "//h6[normalize-space()='Attachments']/following::button[normalize-space()='Add']")
    private WebElement btnAddAttachments;

    @FindBy(xpath = "//div[normalize-space()='Browse']")
    private WebElement divBrowse;

    @FindBy(xpath = "//textarea[@placeholder='Type comment here']")
    private WebElement txtareaComment;

    @FindBy(xpath = "//h6[normalize-space()='Add Attachment']/following::button[normalize-space()='Save']")
    private WebElement btnSaveAttachments;

    @FindBy(xpath = "//div[contains(span, 'Record Found')]")
    private WebElement txtRecordFound;

    public EmergencyContactsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAddEmergencyContact() {
        wait.until(ExpectedConditions.visibilityOf(btnAddEmergencyContact));
        btnAddEmergencyContact.click();
    }

    public void setName(String contactName) {
        txtName.sendKeys(contactName);
    }

    public void setRelationship(String contactRelationship) {
        txtRelationship.sendKeys(contactRelationship);
    }

    public void setHomePhone(String contactHomePhone) {
        txtHomePhone.sendKeys(contactHomePhone);
    }

    public void setMobilePhone(String contactMobilePhone) {
        txtMobilePhone.sendKeys(contactMobilePhone);
    }

    public void setWorkPhone(String contactWorkPhone) {
        txtWorkPhone.sendKeys(contactWorkPhone);
    }

    public void clickSaveEmergencyContact() {
        btnSaveEmergencyContact.click();
    }

    public void clickAddAttachments() {
        btnAddAttachments.click();
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
