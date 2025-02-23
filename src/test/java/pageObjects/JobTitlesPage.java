package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobTitlesPage extends BasePage {
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;

    public JobTitlesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAddJobTitles() { btnAdd.click(); }
}
