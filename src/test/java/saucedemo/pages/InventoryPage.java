package saucedemo.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class InventoryPage {

    private final static ElementsCollection PRODUCTS_LIST =
            $$x("//div[@class='inventory_list']//div[@class='inventory_item_img']");
    private final static SelenideElement BACK_TO_LIST =
            $x("//button[@class='btn btn_secondary back btn_large inventory_details_back_button']");

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
        if (InventoryPage.getBackToList().isDisplayed()) {
            InventoryPage.getBackToList().click();
        }
    }
}