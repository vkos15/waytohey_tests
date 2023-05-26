package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.MyProfilePage;
import cloud.autotests.pages.PhotoPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;

public class MyProfileTests extends TestBase {

    MyProfilePage myProfilePage = new MyProfilePage();
    LoginWindow loginWindow = new LoginWindow();
    PhotoPage photoPage = new PhotoPage();

    @Test
    @Tag("general")
       //Добавление и удаление фото в своем профиле с фото
    void addPhotoFromMyProfileWithPhoto() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        String photo_id = myProfilePage.openPhotoAddWindow()
                .uploadMyPhoto("img/cat.jpg");
        photoPage.checkCountPhotoInProfile(3);
        photoPage.delMyPhotoFromProfile(photo_id);
        photoPage.checkCountPhotoInProfile(2);

    }

    @Test
    @Tag("general")
        //Добавление и удаление фото в своем профиле без фото
    void addPhotoFromMyProfileWithoutPhoto() {
        loginWindow.loginByAuthKey(configW2H.userNoPhoto());
        String photo_id = myProfilePage.openPhotoAddWindow()
                .uploadMyPhoto("img/cat.jpg");
        photoPage.checkCountPhotoInProfile(1);
        photoPage.delMyPhotoFromProfile(photo_id);
        photoPage.checkCountPhotoInProfile(0);

    }

    @Test
    @Tag("general")
    @DisplayName("Отображение логина в своей анкете")
    void viewLoginInProfile() {
        loginWindow.loginByAuthKey(configW2H.userNoPhoto());
       myProfilePage.checkLoginInProfile("@alla51191");
    }


}
