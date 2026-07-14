package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ReelsPage extends BasePage{

    @Step("Check reels page")
    public ReelsPage checkPageText(String value) {
        $("body").shouldHave(text(value));
        return this;
    }
}
