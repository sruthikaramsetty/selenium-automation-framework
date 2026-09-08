package tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        // Take screenshot if test fails
        if (result.getStatus() == ITestResult.FAILURE) {

            TakesScreenshot screenshot =
                    (TakesScreenshot) driver;

            File source = screenshot.getScreenshotAs(OutputType.FILE);

            File destination = new File(
                    "screenshots/" + result.getName() + ".png"
            );

            try {
                destination.getParentFile().mkdirs();

                Files.copy(
                        source.toPath(),
                        destination.toPath(),
                        StandardCopyOption.REPLACE_EXISTING
                );

                System.out.println(
                        "Screenshot saved: " + destination.getAbsolutePath()
                );

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        driver.quit();
    }
}