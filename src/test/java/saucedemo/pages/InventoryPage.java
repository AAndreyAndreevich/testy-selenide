package saucedemo.pages;

import com.codeborne.selenide.*;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class InventoryPage {

    private final static ElementsCollection PRODUCTS_LIST =
            $$x("//div[@class='inventory_list']//div[@class='inventory_item_img']");
    private final static SelenideElement BACK_TO_LIST =
            $x("//button[@class='btn btn_secondary back btn_large inventory_details_back_button']");
    private final static SelenideElement MENU_BUTTON = $x("//button[@id='react-burger-menu-btn']");
    private final static SelenideElement LOGOUT_BUTTON = $x("//a[@id='logout_sidebar_link']");

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

    public static SelenideElement getBackToList() {
        return BACK_TO_LIST;
    }

    public static void backToList() {
        if (BACK_TO_LIST.isDisplayed()) {
            BACK_TO_LIST.click();
        }
    }

    public static SelenideElement getMenuButton() {
        return MENU_BUTTON;
    }
    public static SelenideElement getLogoutButton() {
        return LOGOUT_BUTTON;
    }
}