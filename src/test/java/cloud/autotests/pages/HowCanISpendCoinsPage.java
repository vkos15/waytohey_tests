package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HowCanISpendCoinsPage {

    private static final String HEADER_CASH_WHY_WINDOW = "Become popular among WayToHey users";

    @Step("Проверка заголовка окна")
    public HowCanISpendCoinsPage checkHeaderWindowAboutCoins() {
        $("#cash_why_window h2").shouldHave(text(HEADER_CASH_WHY_WINDOW));
        return this;
    }
}
