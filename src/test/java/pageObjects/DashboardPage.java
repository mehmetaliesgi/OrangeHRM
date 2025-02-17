package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    private WebElement txtDashboardHeader;

    @FindBy(xpath = "//span[normalize-space()='PIM']")
    private WebElement btnPIM;

    public boolean isDashboardPageExist() {
        wait.until(ExpectedConditions.visibilityOf(txtDashboardHeader));
        try {
            return txtDashboardHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickPIM() {
        wait.until(ExpectedConditions.visibilityOf(btnPIM));
        btnPIM.click();
    }
}
