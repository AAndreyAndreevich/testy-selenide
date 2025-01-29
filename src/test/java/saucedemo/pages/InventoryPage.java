package saucedemo.pages;

import com.codeborne.selenide.*;
import saucedemo.enums.EnumFilter;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class InventoryPage {

    private final static ElementsCollection PRODUCTS_LIST =
            $$x("//div[@class='inventory_list']//div[@class='inventory_item_img']");
    private final static SelenideElement BACK_TO_LIST =
            $x("//button[@class='btn btn_secondary back btn_large inventory_details_back_button']");
    private final static SelenideElement MENU = $x("//button[@id='react-burger-menu-btn']");
    private final static SelenideElement LOGOUT = $x("//a[@id='logout_sidebar_link']");
    private final static SelenideElement SHOPPING_CART = $x("//a[@class='shopping_cart_link']");
    private final static SelenideElement FILTER = $x("//select[@class='product_sort_container']");
    private final static SelenideElement ADD_TO_CART =
            $x("//button[@class='btn btn_primary btn_small btn_inventory ']");
    private final static SelenideElement REMOVE_FROM_CART =
            $x("//button[@class='btn btn_secondary btn_small btn_inventory ']");
//    private final static SelenideElement TWITTER = $x("");
//    private final static SelenideElement FACEBOOK = $x("");
//    private final static SelenideElement LINKEDIN = $x("");


    public static void setFilter(EnumFilter filter) {
        if (FILTER.isDisplayed()) {
            switch (filter) {
                case NAME_A_TO_Z -> FILTER.selectOption(0);
                case NAME_Z_TO_A -> FILTER.selectOption(1);
                case PRICE_LOW_TO_HIGH -> FILTER.selectOption(2);
                case PRICE_HIGH_TO_LOW -> FILTER.selectOption(3);
            }
        }
    }

    public static void clickFirstProduct() {
        PRODUCTS_LIST
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .filter(Condition.visible)
                .first()
                .click();
    }
    public static void clickRandomProduct() {
        PRODUCTS_LIST
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .filter(Condition.visible)
                .get(new Random().nextInt(PRODUCTS_LIST.size()))
                .click();
    }


    public static void backToList() {
        if (BACK_TO_LIST.isDisplayed()) {
            BACK_TO_LIST.click();
        }
    }

    public static SelenideElement getBackToList() {
        return BACK_TO_LIST;
    }
    public static SelenideElement getMenu() {
        return MENU;
    }
    public static SelenideElement getLogout() {
        return LOGOUT;
    }
    public static void toShoppingCart() {
        SHOPPING_CART.click();
    }
}