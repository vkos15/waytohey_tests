package cloud.autotests.tests;

import cloud.autotests.enums.Purposes;
import cloud.autotests.pages.BottomBar;
import cloud.autotests.pages.Encounters;
import cloud.autotests.pages.EncountersSettings;
import cloud.autotests.pages.LoginWindow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;

@Tag("general")
public class EncountersTests extends TestBase {

    Encounters encountersPage = new Encounters();
    LoginWindow loginWindow = new LoginWindow();
    EncountersSettings encountersSettings = new EncountersSettings();
    BottomBar bottomBar = new BottomBar();

    @Test
        //Проверяем, что открываются симпатии без авторизации
    void encountersPageUnauthorizedUser() {
        encountersPage.openEncounters()
                .checkContentUnAuthorized();
    }

    @Test
        //Проверяем, что открываются симпатии для авторизованного
    void encountersPageAuthorizedUser() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        encountersPage.openEncountersFromMenu()
                .checkContentAuthorized();
    }

    @Test
    @DisplayName("Проверка настроек симпатий")
    void encountersCheckSettings() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        encountersPage.openEncounters()
                .openSettings()
                .checkListLikeSettings();
    }

    @Test
    @DisplayName("Изменение настроек симпатий")
    void encountersChangeSettings() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        encountersPage.openEncounters()
                .openSettings()
                .resetLikeSettings(); //сбросили настройки симпатий
        encountersPage.openSettings() //cнова открыли симпатии
                .changeLikeSettings("Women", "42", "47",
                        Purposes.FLIRTING, "Moscow", false);
        encountersPage.openSettings()
                .checkThatLikeSettingsSaved("Women", "42", "47",
                        Purposes.FLIRTING, "Moscow", false);//cнова открыли симпатии и проверили что настройки сохранились

        encountersSettings.resetLikeSettings();//после теста сбросили настройки симпатий
    }


}
