package factory;

import com.codeborne.selenide.Configuration;
import enums.EnumDriver;

public class WebDriverFactory {
    public static void setWebDriver(EnumDriver driver) {
        switch (driver) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
                Configuration.browser = "chrome";
                break;
            case EDGE:
                System.setProperty("webdriver.edge.verboseLogging", "src\\test\\resources\\drivers\\msedgedriver.exe");
                Configuration.browser = "edge";
                break;
            default:
                System.err.println("Такого драйвера нет, выберите 'edge' или 'chrome'");
                System.exit(1);
        }
    }
}