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

    @BeforeTest
    public void openSite() {
        //рекомендуется запускать эти тесты в edge
        WebDriverFactory.setWebDriver(EnumDriver.EDGE);
        Selenide.open("https://www.saucedemo.com/");
    }

    @Test
    @Description("Попытка входа на заблокированную учетную запись")
    public void lockedUserTest() {
        LoginPage.logIn(EnumUser.LOCKED);
        Assert.assertTrue(LoginPage.getLockedInfo().isDisplayed());
    }

    @Test
    @Description("Открывает первый элемент из списка продуктов")
    public void firstItemClickTest() {
        LoginPage.logIn(EnumUser.STANDARD);
        InventoryPage.clickFirstProduct();
        Assert.assertTrue(InventoryPage.getBackToList().isDisplayed());
    }

    @Test
    @Description("Открывает случайный элемент из списка продуктов")
    public void randomItemClickTest() {
        LoginPage.logIn(EnumUser.STANDARD);
        InventoryPage.clickRandomProduct();
        Assert.assertTrue(InventoryPage.getBackToList().isDisplayed());
    }

//    @Test
//    @Description("Покупка первой вещи из каталога используя стандартного пользователя")
//    public void buyFirstItemTest() {
//        LoginPage.logIn(EnumUser.STANDARD);
//        InventoryPage.clickFirstProduct();
//
//    }

    @Test
    public void filterTest() {
        LoginPage.logIn(EnumUser.STANDARD);
        InventoryPage.setFilter(EnumFilter.PRICE_HIGH_TO_LOW);
        InventoryPage.setFilter(EnumFilter.PRICE_LOW_TO_HIGH);
        InventoryPage.setFilter(EnumFilter.NAME_Z_TO_A);
        InventoryPage.setFilter(EnumFilter.NAME_A_TO_Z);
    }
}