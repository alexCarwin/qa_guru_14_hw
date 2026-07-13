package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RybalkaShopPage {

    private final SelenideElement contactsButton = $("a[href='/page/shops']");
    private final SelenideElement reelsButton = $$(".type-good a[href='/shop/category?id=443']").get(1);
    private final SelenideElement productPrice = $("[itemprop='price']");
    private final SelenideElement buyButton = $(byText("КУПИТЬ"));
    private final SelenideElement deleteButton = $(byText("Удалить"));
    private final SelenideElement confirmDeleteButton = $("button.swal2-confirm.swal2-styled");
    private final SelenideElement cartSum = $("#cart-sum");
    private final SelenideElement productArticle = $("p.small");
    private final SelenideElement acceptCookiesButton = $("button[onclick='setCookieConsent(true)']");

    @Step("Accept Cookies")
    public RybalkaShopPage acceptCookies() {
        acceptCookiesButton.click();
        return this;
    }

    @Step("Open contacts")
    public RybalkaShopPage openContacts() {
        contactsButton.click();
        return this;
    }

    @Step("Open Reels")
    public RybalkaShopPage openReels() {
        reelsButton.click();
        return this;
    }

    @Step("Open page \"{value}\"")
    public RybalkaShopPage openPage(String value) {
        open(value);
        return this;
    }

    @Step("Check that product price is displayed")
    public RybalkaShopPage checkProductPriceIsDisplayed() {
        productPrice.shouldBe(visible);
        return this;
    }


    @Step("Add product in a cart")
    public RybalkaShopPage addProductInCart() {
        buyButton.click();
        sleep(500);
        return this;
    }

    @Step("Check that product art \"{value}\" is displayed")
    public RybalkaShopPage checkProductArt(String value) {
        productArticle.shouldHave(text(value));
        return this;
    }

    @Step("Remove product from a cart")
    public RybalkaShopPage removeProductFromCart() {
        deleteButton.click();
        confirmDeleteButton.shouldBe(visible).click();
        return this;
    }

    @Step("Check that cart is empty")
    public RybalkaShopPage checkCartIsEmpty() {
        cartSum.shouldHave(text("0.00 ₽"));
        return this;
    }


    @Step("Check that  page contains text '{value}'")
    public RybalkaShopPage checkPageText(String value) {
        $("body").shouldHave(text(value));
        return this;
    }
}
