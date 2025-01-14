package service;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import factory.WebDriverFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Arrays;

public class BaseTest {

    @BeforeSuite
    public static void setUp(ITestContext context) {
        Arrays.stream(context.getAllTestMethods()).forEach(x->x.setRetryAnalyzerClass(TestNgRetry.class));
        WebDriverFactory.setWebDriver("edge");
        Configuration.browserSize = "1400x1000";
        Configuration.headless = false;
    }

    @AfterSuite
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}