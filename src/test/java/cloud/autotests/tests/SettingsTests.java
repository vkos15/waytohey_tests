package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.MyProfilePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static cloud.autotests.testdata.TestData.nameRandom;

@Tag("general")
public class SettingsTests extends TestBase {

    LoginWindow loginWindow = new LoginWindow();
    MyProfilePage myProfilePage = new MyProfilePage();

    @Test
    @DisplayName("Смена имени в анкете")
    void changeNameTest() {
        loginWindow.loginByAuthKey(configW2H.userCash1());
        myProfilePage.openSettingsByClickOnPencil()
                .changeName(nameRandom)
                .saveSettings()
                .closeSettings();
        myProfilePage.openProfileByClickOnAva();
        myProfilePage.checkNameInProfile(nameRandom)
                .openSettingsByClickOnPencil()
                .checkNameInSettings(nameRandom);
    }
}
