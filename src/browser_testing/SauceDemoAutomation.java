package browser_testing;
/**
 * Project-4 - ProjectName : com-saucedemo
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class SauceDemoAutomation {
    static String baseURL = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Use scanner to get browser choice from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the browser name (Chrome/Firefox/Edge): ");
        String browser = scanner.nextLine();
        // Multi Browser choice
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
            return; // exit the program if the browser name is incorrect
        }
        // Step 1: Setup Chrome Browser
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        // Step 2: Open URL
        driver.get(baseURL);
        Thread.sleep(5000);
        // Step 3: Print the title of the page
        System.out.println("Title of the page: " + driver.getTitle());
        // Step 4: Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());
        // Step 5: Print the page source
        System.out.println("Page Source: " + driver.getPageSource());
        // Step 6: Enter email to email field
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("prime@gmail.com");
        // Step 7: Enter password to password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("123456");
        // Step 8: Click on Login Button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        // Step 9: Print the current URL after login
        System.out.println("Current URL after login: " + driver.getCurrentUrl());
        // Step 10: Navigate to baseURL
        driver.navigate().to(baseURL);
        // Step 11: Refresh the page
        driver.navigate().refresh();
        // Step 12: Close the browser
        driver.quit();
        // Close scanner
        scanner.close();
    }
}
