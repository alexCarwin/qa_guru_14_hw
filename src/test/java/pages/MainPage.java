package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static tests.testdata.TestData.PRODUCT_URL;

public class MainPage extends BasePage{

    private final SelenideElement contactsButton = $("a[href='/page/shops']");
    private final SelenideElement reelsButton = $$(".type-good a[href='/shop/category?id=443']").get(1);


    @Step("Open contacts")
    public ContactsPage openContacts() {
        contactsButton.click();
        return new ContactsPage();
    }

    @Step("Open Reels")
    public ReelsPage openReels() {
        reelsButton.click();
        return new ReelsPage();
    }

    @Step("Open main page")
    public MainPage openPage() {
        open("");
        return this;
    }
}
