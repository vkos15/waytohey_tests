package cloud.autotests.pages;

import cloud.autotests.enums.PremiumSettings;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static cloud.autotests.config.Project.isWebMobile;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PremiumPage {


    public List<String> getListOfPremiumSettings() {
        List<String> listOfSettings = new ArrayList<>(10);

        for (PremiumSettings d : PremiumSettings.values()) {
            listOfSettings.add(d.getDescription());
        }
        return listOfSettings;
    }

    BottomBar bottomBar = new BottomBar();

    @Step("Нажимаем на плашку премиум")
    public void tapOnPremium() {
        //на мобилке, чтобы добраться до плашки премиум открываем сначала меню
        if (isWebMobile())
            bottomBar.openMenu();
        $(".user-menu-features").$(byText("Premium")).click();
    }

    @Step("Проверяем, что при нажатии на плашку премиум на сайте предлагаем скачать прилу")
    public void checkOfferToDownloadApp() {
        $("#download_app").shouldHave(text("Ready to become Premium user?"));
    }


    @Step("Проверяем, что при нажатии на плашку премиум на сайте открываются вип-настройки")
    public void checkThatVipSettingsOpen() {
        $(".window-settings h2").shouldHave(text("Premium settings"));
        $$(".settings_block label.settings_line").shouldHave(texts(getListOfPremiumSettings()));
    }

    @Step("Изменяем вип-настройку")
    public PremiumPage turnOnVipSettings(PremiumSettings setting) {
        //TODO придумать локатор получше
        $(byText(setting.getDescription())).parent().$(".checkbox").parent().click();
        return this;
    }

    @Step("Сохраняем вип-настройки")
    public PremiumPage saveVipSettings() {
        $("#settings_form #ieditsubmit").click();
        refresh(); //обновляем страничку, чтобы потом проверять, что настройки действительно сохранились
        return this;
    }

    @Step("Сброс вип-настроек")
    public void resetVipSettings() {
        for (PremiumSettings setting : PremiumSettings.values()) {
            if ($(byText(setting.getDescription())).parent().$(".checkbox").isSelected())
                $(byText(setting.getDescription())).parent().$(".checkbox").parent().click();
        }
        saveVipSettings();

    }


    @Step("Проверяем, что включена указанная настройка")
    public PremiumPage checkThatVipSettingsOn(PremiumSettings setting) {
        //TODO придумать локатор получше
        $(byText(setting.getDescription())).parent().$(".checkbox").shouldBe(checked);
        return this;
    }

}
