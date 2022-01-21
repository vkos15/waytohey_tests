package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FreeCoinsPage {

    @Step("Проверка заголовка окна")
    public FreeCoinsPage checkHeaderWindowAboutCoins() {
        $("#cash_free_window h2").shouldHave(text("Get coins for free!"));
        return this;
    }
}
