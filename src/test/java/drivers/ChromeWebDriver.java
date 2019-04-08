package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.logging.Level;

public class ChromeWebDriver {

    WebDriver webDriver;

    public ChromeWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("no-default-browser-check");
        chromeOptions.addArguments("disable-default-apps");
        chromeOptions.addArguments("start-maximized");
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        this.webDriver = new ChromeDriver(chromeOptions);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
