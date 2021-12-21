package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.ProfilePage;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.waytohey.WaytoheyProject.configW2H;
import static cloud.autotests.testdata.TestData.userLoginChatWith;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MessageTests extends TestBase {

    ProfilePage profilePage = new ProfilePage();
    LoginWindow loginWindow = new LoginWindow();

    @Test
    //Проверяем, что окно сообщений открывается из профиля
    void openWindowMessageFromProfile() {
        loginWindow.loginByAuthKey(configW2H.auth_key_user());
             profilePage.openMessageFromProfile(userLoginChatWith)
                     .checkThatChanOpen(userLoginChatWith);
    }



}
