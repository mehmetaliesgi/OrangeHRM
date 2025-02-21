package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.Key;

public class ContactDetailsPage extends BasePage{
    @FindBy(xpath = "//label[normalize-space()='Street 1']/following::input[1]")
    private WebElement txtStreet1;

    @FindBy(xpath = "//label[normalize-space()='Street 2']/following::input[1]")
    private WebElement txtStreet2;

    @FindBy(xpath = "//label[normalize-space()='City']/following::input[1]")
    private WebElement txtCity;

    @FindBy(xpath = "//label[normalize-space()='State/Province']/following::input[1]")
    private WebElement txtStateProvince;

    @FindBy(xpath = "//label[normalize-space()='Zip/Postal Code']/following::input[1]")
    private WebElement txtPostalCode;

    @FindBy(xpath = "//label[normalize-space()='Country']/following::div[4]")
    private WebElement divCountry;

    @FindBy(xpath = "//label[normalize-space()='Home']/following::input[1]")
    private WebElement txtPhoneHome;

    @FindBy(xpath = "//label[normalize-space()='Mobile']/following::input[1]")
    private WebElement txtPhoneMobile;

    @FindBy(xpath = "//label[normalize-space()='Work']/following::input[1]")
    private WebElement txtPhoneWork;

    @FindBy(xpath = "//label[normalize-space()='Work Email']/following::input[1]")
    private WebElement txtEmailWork;

    @FindBy(xpath = "//label[normalize-space()='Other Email']/following::input[1]")
    private WebElement txtEmailOther;

    @FindBy(xpath = "//h6[normalize-space()='Contact Details']/following::button[normalize-space()='Save'][1]")
    private WebElement btnSaveContactDetails;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAddAttachments;

    @FindBy(xpath = "//div[normalize-space()='Browse']")
    private WebElement divBrowse;

    @FindBy(xpath = "//textarea[@placeholder='Type comment here']")
    private WebElement txtareaComment;

    @FindBy(xpath = "//h6[normalize-space()='Add Attachment']/following::button[normalize-space()='Save']")
    private WebElement btnSaveAttachments;

    @FindBy(xpath = "//div[contains(span, 'Record Found')]")
    private WebElement txtRecordFound;

    public ContactDetailsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void setStreet1(String street1) {
        wait.until(ExpectedConditions.visibilityOf(txtStreet1));
        txtStreet1.click();
        txtStreet1.clear();
        txtStreet1.sendKeys(street1);
    }

    public void setStreet2(String street2) {
        txtStreet2.sendKeys(street2);
    }

    public void setCity(String city) {
        txtCity.sendKeys(city);
    }

    public void setStateProvince(String province) {
        txtStateProvince.sendKeys(province);
    }

    public void setPostalCode(String postalCode) {
        txtPostalCode.sendKeys(postalCode);
    }

    public void setCountry() {
        divCountry.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);;
    }

    public void setPhoneHome(String phone) {
        txtPhoneHome.sendKeys(phone);
    }

    public void setTxtPhoneMobile(String phone) {
        txtPhoneMobile.sendKeys(phone);
    }

    public void setTxtPhoneWork(String phone) {
        txtPhoneWork.sendKeys(phone);
    }

    public void setEmailWork(String email) {
        txtEmailWork.sendKeys(email);
    }

    public void setEmailOther(String email) {
        txtEmailOther.sendKeys(email);
    }

    public void clickSaveContactDetails() {
        btnSaveContactDetails.click();
    }

    public void clickAddAttachment() {
        scrollToElement(btnAddAttachments);
        wait.until(ExpectedConditions.visibilityOf(btnAddAttachments));
        btnAddAttachments.click();
    }

    public void addAttachment(String dest) {
        scrollToElement(btnSaveAttachments);
        divBrowse.click();
        addAttachmentFile(dest);
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
