package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobTitlesPage extends BasePage {
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;

    @FindBy(xpath = "//span[contains(normalize-space(),'Records Found')]")
    private WebElement txtRecordFound;

    public JobTitlesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAddJobTitles() {
        wait.until(ExpectedConditions.visibilityOf(btnAdd));
        btnAdd.click();
    }

    public boolean isRecordFoundDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(txtRecordFound));
        try {
            return txtRecordFound.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
