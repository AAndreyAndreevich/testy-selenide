package saucedemo;

import com.codeborne.selenide.Selenide;
import enums.EnumDriver;
import enums.EnumFilter;
import enums.EnumUser;
import factory.WebDriverFactory;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import saucedemo.pages.*;
import service.BaseTest;
import org.testng.annotations.Test;

public class AppTest extends BaseTest {

    private final String FIRST_NAME  = "Jocelyn";
    private final String LAST_NAME = "Flores";
    private final String POSTAL_CODE = "10450";
    private final String COMPLETE_TEXT = "Thank you for your order!";

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
    @Description("Попытка покупки первой вещи из каталога используя стандартного пользователя, ожидает просьбу указать данные")
    public void buyFirstItemThisErrorTest() {
        LoginPage.logIn(EnumUser.STANDARD);
        InventoryPage.clickFirstProduct();
        ProductPage.addToCart();
        InventoryPage.toShoppingCart();
        ShoppingCartPage.acceptOrder();
        CheckoutPage.userInfoBuilder(null, null, null);
        CheckoutPage.acceptAndContinue();
        Assert.assertTrue(CheckoutPage.getErrorMessage().isDisplayed());
    }

    @Test(groups = "saucedemo", priority = 5)
    @Description("Попытка покупки первой вещи из каталога используя стандартного пользователя")
    public void buyFirstItemWithoutErrorTest() {
        LoginPage.logIn(EnumUser.STANDARD);
        InventoryPage.clickFirstProduct();
        ProductPage.addToCart();
        InventoryPage.toShoppingCart();
        ShoppingCartPage.acceptOrder();
        CheckoutPage.userInfoBuilder(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        CheckoutPage.acceptAndContinue();
        CheckoutPage.finishCreateOrder();
        Assert.assertEquals(CheckoutPage.getCompleteText(), COMPLETE_TEXT);
    }

    @Test(groups = "saucedemo", priority = 6)
    @Description("Попытка покупки первой вещи из каталога используя фильтр")
    public void buyFirstItemWithFilter() {
        LoginPage.logIn(EnumUser.STANDARD);
        InventoryPage.setFilter(EnumFilter.PRICE_LOW_TO_HIGH);
        InventoryPage.clickFirstProduct();
        ProductPage.addToCart();
        InventoryPage.toShoppingCart();
        ShoppingCartPage.acceptOrder();
        CheckoutPage.userInfoBuilder(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        CheckoutPage.acceptAndContinue();
        CheckoutPage.finishCreateOrder();
        Assert.assertEquals(CheckoutPage.getCompleteText(), COMPLETE_TEXT);
    }
}