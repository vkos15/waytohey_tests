package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.ProfilePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;

@Tag("general")
public class OtherUserProfileTests extends TestBase {

    ProfilePage userProfilePage = new ProfilePage();
    LoginWindow loginWindow = new LoginWindow();

    @Test
    void checkTimeInProfile() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        userProfilePage.getTimeWhenUserWasOnline(configW2H.userForeverOffline(),
                configW2H.userForeverOfflineTime());
    }

    @Test
    void viewPhotoInProfile() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        userProfilePage.openPhotoByClickOnAvatar(configW2H.userWithPhoto());
        userProfilePage.checkPhotoSwipeByClickOnArrows();

    }
}
