package core.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



public class SelenideConfig {

        private static DesiredCapabilities getBrowserCapabilities() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (System.getProperty("remoteurl") != null) {
                capabilities.setBrowserName(System.getProperty("browserName", "chrome"));
                capabilities.setVersion(System.getProperty("browserVersion", "107.0.5304.62"));
                capabilities.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVnc", "true")));
                capabilities.setCapability("enableVideo", Boolean.parseBoolean(System.getProperty("enableVideo", "false")));
                capabilities.setCapability("sessionTimeout", "5m");
            }
            capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            return capabilities;
        }
    public static void createBrowserConfig(String browser) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");


        Configuration.browser = browser;
        Configuration.browserVersion ="107.0.5304.62";

        if (System.getProperty("remoteurl") != null) {
            Configuration.driverManagerEnabled = false;
            Configuration.remote = System.getProperty("remoteurl");
        }
        Configuration.holdBrowserOpen = true;

        Configuration.startMaximized = false;
//        Configuration.browserSize = "1920x1080";
        Configuration.fastSetValue = false;
        Configuration.savePageSource = false;
        Configuration.screenshots = true;
        Configuration.browserCapabilities = getBrowserCapabilities();
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.pollingInterval = 5000;
        Configuration.pageLoadStrategy = "normal";
        Configuration.pageLoadTimeout = 30000;
        Configuration.timeout = 10000;
        Configuration.reportsFolder = "screenshots";
    }
}
