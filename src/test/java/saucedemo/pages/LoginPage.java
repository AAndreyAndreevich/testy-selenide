package saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private static final SelenideElement USERNAME_ELEMENT = $x("//input[@placeholder='Username']");
    private static final SelenideElement PASSWORD_ELEMENT = $x("//input[@placeholder='Password']");
    private static final SelenideElement LOGIN_BUTTON = $x("//input[@value='Login']");
    private static final SelenideElement LOCKED_INFO = $x("//h3[@data-test='error']");

    private static final String password = "secret_sauce";

    private static boolean authorization;

    public static void standardUserLogin() {
        USERNAME_ELEMENT.setValue("standard_user");
        PASSWORD_ELEMENT.setValue(password);
        LOGIN_BUTTON.click();
        authorization = true;
    }

    public static void lockedOutUserLogin() {
        USERNAME_ELEMENT.setValue("locked_out_user");
        PASSWORD_ELEMENT.setValue(password);
        LOGIN_BUTTON.click();
        authorization = false;
    }

    public static void problemUserLogin() {
        USERNAME_ELEMENT.setValue("problem_user");
        PASSWORD_ELEMENT.setValue(password);
        LOGIN_BUTTON.click();
        authorization = true;
    }

    public static void performanceGlitchUserLogin() {
        USERNAME_ELEMENT.setValue("performance_glitch_user");
        PASSWORD_ELEMENT.setValue(password);
        LOGIN_BUTTON.click();
        authorization = true;
    }

    public static void errorUserLogin() {
        USERNAME_ELEMENT.setValue("error_user");
        PASSWORD_ELEMENT.setValue(password);
        LOGIN_BUTTON.click();
        authorization = true;
    }

    public static void visualUserLogin() {
        USERNAME_ELEMENT.setValue("visual_user");
        PASSWORD_ELEMENT.setValue(password);
        LOGIN_BUTTON.click();
        authorization = true;
    }

    public static SelenideElement getLockedInfo() {
        return LOCKED_INFO;
    }

    public static boolean isAuthorization() {
        return authorization;
    }
}