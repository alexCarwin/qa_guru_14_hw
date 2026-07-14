package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

import static tests.testdata.TestData.*;

public class ShopTests extends TestBase {

    BasePage basePage = new BasePage();
    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    ContactsPage contactsPage = new ContactsPage();
    ReelsPage reelsPage = new ReelsPage();

    @Test
    @DisplayName("Проверка добавления товара в корзину")
    void addProductToCartTest() {
        productPage.openPage();
        basePage.acceptCookies();
        productPage.addProductInCart();
        cartPage
                .openPage()
                .checkProductArt(PRODUCT_ART);
    }

    @Test
    @DisplayName("Проверка удаления товара из корзины")
    void removeProductFromCartTest() {
        productPage.openPage();
        basePage.acceptCookies();
        productPage.addProductInCart();
        cartPage
                .openPage()
                .checkProductArt(PRODUCT_ART)
                .removeProductFromCart();
        basePage.checkCartIsEmpty();
    }

    @Test
    @DisplayName("Проверка раздела Контакты")
    void openContactsPageTest() {

        mainPage.openPage();
        basePage.acceptCookies();
        mainPage.openContacts();
        contactsPage.checkPageText(CONTACT_INN);
    }

    @Test
    @DisplayName("Проверка открытия страницы Катушки из меню")
    void openReelsCategoryTest() {
        mainPage.openPage();
        basePage.acceptCookies();
        mainPage.openReels();
        reelsPage.checkPageText(REELS_TEXT);
    }

    @Test
    @DisplayName("Проверка наличия цены товара")
    void productPriceIsDisplayedTest() {

        productPage.openPage();
        basePage.acceptCookies();
        productPage.checkProductPriceIsDisplayed();

    }

}
