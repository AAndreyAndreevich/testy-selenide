package saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    private final static SelenideElement PRODUCT_NAME =
            $x("//div[@class='inventory_details_name large_size']");
    private final static SelenideElement PRODUCT_PRICE =
            $x("//div[@class='inventory_details_price']");
    private final static SelenideElement PRODUCT_DESCRIPTION =
            $x("//div[@class='inventory_details_desc large_size']");
    private final static SelenideElement ADD_TO_CART_BUTTON =
            $x("//button[@class='btn btn_primary btn_small btn_inventory']");
    private final static SelenideElement REMOVE_FROM_CART =
            $x("//button[@class='btn btn_secondary btn_small btn_inventory']");

}