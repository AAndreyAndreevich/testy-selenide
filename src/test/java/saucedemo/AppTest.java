package saucedemo;

import com.codeborne.selenide.Selenide;
import enums.EnumDriver;
import enums.EnumUser;
import factory.WebDriverFactory;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import saucedemo.pages.InventoryPage;
import saucedemo.pages.LoginPage;
import service.BaseTest;
import org.testng.annotations.Test;

public class AppTest extends BaseTest {

    @BeforeTest
    public void openSite() {
        //рекомендуется запускать эти тесты в edge
        WebDriverFactory.setWebDriver(EnumDriver.EDGE);
        Selenide.open("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    @Description("Попытка входа на заблокированную учетную запись")
    public void lockedUserTest() {
        LoginPage.logIn(EnumUser.LOCKED);
        Assert.assertTrue(LoginPage.getLockedInfo().isDisplayed());
    }

    @Test(priority = 2)
    @Description("Открывает первый элемент из списка продуктов")
    public void firstItemClickTest() {
        InventoryPage.backToList();
        LoginPage.logIn(EnumUser.STANDARD);
        InventoryPage.clickFirstProduct();
        Assert.assertTrue(InventoryPage.getBackToList().isDisplayed());
        InventoryPage.backToList();
    }

    @Test(priority = 3)
    @Description("Открывает случайный элемент из списка продуктов")
    public void randomItemClickTest() {
        InventoryPage.backToList();
        LoginPage.logIn(EnumUser.STANDARD);
        InventoryPage.clickRandomProduct();
        Assert.assertTrue(InventoryPage.getBackToList().isDisplayed());
        InventoryPage.backToList();
    }

}