package saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ShoppingCartPage {
    private final static SelenideElement CHECKOUT =
            $x("//button[@class='btn btn_action btn_medium checkout_button ']");
    private final static SelenideElement REMOVE =
            $x("//button[@class='btn btn_secondary btn_small cart_button']");
    private final static SelenideElement CONTINUE_SHOPPING =
            $x("//button[@class='btn btn_secondary back btn_medium']");
    private final static SelenideElement CANCEL =
            $x("//button[@class='btn btn_secondary back btn_medium cart_cancel_link']");
    private final static SelenideElement CONTINUE =
            $x("//input[@class='submit-button btn btn_primary cart_button btn_action']");
    private final static SelenideElement FIRST_NAME = $x("//input[@placeholder='First Name']");
    private final static SelenideElement LAST_NAME = $x("//input[@placeholder='Last Name']");
    private final static SelenideElement ZIP_POSTAL_CODE = $x("//input[@placeholder='Zip/Postal Code']");

    public static void acceptOrder() {
        CHECKOUT.click();
    }
}