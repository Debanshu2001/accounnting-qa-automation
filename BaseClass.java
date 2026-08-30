package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;

    public static void initializeDriver() {
        String browser = ConfigReader.get("browser");
        if (browser == null) {
            browser = "chrome";
        }

        switch (browser.toLowerCase().trim()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                // options.addArguments("--headless=new"); // uncomment for headless
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        int wait = Integer.parseInt(ConfigReader.get("implicitWait") != null
                ? ConfigReader.get("implicitWait") : "10");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.get(ConfigReader.get("url"));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
