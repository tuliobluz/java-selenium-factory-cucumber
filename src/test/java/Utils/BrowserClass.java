package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserClass {
    ConfigFileReader configFileReader;

    // instance of singleton class
    private static BrowserClass instanceOfBrowserClass = null;

    private WebDriver driver;

    // Constructor
    private BrowserClass() {
        configFileReader= new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
    }

    // TO create instance of class
    public static BrowserClass getInstanceOfSingletonBrowserClass() {
        if (instanceOfBrowserClass == null) {
            instanceOfBrowserClass = new BrowserClass();
        }
        return instanceOfBrowserClass;
    }

    // To get driver
    public WebDriver getDriver() {
        return driver;
    }


}