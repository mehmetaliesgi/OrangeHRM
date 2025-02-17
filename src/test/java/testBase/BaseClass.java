package testBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class BaseClass {
    public static WebDriver driver;
    public Logger logger;
    public Properties properties;
    public WebDriverWait wait;

    @BeforeClass
    @Parameters({"os", "browser"})
    public void setup(String os, String browser) throws IOException {
        logger = LogManager.getLogger(this.getClass());

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        FileReader file =new FileReader("C:\\Users\\mehme\\Desktop\\Selenium_Projects\\OrangeHRM\\src\\test\\resources\\config.properties");
        properties = new Properties();
        properties.load(file);

        switch (browser.toLowerCase()) {
            case "chrome": driver = new ChromeDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default:
                System.out.println("Invalid browser name...");
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(properties.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public String captureScreen(String testName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilepath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timeStamp + ".png";

        File targetFile = new File(targetFilepath);

        sourceFile.renameTo(targetFile);

        return "\\screenshots\\" + testName + "_" + timeStamp + ".png";
    }
}
