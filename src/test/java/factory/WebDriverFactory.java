package factory;

public class WebDriverFactory {
    public static void setWebDriver(String driver) {
        if (driver.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }
}