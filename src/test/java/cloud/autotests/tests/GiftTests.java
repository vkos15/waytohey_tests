package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.SomeoneProfilePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static cloud.autotests.testdata.TestData.userLoginChatWith;

@Tag("general")
public class GiftTests extends TestBase {

    SomeoneProfilePage profilePage = new SomeoneProfilePage();
    LoginWindow loginWindow = new LoginWindow();

    @Test
    @DisplayName("Окно гифтов открывается из чужой анкеты")
    void checkGiftWindowContent() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        profilePage.openGiftWindow(configW2H.userWithPhoto())
                .checkHeader()
                .checkCategories()
                .checkPayButton()
                .checkGiftSettings("Hide my name and message from other users");
    }

    @Test
    @DisplayName("Окно гифтов открывается из диалога")
    void openGiftWindow() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        profilePage.openMessageFromProfile(userLoginChatWith)
                .checkThatChanOpen(userLoginChatWith)
                .openChatSetting()
                .chooseSendGiftInMEnu()
                .checkHeader()
                .checkCategories()
                .checkPayButton();

    }


}
