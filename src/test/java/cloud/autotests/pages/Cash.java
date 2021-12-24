package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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

    public void closeByMenu() {
        $("#cash_window .top_settings img").click();
        $("#cmenu_cash a.close").click();
        $("#cash_window").shouldNotBe(visible);
    }


}
