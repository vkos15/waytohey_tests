package cloud.autotests.pages;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
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
        $("#cash_window a.top_back").click();
        $("#cash_window").shouldNotBe(visible);
    }

    @Step("Открыть меню в кошельке")
    public Cash openMenu() {
        $("#cash_window .top_settings svg").click();
        sleep(1000);
        $(".cmenu").shouldBe(visible);
        return this;
    }

    @Step("Закрыть меню в кошельке")
    public void closeMenu() {
        $("#cmenu_cash a.close").click();
        $("#cmenu_cash .cmenuBottom").shouldNotBe(visible);
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

    @Step("Проверить, что отображаются указанные цены")
    public void checkPrices(String[][] prices) {
        $("#wallet_variant").click();
        $("#wallet_variant label:nth-child(1) input ").shouldHave(attribute("value", prices[0][0]));
        $("#wallet_variant label:nth-child(1) ").shouldHave(text(prices[0][1]));


        $("#wallet_variant label:nth-child(2)  input").shouldHave(attribute("value", prices[1][0]));
        $("#wallet_variant label:nth-child(2)  ").shouldHave(text(prices[1][1]));
        /*

        $("#wallet_variant label:nth-child(3) input ").shouldHave(attribute("value", prices[2][0]));
        $("#wallet_variant label:nth-child(3) ").shouldHave(text(prices[2][1]));


        $("#wallet_variant label:nth-child(4) input").shouldHave(attribute("value", prices[3][0]));
        $("#wallet_variant label:nth-child(4) ").shouldHave(text(prices[3][1]));

         */
    }

    @Step("Проверить, что в кошельке 2 ячейки")
    public void checkCountCells(int countThings) {
        $$("#wallet_variant .pay-premium-plan").shouldHave(CollectionCondition.size(countThings));
    }

    @Step("Нажать Продолжить")
    public void clickContinue() {
        $(".cash-container .pay_button").click();
    }


}
