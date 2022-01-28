package cloud.autotests.tests;

import cloud.autotests.pages.GalleryPage;
import cloud.autotests.pages.LoginWindow;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;

public class GalleryTests {

    GalleryPage galleryPage = new GalleryPage();

    LoginWindow loginWindow = new LoginWindow();

    @Test
    void galleryTestWithPhoto() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        galleryPage.openGallery()
                .checkHeader();
    }
}
