package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.PremiumPage;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;

public class PremiumTests {

    PremiumPage premiumPage = new PremiumPage();

    LoginWindow loginWindow = new LoginWindow();

    //Проверяем, что предлагаем скачать прилу, если обычный юзер кликает на вип
    @Test
    void offerToDownloadAppAfterClickOnPremium() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        premiumPage.tapOnPremium();
        premiumPage.checkOfferToDownloadApp();
    }

    //Проверяем, что открываются вип-настройки, если вип-юзер кликает на вип
    @Test
    void checkOpenVipSettingsAfterClickOnPremium() {
        loginWindow.loginByAuthKey(configW2H.userVipAuthKey());
        premiumPage.tapOnPremium();
        premiumPage.checkThatVipSettingsOpen();


    }
}
