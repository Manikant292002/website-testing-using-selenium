import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleVerificationTest {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chetan\\Desktop\\software testing\\seleniumtesting\\.vscode\\chromedriver\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to Flipkart homepage
            driver.get("https://www.flipkart.com");
            driver.manage().window().maximize();
            System.out.println("Navigated to Flipkart.");

            // Close login popup if it appears
            try {
                WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, '_2KpZ6l')]")));
                closePopup.click();
                System.out.println("Login popup closed.");
            } catch (Exception e) {
                System.out.println("Login popup not found or already closed.");
            }

            // Verify the presence of the search bar
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            if (searchBox.isDisplayed()) {
                System.out.println("Search box is visible.");
            } else {
                System.out.println("Search box is not visible.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
