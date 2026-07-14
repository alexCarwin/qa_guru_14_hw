package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    private final SelenideElement cartSum = $("#cart-sum");
    private final SelenideElement acceptCookiesButton = $("button[onclick='setCookieConsent(true)']");


    @Step("Accept cookies")
    public BasePage acceptCookies() {
        acceptCookiesButton.click();
        return this;
    }

    @Step("Check that cart is empty")
    public BasePage checkCartIsEmpty() {
        cartSum.shouldHave(text("0.00 ₽"));
        return this;
    }


}
