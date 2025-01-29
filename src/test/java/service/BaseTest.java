package service;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Arrays;

public class BaseTest {

    @BeforeSuite
    public static void setUp(ITestContext context) {
        Arrays.stream(context.getAllTestMethods()).forEach(x->x.setRetryAnalyzerClass(TestNgRetry.class));
        Configuration.browserSize = "1400x1000";
        Configuration.headless = false;
    }

    @AfterSuite
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}