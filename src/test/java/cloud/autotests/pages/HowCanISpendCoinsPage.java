package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HowCanISpendCoinsPage {

    private static final String HEADER_CASH_WHY_WINDOW = "Get more attention";
    SelenideElement arrowRight = $(".arrow.chR");
    SelenideElement arrowLeft = $(".arrow.chL");
    SelenideElement info = $("#cashWhy");

    @Step("Проверка заголовка окна")
    public HowCanISpendCoinsPage checkHeaderWindowAboutCoins() {
        $("#cash_why_window h2").shouldHave(text(HEADER_CASH_WHY_WINDOW));
        return this;
    }

    @Step("Проверка листалки информации стрелками")
    public void checkArrows() {
        info.shouldHave(text("Become Premium"));
        arrowRight.click();
        info.shouldHave(text("Use coins"));
        arrowRight.click();
        info.shouldHave(text("Get featured"));
        arrowLeft.click();
        info.shouldHave(text("Use coins"));
        arrowLeft.click();
        info.shouldHave(text("Become Premium"));

    }

    @Step("Проверка листалки информации стрелками")
    public void checkContent() {

        info.shouldHave(text("Use coins"));
        info.shouldHave(text("Get featured"));

    }


}
