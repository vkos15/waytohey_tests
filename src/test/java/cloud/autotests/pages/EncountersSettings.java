package cloud.autotests.pages;

import cloud.autotests.enums.Purposes;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EncountersSettings {

    private SelenideElement nearMeCheckbox = $("#inearme");
    private SelenideElement target = $(byName("target"));
    private SelenideElement ageFrom = $(byName("age_from"));
    private SelenideElement ageTo = $(byName("age_to"));
    private SelenideElement purpose = $(byName("starget"));
    private SelenideElement where = $("#sf_place");

    @Step("Проверяем настройки симпатий")
    public void checkListLikeSettings() {
        //проверяем пункты настроек (порядок учитывается)
        $$(".settings_block .settings_line").shouldHave(texts("Looking for", "Age from to",
                "I’m here for", "Where", "Near me", "Near me"));
    }

    @Step("Изменяем настройки симпатий")
    public void changeLikeSettings(String target, String ageFrom,
                                   String ageTo, Purposes purpose, String city, boolean nearMe) {

        this.target.selectOption(target);
        this.ageFrom.selectOptionByValue(ageFrom);
        this.ageTo.selectOptionByValue(ageTo);
        this.purpose.selectOption(purpose.getDescription());

        //Включаем/выключаем чекбокс в зависимости от нужного значения и начального состояния
        if (nearMe) {
            if (!nearMeCheckbox.isSelected())
                nearMeCheckbox.parent().click();
        } else if (nearMeCheckbox.isSelected())
            nearMeCheckbox.parent().click();
        where.selectOptionContainingText(city);
        $("#search_form #ieditsubmit").shouldHave(value("Save")).click();
    }

    @Step("Проверяем настройки симпатий")
    public void checkThatLikeSettingsSaved(String target, String ageFrom,
                                           String ageTo, Purposes purpose, String city, boolean nearMe) {

        this.target.shouldHave(text(target));
        this.ageTo.shouldHave(text(ageTo));
        this.ageFrom.shouldHave(text(ageFrom));
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
