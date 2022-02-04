package cloud.autotests.tests;

import cloud.autotests.pages.BottomBar;
import cloud.autotests.pages.Encounters;
import cloud.autotests.pages.LoginWindow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;

public class EncountersTests extends TestBase {

    Encounters encountersPage = new Encounters();
    LoginWindow loginWindow = new LoginWindow();
    BottomBar bottomBar = new BottomBar();

    @Test
    void encountersPageUnauthorizedUser() {
        encountersPage.openEncounters()
                .checkContentUnAuthorized();
    }

    @Test
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
                .openSettings();

    }


}
