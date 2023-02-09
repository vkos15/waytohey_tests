package cloud.autotests.tests;

import cloud.autotests.pages.Cash;
import cloud.autotests.pages.HowCanISpendCoinsPage;
import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.PaymentHistoryPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;

@Tag("general")
public class CashTests extends TestBase {

    LoginWindow loginWindow = new LoginWindow();
    Cash cash = new Cash();
    PaymentHistoryPage historyPage = new PaymentHistoryPage();
    HowCanISpendCoinsPage coinsPage = new HowCanISpendCoinsPage();

    @Test
    void closeCashByBack() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        cash.openCash();
        cash.closeByBack();
    }

    @Test
    void menuTest() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        cash.openCash()
                .openMenu()
                .closeMenu();
    }

    @Test
    void paymentHistoryTest() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        cash.openCash()
                .openPaymentHistory();
        historyPage.checkHeaderPaymentHistory()
                .checkMoneyFoRegInPaymentHistory();
    }

    @Test
    void checkWindowWithInfoAboutCoins() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        cash.openCash()
                .openInfoAboutCoins()
                .checkHeaderWindowAboutCoins()
                .checkContent();
        // .checkArrows();
    }

    @Test
    void freeCoinsTest() {
        loginWindow.loginByAuthKey(configW2H.authKeyUser());
        cash.openCash()
                .openInfoAboutFreeCoins()
                .checkHeaderWindowAboutCoins();
    }

    @Test
    void checkPriceInMoscow() {
        loginWindow.loginByAuthKey(configW2H.userFromMoscow());
        cash.openCash()
                .openInfoAboutFreeCoins()
                .checkHeaderWindowAboutCoins();
    }
}
