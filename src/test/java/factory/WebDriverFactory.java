package factory;

public class WebDriverFactory {
    public static void setWebDriver(String driver) {
        switch (driver) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
                break;
            case "edge":
                System.setProperty("webdriver.edge.verboseLogging", "src\\test\\resources\\msedgedriver.exe");
                break;
            default:
                break;
        }
    }
}