package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testdata.TestData.PRODUCT_URL;

public class ProductPage extends BasePage{

    private final SelenideElement productPrice = $("[itemprop='price']");
    private final SelenideElement buyButton = $(byText("КУПИТЬ"));

    @Step("Check that product price is displayed")
    public ProductPage checkProductPriceIsDisplayed() {
        productPrice.shouldBe(visible);
        return this;
    }

    @Step("Add product in a cart")
    public ProductPage addProductInCart() {
        buyButton.click();
        sleep(500);
        return this;
    }

    @Step("Open product page")
    public ProductPage openPage() {
        open(PRODUCT_URL);
        return this;
    }
}
