package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalDetailsPage extends BasePage{

    @FindBy(xpath = "//div/label[normalize-space()='Other Id']/following::input[1]")
    private WebElement txtOtherID;

    @FindBy(xpath = "//div/label[normalize-space()=\"Driver's License Number\"]/following::input[1]")
    private WebElement txtDriverLicense;

    @FindBy(xpath = "//div/label[normalize-space()='License Expiry Date']/following::input[1]")
    private WebElement txtLicenseExpiryDate;

    @FindBy(xpath = "//div/label[normalize-space()='Nationality']/following::div[4]")
    private WebElement btnNationality;

    @FindBy(xpath = "//div/label[normalize-space()='Marital Status']/following::div[4]")
    private WebElement btnMaritalStatus;

    @FindBy(xpath = "//div/label[normalize-space()='Date of Birth']/following::input[1]")
    private WebElement txtDateOfBirth;

    @FindBy(xpath = "//p/following-sibling::button")
    private WebElement btnSave;

    public PersonalDetailsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void setOtherID(String otherId){
        wait.until(ExpectedConditions.visibilityOf(txtOtherID));
        txtOtherID.click();
        txtOtherID.sendKeys(otherId);
    }

    public void setDriverLicense(String driverLicense) {
        wait.until(ExpectedConditions.visibilityOf(txtDriverLicense));
        txtDriverLicense.sendKeys(driverLicense);
    }

    public void setLicenseExpiryDate(String date) {
        wait.until(ExpectedConditions.visibilityOf(txtLicenseExpiryDate));
        txtLicenseExpiryDate.sendKeys(date);
    }

    public void clickAndSelectNationality() {
        btnNationality.click();
        btnNationality.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void clickAndSelectMaritalStatus() {
        btnMaritalStatus.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void setDateOfBirth(String birthDate) {
        wait.until(ExpectedConditions.visibilityOf(txtDateOfBirth));
        txtDateOfBirth.sendKeys(birthDate);
    }

    public void checkGender(String gender) {
        driver.findElement(By.xpath("//label[normalize-space()="+ "'"+ gender +"'"+"]")).click();
    }

    public void clickSave() {
        wait.until(ExpectedConditions.visibilityOf(btnSave));
        btnSave.click();
    }
}
