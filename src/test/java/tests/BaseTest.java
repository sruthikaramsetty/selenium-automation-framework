package tests;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");

        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "profile.password_manager_leak_detection", false
        ));

        // Launch Chrome
        driver = new ChromeDriver(options);

        // Maximize browser
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        // Open application
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (driver != null) {
            driver.quit();
        }
    }
}