package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GiftPage {

    private SelenideElement giftSettings = $("#pay_surprise .settings_checkbox");

    @Step("Проверка заголовка окна")
    public GiftPage checkHeader() {
        $("#pay_surprise_window .top_title").shouldHave(text("Choose a gift"));
        return this;
    }

    @Step("Проверка наличия категорий, выбор категории Love")
    public GiftPage checkCategories() {
        $(".gift-categories-header .categories-cont").shouldBe(visible);
        //выбрали  категорию, проверили что она стала активной
        $(byText("Love")).click();
        $("a.gift-category-active").shouldHave(text("Love"));
        return this;
    }

    @Step("Проверка наличия кнопки оплаты")
    public GiftPage checkPayButton() {
        $("#pay_surprise .pay_button").shouldHave(text("Send Gift"));
        return this;
    }

    @Step("Проверка что отображается чекбокс с настройками гифта - скрытый/не скрытый")
    public GiftPage checkGiftSettings(String textGiftSettings) {
        assertFalse($("#gift_settings #ionly_user").isSelected());
        giftSettings.shouldHave(text(textGiftSettings));
        return this;
    }


}
