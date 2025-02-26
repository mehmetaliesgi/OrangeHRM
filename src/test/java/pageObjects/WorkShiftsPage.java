package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkShiftsPage extends BasePage {
    @FindBy(xpath = "//h6[text()='Work Shifts']")
    private WebElement txtWorkShiftsHeader;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;

    public WorkShiftsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isWorkShiftsPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(txtWorkShiftsHeader));
        try {
            return txtWorkShiftsHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAddWorkShiftButton() {
        btnAdd.click();
    }

    public boolean doesInsetedDataDisplayed(String workShiftName) {
        WebElement workShiftEl = driver.findElement(By.xpath("//div[@class='oxd-table']//div[text()='" + workShiftName + "']"));
        wait.until(ExpectedConditions.visibilityOf(workShiftEl));

        try {
            return workShiftEl.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
