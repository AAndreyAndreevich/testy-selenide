package googlesearch;

import com.codeborne.selenide.Selenide;
import factory.WebDriverFactory;
import googlesearch.pages.GooglePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import saucedemo.enums.EnumDriver;

public class AppTest {

    @BeforeTest(groups = "google")
    public void openSite() {
        //рекомендуется запускать эти тесты в edge
        WebDriverFactory.setWebDriver(EnumDriver.CHROME);
        Selenide.open("https://www.google.com/");
    }

    @Test(groups = "google")
    public void searchNumberOneTest() {
        GooglePage.toSearch("число 1");
    }

}
