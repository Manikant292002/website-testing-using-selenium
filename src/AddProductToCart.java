import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddProductToCart {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chetan\\Desktop\\software testing\\seleniumtesting\\.vscode\\chromedriver\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait with 10 seconds timeout

        try {
            // Open Flipkart website and maximize window
            driver.get("https://www.flipkart.com");
            driver.manage().window().maximize();
            System.out.println("Website opened.");

            // Close login popup if it appears
            try {
                WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), '✕')]")));
                closePopup.click();
                System.out.println("Login popup closed.");
            } catch (Exception e) {
                System.out.println("Login popup not found or already closed.");
            }

            // Search for the product
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            searchBox.sendKeys("iphone 15 pro max");
            searchBox.submit();
            System.out.println("Search submitted.");

            // Wait for search results to load and select the product
            WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/apple-iphone-15-pro-max-blue-titanium-256-gb/p/itm')]")));
            productLink.click();
            System.out.println("Product link clicked.");

            // Switch to the new window
            String mainPage = driver.getWindowHandle();
            for (String page : driver.getWindowHandles()) {
                if (!page.equals(mainPage)) {
                    driver.switchTo().window(page);
                    break;
                }
            }

            // Print current URL of the new page
            System.out.println("Current URL: " + driver.getCurrentUrl());

            // Wait for product details to load and add product to cart
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to cart']")));
            addToCartButton.click();
            System.out.println("Product added to cart.");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
