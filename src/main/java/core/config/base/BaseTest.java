package core.config.base;

import com.codeborne.selenide.Selenide;
import com.google.common.collect.ImmutableMap;
import core.config.SelenideConfig;
import core.config.TestListener;
import core.config.allure.AllureLogger;
import org.testng.annotations.*;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
@Listeners({TestListener.class})
public class BaseTest extends AllureLogger {

    @BeforeSuite(alwaysRun = true, description = "Opening web browser...")
    public void setUp() {
        logInfo("Creating web driver configuration...");
        SelenideConfig.createBrowserConfig(System.getProperty("browser", "chrome"));

        logInfo("Writing down testing environment details...");
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", System.getProperty("browser", "chrome"))
                        .put("Browser.Version", System.getProperty("browserVersion", "107.0.5304.62"))
                        .put("URL", System.getProperty("base.url", "https://www.saucedemo.com/inventory.html"))
                        .build());


//        SelenideConfig.createBrowserConfig(System.getProperty("browser", "firefox"));
        logInfo("Open browser...");
    }
    @BeforeMethod(alwaysRun = true, description = "Opening base.url...")
    public void openUrl(){
        Selenide.open(System.getProperty("base.url", "https://www.saucedemo.com/inventory.html"));
    }


    @AfterMethod(alwaysRun = true, description = "Web driver cleanup...")
    public void cleanWebDriver(){
        Selenide.clearBrowserCookies();
        Selenide.refresh();
        Selenide.open("about:blank");
    }

    @AfterSuite(alwaysRun = true, description = "Closing web browser...")
    public void tearDown() {
        Selenide.closeWebDriver();
        logInfo("Web driver closed!");
    }

}
