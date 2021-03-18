package seleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public Properties prop = new Properties();

    public WebDriver driverInitialize(String browserName) throws IOException {
        //based on browser we should run the below
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
        //load is method which can take fis as argument
        prop.load(fis);
        ;
        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            System.setProperty("webdriver.chrome.driver", "/Users/mertm/Desktop/chromedriver");
            driver = new ChromeDriver(options);
        }

        //execute in chrome
        else if (browserName.equals("firefox")) {
            FirefoxOptions option = new FirefoxOptions();
            option.addArguments("--disable-notifications");
            System.setProperty("webdriver.gecko.driver", "/Users/mertm/Desktop/geckodriver");
            driver = new FirefoxDriver(option);
            // execute in firefox
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}