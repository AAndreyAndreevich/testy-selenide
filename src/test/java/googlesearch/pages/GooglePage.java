package googlesearch.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GooglePage {

    private static final SelenideElement search = $("#APjFqb");

    public static void toSearch(String text) {
        search.setValue(text).pressEnter();
    }

}
