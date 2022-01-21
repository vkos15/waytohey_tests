package cloud.autotests.tests;

import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.PremiumPage;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;

public class PremiumTests {

    PremiumPage premiumPage = new PremiumPage();

    LoginWindow loginWindow = new LoginWindow();

    @Test
    void offerToDownloadAppAfterClickOnPremium() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        premiumPage.openPremium();
        premiumPage.checkOfferToDownloadApp();
    }
}
