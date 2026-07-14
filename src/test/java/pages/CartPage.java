package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.CART_URL;


public class CartPage extends BasePage{
    private final SelenideElement deleteButton = $(byText("Удалить"));
    private final SelenideElement confirmDeleteButton = $("button.swal2-confirm.swal2-styled");
    private final SelenideElement productArticle = $("p.small");

    @Step("Check that product art \"{value}\" is displayed")
    public CartPage checkProductArt(String value) {
        productArticle.shouldHave(text(value));
        return this;
    }

    @Step("Remove product from a cart")
    public CartPage removeProductFromCart() {
        deleteButton.click();
        confirmDeleteButton.shouldBe(visible).click();
        return this;
    }

    @Step("Open cart page")
    public CartPage openPage() {
        open(CART_URL);
        return this;
    }
}
