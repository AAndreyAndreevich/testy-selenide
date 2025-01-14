package factory;

import com.codeborne.selenide.Configuration;

public class WebDriverFactory {
    public static void setWebDriver(String driver) {
        switch (driver) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
                Configuration.browser = "chrome";
                break;
            case "edge":
                System.setProperty("webdriver.edge.verboseLogging", "src\\test\\resources\\drivers\\msedgedriver.exe");
                Configuration.browser = "edge";
                break;
            default:
                System.err.println("Такого драйвера нет, выберите 'edge' или 'chrome'");
                break;
        }
    }
}