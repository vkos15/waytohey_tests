package cloud.autotests.pages;

import io.qameta.allure.Step;

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

    @Step("Открыть историю платежей")
    public PaymentHistoryPage openPaymentHistory() {
        $("#cash_window .top_settings img").click();
        //выглядит странно, но без этих скроллов и проверок на видимость меню иногда кликает пока меню не видимо
        sleep(100);
        $(".cmenu").$(byText("Payment History")).scrollIntoView(true).shouldBe(visible).click();
        return new PaymentHistoryPage();
    }

    @Step("Открыть раздел Зачем нужны монетки")
    public HowCanISpendCoinsPage openInfoAboutCoins() {
        $("#cash_window .top_settings img").click();
        sleep(100);
        //  $(".cmenu").shouldBe(visible);
        //   $x("//a[text()='How can I spend coins?']").scrollIntoView(true).click();
        $(".cmenu").$(byText("How can I spend coins?")).scrollIntoView(true)
                .shouldBe(visible).click();
        return new HowCanISpendCoinsPage();
    }


}
