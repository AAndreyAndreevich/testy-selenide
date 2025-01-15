package saucedemo;

import com.codeborne.selenide.Selenide;
import enums.EnumDriver;
import enums.EnumFilter;
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

    @BeforeTest(groups = "saucedemo")
    public void openSite() {
        //рекомендуется запускать эти тесты в edge
        WebDriverFactory.setWebDriver(EnumDriver.EDGE);
        Selenide.open("https://www.saucedemo.com/");
    }

    @Test(groups = "saucedemo", priority = 1)
    @Description("Попытка входа на заблокированную учетную запись")
    public void lockedUserTest() {
        LoginPage.logIn(EnumUser.LOCKED);
        Assert.assertTrue(LoginPage.getLockedInfo().isDisplayed());
    }

    @Test(groups = "saucedemo", priority = 2)
    @Description("Открывает первый элемент из списка продуктов")
    public void firstItemClickTest() {
        LoginPage.logIn(EnumUser.STANDARD);
        InventoryPage.clickFirstProduct();
        Assert.assertTrue(InventoryPage.getBackToList().isDisplayed());
    }

    @Test(groups = "saucedemo", priority = 3)
    @Description("Открывает случайный элемент из списка продуктов")
    public void randomItemClickTest() {
        LoginPage.logIn(EnumUser.STANDARD);
        InventoryPage.clickRandomProduct();
        Assert.assertTrue(InventoryPage.getBackToList().isDisplayed());
    }

    @Test(groups = "saucedemo", priority = 4)
    @Description("Покупка первой вещи из каталога используя стандартного пользователя")
    public void buyFirstItemTest() {
        LoginPage.logIn(EnumUser.STANDARD);
        InventoryPage.clickFirstProduct();

    }

    @Test(groups = "saucedemo", priority = 5)
    public void filterTest() {
        LoginPage.logIn(EnumUser.STANDARD);
        InventoryPage.setFilter(EnumFilter.PRICE_HIGH_TO_LOW);
        InventoryPage.setFilter(EnumFilter.PRICE_LOW_TO_HIGH);
        InventoryPage.setFilter(EnumFilter.NAME_Z_TO_A);
        InventoryPage.setFilter(EnumFilter.NAME_A_TO_Z);
    }
}