package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.MyProfilePage;
import cloud.autotests.pages.StoriesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static cloud.autotests.testdata.TestData.nameRandom;

public class StoriesTests extends TestBase{

    LoginWindow loginWindow = new LoginWindow();
    MyProfilePage myProfilePage = new MyProfilePage();
    StoriesPage storiesPage = new StoriesPage();

    @Test
    @DisplayName("Открыть первую сториз")
    void openStoriesTest() {
        loginWindow.loginByAuthKey(configW2H.userCash1());
        storiesPage.openStories()
                .checkOpenedStories();
    }

}
