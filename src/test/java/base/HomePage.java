package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    WebDriver driver;

    By promptArea = By.cssSelector("textarea[data-slot='textarea']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void writeAndSendMessage(String message) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputBox = wait.until(ExpectedConditions.elementToBeClickable(promptArea));

        inputBox.click();
        Thread.sleep(500);

        inputBox.sendKeys(message);
        Thread.sleep(1000);

        try {
            WebElement sendButton = driver.findElement(By.cssSelector("button[type='submit']"));
            sendButton.click();
            System.out.println("ACTION: 'Send' button clicked.");
        } catch (Exception e) {
            System.out.println("WARNING: Send button not found, attempting Enter key...");
            inputBox.sendKeys(Keys.ENTER);
        }
        Thread.sleep(3000);
    }
}
