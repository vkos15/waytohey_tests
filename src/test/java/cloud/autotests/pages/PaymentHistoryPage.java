package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PaymentHistoryPage {

    @Step("Проверка заголовка окна")
    public PaymentHistoryPage checkHeaderPaymentHistory() {
        $("#cash_history_window").shouldHave(text("Payment History"));
        return this;
    }

    @Step("Проверка, что в истории есть запись о начисленном бонусе за регу")
    public PaymentHistoryPage checkMoneyFoRegInPaymentHistory() {
        $("#cash_history").scrollIntoView(true).shouldHave(text("Bonus for signing up"));
        return this;
    }

    @Step("Закрыть историю платежей крестиком")
    public void closePaymentHistory() {
        $("a.close_window").click();
    }

}
