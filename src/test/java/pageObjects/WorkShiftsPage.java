package pageObjects;

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


}
