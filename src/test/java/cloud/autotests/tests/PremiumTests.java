package cloud.autotests.tests;

import cloud.autotests.enums.PremiumSettings;
import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.PremiumPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;

@Tag("general")
public class PremiumTests extends TestBase {

    PremiumPage premiumPage = new PremiumPage();

    LoginWindow loginWindow = new LoginWindow();

    //Проверяем, что предлагаем скачать прилу, если обычный юзер кликает на вип
    @Test
    @Disabled
    //неактуально
    void offerToDownloadAppAfterClickOnPremium() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        premiumPage.tapOnPremium();
        premiumPage.checkOfferToDownloadApp();
    }

    @Test
    void OpenWindowPremiumByClickOnIcon() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        premiumPage.tapOnPremium();
        premiumPage.checkPremiumWindowIsOpen();
    }

    //Проверяем, что открываются вип-настройки, если вип-юзер кликает на вип
    @Test
    void checkOpenVipSettingsAfterClickOnPremium() {
        loginWindow.loginByAuthKey(configW2H.userVipAuthKey());
        premiumPage.tapOnPremium();
        premiumPage.checkListVipSettings();

    }

    @Test
        //Изменение вип-настроек
    void ChangeVipSettings() {
        loginWindow.loginByAuthKey(configW2H.userVipAuthKey());

        premiumPage.tapOnPremium();
        premiumPage.resetVipSettings();//сначала сбросили вип-настройки
        premiumPage.turnOnVipSettings(PremiumSettings.IS_INVISIBLE)
                .saveVipSettings();
        premiumPage.checkThatVipSettingsOn(PremiumSettings.IS_INVISIBLE);

    }


}
