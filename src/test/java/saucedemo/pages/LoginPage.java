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

    public static SelenideElement getLockedInfo() {
        return LOCKED_INFO;
    }

    public static boolean isAuthorization() {
        return !authorization;
    }

    public static void logIn(String username) {
        if (LoginPage.isAuthorization()) {
            switch (username) {
                case "standard_user":
                    USERNAME_ELEMENT.setValue("standard_user");
                    break;
                case "locked_out_user":
                    USERNAME_ELEMENT.setValue("locked_out_user");
                    break;
                case "problem_user":
                    USERNAME_ELEMENT.setValue("problem_user");
                    break;
                case "performance_glitch_user":
                    USERNAME_ELEMENT.setValue("performance_glitch_user");
                    break;
                case "error_user":
                    USERNAME_ELEMENT.setValue("error_user");
                    break;
                case "visual_user":
                    USERNAME_ELEMENT.setValue("visual_user");
                    break;
                default:
                    System.err.println("Данного пользователя не существует");
                    break;
            }
            PASSWORD_ELEMENT.setValue(password);
            LOGIN_BUTTON.click();
            authorization = !username.equals("locked_out_user");
        }
    }
}