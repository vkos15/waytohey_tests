package cloud.autotests.pages;

import cloud.autotests.enums.Purposes;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EncountersSettings {

    private SelenideElement nearMeCheckbox = $("#inearme");
    private SelenideElement target = $("#search_form .settings_line");
    private SelenideElement ageFrom = $(".from_to input");
    private SelenideElement ageTo = $(".from_to input:nth-child(2)");
    private SelenideElement purpose = $("#search_form .settings_line:nth-child(4)");
    private SelenideElement where = $(byName("geo-input-value"));

    @Step("Проверяем названия настроек симпатий")
    public void checkListLikeSettings() {
        //проверяем пункты настроек (порядок учитывается)
        $$(".settings_block .settings_line").shouldHave(texts("Looking for", "Age from to",
                "I’m here for", "Where", "Near me", "Near me"));
    }

    @Step("Изменяем настройки симпатий")
    public void changeLikeSettings(String target, String ageFrom,
                                   String ageTo, Purposes purpose, String city, boolean nearMe) {

        $(byText(target)).click();

        this.ageFrom.setValue(ageFrom);
        this.ageTo.setValue(ageTo);
        this.purpose.$(byText(purpose.getDescription())).click();
        //this.purpose.shouldHave(text("Doesn't matter"));
        //Включаем/выключаем чекбокс в зависимости от нужного значения и начального состояния
        if (nearMe) {
            if (!nearMeCheckbox.isSelected())
                nearMeCheckbox.parent().click();
        } else if (nearMeCheckbox.isSelected())
            nearMeCheckbox.parent().click();
        where.setValue(city);
        $(".top_confirm").click();
    }

    @Step("Проверяем настройки симпатий")
    public void checkThatLikeSettingsSaved(String target, String ageFrom,
                                           String ageTo, Purposes purpose, String city, boolean nearMe) {

        this.target.shouldHave(text(target));
        this.ageTo.shouldHave(value(ageTo));
        this.ageFrom.shouldHave(value(ageFrom));
        this.purpose.shouldHave(text(purpose.getDescription()));
        this.where.shouldHave(text(city));
        if (nearMe)
            nearMeCheckbox.shouldBe(selected);
        else
            nearMeCheckbox.shouldNotBe(selected);
    }

    @Step("Сбрасываем настройки симпатий в состояние по умолчанию")
    public void resetLikeSettings() {
        changeLikeSettings("Doesn't matter", "18", "80",
                Purposes.NO_MATTER, "Doesn't matter", false);
    }

}
