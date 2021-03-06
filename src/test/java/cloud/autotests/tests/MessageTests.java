package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.ProfilePage;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static cloud.autotests.testdata.TestData.userLoginChatWith;

public class MessageTests extends TestBase {

    ProfilePage profilePage = new ProfilePage();
    LoginWindow loginWindow = new LoginWindow();

    @Test
    //Проверяем, что окно сообщений открывается из профиля
    void openWindowMessageFromProfile() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        profilePage.openMessageFromProfile(userLoginChatWith)
                .checkThatChanOpen(userLoginChatWith);
    }
}
