import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PreLoginTest {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chetan\\Desktop\\software testing\\seleniumtesting\\.vscode\\chromedriver\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Navigate to the website
            driver.get("https://www.flipkart.com");
            driver.manage().window().maximize();
            System.out.println("Navigated to Flipkart.");

            // Check if captcha or password entry field is present
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='captcha']")));
                System.out.println("Captcha field is present.");
            } catch (Exception e) {
                System.out.println("Captcha field is not found or not required.");
            }

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
                System.out.println("Password entry field is present.");
            } catch (Exception e) {
                System.out.println("Password entry field is not found.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
