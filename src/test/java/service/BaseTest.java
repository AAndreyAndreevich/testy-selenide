package service;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import factory.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public static void setUp() {
        WebDriverFactory.setWebDriver("edge");
        Configuration.browserSize = "1400x1000";
        Configuration.headless = false;
    }

    @AfterSuite
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}