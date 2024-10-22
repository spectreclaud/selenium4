import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class Screenshots {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://applitools.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void takeWebElementsScreenshot() throws IOException {
        WebElement nextGenerationPlatform = driver.findElement(By.cssSelector("#h-maximum-coverage-minimum-time"));
        File source = nextGenerationPlatform.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        File destination = new File("nextGenerationPlatform.png");
        FileHandler.copy(source, destination);
    }

    @Test
    public void takeWebElementPageSectionScreenshot() throws IOException {
        WebElement appPageSection = driver.findElement(By.cssSelector("#h-maximum-coverage-minimum-time > br"));
        File source = appPageSection.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        FileUtils.copyFile(source, new File("app_page_section.png"));
    }

    @Test
    public void takeFullPageScreenshot() throws IOException {
        File source = ((FirefoxDriver)driver).getFullPageScreenshotAs(org.openqa.selenium.OutputType.FILE);
        FileHandler.copy(source, new File("full_page.png"));
    }
}
