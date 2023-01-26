package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.ProfilePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;

@Tag("general")
public class GiftTests extends TestBase {

    ProfilePage profilePage = new ProfilePage();
    LoginWindow loginWindow = new LoginWindow();

    @Test
    void checkGiftWindowContent() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        profilePage.openGiftWindow(configW2H.userWithPhoto())
                .checkHeader()
                .checkCategories()
                .checkPayButton();
    }
}
