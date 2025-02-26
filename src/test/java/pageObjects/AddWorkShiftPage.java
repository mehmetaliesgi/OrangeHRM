package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddWorkShiftPage extends BasePage {
    @FindBy(xpath = "//h6[normalize-space()='Add Work Shift']")
    private WebElement txtAddWorkShiftHeader;

    @FindBy(xpath = "//label[normalize-space()='Shift Name']/following::input[1]")
    private WebElement txtShiftName;

    @FindBy(xpath = "//p[normalize-space()='Working Hours *']/following::i[1]")
    private WebElement iFromHour;

    @FindBy(xpath = "//div[@class='oxd-time-hour-input']/input")
    private WebElement txtFromHour;

    @FindBy(xpath = "//div[@class='oxd-time-minute-input']/input")
    private WebElement txtFromMinute;

    @FindBy(xpath = "//p[normalize-space()='Working Hours *']/following::i[2]")
    private WebElement iToHour;

    @FindBy(xpath = "//div[@class='oxd-time-picker']//input[@class='oxd-input oxd-input--active oxd-time-hour-input-text']")
    private WebElement txtToHour;

    @FindBy(xpath = "//div[@class='oxd-time-picker']//input[@class='oxd-input oxd-input--active oxd-time-minute-input-text']")
    private WebElement txtToMinute;

    @FindBy(xpath = "//label[normalize-space()='Assigned Employees']/following::input[1]")
    private WebElement txtAssignedEmployees;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement btnSave;

    public AddWorkShiftPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isWorkShiftPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(txtAddWorkShiftHeader));
        try {
            return txtAddWorkShiftHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void setShiftName(String shiftName) {
        txtShiftName.sendKeys(shiftName);
    }

    public void setFromHour(String fromHour, String fromMinute, String period) {
        iFromHour.click();
        wait.until(ExpectedConditions.visibilityOf(txtFromHour));
        txtFromHour.sendKeys(fromHour);
        txtFromMinute.sendKeys(fromMinute);
        driver.findElement(By.xpath("//div[@class='oxd-time-period-input']//input[@value='" + period.toUpperCase() + "']")).click();
    }

    public void setToHour(String toHour, String toMinute, String period) {
        iToHour.click();
        wait.until(ExpectedConditions.visibilityOf(txtToHour));
        txtToHour.sendKeys(toHour);
        txtToMinute.sendKeys(toMinute);
        driver.findElement(By.xpath("//div[@class='oxd-time-period-input']//input[@value='" + period.toUpperCase() + "']")).click();
    }

    public void setAssignedEmployees(String employeeName) throws InterruptedException {
        txtAssignedEmployees.sendKeys(employeeName);
        Thread.sleep(1500);
        txtAssignedEmployees.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void clickSave() {
        btnSave.click();
    }


}
