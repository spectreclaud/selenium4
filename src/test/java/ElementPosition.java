import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ElementPosition {
    private static final Logger log = LoggerFactory.getLogger(ElementPosition.class);
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationu.applitools.com/learningpaths.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void getPosition() {
        WebElement logoTAU = driver.findElement(By.xpath("//div[@id='app']//header/a/img"));
        Rectangle rectTAULogo = logoTAU.getRect();
        System.out.println("x: " + rectTAULogo.getX());
        System.out.println("y: " + rectTAULogo.getY());
        System.out.println("width: " + rectTAULogo.getWidth());
        System.out.println("height: " + rectTAULogo.getHeight());
    }
}
