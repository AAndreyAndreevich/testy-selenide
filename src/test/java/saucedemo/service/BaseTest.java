package saucedemo.service;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.browserSize = "1400x1000";
        Configuration.headless = false;
        Selenide.open("https://www.saucedemo.com/");
    }

    @AfterSuite
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}