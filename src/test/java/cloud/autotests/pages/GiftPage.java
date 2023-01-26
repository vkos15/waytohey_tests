package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GiftPage {


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

    @Step("Проверка настроек гифта - текст/скрытие")
    public GiftPage checkGiftSettings() {
        $("#pay_surprise .pay_button").shouldHave(text("Send Gift"));
        return this;
    }


}
