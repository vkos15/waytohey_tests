package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.MyProfilePage;
import cloud.autotests.pages.PhotoPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;

public class PhotoTests extends TestBase {

    MyProfilePage myProfilePage = new MyProfilePage();
    LoginWindow loginWindow = new LoginWindow();
    PhotoPage photoPage = new PhotoPage();

    @Test
    @Tag("general")
        //TODO
    void testRules() {

        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        myProfilePage.openPhotoAddWindow()
                .checkRulesOfPhotos();
    }

}
