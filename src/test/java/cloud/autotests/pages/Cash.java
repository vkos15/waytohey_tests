package cloud.autotests.pages;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Cash {

    @Step("Открыть Кошелек")
    public Cash openCash() {
        open("#cash");
        return this;
    }

    @Step("Проверка, что кошелек закрывается нажатием на стрелку назад")
    public void closeByBack() {
        $("a.top_back").click();
        $("#cash_window").shouldNotBe(visible);
    }

    @Step("Проверка, что кошелек закрывается при выборе в меню Закрыть")
    public void closeByMenu() {
        $("#cash_window .top_settings img").click();
        $("#cmenu_cash a.close").click();
        $("#cash_window").shouldNotBe(visible);
    }

    @Step("Открыть меню в кошельке")
    public void openMenu() {
        $("#cash_window .top_settings svg").click();
        sleep(1000);
        $(".cmenu").shouldBe(visible);
    }

    @Step("Открыть историю платежей")
    public PaymentHistoryPage openPaymentHistory() {
        openMenu();
        $(byText("Payment History")).scrollIntoView("{block: \"center\"}").click();

        $("#cash_history_window").shouldBe(visible, Duration.ofSeconds(30));
        return new PaymentHistoryPage();
    }

    @Step("Открыть раздел Зачем нужны монетки")
    public HowCanISpendCoinsPage openInfoAboutCoins() {

        openMenu();
        $(byText("How can I spend coins?")).scrollIntoView(true)
                .click();
        return new HowCanISpendCoinsPage();
    }

    @Step("Открыть раздел Бесплатные монетки")
    public FreeCoinsPage openInfoAboutFreeCoins() {

        openMenu();
        $(byText("Free coins")).scrollIntoView(true)
                .click();
        return new FreeCoinsPage();
    }

    @Step("Закрыть окно с бонусом, если оно вылезло")
    public void checkAndCloseBonusWindow() {
        if ($("#cash_bonus_info").isDisplayed())
            closeByBack();
    }

}
