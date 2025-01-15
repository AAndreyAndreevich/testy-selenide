package factory;

import com.codeborne.selenide.Configuration;
import enums.EnumDriver;

public class WebDriverFactory {
    public static void setWebDriver(EnumDriver driver) {
        switch (driver) {
            case CHROME -> {
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
                Configuration.browser = "chrome";
            }
            case EDGE -> {
                System.setProperty("webdriver.edge.verboseLogging", "src\\test\\resources\\drivers\\msedgedriver.exe");
                Configuration.browser = "edge";
            }
        }
    }
}