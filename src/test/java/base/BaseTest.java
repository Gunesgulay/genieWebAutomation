package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://chatbotai.com");
        System.out.println("SETUP: Browser opened and navigated to the website.");
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("TEARDOWN: Browser closed.");
        }
    }
}
