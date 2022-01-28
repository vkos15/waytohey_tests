package cloud.autotests.pages;

import cloud.autotests.enums.PremiumSettings;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PremiumPage {


    public List<String> getListOfPremiumSettings() {
        List<String> listOfSettings = new ArrayList<>(10);

        for (PremiumSettings d : PremiumSettings.values()) {
            listOfSettings.add(d.getDescription());
        }
        return listOfSettings;
    }

    @Step("Нажимаем на плашку премиум")
    public void tapOnPremium() {
        $(".user-menu-features").$(byText("Premium")).click();
    }

    @Step("Проверяем, что при нажатии на плашку премиум на сайте предлагаем скачать прилу")
    public void checkOfferToDownloadApp() {
        $("#download_app").shouldHave(text("Ready to become Premium user?"));
    }


    @Step("Проверяем, что при нажатии на плашку премиум на сайте открываются вип-настройки")
    public void checkThatVipSettingsOpen() {
        $(".window-settings h2").shouldHave(text("Premium settings"));

    }

    @Step("Проверяем список вип-настроек")
    public void checkListVipSettings() {
        $$(".settings_block label.settings_line").shouldHave(texts(getListOfPremiumSettings()));
    }

}
