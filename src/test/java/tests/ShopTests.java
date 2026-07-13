package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RybalkaShopPage;

import static tests.testdata.TestData.*;

public class ShopTests extends TestBase {

    RybalkaShopPage rybalkaShopPage = new RybalkaShopPage();

    @Test
    @DisplayName("Проверка добавления товара в корзину")
    void addProductToCartTest() {
        rybalkaShopPage
                .openPage(PRODUCT_URL)
                .acceptCookies()
                .addProductInCart()
                .openPage(CART_URL)
                .checkProductArt(PRODUCT_ART);
    }

    @Test
    @DisplayName("Проверка удаления товара из корзины")
    void removeProductFromCartTest() {
        rybalkaShopPage
                .openPage(PRODUCT_URL)
                .acceptCookies()
                .addProductInCart()
                .openPage(CART_URL)
                .checkProductArt(PRODUCT_ART)
                .removeProductFromCart()
                .checkCartIsEmpty();
    }

    @Test
    @DisplayName("Проверка раздела Контакты")
    void openContactsPageTest() {
        rybalkaShopPage
                .openPage("")
                .acceptCookies()
                .openContacts()
                .checkPageText(CONTACT_INN);
    }

    @Test
    @DisplayName("Проверка открытия страницы Катушки из меню")
    void openReelsCategoryTest() {
        rybalkaShopPage
                .openPage("")
                .acceptCookies()
                .openReels()
                .checkPageText(REELS_TEXT);
    }

    @Test
    @DisplayName("Проверка наличия цены товара")
    void productPriceIsDisplayedTest() {

        rybalkaShopPage
                .openPage(PRODUCT_URL)
                .acceptCookies()
                .checkProductPriceIsDisplayed();
    }

}
