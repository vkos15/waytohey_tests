package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SettingsPage {

    @Step("Ввести новое имя")
    public SettingsPage changeName(String newName) {
        $("input[name='name']").setValue(newName);
        return this;
    }

    @Step("Сохранить настройки")
    public SettingsPage saveSettings() {
        $("#ieditsubmit").click();
        return this;
    }


}
