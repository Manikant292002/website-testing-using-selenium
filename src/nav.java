import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class nav {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chetan\\Desktop\\software testing\\seleniumtesting\\.vscode\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        
        try {
            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), '✕')]")));
            closePopup.click();
        } catch (Exception e) {
            // No popup to close
        }

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys("laptop");
        searchBox.submit();
        
        System.out.println("Product search executed.");
        
        driver.quit();
    }
}
