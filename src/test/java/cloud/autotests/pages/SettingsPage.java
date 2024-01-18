package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;



public class SettingsPage {
    SelenideElement inputName = $("input[name='name']");
    SelenideElement inputCity = $("#settings_profile_form #search");


    @Step("Ввести новое имя")
    public SettingsPage changeName(String newName) {
        inputName.setValue(newName);
        return this;
    }

    @Step("Сохранить настройки")
    public SettingsPage saveSettings() {
        // $("#ieditsubmit").click();
        $(".top_confirm").click();
        return this;
    }

    @Step("Проверить имя в настройках")
    public SettingsPage checkNameInSettings(String currentName) {
        inputName.shouldHave(value(currentName));
        return this;
    }


    @Step("Закрыть настройки")
    public void closeSettings() {
        $(".window-settings .close_window").click();
    }

    @Step("Ввести Новый город")
    public SettingsPage changeCity(String newCity) {
        inputCity.setValue(newCity);
        $(".place_search_variant").click();
        return this;
    }


    @Step("Проверить город настройках")
    public SettingsPage checkCityInSettings(String currentCity) {
        inputCity.shouldHave(value(currentCity));
        return this;
    }


    @Step("Выбрать ночную тему")
    public SettingsPage selectDarkTheme() {
        $(byText("Dark theme")).shouldBe(visible);
        $("#new_dark_theme_enabled").parent().click();
        return this;
    }


}
