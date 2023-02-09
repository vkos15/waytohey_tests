package cloud.autotests.tests;

import cloud.autotests.pages.Cash;
import cloud.autotests.pages.HowCanISpendCoinsPage;
import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.PaymentHistoryPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.WaytoheyProject.configW2H;
import static cloud.autotests.testdata.DataPrices.price1;
import static cloud.autotests.testdata.DataPrices.price2;

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

    @Tag("loveru")
    @Test
    void CashPrice1Test() {

        loginWindow.loginByAuthKey(configW2H.userCash1());
        cash.openCash()
                .checkPrices(price1);

    }

    @Tag("loveru")
    @Test
    void CashPrice2Test() {
        loginWindow.loginByAuthKey(configW2H.userCash2());
        cash.openCash()
                .checkPrices(price2);
    }
}
