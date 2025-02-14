import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigateAndClosePopup {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chetan\\Desktop\\software testing\\seleniumtesting\\.vscode\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.flipkart.com");
            driver.manage().window().maximize();
            System.out.println("Navigated to Flipkart.");

            // Close login popup if it appears
            try {
                WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), '✕')]")));
                closePopup.click();
                System.out.println("Login popup closed.");
            } catch (Exception e) {
                System.out.println("Login popup did not appear.");
            }

        } finally {
            driver.quit();
        }
    }
}
