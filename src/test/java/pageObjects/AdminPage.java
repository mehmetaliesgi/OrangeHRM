package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage{
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;
    public AdminPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAddUser() {
        wait.until(ExpectedConditions.visibilityOf(btnAdd));
        btnAdd.click();
    }
}
