package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ContactsPage extends BasePage{

    @Step("Check contacts page")
    public ContactsPage checkPageText(String value) {
        $("body").shouldHave(text(value));
        return this;
    }
}
