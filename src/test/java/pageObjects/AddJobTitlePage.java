package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddJobTitlePage extends BasePage {
    @FindBy(xpath = "//label[normalize-space()='Job Title']/following::input[1]")
    private WebElement txtJobTitle;

    @FindBy(xpath = "//textarea[@placeholder='Type description here']")
    private WebElement txtareaJobDescription;

    @FindBy(xpath = "//label[normalize-space()='Job Specification']/following::div[normalize-space()='Browse']")
    private WebElement btnBrowse;

    @FindBy(xpath = "//textarea[@placeholder='Add note']")
    private WebElement txtareaAddNote;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement btnSave;

    public AddJobTitlePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void setJobTitle(String jobTitle) {
        wait.until(ExpectedConditions.visibilityOf(txtJobTitle));
        txtJobTitle.sendKeys(jobTitle);
    }

    public void setJobDescription(String description) {
        txtareaJobDescription.sendKeys(description);
    }

    public void addJobSpesification(String filePath) {
        btnBrowse.click();
        addAttachmentFile(filePath);
    }

    public void addNote(String note) {
        txtareaAddNote.sendKeys(note);
    }

    public void clickSaveJobTitle() {
        btnSave.click();
    }
}
