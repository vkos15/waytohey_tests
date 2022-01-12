package cloud.autotests.tests;

import cloud.autotests.pages.Cash;
import cloud.autotests.pages.LoginWindow;
import cloud.autotests.pages.PaymentHistoryPage;
import org.junit.jupiter.api.Test;

import static cloud.autotests.config.waytohey.WaytoheyProject.configW2H;

public class CashTests extends TestBase {

    LoginWindow loginWindow = new LoginWindow();
    Cash cash = new Cash();
    PaymentHistoryPage historyPage = new PaymentHistoryPage();

    @Test
    void closeCashByBack() {
        loginWindow.loginByAuthKey(configW2H.auth_key_user());
        cash.openCash();
        cash.closeByBack();
    }

    @Test
    void PaymentHistory() {
        loginWindow.loginByAuthKey(configW2H.auth_key_user());
        cash.openCash()
                .openPaymentHistory();
        historyPage.checkHeaderPaymentHistory()
                .checkMoneyFoRegInPaymentHistory();
    }
}
