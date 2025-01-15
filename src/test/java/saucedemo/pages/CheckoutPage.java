package saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckoutPage {

    private final static SelenideElement CANCEL =
            $x("//button[@class='btn btn_secondary back btn_medium cart_cancel_link']");
    private final static SelenideElement CONTINUE =
            $x("//input[@class='submit-button btn btn_primary cart_button btn_action']");
    private final static SelenideElement FIRST_NAME = $x("//input[@placeholder='First Name']");
    private final static SelenideElement LAST_NAME = $x("//input[@placeholder='Last Name']");
    private final static SelenideElement ZIP_OR_POSTAL_CODE = $x("//input[@placeholder='Zip/Postal Code']");
    private final static SelenideElement ERROR_MESSAGE = $x("//button[@class='error-button']");
    private final static SelenideElement FINISH =
            $x("//button[@class='btn btn_action btn_medium cart_button']");
    private final static SelenideElement COMPLETE_HEADER = $x("//h2[@class='complete-header']");

    public static void userInfoBuilder(String firstName, String lastName, String zipOrPostalCode) {
        FIRST_NAME.setValue(firstName);
        LAST_NAME.setValue(lastName);
        ZIP_OR_POSTAL_CODE.setValue(zipOrPostalCode);
    }

    public static SelenideElement getErrorMessage() {
        return ERROR_MESSAGE;
    }

    public static void acceptAndContinue() {
        CONTINUE.click();
    }
    public static void finishCreateOrder() {
        FINISH.click();
    }
    public static String getCompleteText() {
        return COMPLETE_HEADER.getText();
    }

}
